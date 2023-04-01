package utils;

import entity.Account;

/**
 *
 * @author Nguyễn Văn Sĩ
 */
public class Auth {

    public static Account user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        return Auth.isLogin() && user.isRole()== false;
    }

    public static boolean isUser() {
        return Auth.isLogin() && user.isRole() == true;
    }
    
}

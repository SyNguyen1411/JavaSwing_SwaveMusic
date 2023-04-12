package dao;

import entity.Account;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author NGUYEN VAN SI
 */
public class AccountDAO extends SwaveDAO<Account, String> {

    final String INSERT_SQL = "INSERT INTO TAIKHOAN(TenTK, MatKhau, VaiTro, TrangThai) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE TAIKHOAN SET MatKhau = ?, TrangThai = ? WHERE TenTK = ?";
    final String UPDATE_PASS_SQL = "UPDATE TAIKHOAN SET MatKhau = ? WHERE TenTK = ?";
    final String DELETE_SQL = "DELETE FROM TAIKHOAN WHERE TenTK = ?";
    final String SELECTALL_SQL = "SELECT * FROM TAIKHOAN";
    final String SELECTBYID_SQL = "SELECT * FROM TAIKHOAN WHERE TenTK = ?";
    final String UPDATE_STATUS_SQL = "UPDATE TAIKHOAN SET TrangThai = ? WHERE TenTK = ?";

    @Override
    public void insert(Account entity) {
        JdbcHelper.update(INSERT_SQL, entity.getUserID(), entity.getPassword(),
                entity.isRole(), entity.isStatus());
    }

    @Override
    public void update(Account entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getPassword(), entity.isStatus(), entity.getUserID());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Account> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Account selectById(String key) {
        List<Account> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Account> selectSql(String Sql, Object... args) {
        List<Account> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Account entity = new Account();
                entity.setUserID(rs.getString(1));
                entity.setPassword(rs.getString(2));
                entity.setRole(rs.getBoolean(3));
                entity.setStatus(rs.getBoolean(4));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void updatePassword(String userId, String password) {
        JdbcHelper.update(UPDATE_PASS_SQL, password, userId);
    }

    public void updateStatus(String userId, boolean status) {
        JdbcHelper.update(UPDATE_STATUS_SQL, status, userId);
    }
    
}

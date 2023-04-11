/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Phan Qui Duc
 */
public class UserDAO extends SwaveDAO<User, String> {

    final String INSERT_SQL = "INSERT INTO NGUOIDUNG(HoTen, NgaySinh, GioiTinh, Email, Avatar, TenTK) VALUES (?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NGUOIDUNG SET HoTen = ?, NgaySinh = ?, GioiTinh = ?, Email = ?, Avatar = ?, WHERE TenTK = ?";
    final String DELETE_SQL = "DELETE FROM NGUOIDUNG WHERE TenTK = ?";
    final String SELECTALL_SQL = "SELECT * FROM NGUOIDUNG";
    final String SELECTBYID_SQL = "SELECT * FROM NGUOIDUNG WHERE TenTK = ?";
    final String SELECTBYIDUSER_SQL = "SELECT * FROM NGUOIDUNG WHERE MaND = ?";
    final String SELECTBYEMAIL_SQL = "SELECT * FROM NGUOIDUNG WHERE Email = ?";

    @Override
    public void insert(User entity) {
        JdbcHelper.update(INSERT_SQL, entity.getFullname(), entity.getBirthDate(),
                entity.isGender(), entity.getEmail(), entity.getAvt(), entity.getAccount());
    }

    @Override
    public void update(User entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getFullname(), entity.getBirthDate(),
                entity.isGender(), entity.getEmail(), entity.getAvt(), entity.getAccount());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<User> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public User selectById(String key) {
        List<User> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<User> selectSql(String Sql, Object... args) {
        List<User> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                User entity = new User();
                entity.setUserID(rs.getInt(1));
                entity.setFullname(rs.getString(2));
                entity.setBirthDate(rs.getDate(3));
                entity.setGender(rs.getBoolean(4));
                entity.setEmail(rs.getString(5));
                entity.setAvt(rs.getString(6));
                entity.setAccount(rs.getString(7));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public User selectByIDUser(int key) {
        List<User> list = selectSql(SELECTBYIDUSER_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public User selectByEmail(String key) {
        List<User> list = selectSql(SELECTBYEMAIL_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}

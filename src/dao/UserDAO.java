/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.User;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;
import java.sql.ResultSet;

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
    
    @Override
    public void insert (User entity) {
        JdbcHelper.update(INSERT_SQL, entity.getFullname(), entity.getBirthDate(),
                entity.isGender(), entity.getEmail(), entity.getAvt(), entity.getAccount());
    }

    @Override
    public void update (User entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getFullname(), entity.getBirthDate(),
                entity.isGender(), entity.getEmail(), entity.getAvt(), entity.getAccount());
    }

    @Override
    public void delete(String key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<User> selectAll () {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public User selectById (String key) {
        List<User> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<User> selectSql(String Sql, Object... args) {
        
        return null;
        
    }
    
}

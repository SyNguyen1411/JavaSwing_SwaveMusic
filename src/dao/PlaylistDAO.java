/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.PlayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PlaylistDAO extends SwaveDAO<PlayList, Integer> {
    // Chưa hoàn thiện
    final String INSERT_SQL = "INSERT INTO BAIHAT(TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, TrangThai, MaND) VALUES (?,?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE BAIHAT SET TenBH = ?, NhacSi = ?, CaSi = ?, TheLoai = ?, LoiBH = ?, HinhAnh = ?, FileBH = ?, TrangThai = ?, WHERE MaBH = ?";
    final String DELETE_SQL = "DELETE FROM BAIHAT WHERE MaBH = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAIHAT";
    final String SELECTBYID_SQL = "SELECT * FROM BAIHAT WHERE MaBH = ?";
    
    @Override
    public void insert(PlayList entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PlayList entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PlayList> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PlayList selectById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PlayList> selectSql(String Sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

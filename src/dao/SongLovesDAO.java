/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SongLoves;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class SongLovesDAO extends SwaveDAO<SongLoves, SongLoves> {

    final String INSERT_SQL = "INSERT INTO LUOTYEUTHICH(MaBH, MaND) VALUES (?,?)";
    //final String UPDATE_SQL = "UPDATE LUOTYEUTHICH SET TrangThai = ?, BaoCao = ? WHERE MaBL = ? AND MaND = ?";
    final String DELETE_SQL = "DELETE FROM LUOTYEUTHICH WHERE MaBH = ? AND MaND = ?";
    final String SELECTALL_SQL = "SELECT * FROM LUOTYEUTHICH";
    final String SELECTBYID_SQL = "SELECT * FROM LUOTYEUTHICH WHERE MaBH = ? AND MaND = ?";

    @Override
    public void insert(SongLoves entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSongID(), entity.getUserID());
    }

    @Override
    public void update(SongLoves entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(SongLoves key) {
        JdbcHelper.update(DELETE_SQL, key.getSongID(), key.getUserID());
    }

    @Override
    public List<SongLoves> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public SongLoves selectById(SongLoves key) {
        List<SongLoves> list = selectSql(SELECTBYID_SQL, key.getSongID(), key.getUserID());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SongLoves> selectSql(String Sql, Object... args) {
        List<SongLoves> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                SongLoves entity = new SongLoves();
                entity.setSongID(rs.getInt(1));
                entity.setUserID(rs.getInt(2));
                entity.setlovesDate(rs.getDate(3));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}

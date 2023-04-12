/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.LoveSong;
import entity.SongLoves;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class LoveSongDAO extends SwaveDAO<LoveSong, LoveSong> {

    final String INSERT_SQL = "INSERT INTO BAIHATYEUTHICH(MaBH, MaND) VALUES (?,?)";
    //final String UPDATE_SQL = "UPDATE BAIHATYEUTHICH SET TrangThai = ?, BaoCao = ? WHERE MaBL = ? AND MaND = ?";
    final String DELETE_SQL = "DELETE FROM BAIHATYEUTHICH WHERE MaBH = ? AND MaND = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAIHATYEUTHICH";
    final String SELECTBYID_SQL = "SELECT * FROM BAIHATYEUTHICH WHERE MaBH = ? AND MaND = ?";
    final String SELECTALLBYUSERID_SQL = "SELECT * FROM BAIHATYEUTHICH WHERE MaND = ?";

    @Override
    public void insert(LoveSong entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSongID(), entity.getUserID());
    }

    @Override
    public void update(LoveSong entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(LoveSong key) {
        JdbcHelper.update(DELETE_SQL, key.getSongID(), key.getUserID());
    }

    @Override
    public List<LoveSong> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public LoveSong selectById(LoveSong key) {
        List<LoveSong> list = selectSql(SELECTBYID_SQL, key.getSongID(), key.getUserID());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<LoveSong> selectAllByUID(int key) {
        List<LoveSong> list = selectSql(SELECTALLBYUSERID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<LoveSong> selectSql(String Sql, Object... args) {
        List<LoveSong> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                LoveSong entity = new LoveSong();
                entity.setPosition(rs.getInt(1));
                entity.setSongID(rs.getInt(2));
                entity.setUserID(rs.getInt(3));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}

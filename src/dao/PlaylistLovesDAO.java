package dao;


import entity.PlaylistLoves;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class PlaylistLovesDAO extends SwaveDAO<PlaylistLoves, PlaylistLoves>{

    final String INSERT_SQL = "INSERT INTO LUOTYEUTHICHPLAYLIST(MaPlayList, MaND) VALUES (?,?)";
    //final String UPDATE_SQL = "UPDATE LUOTYEUTHICHPLAYLIST SET TrangThai = ?, BaoCao = ? WHERE MaBL = ? AND MaND = ?";
    final String DELETE_SQL = "DELETE FROM LUOTYEUTHICHPLAYLIST WHERE MaPlayList = ? AND MaND = ?";
    final String SELECTALL_SQL = "SELECT * FROM LUOTYEUTHICHPLAYLIST";
    final String SELECTBYID_SQL = "SELECT * FROM LUOTYEUTHICHPLAYLIST WHERE MaPlayList = ? AND MaND = ?";
    
    @Override
    public void insert(PlaylistLoves entity) {
        JdbcHelper.update(INSERT_SQL, entity.getPlaylistID(), entity.getUserID());
    }

    @Override
    public void update(PlaylistLoves entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(PlaylistLoves key) {
        JdbcHelper.update(DELETE_SQL, key.getPlaylistID(), key.getUserID());
    }

    @Override
    public List<PlaylistLoves> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public PlaylistLoves selectById(PlaylistLoves key) {
        List<PlaylistLoves> list = selectSql(SELECTBYID_SQL, key.getPlaylistID(), key.getUserID());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PlaylistLoves> selectSql(String Sql, Object... args) {
        List<PlaylistLoves> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                PlaylistLoves entity = new PlaylistLoves();
                entity.setPlaylistID(rs.getInt(1));
                entity.setUserID(rs.getInt(2));
                entity.setLovesDate(rs.getDate(3));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
}

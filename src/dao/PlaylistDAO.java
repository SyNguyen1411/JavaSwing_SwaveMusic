/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.PlayList;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class PlaylistDAO extends SwaveDAO<PlayList, Integer> {

    final String INSERT_SQL = "INSERT INTO PLAYLIST(TenPlayList, RiengTu, HinhAnh, MaND) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE PLAYLIST SET TenPlayList = ?, RiengTu = ?, HinhAnh = ? WHERE MaPlayList = ?";
    final String DELETE_SQL = "DELETE FROM PLAYLIST WHERE MaPlayList = ?";
    final String SELECTALL_SQL = "SELECT * FROM PLAYLIST";
    final String SELECTBYID_SQL = "SELECT * FROM PLAYLIST WHERE MaPlayList = ?";

    @Override
    public void insert(PlayList entity) {
        JdbcHelper.update(INSERT_SQL, entity.getPlaylistName(), entity.isStatus(),
                entity.getIcon(), entity.getUserID());
    }

    @Override
    public void update(PlayList entity) {
        JdbcHelper.update(INSERT_SQL, entity.getPlaylistName(), entity.isStatus(),
                entity.getIcon(), entity.getPlaylistID());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<PlayList> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public PlayList selectById(Integer key) {
        List<PlayList> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PlayList> selectSql(String Sql, Object... args) {
        List<PlayList> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                PlayList entity = new PlayList();
                entity.setPlaylistID(rs.getInt(1));
                entity.setPlaylistName(rs.getString(2));
                entity.setStatus(rs.getBoolean(3));
                entity.setIcon(rs.getString(4));
                entity.setUserID(rs.getInt(5));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}

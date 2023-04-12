/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SongOfPlaylist;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class SongOfPlaylistDAO extends SwaveDAO<SongOfPlaylist, SongOfPlaylist> {

    final String INSERT_SQL = "INSERT INTO BAIHATPLAYLIST(STT ,MaPlayList, MaBH) VALUES (?,?,?)";
    //final String UPDATE_SQL = "UPDATE BAIHAT SET TenBH = ?, NhacSi = ?, CaSi = ?, TheLoai = ?, LoiBH = ?, HinhAnh = ?, FileBH = ?, TrangThai = ?, WHERE MaBH = ?";
    final String DELETE_SQL = "DELETE FROM BAIHATPLAYLIST WHERE STT = ? AND MaPlayList = ? AND MaBH = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAIHATPLAYLIST";
    final String SELECTBYID_SQL = "SELECT * FROM BAIHATPLAYLIST WHERE STT = ?";
    final String SELECTSONGOFPLAYLIST_SQL = "SELECT * FROM BAIHATPLAYLIST WHERE MaPlayList = ?";

    @Override
    public void insert(SongOfPlaylist entity) {
        JdbcHelper.update(INSERT_SQL, entity.getPosition(), entity.getPlaylistID(),
                entity.getSongID());
    }

    @Override
    public void update(SongOfPlaylist entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(SongOfPlaylist key) {
        JdbcHelper.update(DELETE_SQL, key.getPosition(), key.getPlaylistID(), key.getSongID());
    }

    @Override
    public List<SongOfPlaylist> selectAll() {
        return selectSql(SELECTALL_SQL);
    }
    
    public List<SongOfPlaylist> selectSongOfPlaylists(Integer key) {
        return selectSql(SELECTSONGOFPLAYLIST_SQL, key);
    }

    @Override
    public SongOfPlaylist selectById(SongOfPlaylist key) {
        List<SongOfPlaylist> list = selectSql(SELECTBYID_SQL, key.getPosition());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SongOfPlaylist> selectSql(String Sql, Object... args) {
        List<SongOfPlaylist> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                SongOfPlaylist entity = new SongOfPlaylist();
                entity.setPosition(rs.getInt(1));
                entity.setPlaylistID(rs.getInt(2));
                entity.setSongID(rs.getInt(3));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Song;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class SongDAO extends SwaveDAO<Song,Integer> {
    
    final String INSERT_SQL = "INSERT INTO BAIHAT(TenBH, NhacSi, CaSi, TheLoai, LoiBH, HinhAnh, FileBH, MaND) VALUES (?,?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE BAIHAT SET TenBH = ?, NhacSi = ?, CaSi = ?, TheLoai = ?, LoiBH = ?, HinhAnh = ?, FileBH = ? WHERE MaBH = ?";
    final String DELETE_SQL = "DELETE FROM BAIHAT WHERE MaBH = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAIHAT";
    final String SELECTALLSONGBYUSERID_SQL = "SELECT * FROM BAIHAT WHERE MaND = ? AND TrangThai = 1";
    final String SELECTBYID_SQL = "SELECT * FROM BAIHAT WHERE MaBH = ?";
    
    @Override
    public void insert(Song entity) {
        JdbcHelper.update(INSERT_SQL, entity.getNameSong(), entity.getMusician(),
                entity.getSinger(), entity.getCategory(), entity.getFileLyrics(),
                entity.getAVT(), entity.getFileSong(), entity.getUserID());
    }

    @Override
    public void update(Song entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getNameSong(), entity.getMusician(),
                entity.getSinger(), entity.getCategory(), entity.getFileLyrics(),
                entity.getAVT(), entity.getFileSong(), entity.getSongID());
    }

    @Override
    public void delete(Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Song> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Song selectById(Integer key) {
        List<Song> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Song> selectSql(String Sql, Object... args) {
        List<Song> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Song entity = new Song();
                entity.setSongID(rs.getInt(1));
                entity.setNameSong(rs.getString(2));
                entity.setMusician(rs.getString(3));
                entity.setSinger(rs.getString(4));
                entity.setCategory(rs.getString(5));
                entity.setFileLyrics(rs.getString(6));
                entity.setAVT(rs.getString(7));
                entity.setFileSong(rs.getString(8));
                entity.setStatus(rs.getBoolean(9));
                entity.setUserID(rs.getInt(10));
                list.add(entity);
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<Song> selectAllSongByUserID(Integer key){
        List<Song> list = selectSql(SELECTALLSONGBYUSERID_SQL, key);
        return list;
    }
    
}

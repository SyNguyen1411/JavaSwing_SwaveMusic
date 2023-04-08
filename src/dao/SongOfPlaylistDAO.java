/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.SongOfPlaylist;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Admin
 */
public class SongOfPlaylistDAO extends SwaveDAO<SongOfPlaylist, SongOfPlaylist>{

    final String INSERT_SQL = "INSERT INTO BAIHATPLAYLIST(STT ,MaPlayList, MaBH) VALUES (?,?,?)";
    //final String UPDATE_SQL = "UPDATE BAIHAT SET TenBH = ?, NhacSi = ?, CaSi = ?, TheLoai = ?, LoiBH = ?, HinhAnh = ?, FileBH = ?, TrangThai = ?, WHERE MaBH = ?";
    final String DELETE_SQL = "DELETE FROM BAIHATPLAYLIST WHERE STT = ? AND MaPlayList = ? AND MaBH = ?";
    final String SELECTALL_SQL = "SELECT * FROM BAIHATPLAYLIST";
    final String SELECTBYID_SQL = "SELECT * FROM BAIHATPLAYLIST WHERE MaBH = ?";
    
    @Override
    public void insert (SongOfPlaylist entity) {
        JdbcHelper.update(INSERT_SQL, entity.getPosition(), entity.getPlaylistID(),
                entity.getSongID());
    }

    @Override
    public void update (SongOfPlaylist entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete (SongOfPlaylist key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SongOfPlaylist> selectAll () {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SongOfPlaylist selectById (SongOfPlaylist key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SongOfPlaylist> selectSql (String Sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

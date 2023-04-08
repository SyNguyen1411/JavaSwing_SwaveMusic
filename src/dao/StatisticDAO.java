/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Phan Qui Duc
 */
public class StatisticDAO {

    private List<Object[]> getListofArray (String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(i + 1);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Object[]> getAllSongByLoves(){
        String sql = "{CALL  proc_thongKeLuotThich()}";
        String[] cols = {"MaBH", "TenBH", "TongLike"};
        return getListofArray(sql, cols);
    }    
    
    public List<Object[]> getAllSongByListens(){
        String sql = "{CALL  proc_thongKeLuotNghe()}";
        String[] cols = {"MaBH", "TenBH", "TongNghe"};
        return getListofArray(sql, cols);
    }    
    
//    public List<Object[]> getTrending(){
//        
//    }
    
    public List<Object[]> getTopPlaylist(Integer days){
        String sql = "{CALL  proc_xepHang100Playlist(?)}";
        String[] cols = {"MaPlayList", "TenPlayList", "HinhAnh", "TongLike"};
        return getListofArray(sql, cols, days);
    }
}

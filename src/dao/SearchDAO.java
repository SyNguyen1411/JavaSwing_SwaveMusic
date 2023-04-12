/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Search;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author CAMERA VIET PHAT
 */
public class SearchDAO extends SwaveDAO<Search,String>{

    final String SELECTALL_SQL = "EXEC proc_deXuatTimKiem ?";
    
    @Override
    public void insert(Search entity) {
    }

    @Override
    public void update(Search entity) {
    }

    @Override
    public void delete(String key) {
    }

    @Override
    public List<Search> selectAll() {
        return null;
    }

    @Override
    public Search selectById(String key) {
        return null;
    }

    @Override
    public List<Search> selectSql(String Sql, Object... args) {
        List<Search> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Search entity = new Search();
                entity.setText(rs.getString(1));
                list.add(entity);
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<Search> selectAll(String key){
        List<Search> list = selectSql(SELECTALL_SQL, key);
        return list;
    }
    
}

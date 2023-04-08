/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Comment;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Phan Qui Duc
 */
public class CommentDAO extends SwaveDAO<Comment, Integer>{

    final String INSERT_SQL = "INSERT INTO BINHLUAN(STT, NoiDung, MaBH, MaND) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE BINHLUAN SET NoiDung = ? WHERE MaBL = ?";
    final String DELETE_SQL = "DELETE FROM BINHLUAN WHERE MaBL = ?";
    final String SELECTALL_SQL = "SELECT * FROM BINHLUAN";
    final String SELECTBYID_SQL = "SELECT * FROM BINHLUAN WHERE MaBL = ?";
    
    
    @Override
    public void insert (Comment entity) {
        JdbcHelper.update(INSERT_SQL, entity.getPosition(), entity.getContent(),
                entity.getSongID(), entity.getUserID());
    }

    @Override
    public void update (Comment entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getContent(), entity.getCommentID());
    }

    @Override
    public void delete (Integer key) {
        JdbcHelper.update(DELETE_SQL, key);
    }

    @Override
    public List<Comment> selectAll () {
       return selectSql(SELECTALL_SQL);
    }

    @Override
    public Comment selectById (Integer key) {
        List<Comment> list = selectSql(SELECTBYID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Comment> selectSql (String Sql, Object... args) {
        List<Comment> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Comment entity = new Comment();
                entity.setCommentID(rs.getInt(1));
                entity.setPosition(rs.getInt(2));
                entity.setContent(rs.getString(3));
                entity.setCommentDate(rs.getDate(4));
                entity.setSongID(rs.getInt(5));
                entity.setUserID(rs.getInt(6));
                list.add(entity);
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}

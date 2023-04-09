/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CommentInteraction;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Phan Qui Duc
 */
public class CommentInteractionDAO extends SwaveDAO<CommentInteraction, CommentInteraction> {

    final String INSERT_SQL = "INSERT INTO TUONGTACBINHLUAN(MaBL, MaND, TrangThai, BaoCao) VALUES (?,?,?,?)";
    final String UPDATE_SQL = "UPDATE TUONGTACBINHLUAN SET TrangThai = ?, BaoCao = ? WHERE MaBL = ? AND MaND = ?";
    final String DELETE_SQL = "DELETE FROM TUONGTACBINHLUAN WHERE MaBL = ? AND MaND = ?";
    final String SELECTALL_SQL = "SELECT * FROM TUONGTACBINHLUAN";
    final String SELECTBYID_SQL = "SELECT * FROM TUONGTACBINHLUAN WHERE MaBL = ? AND MaND = ?";
    final String SELECTBYCMID_SQL = "SELECT * FROM TUONGTACBINHLUAN WHERE MaBL = ?";

    @Override
    public void insert(CommentInteraction entity) {
        JdbcHelper.update(INSERT_SQL, entity.getCommentID(), entity.getUserID(),
                entity.isLiked(), entity.isReported());
    }

    @Override
    public void update(CommentInteraction entity) {
        JdbcHelper.update(UPDATE_SQL, entity.isLiked(), entity.isReported(),
                entity.getCommentID(), entity.getUserID());
    }

    @Override
    public void delete(CommentInteraction key) {
        JdbcHelper.update(DELETE_SQL, key.getCommentID(), key.getUserID());
    }

    @Override
    public List<CommentInteraction> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public CommentInteraction selectById(CommentInteraction key) {
        List<CommentInteraction> list = selectSql(SELECTBYID_SQL, key.getCommentID(), key.getUserID());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CommentInteraction> selectSql(String Sql, Object... args) {
        List<CommentInteraction> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                CommentInteraction entity = new CommentInteraction();
                entity.setCommentID(rs.getInt(1));
                entity.setUserID(rs.getInt(2));
                entity.setLiked(rs.getBoolean(3));
                entity.setReported(rs.getBoolean(4));
                list.add(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<CommentInteraction> selectByCMId(int key) {
        List<CommentInteraction> list = selectSql(SELECTBYCMID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}

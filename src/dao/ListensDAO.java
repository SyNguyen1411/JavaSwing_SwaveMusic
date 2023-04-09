/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Listens;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author Phan Qui Duc
 */
public class ListensDAO extends SwaveDAO<Listens, Listens> {

    final String INSERT_SQL = "INSERT INTO LUOTNGHE(MaBH, MaND) VALUES (?,?)";
    //final String UPDATE_SQL = "UPDATE LUOTNGHE SET TrangThai = ?, BaoCao = ? WHERE MaBL = ? AND MaND = ?";
    final String DELETE_SQL = "DELETE FROM LUOTNGHE WHERE STT = ? AND MaND = ? AND MaBH = ?";
    final String SELECTALL_SQL = "SELECT * FROM LUOTNGHE";
    final String SELECTBYID_SQL = "SELECT * FROM LUOTNGHE WHERE STT = ? AND MaND = ? AND MaBH = ?";

    @Override
    public void insert(Listens entity) {
        JdbcHelper.update(INSERT_SQL, entity.getSongID(), entity.getUserID());
    }

    @Override
    public void update(Listens entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Listens key) {
        JdbcHelper.update(DELETE_SQL, key.getPosition(), key.getSongID(), key.getUserID());
    }

    @Override
    public List<Listens> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    @Override
    public Listens selectById(Listens key) {
        List<Listens> list = selectSql(SELECTBYID_SQL, key.getPosition(), key.getSongID(), key.getUserID());
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Listens> selectSql(String Sql, Object... args) {
        List<Listens> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                Listens entity = new Listens();
                entity.setPosition(rs.getInt(1));
                entity.setSongID(rs.getInt(2));
                entity.setUserID(rs.getInt(3));
                entity.setListenDate(rs.getDate(4));
                list.add(entity);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}

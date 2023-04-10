package dao;

import entity.Account;
import entity.ReportComment;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.JdbcHelper;

/**
 *
 * @author NGUYEN VAN SI
 */
public class ReportCommentDAO extends SwaveDAO<ReportComment, Integer> {

    final String INSERT_SQL = "INSERT INTO BAOCAOBINHLUAN(MaBL, MaND) VALUES (?,?)";
    final String SELECTALL_SQL = "SELECT * FROM BAOCAOBINHLUAN";
    final String SELECTBYIDBL_SQL = "SELECT * FROM BAOCAOBINHLUAN WHERE MaBL = ?";

    @Override
    public void insert(ReportComment entity) {
        JdbcHelper.update(INSERT_SQL, entity.getCommentID(), entity.getUserID());
    }

    @Override
    public void update(ReportComment entity) {
    }

    public void delete(int key) {
    }

    @Override
    public List<ReportComment> selectAll() {
        return selectSql(SELECTALL_SQL);
    }

    public ReportComment selectById(int key) {
        List<ReportComment> list = selectSql(SELECTBYIDBL_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ReportComment> selectSql(String Sql, Object... args) {
        List<ReportComment> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(Sql, args);
            while (rs.next()) {
                ReportComment entity = new ReportComment();
                entity.setCommentID(rs.getInt(1));
                entity.setUserID(rs.getInt(2));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ReportComment selectById(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

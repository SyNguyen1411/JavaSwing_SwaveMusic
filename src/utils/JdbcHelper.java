package utils;

import java.sql.*;

/**
 *
 * @author Nguyễn Văn Sĩ
 */
public class JdbcHelper {

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt (String sql, Object... args) throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SWAVE;user=sa;password=123"
                + ";encrypt=true;trustServerCertificate=true";
        Connection con = DriverManager.getConnection(connectionUrl);
        PreparedStatement pstm = null;
        if (sql.trim().startsWith("{")) {
            pstm = con.prepareCall(sql);
        }
        else {
            pstm = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstm.setObject(i + 1, args[i]);
        }
        return pstm;
    }

    public static int update (String sql, Object... args) {
        try {
            PreparedStatement stmt = getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet query (String sql, Object... args) {
        try {
            PreparedStatement stmt = getStmt(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object value (String sql, Object... args) {
        try {
            ResultSet rs = query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            return new RuntimeException(e);
        }
        return null;
    }

    public static ResultSet executeQuery (String sql, Object... args) throws SQLException {
        PreparedStatement pstmt = JdbcHelper.preparedStatement(sql, args);
        return pstmt.executeQuery();
    }

    public static PreparedStatement preparedStatement (String sql, Object... args) throws SQLException {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=SWAVE;user=sa;password=123"
                + ";encrypt=true;trustServerCertificate=true";
        Connection con = DriverManager.getConnection(connectionUrl);
        PreparedStatement pstmt = null;
        if (sql.startsWith("{")) {
            pstmt = con.prepareCall(sql);
        }
        else {
            pstmt = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;
    }
}

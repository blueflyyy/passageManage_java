package com.example.article_java.util;

import java.sql.*;

public class UpdateExecuteSqlUtil {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public Boolean updateExecute(String sql) {
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            if(pstmt.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return false;
    }
    public int updateExecute(String sql,int i) {
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if (pstmt.executeUpdate() > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return 0;
    }

}

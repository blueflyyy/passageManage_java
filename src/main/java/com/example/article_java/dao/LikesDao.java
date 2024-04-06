package com.example.article_java.dao;

import com.example.article_java.entity.RegionEntity;
import com.example.article_java.util.JdbcUtils;
import com.example.article_java.util.UpdateExecuteSqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface LikesDao {
    static Boolean likesSelect(int uid,int aid){
        String sql = "select * from likes_table where uid = "+uid+" and aid = "+aid+"";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return false;
    }

    static Boolean likesDelete(int uid,int aid){
        String sql = "delete from likes_table where uid = "+uid+" and aid = "+aid+"";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    static Boolean likesInsert(int uid,int aid){
        String sql = "insert into likes_table (uid,aid) values ("+uid+","+aid+")";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }
}

package com.example.article_java.dao;

import com.example.article_java.entity.RegionEntity;
import com.example.article_java.entity.RoleEntity;
import com.example.article_java.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RegionDao {
    static List regionSelect() {
        List list = new ArrayList();

        String sql = "select * from regions_table";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                RegionEntity regionEntity = new RegionEntity();
                regionEntity.setId(rs.getInt("reId"));
                regionEntity.setLabel(rs.getString("label"));
                regionEntity.setValue(rs.getString("value"));
                regionEntity.setTitle(rs.getString("title"));
                list.add(regionEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return list;
    }
}

package com.example.article_java.dao;

import com.example.article_java.entity.ChildrenEntity;
import com.example.article_java.entity.RoleEntity;
import com.example.article_java.entity.UserEntity;
import com.example.article_java.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ChildrenDao {
    static List childrenBasic(){

        List list = new ArrayList();

        String sql = "select * from children_table";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                ChildrenEntity childrenEntity = new ChildrenEntity();
                childrenEntity.setId(rs.getInt("childrenId"));
                childrenEntity.setTitle(rs.getString("title"));
                childrenEntity.setRightId(rs.getInt("rightId"));
                childrenEntity.setKey(rs.getString("key"));
                childrenEntity.setGrade(rs.getInt("grade"));
                childrenEntity.setPagepermisson(rs.getInt("pagePermisson"));
                childrenEntity.setRoutePermisson(rs.getInt("routePermisson"));
                childrenEntity.setLabel(rs.getString("label"));

                list.add(childrenEntity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return list;
    }
    public Boolean childrenUpdate(int id,int pagepermisson);
    public Boolean childrenDelete(int id);
}

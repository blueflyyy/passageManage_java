package com.example.article_java.dao;

import com.example.article_java.entity.ChildrenEntity;
import com.example.article_java.entity.RightEntity;
import com.example.article_java.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RightsDao {
    static List RightsBasic(){

        List list = new ArrayList();

        String sql = "select * from rights_table";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                RightEntity rightEntity = new RightEntity();
                rightEntity.setId(rs.getInt("rightId"));
                rightEntity.setGrade(rs.getInt("grade"));
                rightEntity.setKey(rs.getString("key"));
                rightEntity.setLabel(rs.getString("label"));
                rightEntity.setTitle(rs.getString("title"));
                rightEntity.setPagepermisson(rs.getInt("pagePermisson"));

                sql = "select * from children_table ch where ch.rightId = '"+rightEntity.getId()+"'";
                Connection conn1 = null;
                PreparedStatement pstmt1 = null;
                ResultSet rs1 = null;
                try {
                    conn1 = JdbcUtils.getConnection();
                    pstmt1 = conn1.prepareStatement(sql);
                    rs1 = pstmt1.executeQuery();
                    List<ChildrenEntity> list1 = new ArrayList<>();
                    while(rs1.next()){
                        ChildrenEntity childrenEntity = new ChildrenEntity();
                        childrenEntity.setId(rs1.getInt("childrenId"));
                        childrenEntity.setGrade(rs1.getInt("grade"));
                        childrenEntity.setKey(rs1.getString("key"));
                        childrenEntity.setLabel(rs1.getString("label"));
                        childrenEntity.setPagepermisson(rs1.getInt("pagepermisson"));
                        childrenEntity.setRightId(rs1.getInt("rightId"));
                        childrenEntity.setTitle(rs1.getString("title"));
                        childrenEntity.setRoutePermisson(rs1.getInt("routepermisson"));
                        list1.add(childrenEntity);
                    }
                    rightEntity.setChildren(list1);
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    JdbcUtils.close(rs1, pstmt1, conn1);
                }

                list.add(rightEntity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return list;
    }

    public Boolean rightsUpdate(int id,int pagepermisson);

    public Boolean rightsDelete(int id);
}

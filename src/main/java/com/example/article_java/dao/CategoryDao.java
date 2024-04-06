package com.example.article_java.dao;

import com.example.article_java.entity.CategoryEntity;
import com.example.article_java.entity.ChildrenEntity;
import com.example.article_java.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CategoryDao {
    static List categoryBasic(){

        List list = new ArrayList();

        String sql = "select * from category_table";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                CategoryEntity categoryEntity = new CategoryEntity();
                categoryEntity.setTitle(rs.getString("ctitle"));
                categoryEntity.setValue(rs.getString("value"));
                categoryEntity.setId(rs.getInt("categoryId"));
                list.add(categoryEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return list;
    }
    public Boolean categoryUpdate(CategoryEntity categoryEntity);

    public Boolean categoryDelete(int id);
}

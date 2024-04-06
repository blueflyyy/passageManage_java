package com.example.article_java.dao;

import com.example.article_java.entity.ArticleEntity;
import com.example.article_java.entity.CategoryEntity;
import com.example.article_java.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ArticlesDao {
    static List articleBasic(String sort){

        List list = new ArrayList();

        String sql = "select * from article_table ar left join category_table ca on ar.categoryId = ca.categoryId where ar.publishState = 2 order by '"+sort+"' desc limit 6";
        if(sort==null||sort==" "){
            sql = "select * from article_table ar left join category_table ca on ar.categoryId = ca.categoryId where ar.publishState = 2 ";
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                ArticleEntity articleEntity = new ArticleEntity();
                articleEntity.setAuditState(rs.getInt("auditState"));
                articleEntity.setAuthor(rs.getString("author"));
                articleEntity.setCategoryId(rs.getInt("categoryId"));
                articleEntity.setContent(rs.getString("content"));
                articleEntity.setCommentCount(rs.getInt("commentCount"));
                articleEntity.setCreateTime(rs.getString("createTime"));
                articleEntity.setId(rs.getInt("articleId"));
                articleEntity.setPublishState(rs.getInt("publishState"));
                articleEntity.setRegion(rs.getString("region"));
                articleEntity.setRoleId(rs.getInt("roleId"));
                articleEntity.setStar(rs.getInt("starCount"));
                articleEntity.setPublishTime(rs.getString("publishTime"));
                articleEntity.setTitle(rs.getString("title"));
                articleEntity.setView(rs.getInt("viewCount"));
                CategoryEntity categoryEntity =  new CategoryEntity();
                categoryEntity.setId(rs.getInt("categoryId"));
                categoryEntity.setValue(rs.getString("value"));
                categoryEntity.setTitle(rs.getString("ctitle"));
                articleEntity.setCategory(categoryEntity);
                list.add(articleEntity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return list;
    }

    public Boolean articleAdd(ArticleEntity articleEntity);

    public List articleSelectByUsername(String username);

    public Boolean articleChangeAuditState(int id,int auditState);

    public Boolean articleDelete(int id);

    public ArticleEntity articleDetail(int id);


}

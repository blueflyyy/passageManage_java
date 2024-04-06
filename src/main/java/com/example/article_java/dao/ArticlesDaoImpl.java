package com.example.article_java.dao;

import com.example.article_java.entity.ArticleEntity;
import com.example.article_java.entity.CategoryEntity;
import com.example.article_java.entity.RoleEntity;
import com.example.article_java.util.JdbcUtils;
import com.example.article_java.util.UpdateExecuteSqlUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticlesDaoImpl implements ArticlesDao{
    @Override
    public Boolean articleAdd(ArticleEntity articleEntity) {
        String sql = "insert into article_table (articleId,title,categoryId,content,author,publishState,viewCount,starCount,commentCount,auditState,region,createTime,publishTime,roleId,type)" +
                "values('"+articleEntity.getId()+"','"+articleEntity.getTitle()+"','"+articleEntity.getCategoryId()+"','"+articleEntity.getContent()+"','"+articleEntity.getAuthor()+"'," +
                "'"+articleEntity.getPublishState()+"','"+articleEntity.getView()+"','"+articleEntity.getStar()+"'," +
                "'"+articleEntity.getCommentCount()+"','"+articleEntity.getAuditState()+"','"+articleEntity.getRegion()+"','"+articleEntity.getCreateTime()+"','"+articleEntity.getPublishTime()+"','"+articleEntity.getRoleId()+"',"+articleEntity.getType()+")";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    public Boolean articleAddPdf(ArticleEntity articleEntity) throws SQLException {
        String sql = "insert into article_table (title,categoryId, author,type, publishState,contentblob,auditState,region,createTime,roleId,viewCount,starCount,commentCount) value(?, ?, ?, ?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = JdbcUtils.getConnection().prepareStatement(sql);
        pstm.setString(1,articleEntity.getTitle() );
        pstm.setInt(2, articleEntity.getCategoryId());
        pstm.setString(3, articleEntity.getAuthor());
        pstm.setInt(4, articleEntity.getType());
        pstm.setInt(5,articleEntity.getPublishState());
        pstm.setBlob(6,articleEntity.getContentBlob());
        pstm.setInt(7,articleEntity.getAuditState());
        pstm.setString(8,articleEntity.getRegion());
        pstm.setString(9,articleEntity.getCreateTime());
        pstm.setInt(10,articleEntity.getRoleId());
        pstm.setInt(11,articleEntity.getView());
        pstm.setInt(12,articleEntity.getStar());
        pstm.setInt(13,articleEntity.getCommentCount());
        if(pstm.executeUpdate() > 0){
            pstm.close();
            return true;
        }
        return false;
    }

    public byte[] articleSelectPdf(int aid) throws SQLException {
            String sql = "select contentblob from article_table where articleId = ?";
            PreparedStatement pstm = JdbcUtils.getConnection().prepareStatement(sql);
            pstm.setInt(1, aid);
            ResultSet rs = pstm.executeQuery();
            byte[] res = new byte[0];
            if (rs.next()) {
                res =rs.getBytes(1);
            }
            rs.close();
            pstm.close();
            return res;
    }

    @Override
    public List articleSelectByUsername(String username) {
        String sql = "select * from article_table ar left join category_table ca on ar.categoryId = ca.categoryId where ar.author = '"+username+"' and ar.auditState = 0";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List list = new ArrayList();
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

    @Override
    public Boolean articleChangeAuditState(int id, int auditState) {
        String sql = "update article_table set auditState = '"+auditState+"'where articleId = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    @Override
    public Boolean articleDelete(int id) {
        String sql = "delete from article_table where articleId = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    @Override
    public ArticleEntity articleDetail(int id) {
        String sql = "select * from article_table ar left join category_table ca on ar.categoryId = ca.categoryId left join roles_table  ro on ro.rid = ar.roleId where articleId = '"+id+"'";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArticleEntity articleEntity = new ArticleEntity();
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){

                articleEntity.setAuditState(rs.getInt("auditState"));
                articleEntity.setAuthor(rs.getString("author"));
                articleEntity.setCategoryId(rs.getInt("categoryId"));
                articleEntity.setContent(rs.getString("content"));
                articleEntity.setCommentCount(rs.getInt("commentCount"));
                articleEntity.setCreateTime(rs.getString("createTime"));
                articleEntity.setId(rs.getInt("articleId"));
                articleEntity.setPublishState(rs.getInt("publishState"));
                articleEntity.setRegion(rs.getString("region"));
                articleEntity.setType(rs.getInt("type"));
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
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setRoleName(rs.getString("roleName"));
                roleEntity.setRoleType(rs.getInt("roleType"));
                roleEntity.setRights(rs.getString("rights"));
                roleEntity.setId(rs.getInt("rid"));
                articleEntity.setRole(roleEntity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return articleEntity;
    }


    public Boolean articleUpdate(ArticleEntity articleEntity) throws SQLException {
        String sql = "update article_table set categoryId = '"+articleEntity.getCategoryId()+"',title = '"+articleEntity.getTitle()+"',content = '"+articleEntity.getContent()+"',auditState = '"+articleEntity.getAuditState()+"',type="+articleEntity.getType()+",contentBlob = ? where articleId = "+articleEntity.getId()+"";
        PreparedStatement pstm = JdbcUtils.getConnection().prepareStatement(sql);
        pstm.setBlob(1,articleEntity.getContentBlob() );
        Boolean res = pstm.executeUpdate()>0?true:false;
        pstm.close();
        return res;
//        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    public List articleAuditSelect(int auditState){
        List list = new ArrayList();
        String sql = "select * from article_table ar left join category_table ca on ar.categoryId = ca.categoryId where ar.auditState = "+auditState+"";
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

    public Boolean articleChangeState(int id,int auditState,int publishState){
        String sql = "update article_table set auditState = "+auditState+",publishState = "+publishState+" where articleId = "+id+"";
        if(publishState==-1){
            sql = "update article_table set auditState = "+auditState+" where articleId = "+id+"";
        }
        if(auditState == -1){
            sql = "update article_table set publishState = "+publishState+" where articleId = "+id+"";
        }

        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    public List articleAuditList(String username,int auditState,int publishState){
        String sql = "select * from article_table ar left join category_table ca on ar.categoryId = ca.categoryId where author = '"+username+"' and auditState != "+auditState+" and publishState <= "+publishState+"";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List list = new ArrayList();
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

    public Boolean articlePublish(int id,int publishState,String publishTime){
        String sql = "update article_table set publishState = "+publishState+",publishTime = '"+publishTime+"' where articleId = "+id+"";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    public List articlePublishManage(String username,int publishState){
        String sql = "select * from article_table ar left join category_table ca on ar.categoryId = ca.categoryId where author = '"+username+"' and publishState = "+publishState+"";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List list = new ArrayList();
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

    public Boolean articleViewUpdate(int articleId){
        String sql = "update article_table set viewCount = viewCount + 1 where articleId = "+articleId+"";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    public List articleTable(int sort){
        String sql = "select * from article_table ar left join category_table ca on ar.categoryId = ca.categoryId where ca.categoryId = "+sort+" and ar.publishState = 2";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List list  = new ArrayList();

        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                ArticleEntity articleEntity = new ArticleEntity();
                articleEntity.setId(rs.getInt("articleId"));
                articleEntity.setTitle(rs.getString("title"));
                articleEntity.setAuthor(rs.getString("author"));
                articleEntity.setRegion(rs.getString("region"));
                articleEntity.setPublishTime(rs.getString("publishTime"));
                CategoryEntity categoryEntity = new CategoryEntity();
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




}

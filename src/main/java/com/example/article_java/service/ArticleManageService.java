package com.example.article_java.service;

import com.example.article_java.dao.ArticlesDaoImpl;
import com.example.article_java.dao.CategoryDaoImpl;
import com.example.article_java.entity.ArticleEntity;
import com.example.article_java.entity.CategoryEntity;

import java.sql.SQLException;
import java.util.List;

public class ArticleManageService {
    public Boolean categoryUpdate(CategoryEntity categoryEntity) {
        return new CategoryDaoImpl().categoryUpdate(categoryEntity);
    }



    public Boolean categoryDelete(int id) {
        return new CategoryDaoImpl().categoryDelete(id);
    }

    public Boolean articleAdd(ArticleEntity articleEntity) {
        return new ArticlesDaoImpl().articleAdd(articleEntity);
    }
    public Boolean articleAddPdf(ArticleEntity articleEntity) throws SQLException {
        return new ArticlesDaoImpl().articleAddPdf(articleEntity);
    }

    public List articleDraft(String username) {
        return new ArticlesDaoImpl().articleSelectByUsername(username);
    }

    public Boolean articleDraftAuditState(int id, int auditState) {
        return new ArticlesDaoImpl().articleChangeAuditState(id, auditState);
    }

    public Boolean articleDelete(int id) {
        return new ArticlesDaoImpl().articleDelete(id);
    }

    public ArticleEntity articleDetail(int id) {
      return new ArticlesDaoImpl().articleDetail(id);
   }

    public Boolean articleUpdate(ArticleEntity articleEntity) throws SQLException {
        return new ArticlesDaoImpl().articleUpdate(articleEntity);
    }

    public Boolean articleViewCount(int articleId){
        return new ArticlesDaoImpl().articleViewUpdate(articleId);
    }
}

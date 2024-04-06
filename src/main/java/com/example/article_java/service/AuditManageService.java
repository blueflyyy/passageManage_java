package com.example.article_java.service;

import com.example.article_java.dao.ArticlesDaoImpl;

import java.util.List;

public class AuditManageService {
    public List auditArticle(int auditState){
        return new ArticlesDaoImpl().articleAuditSelect(auditState);
    }
    public Boolean articleChangeState(int id,int auditState,int publishState){
        return new ArticlesDaoImpl().articleChangeState(id,auditState,publishState);
    }

    public List auditList(String username,int auditState,int publishState){
        return new ArticlesDaoImpl().articleAuditList(username,auditState,publishState);
    }

    public Boolean auditPublish(int id,int publishState,String publishTime){
        return new ArticlesDaoImpl().articlePublish(id,publishState,publishTime);
    }
}

package com.example.article_java.service;

import com.example.article_java.dao.ArticlesDaoImpl;

import java.util.List;

public class PublishManageService {
    public List publishManageArticle(String username,int publishState){
        return new ArticlesDaoImpl().articlePublishManage(username,publishState);
    }

    public Boolean publishArticleDelete(int id){
        return new ArticlesDaoImpl().articleDelete(id);
    }
}

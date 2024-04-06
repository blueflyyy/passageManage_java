package com.example.article_java.entity;

import java.io.InputStream;

public class ArticleEntity {
    private String region;
    private String author;
    private int roleId;
    private int auditState;
    private int publishState;
    private String createTime;
    private int star;
    private int view;
    private int id;
    private String publishTime;
    private CategoryEntity category;
    private String title;
    private int categoryId;
    private String content;
    private int commentCount;
    private String comment;
    private RoleEntity role;
    private int type;
    private InputStream contentBlob;

    public ArticleEntity() {
    }



    public String getComment() {
        return comment;
    }

    public ArticleEntity(String region, String author, int roleId, int auditState, int publishState, String createTime, int star, int view, int id, String publishTime, CategoryEntity category, String title, int categoryId, String content, int commentCount, String comment, RoleEntity role, int type,InputStream contentBlob) {
        this.region = region;
        this.author = author;
        this.roleId = roleId;
        this.auditState = auditState;
        this.publishState = publishState;
        this.createTime = createTime;
        this.star = star;
        this.view = view;
        this.id = id;
        this.publishTime = publishTime;
        this.category = category;
        this.title = title;
        this.categoryId = categoryId;
        this.content = content;
        this.commentCount = commentCount;
        this.comment = comment;
        this.role = role;
        this.type = type;
        this.contentBlob = contentBlob;
    }

    public InputStream getContentBlob() {
        return contentBlob;
    }

    public void setContentBlob(InputStream contentBlob) {
        this.contentBlob = contentBlob;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    public int getPublishState() {
        return publishState;
    }

    public void setPublishState(int publishState) {
        this.publishState = publishState;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "region='" + region + '\'' +
                ", author='" + author + '\'' +
                ", roleId=" + roleId +
                ", auditState=" + auditState +
                ", publishState=" + publishState +
                ", createTime='" + createTime + '\'' +
                ", star=" + star +
                ", view=" + view +
                ", id=" + id +
                ", publishTime='" + publishTime + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", content='" + content + '\'' +
                ", commentCount=" + commentCount +
                ", comment='" + comment + '\'' +
                '}';
    }
}

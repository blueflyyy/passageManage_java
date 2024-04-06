package com.example.article_java.entity;

import java.util.List;

public class RightEntity {
    private int id;
    private int grade;
    private String key;
    private String label;
    private int pagepermisson;
    private String title;
    private List<ChildrenEntity> children;

    public RightEntity() {
    }

    public RightEntity(int id, int grade, String key, String label, int pagepermisson, String title) {
        this.id = id;
        this.grade = grade;
        this.key = key;
        this.label = label;
        this.pagepermisson = pagepermisson;
        this.title = title;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getPagepermisson() {
        return pagepermisson;
    }

    public void setPagepermisson(int pagepermisson) {
        this.pagepermisson = pagepermisson;
    }

    public List<ChildrenEntity> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenEntity> children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}

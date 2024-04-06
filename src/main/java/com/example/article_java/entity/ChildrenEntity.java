package com.example.article_java.entity;

public class ChildrenEntity {
    private int id;
    private int grade;
    private String key;
    private String label;
    private int pagepermisson;
    private int rightId;
    private String title;
    private int routePermisson;

    public ChildrenEntity() {
    }

    public ChildrenEntity(int id, int grade, String key, String label, int pagepermisson, int rightId, String title, int routePermisson) {
        this.id = id;
        this.grade = grade;
        this.key = key;
        this.label = label;
        this.pagepermisson = pagepermisson;
        this.rightId = rightId;
        this.title = title;
        this.routePermisson = routePermisson;
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

    public int getRightId() {
        return rightId;
    }

    public void setRightId(int rightId) {
        this.rightId = rightId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRoutePermisson() {
        return routePermisson;
    }

    public void setRoutePermisson(int routePermisson) {
        this.routePermisson = routePermisson;
    }
}

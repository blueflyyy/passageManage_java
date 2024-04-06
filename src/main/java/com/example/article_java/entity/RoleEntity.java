package com.example.article_java.entity;

public class RoleEntity {
    private int id;
    private String rights;
    private String roleName;
    private int roleType;

    public RoleEntity() {
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public RoleEntity(int id, String rights, String roleName, int roleType) {
        this.id = id;
        this.rights = rights;
        this.roleName = roleName;
        this.roleType = roleType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }
}

package com.example.article_java.entity;

public class UserEntity {
    private int id ;
    private boolean _default;
    private String password;
    private String region;
    private int roleId;
    private boolean roleState;
    private String username;
    private RoleEntity role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean is_default() {
        return _default;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public boolean isRoleState() {
        return roleState;
    }

    public void setRoleState(boolean roleState) {
        this.roleState = roleState;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public UserEntity() {
    }

    public UserEntity(int id, boolean _default, String password, String region, int roleId, boolean roleState, String username, RoleEntity role) {
        this.id = id;
        this._default = _default;
        this.password = password;
        this.region = region;
        this.roleId = roleId;
        this.roleState = roleState;
        this.username = username;
        this.role = role;
    }
}

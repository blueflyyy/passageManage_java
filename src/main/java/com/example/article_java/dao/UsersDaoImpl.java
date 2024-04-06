package com.example.article_java.dao;


import com.example.article_java.entity.RoleEntity;
import com.example.article_java.entity.UserEntity;
import com.example.article_java.util.JdbcUtils;
import com.example.article_java.util.UpdateExecuteSqlUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    @Override
    public int userManageInsert(UserEntity userEntity) {
        String sql = "insert into users_table(username,password,roleState,`default`,region,roleId) values ('"+userEntity.getUsername()+"','"+userEntity.getPassword()+"','"+userEntity.isRoleState()+"','"+userEntity.is_default()+"','"+userEntity.getRegion()+"','"+userEntity.getRoleId()+"')";
        return new UpdateExecuteSqlUtil().updateExecute(sql,1);
    }

    @Override
    public Boolean userManageUpdate(int id, UserEntity userEntity) {
        String sql = "update users_table set username = '"+userEntity.getUsername()+"',password = '"+userEntity.getPassword()+"', region = '"+userEntity.getRegion()+"',roleId = '"+userEntity.getRoleId()+"' where uid = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    @Override
    public Boolean userManageStateChange(int id,Boolean roleState) {
        String sql = "update users_table set roleState = "+roleState+" where uid = "+id+"";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    @Override
    public Boolean userManageDelete(int id) {
        String sql = "delete from users_table where uid = "+id+"";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    @Override
    public List userRoleSelect(int id) {
        List list = new ArrayList();

        String sql = "select * from users_table us left join roles_table ro on us.roleId = ro.rid ";
        if(id!=-1){
            sql = "select * from users_table us left join roles_table ro on us.roleId = ro.rid where uid = '"+id+"'";
        }
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){

                UserEntity userEntity = new UserEntity();
                userEntity.set_default(rs.getBoolean("default"));
                userEntity.setId(rs.getInt("uid"));
                userEntity.setPassword(rs.getString("password"));
                userEntity.setRegion(rs.getString("region"));
                userEntity.setRoleId(rs.getInt("roleId"));
                userEntity.setRoleState(rs.getBoolean("roleState"));
                userEntity.setUsername(rs.getString("username"));
                RoleEntity roleEntity = new RoleEntity();
                roleEntity.setId(rs.getInt("rid"));
                roleEntity.setRoleName(rs.getString("roleName"));
                roleEntity.setRoleType(rs.getInt("roleType"));
                roleEntity.setRights(rs.getString("rights"));
                userEntity.setRole(roleEntity);
                list.add(userEntity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return list;
    }



    public int userRoleSelectId() {
        int id = 0;

        String sql = "select LAST_INSERT_ID()";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("rs");
                System.out.println(rs.getInt(1));
             id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return id;
    }
}

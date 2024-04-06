package com.example.article_java.dao;

import com.example.article_java.entity.RoleEntity;
import com.example.article_java.entity.UserEntity;
import com.example.article_java.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UsersDao {
    static List LoginBasic(String username,String password,Boolean roleState){

        List list = new ArrayList();

        String sql = "select * from users_table us left join roles_table ro on us.roleId = ro.rid where us.username='"+username+"' and us.password='"+password+"'and us.roleState='"+roleState+"'";
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
    int userManageInsert(UserEntity userEntity);
    Boolean userManageUpdate(int id,UserEntity userEntity);
    Boolean userManageStateChange(int id,Boolean roleState);
    Boolean userManageDelete(int id);
    List userRoleSelect(int id);
}

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

public interface RoleDao {
    static List roleSelect() {
        List list = new ArrayList();

        String sql = "select * from roles_table";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
              RoleEntity roleEntity = new RoleEntity();
              roleEntity.setRights(rs.getString("rights"));
              roleEntity.setRoleType(rs.getInt("roleType"));
              roleEntity.setRoleName(rs.getString("roleName"));
              roleEntity.setId(rs.getInt("rid"));
              list.add(roleEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(rs, pstmt, conn);
        }
        return list;
    }

    public Boolean roleUpdate(int id,String rights);

    public Boolean roleDelete(int id);
}

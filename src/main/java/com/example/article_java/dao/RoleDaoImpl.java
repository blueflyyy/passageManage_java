package com.example.article_java.dao;

import com.example.article_java.util.UpdateExecuteSqlUtil;

public class RoleDaoImpl implements RoleDao{
    @Override
    public Boolean roleUpdate(int id, String rights) {
        String sql = "update roles_table set rights = '"+rights+"' where rid = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    @Override
    public Boolean roleDelete(int id) {
        String sql = "delete from roles_table where rid = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }
}

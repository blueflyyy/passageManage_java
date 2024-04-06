package com.example.article_java.dao;

import com.example.article_java.util.UpdateExecuteSqlUtil;

public class ChildrenDaoImpl implements ChildrenDao{
    @Override
    public Boolean childrenUpdate(int id,int pagepermisson) {
        String sql = "update children_table set pagepermisson = '"+pagepermisson+"'where childrenId = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    @Override
    public Boolean childrenDelete(int id) {
        String sql = "delete from children_table where childrenId = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }
}

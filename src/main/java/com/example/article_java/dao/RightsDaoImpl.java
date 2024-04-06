package com.example.article_java.dao;

import com.example.article_java.util.UpdateExecuteSqlUtil;

public class RightsDaoImpl implements RightsDao{
    @Override
    public Boolean rightsUpdate(int id, int pagepermisson) {
        String sql = "update rights_table set pagepermisson = '"+pagepermisson+"' where rightId = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }

    @Override
    public Boolean rightsDelete(int id) {
        String sql = "delete from rights_table where rightId = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }
}

package com.example.article_java.dao;

import com.example.article_java.entity.CategoryEntity;
import com.example.article_java.util.UpdateExecuteSqlUtil;

public class CategoryDaoImpl implements CategoryDao{
    @Override
    public Boolean categoryUpdate(CategoryEntity categoryEntity) {

        String sql = "update category_table set ctitle = '"+categoryEntity.getTitle()+"',value = '"+categoryEntity.getValue()+"' where categoryId = '"+categoryEntity.getId()+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);

    }

    @Override
    public Boolean categoryDelete(int id) {
        String sql = "delete from category_table where categoryId = '"+id+"'";
        return new UpdateExecuteSqlUtil().updateExecute(sql);
    }
}

package com.example.article_java.service;

import com.example.article_java.dao.ChildrenDaoImpl;
import com.example.article_java.dao.RightsDaoImpl;


public class RightListService {
    public Boolean rightListRightUpdate(int id,int pagepermisson){
        return  new RightsDaoImpl().rightsUpdate(id,pagepermisson);
    }

    public Boolean rightListRightDelete(int id){
        return new RightsDaoImpl().rightsDelete(id);
    }

    public Boolean rightListChildrenUpdate(int id,int pagepermisson){
        return new ChildrenDaoImpl().childrenUpdate(id,pagepermisson);
    }

    public Boolean rightListChildrenDelete(int id){
        return new ChildrenDaoImpl().childrenDelete(id);
    }
}

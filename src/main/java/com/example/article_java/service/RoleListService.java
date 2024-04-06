package com.example.article_java.service;

import com.example.article_java.dao.RoleDaoImpl;

public class RoleListService {
         public Boolean roleListUpdate(int id,String rights){
             return new RoleDaoImpl().roleUpdate(id,rights);
         }

         public Boolean roleListDelete(int id){
             return new RoleDaoImpl().roleDelete(id);
         }
}

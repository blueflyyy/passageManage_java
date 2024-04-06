package com.example.article_java.service;

import com.example.article_java.dao.UsersDaoImpl;
import com.example.article_java.entity.UserEntity;

import java.util.List;

public class UserManageService {

    UsersDaoImpl usersDao = new UsersDaoImpl();

    public Boolean userManage(int id){
        return usersDao.userManageDelete(id);
    }

    public Boolean userManage(int id,Boolean roleState){
        return usersDao.userManageStateChange(id,roleState);
    }

    public Boolean userManage(int id, UserEntity userEntity){
        return usersDao.userManageUpdate(id,userEntity);
    }

    public int userManage(UserEntity userEntity){
        return usersDao.userManageInsert(userEntity);
    }

    public List userRole(int id){
        return usersDao.userRoleSelect(id);
    }

    public int userRoleSelectId(){
       return usersDao.userRoleSelectId();
    }
}

package com.example.article_java.servlet;

import com.example.article_java.dao.UsersDao;
import com.example.article_java.service.UserManageService;
import com.example.article_java.util.JdbcUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
          Boolean result = false;
          String username = request.getParameter("username");
          String password = request.getParameter("password");
          Boolean roleState =Boolean.parseBoolean (request.getParameter("roleState"));
          ObjectMapper mapper = new ObjectMapper();

          List list = null;
          if(username==null){
             list = new UserManageService().userRole(-1);
          }else{
              list =  UsersDao.LoginBasic(username,password,roleState);
          }

          response.setContentType("application/json;charset=utf-8");
          mapper.writeValue(response.getOutputStream(),list);

         }




    public void destroy() {
    }

}
package com.example.article_java.servlet.publishManage;

import com.example.article_java.dao.ArticlesDaoImpl;
import com.example.article_java.dao.UsersDao;
import com.example.article_java.service.UserManageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "publishManageServlet", value = "/servlet/publishManageServlet")
public class publishManageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        int publishState = Integer.parseInt(request.getParameter("publishState"));

        ObjectMapper mapper = new ObjectMapper();

        List list = new ArticlesDaoImpl().articlePublishManage(username,publishState);

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);

    }




    public void destroy() {
    }

}

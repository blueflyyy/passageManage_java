package com.example.article_java.servlet;

import com.example.article_java.dao.ArticlesDao;
import com.example.article_java.dao.ArticlesDaoImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PassageTableServlet", value = "/servlet/PassageTableServlet")
public class PassageTableServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        int sort = Integer.parseInt(request.getParameter("sort"));
//        System.out.println(sort);
        List list = new ArticlesDaoImpl().articleTable(sort);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }

    public void destroy() {
    }
}

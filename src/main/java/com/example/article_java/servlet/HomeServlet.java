package com.example.article_java.servlet;

import com.example.article_java.dao.ArticlesDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/servlet/HomeServlet")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String sort = request.getParameter("sort");
        List list = ArticlesDao.articleBasic(sort);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }

    public void destroy() {
    }
}

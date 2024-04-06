package com.example.article_java.servlet;

import com.example.article_java.dao.ArticlesDao;
import com.example.article_java.dao.ChildrenDao;
import com.example.article_java.entity.ChildrenEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "newsRouterServlet", value = "/servlet/newsRouterServlet")
public class NewsRouterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List list = ChildrenDao.childrenBasic();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }




    public void destroy() {
    }
}

package com.example.article_java.servlet.articleManage;

import com.example.article_java.dao.ArticlesDao;
import com.example.article_java.dao.CategoryDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "articleCategorySelect", value = "/servlet/articleCategorySelect")
public class articleCategorySelect extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List list = CategoryDao.categoryBasic();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }

    public void destroy() {
    }
}

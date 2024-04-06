package com.example.article_java.servlet.articleManage;

import com.example.article_java.entity.ArticleEntity;
import com.example.article_java.service.ArticleManageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "articleDetail", value = "/servlet/articleDetail")
public class articleDetailServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.parseInt(request.getParameter("id"));
        ArticleEntity articleEntity = new ArticleManageService().articleDetail(id);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),articleEntity);
    }

    public void destroy() {
    }
}

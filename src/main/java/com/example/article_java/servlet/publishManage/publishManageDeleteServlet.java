package com.example.article_java.servlet.publishManage;

import com.example.article_java.dao.ArticlesDaoImpl;
import com.example.article_java.service.PublishManageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "publishManageDeleteServlet", value = "/servlet/publishManageDeleteServlet")
public class publishManageDeleteServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ObjectMapper mapper = new ObjectMapper();

        Boolean result = new PublishManageService().publishArticleDelete(id);

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);

    }




    public void destroy() {
    }
}

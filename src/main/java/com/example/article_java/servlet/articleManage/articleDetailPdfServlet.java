package com.example.article_java.servlet.articleManage;



import com.example.article_java.dao.ArticlesDaoImpl;


import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "articleDetailPdf", value = "/servlet/articleDetailPdf")
public class articleDetailPdfServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        byte[] res = new byte[0];
        try {
            res = new ArticlesDaoImpl().articleSelectPdf(Integer.parseInt(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("application/pdf");
        response.getOutputStream().write(res);
    }

    public void destroy() {
    }
}

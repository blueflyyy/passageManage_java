package com.example.article_java.servlet.articleManage;

import com.example.article_java.service.ArticleManageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "articleDraftAuditState", value = "/servlet/articleDraftAuditState")
public class articleDraftAuditState extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.parseInt(request.getParameter("id"));
        int auditState = Integer.parseInt(request.getParameter("auditState"));
        Boolean result = new ArticleManageService().articleDraftAuditState(id,auditState);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);
    }

    public void destroy() {
    }
}

package com.example.article_java.servlet.auditManage;

import com.example.article_java.service.AuditManageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "articleChangeStateServlet", value = "/servlet/articleChangeStateServlet")
public class articleChangeStateServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        int id = Integer.parseInt(request.getParameter("id"));
        int auditState = Integer.parseInt(request.getParameter("auditState"));

        int publishState = Integer.parseInt(request.getParameter("publishState"));
        Boolean result = new AuditManageService().articleChangeState(id,auditState,publishState);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);
    }

    public void destroy() {
    }
}

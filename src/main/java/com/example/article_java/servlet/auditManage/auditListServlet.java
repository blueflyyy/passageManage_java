package com.example.article_java.servlet.auditManage;

import com.example.article_java.service.AuditManageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "auditListServlet", value = "/servlet/auditListServlet")
public class auditListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String username = request.getParameter("username");
        int auditState = Integer.parseInt(request.getParameter("auditState"));
        int publishState = Integer.parseInt(request.getParameter("publishState"));
        List list = new AuditManageService().auditList(username,auditState,publishState);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);
    }

    public void destroy() {
    }
}

package com.example.article_java.servlet;

import com.example.article_java.dao.RoleDao;
import com.example.article_java.service.RoleListService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "roleListServlet", value = "/servlet/roleListServlet")
public class RoleListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String flag = request.getParameter("flag");
        int id = Integer.parseInt(request.getParameter("id"));
        String rights = null;
        Boolean result = false;
        if("update".equals(flag)){
            rights = request.getParameter("rights");
            result = new RoleListService().roleListUpdate(id,rights);
        }else{
            result = new RoleListService().roleListDelete(id);
        }
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);

    }




    public void destroy() {
    }
}

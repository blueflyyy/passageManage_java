package com.example.article_java.servlet;

import com.example.article_java.service.RightListService;
import com.example.article_java.service.RoleListService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(name = "rightListServlet", value = "/servlet/rightListServlet")
public class RightListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String flag = request.getParameter("flag");
        int id = Integer.parseInt(request.getParameter("id"));
        int pagepermisson = 0 ;
        Boolean result = false;
        if("rightUpdate".equals(flag)||"childrenUpdate".equals(flag)){
            pagepermisson = Integer.parseInt(request.getParameter("pagepermisson"));
        }
        RightListService rightListService = new RightListService();
        if("rightUpdate".equals(flag)){
            result = rightListService.rightListRightUpdate(id,pagepermisson);
        }else if("rightDelete".equals(flag)){
            result = rightListService.rightListRightDelete(id);
        }else if("childrenUpdate".equals(flag)){
            result = rightListService.rightListChildrenUpdate(id,pagepermisson);
        }else if("childrenDelete".equals(flag)){
            result = rightListService.rightListChildrenDelete(id);
        }
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);

    }




    public void destroy() {
    }
}

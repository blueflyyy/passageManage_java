package com.example.article_java.servlet;

import com.example.article_java.dao.RegionDao;
import com.example.article_java.dao.RoleDao;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "regionSelectServlet", value = "/servlet/regionSelectServlet")
public class RegionSelectServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        ObjectMapper mapper = new ObjectMapper();

        List list = RegionDao.regionSelect();

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),list);

    }




    public void destroy() {
    }
}

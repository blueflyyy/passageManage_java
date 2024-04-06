package com.example.article_java.servlet.articleManage;

import com.example.article_java.entity.ArticleEntity;
import com.example.article_java.entity.CategoryEntity;
import com.example.article_java.service.ArticleManageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "articleAdd", value = "/servlet/articleAdd")
@MultipartConfig
public class articleAddServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArticleEntity articleEntity = new ArticleEntity();
        Map<String, String[]> map ;

        map = request.getParameterMap();
        try {
            BeanUtils.populate(articleEntity, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Boolean result = new ArticleManageService().articleAdd(articleEntity);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ObjectMapper mapper = new ObjectMapper();
        ArticleEntity articleEntity = new ArticleEntity();
        Map<String, String[]> map ;

        map = request.getParameterMap();
        try {
            BeanUtils.populate(articleEntity, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Boolean result = false;
        if(articleEntity.getType()==1){
            result = new ArticleManageService().articleAdd(articleEntity);
        }else if(articleEntity.getType()==2){
            try {
                result = new ArticleManageService().articleAddPdf(articleEntity);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);


    }

    public void destroy() {
    }
}

package com.example.article_java.servlet.articleManage;

import com.example.article_java.dao.CategoryDao;
import com.example.article_java.entity.CategoryEntity;
import com.example.article_java.entity.UserEntity;
import com.example.article_java.service.ArticleManageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "articleCategoryUpdate", value = "/servlet/articleCategoryUpdate")
public class articleCategoryUpdate extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        CategoryEntity categoryEntity = new CategoryEntity();
        Map<String, String[]> map ;

        map = request.getParameterMap();
        try {
            BeanUtils.populate(categoryEntity, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Boolean result = new ArticleManageService().categoryUpdate(categoryEntity);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);
    }

    public void destroy() {
    }
}

package com.example.article_java.servlet.articleManage;

import com.example.article_java.dao.LikesDao;
import com.example.article_java.service.ArticleManageService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "articleLikeServlet", value = "/servlet/articleLikeServlet")
public class articleLikesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String flag = request.getParameter("flag");
        int uid = Integer.parseInt(request.getParameter("uid"));
        int aid = Integer.parseInt(request.getParameter("aid"));
        Boolean result = false;
        if("select".equals(flag)){
            result = LikesDao.likesSelect(uid,aid);
        }else if("delete".equals(flag)){
            result = LikesDao.likesDelete(uid,aid);
        }else {
            result = LikesDao.likesInsert(uid,aid);
        }
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),result);
    }

    public void destroy() {
    }
}

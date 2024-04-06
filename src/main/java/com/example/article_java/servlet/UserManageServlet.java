package com.example.article_java.servlet;

import com.example.article_java.entity.UserEntity;
import com.example.article_java.service.UserManageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "userManageServlet", value = "/servlet/userManageServlet")
public class UserManageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String flag = request.getParameter("flag");
        int id = -1;
        if(!"insert".equals(flag)){
            id = Integer.parseInt(request.getParameter("id"));
        }
        UserEntity userEntity = new UserEntity();
        Map<String, String[]> map ;

        map = request.getParameterMap();
        try {
                BeanUtils.populate(userEntity, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        Boolean result = false;
        UserManageService userManageService = new UserManageService();
        response.setContentType("application/json;charset=utf-8");
        if("delete".equals(flag)){
            result = userManageService.userManage(id);
            mapper.writeValue(response.getOutputStream(),result);
        }else if("roleStateChange".equals(flag)){
            result = userManageService.userManage(id,Boolean.parseBoolean(request.getParameter("roleState")));
            mapper.writeValue(response.getOutputStream(),result);
        }else if("update".equals(flag)){
            result = userManageService.userManage(id,userEntity);
            mapper.writeValue(response.getOutputStream(),result);
        }else if("insert".equals(flag)){
            int i = userManageService.userManage(userEntity);
            if(i>0){
                List list = userManageService.userRole(i);
                mapper.writeValue(response.getOutputStream(),list);
            }else{
                mapper.writeValue(response.getOutputStream(),result);
            }
        }




    }




    public void destroy() {
    }
}

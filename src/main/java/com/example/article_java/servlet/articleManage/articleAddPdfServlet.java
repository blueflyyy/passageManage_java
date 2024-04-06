package com.example.article_java.servlet.articleManage;

import com.example.article_java.dao.ArticlesDaoImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;


import com.example.article_java.entity.ArticleEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "publishManagePdfServlet", value = "/servlet/publishManagePdfServlet")
@MultipartConfig
public class articleAddPdfServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        if (ServletFileUpload.isMultipartContent(request)) {
            ArticleEntity articleEntity = new ArticleEntity();
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {

                        articleEntity.setContentBlob(item.getInputStream());
//                        byte[] res = new ArticlesDaoImpl().articleAddPdf1(item.getInputStream());

                    } else {


                        String fieldName = item.getFieldName();
                        //待解决：中文乱码问题
                        String value = item.getString("UTF-8");


                        switch (fieldName) {
                            case "categoryId":
                                articleEntity.setCategoryId(Integer.parseInt(value));
                                break;
                            case "title":
                                articleEntity.setTitle(value);
                                break;
                            case "type":
                                articleEntity.setType(Integer.parseInt(value));
                                break;
                            case "region":
                                articleEntity.setRegion(value);
                                break;
                            case "author":
                                articleEntity.setAuthor(value);
                                break;
                            case "roleId":
                                articleEntity.setRoleId(Integer.parseInt(value));
                                break;
                            case "auditState":
                                articleEntity.setAuditState(Integer.parseInt(value));
                                break;
                            case "publishState":
                                articleEntity.setPublishState(Integer.parseInt(value));
                                break;
                            case "createTime":
                                articleEntity.setCreateTime(value);
                                break;
                            case "star":
                                articleEntity.setStar(Integer.parseInt(value));
                                break;
                            case "view":
                                articleEntity.setView(Integer.parseInt(value));
                                break;
                            case "commentCount":
                                articleEntity.setCommentCount(Integer.parseInt(value));
                            default:
                                break;
                        }
                    }
                }
                Boolean res = false;
                ObjectMapper mapper = new ObjectMapper();
                res = new ArticlesDaoImpl().articleAddPdf(articleEntity);
//                response.setContentType("application/pdf");
//                response.getOutputStream().write(res);
                response.setContentType("application/json;charset=utf-8");
                mapper.writeValue(response.getOutputStream(),res);
            } catch (FileUploadException | SQLException e) {
                e.printStackTrace();
            }
        }



    }

    public void destroy() {
    }
}

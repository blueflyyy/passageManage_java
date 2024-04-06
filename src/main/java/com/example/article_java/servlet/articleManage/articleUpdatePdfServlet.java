package com.example.article_java.servlet.articleManage;

import com.example.article_java.dao.ArticlesDaoImpl;
import com.example.article_java.entity.ArticleEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "articleUpdatePdf", value = "/servlet/articleUpdatePdf")
@MultipartConfig
public class articleUpdatePdfServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (ServletFileUpload.isMultipartContent(request)) {
            ArticleEntity articleEntity = new ArticleEntity();
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        articleEntity.setContentBlob(item.getInputStream());
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
                            case "auditState":
                                articleEntity.setAuditState(Integer.parseInt(value));
                                break;
                            case "id":
                                articleEntity.setId(Integer.parseInt(value));
                                break;
                            default:
                                break;
                        }
                    }
                }
                Boolean res = false;
                ObjectMapper mapper = new ObjectMapper();
                res = new ArticlesDaoImpl().articleUpdate(articleEntity);
                response.setContentType("application/json;charset=utf-8");
                mapper.writeValue(response.getOutputStream(),res);
            } catch (FileUploadException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.example.article_java.util;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class GetRequestBodyUtil {

        public String getStringFromStream(HttpServletRequest req) {
            ServletInputStream is;
            try {
                is = req.getInputStream();
                int nRead = 1;
                int nTotalRead = 0;
                byte[] bytes = new byte[10240];
                while (nRead > 0) {
                    nRead = is.read(bytes, nTotalRead, bytes.length - nTotalRead);
                    if (nRead > 0)
                        nTotalRead = nTotalRead + nRead;
                }
                String str = new String(bytes, 0, nTotalRead, "utf-8");
                return str;
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

}

package mhj.first.web.util;

import mhj.first.web.exception.file.FileException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class FileUtil {
    public static String getUpLoadFilePath() throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        System.out.println(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/db.properties"));
//        System.out.println("**************");
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/db.properties"))));
        } catch (IOException e) {
            throw new FileException("获取文件路径失败！" + e.getMessage());
        }
        String filepath = properties.getProperty("upLoadFilePath");
        if (filepath == null || "".equals(filepath)) {
            throw new FileException("文件路径不正确：upLoadFilePath=" + filepath);
        }
        return filepath;
    }
}

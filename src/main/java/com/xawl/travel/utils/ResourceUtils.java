package com.xawl.travel.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/24.
 */

public class ResourceUtils {

    public static String path = "img/businessKeepsakeImg";  //保存的文件夹

    public static String  upload(HttpServletRequest request,
                                 MultipartFile multipartFile, String name) throws IOException {
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM");

        String fileName = request.getSession().getServletContext()
                .getRealPath(path)
                + "/";
        File file = new File(fileName+sm.format(new Date())+"/");
        if (!file.exists()) {
            file.mkdirs();
        }
        name=sm.format(new Date())+"/"+ UUID.randomUUID().toString().replace("-", "")+name.substring(name.indexOf("."));
        file = new File(fileName + name);
        multipartFile.transferTo(file);
        return "/"+path+"/"+name;
    }

    public static void deleteResource(String resourceName,
                                      HttpServletRequest request) {
        String fileName = request.getSession().getServletContext()
                .getRealPath(path)
                + "/";
        File file = new File(fileName + resourceName);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void reName(HttpServletRequest request, String oldName,
                              String newName) {
        String fileName = request.getSession().getServletContext()
                .getRealPath(path)
                + "/";
        File file = new File(fileName + oldName);
        File newFile = new File(fileName + newName);
        FileOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new FileOutputStream(newFile);
            in = new FileInputStream(file);
            IOUtils.copy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        file.delete();
    }

    public static File getResource(HttpServletRequest request,
                                   String resourceName) {
        String fileName = request.getSession().getServletContext()
                .getRealPath(path)
                + "/";
        File file = new File(fileName + resourceName);
        return file;
    }
}

package com.xawl.travel.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by wt on 2017/12/3.
 */
    public class ImgUploadUtil {


        private static String PATH_ROOT;

        // 允许上传的格式
        private static final String[] IMAGE_TYPE = new String[] { ".bmp", ".jpg", ".jpeg", ".gif", ".png" };

        public static String upload( HttpServletRequest request,MultipartFile multipartFile ,String basePath) throws Exception {
            //获得物理路径webapp所在路径
            PATH_ROOT = request.getSession().getServletContext().getRealPath("");
            boolean isLegal = false;
            // 校验图片格式
            for (String type : IMAGE_TYPE) {
                if (StringUtils.endsWithIgnoreCase(multipartFile.getOriginalFilename(), type)) {
                    isLegal = true;
                    break;
                }
            }
                // 文件新路径
                String img_path = getFilePath(multipartFile,basePath);
                String filePath = PATH_ROOT + img_path;
                // 生成图片的绝对引用地址
                /* String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath,REPOSITORY_PATH), "\\", "/");
                pic.setUrl(IMAGE_BASE_URL + picUrl);*/
                File imgFile = new File(filePath);
                // 写文件到磁盘
                multipartFile.transferTo(imgFile);
                // 校验图片是否合法
                isLegal = false;
                try {
                    BufferedImage image = ImageIO.read(imgFile);
                    if (image != null) {
                        isLegal = true;
                    }
                } catch (IOException e) {
                }
                if (!isLegal) {
                    // 不合法，将磁盘上的文件删除
                    imgFile.delete();
                }
            return img_path;
        }

    private static String getFilePath(MultipartFile multipartFile ,String basePath) {
            String baseFolder = PATH_ROOT;
            //Date nowDate = new Date();
            // yyyy/MM/dd
            /*String fileFolder = baseFolder + File.separator + new DateTime(nowDate).toString("yyyy") + File.separator + new DateTime(nowDate).toString("MM") + File.separator
                    + new DateTime(nowDate).toString("dd");*/
            //yyyy-MM
            SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM");
            String imgPath = basePath +"/"+ sm.format(new Date());
            String fileFolder = baseFolder + imgPath;
            File file = new File(fileFolder);
            if (!file.isDirectory()) {
                // 如果目录不存在，则创建目录
                file.mkdirs();
            }
            //生成uuid作为文件名称
            //String uuid = UUID.randomUUID().toString().replaceAll("-","");
            //String fileName = multipartFile.getOriginalFilename();
            //String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = multipartFile.getContentType();
            //获得文件后缀名称
            String fileType = contentType.substring(contentType.indexOf("/")+1);
            // 生成新的文件名
            String fileName = new SimpleDateFormat("yyyyMMddhhmmssSSSS").format(new Date())+ "_" + new Random().nextInt(9999)%(9999-100+1) + "." + fileType;
            //File.separator
            return imgPath + "/" + fileName;
        }
    }


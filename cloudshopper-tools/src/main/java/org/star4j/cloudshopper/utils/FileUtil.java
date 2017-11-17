package org.star4j.cloudshopper.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @Author: WuYL
 * @Description: 封装常用对文件的操作
 * @Date: Create in 2017/11/16 14:50
 * @Modified By:
 */
public class FileUtil {


    /**
     * 装载缩略图名称
     * "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP"
     * @param storePath 文件路径
     * @return 缩略图名称
     */
    public static String getThumbImage(String storePath, String fdfsInfoSize){
        if(StringUtils.isBlank(storePath)){
            throw new NullPointerException();
        }
        //获取文件名称
        String pathL = StringUtil.fileName(storePath) + "_" + fdfsInfoSize;
        //获取文件后缀名
        String pathR = StringUtil.extName(storePath);
        return pathL + "." + pathR;
    }


    /**
     * 封装完整文件地址
     * @param fullPath 文件路径
     * @return 文件访问地址
     */
    public static String getFilePath(String fullPath, String ngAddr) {
        if(StringUtils.isBlank(fullPath)){
            throw new NullPointerException();
        }
        StringBuffer filePath = new StringBuffer(ngAddr);
        filePath.append("/");
        filePath.append(fullPath);
        return filePath.toString();
    }


    /**
     * 输入流转文件
     * @param ins
     * @param file
     */
    public static void inputstreamConvertFile(InputStream ins, File file){
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }	finally {
            try {
                if (os != null)
                    os.flush();
                    os.close();
                if(ins != null)
                    ins.close();
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}

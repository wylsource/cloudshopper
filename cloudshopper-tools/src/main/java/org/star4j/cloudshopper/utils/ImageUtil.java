package org.star4j.cloudshopper.utils;

import org.star4j.cloudshopper.vo.ImageInfoVo;

/**
 * @Author: WuYL
 * @Description: 操作图片的工具
 * @Date: Create in 2017/11/16 18:25
 * @Modified By:
 */
public class ImageUtil {

    /**
     * 封装图片信息
     * @param filePath
     * @param thumbImagePath
     * @param fileUrl
     * @return
     */
    public static ImageInfoVo getImageInfoVo(String filePath, String thumbImagePath, String fileUrl) {
        return new ImageInfoVo(filePath, thumbImagePath, fileUrl);
    }

    /**
     * 封装图片信息
     * @param filePath
     * @return
     */
    public static ImageInfoVo getImageInfoVo(String filePath) {
        return new ImageInfoVo(filePath, null, null);
    }

    /**
     * 封装图片信息
     * @param filePath
     * @return
     */
    public static ImageInfoVo getImageInfoVo(String filePath, String fileUrl) {
        return new ImageInfoVo(filePath, null, fileUrl);
    }
}

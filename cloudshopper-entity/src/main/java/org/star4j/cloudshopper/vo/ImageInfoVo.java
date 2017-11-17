package org.star4j.cloudshopper.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: WuYL
 * @Description: 封装图片信息
 * @Date: Create in 2017/11/16 18:21
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageInfoVo {

    private String filePath; //图片存储路径

    private String thumbImagePath; // 图片缩略图路径

    private String fileUrl; //http 请求图片路径
}

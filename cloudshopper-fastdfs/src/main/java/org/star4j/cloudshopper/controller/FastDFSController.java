package org.star4j.cloudshopper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.star4j.cloudshopper.Client.FastDFSClient;
import org.star4j.cloudshopper.model.FdfsInfo;
import org.star4j.cloudshopper.model.NginxInfo;
import org.star4j.cloudshopper.result.Result;
import org.star4j.cloudshopper.utils.FileUtil;
import org.star4j.cloudshopper.utils.ImageUtil;
import org.star4j.cloudshopper.utils.ResultUtil;

/**
 * @Author: WuYL
 * @Description: 提供操作 fastdfs 的接口
 * @Date: Create in 2017/11/16 18:00
 * @Modified By:
 */
@RestController
public class FastDFSController {

    @Autowired
    private FastDFSClient client;

    @Autowired
    private FdfsInfo fdfsInfo;

    @Autowired
    private NginxInfo nginxInfo;

    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/uploadFile")
    public Result uploadFile(MultipartFile file) {
        String fileId = client.uploadFile(file);
        String fileUrl = FileUtil.getFilePath(fileId, nginxInfo.getAddress());
        return ResultUtil.success(ImageUtil.getImageInfoVo(fileId, fileUrl));
    }

    /**
     * 下载文件
     * @param fileId 要下载的文件 ID
     * @param downloadPath 下载的目的路径
     * @return
     */
    @GetMapping("/downloadFile/{fileId}/{downloadPath}")
    public Result downloadFile(@PathVariable("fileId") String fileId, @PathVariable("downloadPath") String downloadPath) {
        String downloadFilePath = client.downloadFile(fileId, downloadPath);
        return ResultUtil.success(ImageUtil.getImageInfoVo(downloadFilePath));
    }

    /**
     * 删除文件
     * @param fileId 要删除的文件 ID
     * @return
     */
    @DeleteMapping("/deleteFile/{fileId}")
    public Result deleteFile(@PathVariable("fileId") String fileId) {
        client.deleteFile(fileId);
        return ResultUtil.success(ImageUtil.getImageInfoVo(fileId));
    }

    /**
     * 上传文件（同时生成缩略图）
     * @param file
     * @return
     */
    @PostMapping("/uploadImageAndCrtThumbImage")
    public Result uploadImageAndCrtThumbImage(MultipartFile file) {
        String filePath = client.uploadImageAndCrtThumbImage(file);
        String thumbImagePath = FileUtil.getThumbImage(filePath, fdfsInfo.getSize());
        String fileUrl = FileUtil.getFilePath(filePath, nginxInfo.getAddress());
        return ResultUtil.success(ImageUtil.getImageInfoVo(filePath, thumbImagePath, fileUrl));
    }
}

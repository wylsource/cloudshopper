package org.star4j.cloudshopper.Client;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.proto.storage.DownloadCallback;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.star4j.cloudshopper.model.FdfsInfo;
import org.star4j.cloudshopper.model.NginxInfo;
import org.star4j.cloudshopper.utils.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: WuYL
 * @Description:
 * @Date: Create in 2017/11/16 15:12
 * @Modified By:
 */
@Component
public class FastDFSClient {

    /**
     * 	TrackerClient - TrackerServer接口
     * 	GenerateStorageClient - 一般文件存储接口 (StorageServer接口)
     *	FastFileStorageClient - 为方便项目开发集成的简单接口(StorageServer接口)
     *	AppendFileStorageClient - 支持文件续传操作的接口 (StorageServer接口)
     */
    @Autowired
    private FastFileStorageClient storageClient;

    private static StorePath storePath;

    @Autowired
    private FdfsInfo fdfsInfo;

    @Autowired
    private NginxInfo nginxInfo;

    /**
     * 文件上传
     * @param file
     * @return
     */
    public String uploadFile(MultipartFile file) {
        try {
            storePath = storageClient.uploadFile(file.getInputStream(),file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()),null);
            return storePath.getFullPath();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return null;
    }

    /**
     * 文件下载
     * @param fileId
     * @return
     */
    public String downloadFile(String fileId, String downloadPath) {
        File downloadFile = storageClient.downloadFile(storePath.getGroup(), fileId, new DownloadCallback<File>() {
            @Override
            public File recv(InputStream ins) throws IOException {
                File file = new File(downloadPath);
                FileUtil.inputstreamConvertFile(ins, file);
                return file;
            }
        });

        return downloadFile.getPath();
    }

    /**
     * 删除文件
     * @param fileId
     * @return
     */
    public boolean deleteFile(String fileId) {
        try {
            storageClient.deleteFile(fileId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 传图片并同时生成一个缩略图
     * "JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP"
     * @param file 文件对象
     * @return 文件访问地址
     * @throws IOException
     */
    public String uploadImageAndCrtThumbImage(MultipartFile file) {
        try {
            StorePath storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(),file.getSize(),
                    FilenameUtils.getExtension(file.getOriginalFilename()),null);
            return storePath.getFullPath();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.mohism.pudding.base.file.server.modular.factory;


import com.mohism.pudding.base.file.api.entity.Fileinfo;
import com.mohism.pudding.base.file.server.config.properties.OssProperteis;
import com.mohism.pudding.base.file.server.core.util.FileUtil;
import com.mohism.pudding.core.util.SpringContextHolder;
import com.mohism.pudding.core.util.ToolUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 文件信息组装工厂
 *
 * @author fengshuonan
 * @date 2018-07-27-下午3:12
 */
@Slf4j
public class FileFactory {

    public static Fileinfo getFileInfo(String appCode, String fileOriginName, Long fileSize, Long fileId, String fileStorageName) {
        if (ToolUtil.isEmpty(appCode)) {
            appCode = "noneAppCode";
        }

        Fileinfo fileinfo = new Fileinfo();
        fileinfo.setFileId(fileId);
        fileinfo.setAppCode(appCode);
        fileinfo.setFileOriginName(fileOriginName);
        fileinfo.setFileSuffix(FileUtil.getFileSuffix(fileOriginName));
        fileinfo.setFileSize(fileSize);
        fileinfo.setFileStorageName(fileStorageName);

        try {
            OssProperteis ossProperteis = SpringContextHolder.getBean(OssProperteis.class);
            fileinfo.setFileUrl(ossProperteis.getInternetFileUrl() + fileStorageName);
        } catch (Exception e) {
            log.error("获取ossProperties失败！存储文件地址为；" + fileStorageName);
            fileinfo.setFileUrl(fileStorageName);
        }

        return fileinfo;
    }
}

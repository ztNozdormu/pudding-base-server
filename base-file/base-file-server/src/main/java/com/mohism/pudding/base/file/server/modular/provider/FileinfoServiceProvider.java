package com.mohism.pudding.base.file.server.modular.provider;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.file.api.FileApi;
import com.mohism.pudding.base.file.api.entity.Fileinfo;
import com.mohism.pudding.base.file.api.model.FileByteInfo;
import com.mohism.pudding.base.file.server.modular.service.FileinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * <p>
 * 文件信息表 服务实现类
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-27
 */
@RestController
public class FileinfoServiceProvider implements FileApi {

    @Autowired
    private FileinfoService fileinfoService;


    @Override
    public Fileinfo getFileInfo(@RequestParam("fileId") Long fileId) {
        return this.fileinfoService.getFileInfo(fileId);
    }

    @Override
    public String uploadFileAndSaveFileInfo(@RequestBody FileByteInfo byteInfo,
                                            @RequestParam("fileName") String fileName,
                                            @RequestParam("size") Long size) {
        if (byteInfo == null || byteInfo.getFileBytes() == null) {
            return null;
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteInfo.getFileBytes());
            return this.fileinfoService.uploadFileAndSaveFileInfo(byteArrayInputStream, fileName, size);
        }
    }

    @Override
    public String getFileUrlById(@RequestParam("fileId") Long fileId) {
        return this.fileinfoService.getFileUrlById(fileId);
    }

    @Override
    public List<Fileinfo> getFileInfoList(@RequestBody Fileinfo fileinfo, @RequestParam("pageNo") Integer pageNo,
                                          @RequestParam("pageSize") Integer pageSize) {
        return this.fileinfoService.getFileInfoList(new Page(pageNo, pageSize), fileinfo);
    }

}

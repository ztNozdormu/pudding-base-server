package com.mohism.pudding.base.file.server.modular.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.file.api.entity.Fileinfo;
import com.mohism.pudding.base.file.server.modular.service.FileinfoService;
import com.mohism.pudding.core.page.PageFactory;
import com.mohism.pudding.core.reqres.request.RequestData;
import com.mohism.pudding.core.reqres.response.ResponseData;
import com.mohism.pudding.kernel.scanner.modular.annotation.PostResource;
import com.mohism.pudding.kernel.scanner.modular.stereotype.ApiResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文件管理系统的接口
 *
 * @author fengshuonan
 * @Date 2018/4/17 23:14
 */
@RestController
@ApiResource(name = "文件后台管理", path = "/fileManager")
@Slf4j
public class FileManagerController {

    @Autowired
    private FileinfoService fileinfoService;

    /**
     * 获取文件列表
     *
     * @author fengshuonan
     * @Date 2018/7/27 下午4:10
     */
    @PostResource(name = "查询文件列表", path = "/getFileInfoList")
    public ResponseData getFileInfoList(RequestData requestData) {
        Fileinfo fileinfo = requestData.parse(Fileinfo.class);
        Page<Fileinfo> page = PageFactory.defaultPage();

        List<Fileinfo> results = fileinfoService.getFileInfoList(page, fileinfo);
        page.setRecords(results);
        return ResponseData.success(results);
    }

}

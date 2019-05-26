package com.mohism.pudding.base.route.server.modular.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.route.entity.DynamicVersion;

import com.mohism.pudding.base.route.server.config.RedisConfig;
import com.mohism.pudding.base.route.server.modular.service.DynamicVersionService;
import com.mohism.pudding.core.page.PageFactory;
import com.mohism.pudding.core.reqres.request.RequestData;
import com.mohism.pudding.core.reqres.response.ResponseData;
import com.mohism.pudding.kernel.scanner.modular.stereotype.ApiResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ApiResource(name = "路由版本号信息", path = "/routeVersion")
public class DynamicVersionController {

    @Autowired
    private DynamicVersionService dynamicVersionService;
    @Autowired
    private StringRedisTemplate   redisTemplate;

    /**
     * 添加路由版本信息
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "添加路由版本信息", path = "/add")
    public ResponseData add(RequestData requestData){
        DynamicVersion version = requestData.parse(DynamicVersion.class);
        this.dynamicVersionService.save(version);
        return ResponseData.success();
    }

    /**
     * 获取最后一次发布的版本号
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "获取路由最新版本号", path = "/lastVersion")
    public ResponseData getLastVersion(){
        Map<String,Object> data =  new HashMap<String,Object>();
        Long versionId = 0L;
        String result = this.redisTemplate.opsForValue().get(RedisConfig.versionKey);
        if(!StringUtils.isEmpty(result)){
            System.out.println("返回 redis 缓存的版本信息......");
            versionId = Long.valueOf(result);
        }else{
            System.out.println("返回 mysql最新的版本信息......");
            versionId = this.dynamicVersionService.getLastVersion();
            redisTemplate.opsForValue().set(RedisConfig.versionKey , String.valueOf(versionId));
        }
        data.put("versionId",versionId);
        return ResponseData.success(data);
    }
    /**
     * 发布版本列表
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "获取发布的路由版本列表", path = "/versionList")
    public ResponseData getDynamicVersionList(RequestData requestData){
        Page<DynamicVersion> page = PageFactory.defaultPage();
        DynamicVersion  dictInfo = requestData.parse(DynamicVersion.class);
        List<DynamicVersion> dynamicVersionList = this.dynamicVersionService.getDynamicVersionList(page, dictInfo);
        page.setRecords(dynamicVersionList);
        return ResponseData.success(page);
    }

}

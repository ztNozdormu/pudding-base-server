package com.mohism.pudding.base.route.api;


import com.mohism.pudding.base.route.entity.DynamicVersion;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 动态路由版本相关的远程调用
 *
 * @author real earth
 * @date 2019-05-25-上午10:12
 */
@RequestMapping("/api/routesVersion")
public interface DynamicVersionApi {

    public boolean addDynamicVersion(DynamicVersion version);

    public boolean update(DynamicVersion version);

    public boolean delete(Long id);

    /**
     * 获取最后一次发布的版本号--这个方法要改
     * @return
     */
    public Long getLastVersion();

    public List<DynamicVersion> getDynamicVersionList(@RequestBody DynamicVersion dynamicVersion, @RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize);
}

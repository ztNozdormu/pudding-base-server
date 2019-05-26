package com.mohism.pudding.base.route.server.modular.provider;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.route.api.DynamicVersionApi;
import com.mohism.pudding.base.route.entity.DynamicVersion;
import com.mohism.pudding.base.route.entity.GatewayRoute;
import com.mohism.pudding.base.route.server.modular.service.DynamicVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 日志服务接口
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-27
 */
@Service
public class DynamicVersionProvider implements DynamicVersionApi {

    @Autowired
    private DynamicVersionService dynamicVersionService;
    @Override
    public boolean addDynamicVersion(@RequestBody DynamicVersion dynamicVersion) {
        return dynamicVersionService.addDynamicVersion(dynamicVersion);
    }

    @Override
    public boolean update(@RequestBody DynamicVersion dynamicVersion) {
        return dynamicVersionService.update(dynamicVersion);
    }

    @Override
    public boolean delete(@RequestParam("id")Long id) {
        return dynamicVersionService.delete(id);
    }

    @Override
    public Long getLastVersion() {
        return dynamicVersionService.getLastVersion();
    }

    @Override
    public List<DynamicVersion> getDynamicVersionList(@RequestBody DynamicVersion dynamicVersion, @RequestParam("pageNo") Integer pageNo,
                                                      @RequestParam("pageSize") Integer pageSize) {
        return dynamicVersionService.getDynamicVersionList(new Page(pageNo, pageSize), dynamicVersion);
    }
}

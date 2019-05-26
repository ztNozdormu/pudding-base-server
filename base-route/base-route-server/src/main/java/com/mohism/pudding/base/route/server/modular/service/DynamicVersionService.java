package com.mohism.pudding.base.route.server.modular.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohism.pudding.base.route.entity.DynamicVersion;
import com.mohism.pudding.base.route.server.config.RedisConfig;
import com.mohism.pudding.base.route.server.modular.mapper.DynamicVersionMapper;
import com.mohism.pudding.core.page.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DynamicVersionService extends ServiceImpl<DynamicVersionMapper, DynamicVersion> {

    @Autowired private StringRedisTemplate  redisTemplate;
    @Autowired private GatewayRoutesService routesService;

    public boolean addDynamicVersion(DynamicVersion version) {

        version.setCreateTime(new Date());
        boolean result = this.save(version);

        //发布时，把版本信息与路由信息存入redis
        redisTemplate.opsForValue().set(RedisConfig.versionKey , String.valueOf(version.getId()));
        redisTemplate.opsForValue().set(RedisConfig.routeKey , JSON.toJSONString(routesService.getRouteDefinitions()));

        return result;
    }

    public boolean update(DynamicVersion version) {
        return this.updateById(version);
    }

    public boolean delete(Long id) {
        return this.delete(id);
    }

    /**
     * 获取最后一次发布的版本号
     * @return
     */
    public Long getLastVersion() {
        return this.getLastVersion();
    }

    public List<DynamicVersion> getDynamicVersionList(Page page, DynamicVersion dynamicVersion) {
        if (page == null) {
            page = PageFactory.defaultPage();
        }

        if (dynamicVersion == null) {
            dynamicVersion = new DynamicVersion();
        }
        return baseMapper.getDynamicVersionList(page, dynamicVersion);
    }
}

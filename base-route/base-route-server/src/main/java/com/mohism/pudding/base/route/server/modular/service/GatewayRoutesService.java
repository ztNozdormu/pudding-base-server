package com.mohism.pudding.base.route.server.modular.service;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohism.pudding.base.route.dto.GatewayRouteDefinition;
import com.mohism.pudding.base.route.entity.GatewayRoute;
import com.mohism.pudding.base.route.server.modular.mapper.GatewayRoutesMapper;
import com.mohism.pudding.core.page.PageFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GatewayRoutesService extends ServiceImpl<GatewayRoutesMapper, GatewayRoute> {


    public boolean add(GatewayRoute route) {

            route.setIsEbl(false);
            route.setIsDel(false);
            route.setCreateTime(new Date());
            route.setUpdateTime(new Date());

        return this.save(route);
    }

    public boolean update(GatewayRoute route) {

          route.setUpdateTime(new Date());

        return this.updateById(route);
    }

    public boolean delete(Long id, boolean isDel) {

        return this.delete(id , isDel);
    }

    public boolean enableById(Long id, boolean isEbl) {
        return this.enableById(id , isEbl);
    }

    public GatewayRoute getById(Long id) {
        return this.getById(id);
    }

    /**
     * 查询路由信息--分页
     * @return
     */
    public List<GatewayRoute> getGatewayRouteList(Page page, GatewayRoute route) {
        if (page == null) {
            page = PageFactory.defaultPage();
        }

        if (route == null) {
            route = new GatewayRoute();
        }
        return baseMapper.getGatewayRouteList(page, route);
    }
    public List<GatewayRoute>  getAllList(){
        QueryWrapper<GatewayRoute> wrapper = new QueryWrapper<GatewayRoute>().eq("isDel", false).eq("isEbl",false);
        return this.list(wrapper);
    }
    /**
     * 返回组装后网关需要的路由信息
     * @return
     */
    public List<GatewayRouteDefinition> getRouteDefinitions() {
        List<GatewayRouteDefinition> routeDefinitions = new ArrayList<>();
        List<GatewayRoute> routes = this.getAllList();
        for(GatewayRoute gatewayRoute : routes){
            GatewayRouteDefinition routeDefinition = new GatewayRouteDefinition();
            routeDefinition.setId(gatewayRoute.getRouteId());
            routeDefinition.setUri(gatewayRoute.getRouteUri());
            routeDefinition.setFilters(gatewayRoute.getFilterDefinition());
            routeDefinition.setPredicates(gatewayRoute.getPredicateDefinition());
            routeDefinitions.add(routeDefinition);
        }
        return routeDefinitions;
    }
}

package com.mohism.pudding.base.route.server.modular.provider;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.route.api.GatewayRouteApi;
import com.mohism.pudding.base.route.entity.DynamicVersion;
import com.mohism.pudding.base.route.entity.GatewayRoute;
import com.mohism.pudding.base.route.server.modular.service.GatewayRoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class GatewayRouteProvider implements GatewayRouteApi {

    @Autowired
    private GatewayRoutesService gatewayRoutesService;
    @Override
    public boolean add(@RequestBody GatewayRoute route) {
        return gatewayRoutesService.add(route);
    }

    @Override
    public boolean update(@RequestBody GatewayRoute route) {
        return gatewayRoutesService.update(route);
    }

    @Override
    public boolean delete(@RequestParam("id") Long id,@RequestParam("isDel") boolean isDel) {
        return gatewayRoutesService.delete(id,isDel);
    }

    @Override
    public boolean enableById(@RequestParam("id") Long id,@RequestParam("isEbl") boolean isEbl) {
        return gatewayRoutesService.enableById(id,isEbl);
    }

    @Override
    public GatewayRoute getById(@RequestParam("id") Long id) {
        return gatewayRoutesService.getById(id);
    }

    @Override
    public List<GatewayRoute> getGatewayRouteList(@RequestBody GatewayRoute route, @RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize) {
        return this.gatewayRoutesService.getGatewayRouteList(new Page(pageNo, pageSize), route);
    }
    @Override
    public List<GatewayRoute> getAllList() {
        return this.gatewayRoutesService.getAllList();
    }
}

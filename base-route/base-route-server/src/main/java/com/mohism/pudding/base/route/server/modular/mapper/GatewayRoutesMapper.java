package com.mohism.pudding.base.route.server.modular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.route.entity.GatewayRoute;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GatewayRoutesMapper extends BaseMapper<GatewayRoute>{

    public List<GatewayRoute> getGatewayRouteList(Page page, GatewayRoute route);
}
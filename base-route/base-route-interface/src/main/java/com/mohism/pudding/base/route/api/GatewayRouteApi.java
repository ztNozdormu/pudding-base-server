package com.mohism.pudding.base.route.api;

import com.mohism.pudding.base.route.entity.GatewayRoute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 动态路由相关的远程调用
 *
 * @author real earth
 * @date 2019-05-25-上午10:12
 */
@RequestMapping("/api/routes")
public interface GatewayRouteApi {

    public boolean add(GatewayRoute route);

    public boolean update(GatewayRoute route);

    public boolean delete(Long id, boolean isDel);

    public boolean enableById(Long id, boolean isEbl);

    public GatewayRoute getById(Long id);

    public List<GatewayRoute> getGatewayRouteList(@RequestBody GatewayRoute route, @RequestParam("pageNo") Integer pageNo,
                                           @RequestParam("pageSize") Integer pageSize);
    public List<GatewayRoute> getAllList();
}

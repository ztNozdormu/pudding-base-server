package com.mohism.pudding.base.route.server.modular.controller;

import com.alibaba.fastjson.JSON;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.route.entity.GatewayRoute;
import com.mohism.pudding.base.route.server.config.RedisConfig;
import com.mohism.pudding.base.route.server.modular.service.GatewayRoutesService;
import com.mohism.pudding.core.page.PageFactory;
import com.mohism.pudding.core.reqres.request.RequestData;
import com.mohism.pudding.core.reqres.response.ResponseData;
import com.mohism.pudding.kernel.scanner.modular.stereotype.ApiResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ApiResource(name = "网关路由信息", path = "/routes")
public class GatewayRoutesController {

    @Autowired
    private GatewayRoutesService routesService;
    @Autowired
    private StringRedisTemplate  redisTemplate;

    /**
     * 获取路由信息
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "获取路由信息", path = "/routes")
    public ResponseData getRouteDefinitions(){

        Map<String,Object> data = new HashMap<String,Object>();
        //先从redis中取，再从mysql中取
        String result = redisTemplate.opsForValue().get(RedisConfig.routeKey);
        if(!StringUtils.isEmpty(result)){
        }else{
            result = JSON.toJSONString(routesService.getRouteDefinitions());
            //再set到redis
            redisTemplate.opsForValue().set(RedisConfig.routeKey , result);
        }
        return ResponseData.success(data);

    }
    /**
     * 添加路由信息
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "添加路由信息", path = "/add")
    public ResponseData add(RequestData requestData){
        GatewayRoute route = requestData.parse(GatewayRoute.class);
           this.routesService.add(route);
        return ResponseData.success();
    }

    /**
     * 通过ID获取路由详细信息
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "获取路由详细信息", path = "/detail")
    public ResponseData routeDetail(RequestData requestData){
        GatewayRoute route = requestData.parse(GatewayRoute.class);
          this.routesService.getById(route.getId());
        return ResponseData.success();
    }
    /**
     * 修改路由信息
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "修改路由信息", path = "/update")
    public ResponseData update(RequestData requestData){
        GatewayRoute route = requestData.parse(GatewayRoute.class);
           this.routesService.updateById(route);
        return ResponseData.success();
    }

    /**
     * 修改路由信息
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "删除路由信息", path = "/delete")
    public ResponseData delete(RequestData requestData){
        GatewayRoute route = requestData.parse(GatewayRoute.class);
          this.routesService.delete(route.getId(), true);
        return ResponseData.success();
    }
    /**
     * 获取有效的路由列表
     * @author real earth
     * @Date 2019/5/25 晚上23:03
     */
    @PostMapping(name = "获取有效的路由列表", path = "/list")
    public ResponseData list(RequestData requestData){
        Page<GatewayRoute> page = PageFactory.defaultPage();
        GatewayRoute route = requestData.parse(GatewayRoute.class);
        if(StringUtils.isEmpty(route.getIsDel())){
            route.setIsDel(false);
        }
        if(StringUtils.isEmpty(route.getIsEbl())) {
            route.setIsEbl(false);
        }
        List<GatewayRoute> routes = this.routesService.getGatewayRouteList(page,route);
        page.setRecords(routes);
        return ResponseData.success(page);
    }

}

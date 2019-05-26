package com.mohism.pudding.base.route.dto;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 过滤器模型
 * zhuyu 2019-01-17
 */
@Data
public class GatewayFilterDefinition {

    //Filter Name
    private String name;
    //对应的路由规则
    private Map<String, String> args = new LinkedHashMap<>();

}

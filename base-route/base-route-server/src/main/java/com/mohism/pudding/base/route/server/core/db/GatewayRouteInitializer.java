package com.mohism.pudding.base.route.server.core.db;


import cn.hutool.core.lang.Dict;
import com.mohism.pudding.core.db.DbInitializer;

/**
 * 网关路由信息表
 *
 * @author real earth
 * @date 2019-05-26-晚上12:04
 */
public class GatewayRouteInitializer extends DbInitializer {

    @Override
    public String getTableInitSql() {
        return "CREATE TABLE `gateway_route` (\n" +
                " `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `route_id` varchar(64) DEFAULT NULL COMMENT '路由id',\n" +
                "  `route_uri` varchar(128) DEFAULT NULL COMMENT '转发目标uri',\n" +
                "  `route_order` int(11) DEFAULT NULL COMMENT '路由执行顺序',\n" +
                "  `predicates` text COMMENT '断言字符串集合，字符串结构：[{'name':'Path','args':{'pattern':'/zy/**'}}]',\n" +
                "  `filters` text COMMENT '过滤器字符串集合，字符串结构：{'name':'StripPrefix','args':{'_genkey_0':'1'}}',\n"+
                "  `is_ebl` tinyint(1) DEFAULT NULL COMMENT '是否启用',\n" +
                "  `is_del` tinyint(1) DEFAULT NULL COMMENT '是否删除',\n" +
                "  `create_time` datetime DEFAULT NULL COMMENT '创建时间',\n" +
                "  `update_time` datetime DEFAULT NULL COMMENT '修改时间',\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                " ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='路由信息表'";
    }

    @Override
    public String getTableName() {
        return "gateway_route";
    }

    @Override
    public Class<?> getEntityClass() {
        return Dict.class;
    }
}

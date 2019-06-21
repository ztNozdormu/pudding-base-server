package com.mohism.pudding.base.route.server.core.db;


import com.mohism.pudding.base.route.entity.DynamicVersion;
import com.mohism.pudding.core.db.DbInitializer;

 /**
 *  网关路由版本信息表
 *
 * @author real earth
 * @date 2019-05-26-晚上12:04
 */
public class DynamicVersionInitializer extends DbInitializer {

    @Override
    public String getTableInitSql() {
        return "CREATE TABLE `dynamic_version` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、版本号',\n" +
                "  `create_time` datetime DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='路由版本信息表'";
    }

    @Override
    public String getTableName() {
        return "dynamic_version";
    }

    @Override
    public Class<?> getEntityClass() {
        return DynamicVersion.class;
    }
}

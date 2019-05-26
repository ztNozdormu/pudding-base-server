
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gateway_routes
-- ----------------------------
DROP TABLE IF EXISTS `gateway_routes`;
CREATE TABLE `gateway_routes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `route_id` varchar(64) DEFAULT NULL COMMENT '路由id',
  `route_uri` varchar(128) DEFAULT NULL COMMENT '转发目标uri',
  `route_order` int(11) DEFAULT NULL COMMENT '路由执行顺序',
  `predicates` text COMMENT '断言字符串集合，字符串结构：[{\r\n                "name":"Path",\r\n                "args":{\r\n                   "pattern" : "/zy/**"\r\n                }\r\n              }]',
  `filters` text COMMENT '过滤器字符串集合，字符串结构：{\r\n              	"name":"StripPrefix",\r\n              	 "args":{\r\n              	 	"_genkey_0":"1"\r\n              	 }\r\n              }',
  `is_ebl` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `is_del` tinyint(1) DEFAULT NULL COMMENT '是否删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


-- ----------------------------
-- Table structure for dynamic_version
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_version`;
CREATE TABLE `dynamic_version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键、自动增长、版本号',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;



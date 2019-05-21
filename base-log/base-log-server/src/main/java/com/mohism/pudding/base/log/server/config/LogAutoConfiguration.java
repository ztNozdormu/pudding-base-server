package com.mohism.pudding.base.log.server.config;

import com.mohism.pudding.base.log.server.core.db.CommonLogInitializer;
import com.mohism.pudding.base.log.server.core.db.TraceLogInitializer;
import com.mohism.pudding.base.log.server.core.listener.LogMessageListener;
import com.mohism.pudding.base.log.server.modular.controller.LogController;
import com.mohism.pudding.base.log.server.modular.provider.LogServiceProvider;
import com.mohism.pudding.base.log.server.modular.service.CommonLogService;
import com.mohism.pudding.base.log.server.modular.service.TraceLogService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志服务的自动配置
 *
 * @author fengshuonan
 * @date 2018-07-30-下午3:44
 */
@Configuration
public class LogAutoConfiguration {

    /**
     * 数据库初始化
     */
    @Bean
    public CommonLogInitializer commonLogInitializer() {
        return new CommonLogInitializer();
    }

    @Bean
    public TraceLogInitializer traceLogInitializer() {
        return new TraceLogInitializer();
    }

    /**
     * 日志的消息监听器
     */
    @Bean
    public LogMessageListener logMessageListener() {
        return new LogMessageListener();
    }

    /**
     * 控制器
     */
    @Bean
    public LogController logController() {
        return new LogController();
    }

    /**
     * service服务
     */
    @Bean
    public CommonLogService commonLogService() {
        return new CommonLogService();
    }

    @Bean
    public TraceLogService traceLogService() {
        return new TraceLogService();
    }

    /**
     * 服务提供者
     */
    @Bean
    public LogServiceProvider logServiceProvider() {
        return new LogServiceProvider();
    }

}

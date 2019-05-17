package com.mohism.pudding.base.log.server.controller;


import com.mohism.pudding.base.log.entity.TraceLog;
import com.mohism.pudding.base.log.server.factory.CommonLogFactory;
import com.mohism.pudding.base.log.server.factory.TraceLogFactory;
import com.mohism.pudding.base.log.server.model.CommonLogCondition;
import com.mohism.pudding.base.log.server.model.CommonLogParams;
import com.mohism.pudding.base.log.server.model.TraceLogCondition;
import com.mohism.pudding.base.log.server.model.TraceLogParams;
import com.mohism.pudding.base.log.server.service.CommonLogService;
import com.mohism.pudding.base.log.server.service.TraceLogService;
import com.mohism.pudding.core.reqres.request.RequestData;
import com.mohism.pudding.core.reqres.response.ResponseData;
import com.mohism.pudding.kernel.model.page.PageResult;
import com.mohism.pudding.kernel.scanner.modular.stereotype.ApiResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志管理
 *
 * @author fengshuonan
 * @Date 2018/4/17 23:14
 */
@RestController
@ApiResource(name = "日志管理", path = "/log")
@Slf4j
public class LogController {

    @Autowired
    private CommonLogService commonLogService;

    @Autowired
    private TraceLogService traceLogService;

    /**
     * 获取普通日志列表
     *
     * @author fengshuonan
     * @Date 2018/8/1 下午2:42
     */
    @PostMapping(name = "查询普通日志列表", path = "/getCommonLogList")
    public ResponseData getCommonLogList(RequestData requestData) {
        Object request = CommonLogFactory.getRequest(requestData);

        if (request instanceof CommonLogParams) {
            CommonLogParams commonLogParams = (CommonLogParams) request;
            return ResponseData.success(commonLogService.getCommonLogList(commonLogParams));
        } else if (request instanceof CommonLogCondition) {
            CommonLogCondition commonLogCondition = (CommonLogCondition) request;
            return ResponseData.success(commonLogService.getCommonLogListByCondition(commonLogCondition));
        }

        return ResponseData.success();
    }

    /**
     * 获取调用链日志列表
     *
     * @author fengshuonan
     * @Date 2018/8/1 下午2:42
     */
    @PostMapping(name = "查询调用链日志列表", path = "/getTraceLogList")
    public ResponseData getTraceLogList(RequestData requestData) {
        Object request = TraceLogFactory.getRequest(requestData);

        if (request instanceof TraceLogParams) {
            TraceLogParams traceLogParams = (TraceLogParams) request;
            return ResponseData.success(this.traceLogService.getTraceLogList(traceLogParams));
        } else if (request instanceof TraceLogCondition) {
            TraceLogCondition traceLogCondition = (TraceLogCondition) request;
            PageResult<TraceLog> traceLogList = traceLogService.getTraceLogListByCondition(traceLogCondition);
            return ResponseData.success(traceLogList);
        }

        return ResponseData.success();
    }

}
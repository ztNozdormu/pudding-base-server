package com.mohism.pudding.base.log.server.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mohism.pudding.base.log.entity.CommonLog;
import com.mohism.pudding.base.log.server.factory.CommonLogFactory;
import com.mohism.pudding.base.log.server.mapper.CommonLogMapper;
import com.mohism.pudding.base.log.server.model.CommonLogCondition;
import com.mohism.pudding.base.log.server.model.CommonLogParams;
import com.mohism.pudding.kernel.model.page.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-30
 */
@Service
public class CommonLogService extends ServiceImpl<CommonLogMapper, CommonLog> {

    /**
     * 获取普通日志列表（没有查询条件的）
     *
     * @author fengshuonan
     * @Date 2018/8/1 下午4:10
     */
    public PageResult<CommonLog> getCommonLogList(CommonLogParams commonLogParams) {
        Long commonLogCount = this.baseMapper.getCommonLogCount();

        if (commonLogParams.getGtValue() == null) {
            commonLogParams.setGtValue(commonLogCount);
        }

        List<CommonLog> commonLogList = this.baseMapper.getCommonLogList(commonLogParams);
        return CommonLogFactory.getResponse(commonLogList, commonLogCount, commonLogParams);
    }

    /**
     * 获取普通日志列表（带查询条件的）
     *
     * @author fengshuonan
     * @Date 2018/8/1 下午4:10
     */
    public PageResult<CommonLog> getCommonLogListByCondition(CommonLogCondition commonLogCondition) {
        List<CommonLog> commonLogList = this.baseMapper.getCommonLogListByCondition(commonLogCondition);
        return CommonLogFactory.getResponseCondition(commonLogList, commonLogCondition);
    }

}

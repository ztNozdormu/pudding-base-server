package com.mohism.pudding.base.log.server.modular.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.log.entity.CommonLog;
import com.mohism.pudding.base.log.server.modular.model.CommonLogCondition;
import com.mohism.pudding.base.log.server.modular.model.CommonLogParams;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-30
 */
public interface CommonLogMapper extends BaseMapper<CommonLog> {

    /**
     * 获取常规日志总数量
     *
     * @author fengshuonan
     * @Date 2018/7/31 下午5:51
     */
    Long getCommonLogCount();

    /**
     * 获取常规日志列表
     *
     * @author fengshuonan
     * @Date 2018/7/31 下午5:51
     */
    List<CommonLog> getCommonLogList(CommonLogParams commonLogParams);

    /**
     * 获取常规日志列表(条件查询)
     *
     * @author fengshuonan
     * @Date 2018/7/31 下午5:51
     */
    List<CommonLog> getCommonLogListByCondition(CommonLogCondition commonLogCondition);

    /**
     * 获取常规日志列表(条件查询和分页)
     *
     * @author fengshuonan
     * @Date 2018/7/31 下午5:51
     */
    List<CommonLog> getCommonLogListPageByCondition(Page<CommonLog> page, CommonLogCondition commonLogCondition);

}

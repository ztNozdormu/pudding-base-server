package com.mohism.pudding.base.dict.server.modular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.dict.api.entity.Dict;
import com.mohism.pudding.base.dict.api.model.DictInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 基础字典 Mapper 接口
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-24
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

    /**
     * 获取字典列表
     *
     * @author fengshuonan
     * @Date 2018/7/25 下午5:21
     */
    List<DictInfo> getDictList(Page page, DictInfo dictInfo);

}

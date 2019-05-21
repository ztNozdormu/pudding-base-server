package com.mohism.pudding.base.dict.server.modular.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.dict.api.entity.DictType;
import com.mohism.pudding.base.dict.api.model.DictTypeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 字典类型表 Mapper 接口
 * </p>
 *
 * @author fengshuonan
 * @since 2018-07-24
 */
@Mapper
public interface DictTypeMapper extends BaseMapper<DictType> {

    /**
     * 获取字典类型列表
     *
     * @author fengshuonan
     * @Date 2018/7/25 上午11:24
     */
    List<DictTypeInfo> getDictTypeList(Page page, DictTypeInfo dictTypeInfo);

}

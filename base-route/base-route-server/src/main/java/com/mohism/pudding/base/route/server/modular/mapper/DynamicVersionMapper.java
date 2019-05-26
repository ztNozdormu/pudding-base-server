package com.mohism.pudding.base.route.server.modular.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mohism.pudding.base.route.entity.DynamicVersion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DynamicVersionMapper extends BaseMapper<DynamicVersion> {

    //获取最后一次发布的版本号
    Long getLastVersion();

    public List<DynamicVersion> getDynamicVersionList(Page page,DynamicVersion ynamicVersion);
}
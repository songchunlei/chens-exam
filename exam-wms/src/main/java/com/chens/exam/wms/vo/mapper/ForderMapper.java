package com.chens.exam.wms.vo.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chens.exam.core.vo.AbstractForder;

/**
 * <p>
 * 文件夹表 Mapper 接口
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public interface ForderMapper<FILE,T extends AbstractForder<FILE,T>> extends BaseMapper<T> {

}
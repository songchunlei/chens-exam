package com.chens.exam.wms.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.wms.mapper.SourceMapper;
import com.chens.exam.wms.service.ISourceService;

/**
 * <p>
 * 资源素材表 服务实现类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@Service
public class SourceServiceImpl extends ServiceImpl<SourceMapper, Source> implements ISourceService {

}

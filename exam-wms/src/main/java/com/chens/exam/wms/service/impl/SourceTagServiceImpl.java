package com.chens.exam.wms.service.impl;

import com.chens.exam.core.entity.wms.SourceTag;
import com.chens.exam.wms.mapper.SourceTagMapper;
import com.chens.exam.wms.service.ISourceTagService;
import com.chens.exam.wms.vo.service.impl.TagServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 *  服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@Service
public class SourceTagServiceImpl extends TagServiceImpl<SourceTagMapper, SourceTag> implements ISourceTagService {
	
}

package com.chens.exam.wms.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.core.entity.wms.SourceForder;
import com.chens.exam.core.entity.wms.SourceTag;
import com.chens.exam.wms.mapper.SourceForderMapper;
import com.chens.exam.wms.mapper.SourceTagMapper;
import com.chens.exam.wms.service.ISourceForderService;
import com.chens.exam.wms.service.ISourceService;
import com.chens.exam.wms.service.ISourceTagService;
import com.chens.exam.wms.vo.service.impl.ForderServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 *  服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@Service
public class SourceForderServiceImpl extends ForderServiceImpl<Source,ISourceService,SourceForderMapper, SourceForder> implements ISourceForderService {
	
}

package com.chens.exam.wms.service.impl;

import com.chens.exam.core.entity.wms.QuestionTag;
import com.chens.exam.wms.mapper.QuestionTagMapper;
import com.chens.exam.wms.service.IQuestionTagService;
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
public class QuestionTagServiceImpl extends TagServiceImpl<QuestionTagMapper, QuestionTag> implements IQuestionTagService {
	
}

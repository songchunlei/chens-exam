package com.chens.exam.wms.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.chens.exam.core.entity.wms.Questions;

/**
 *
 * 题目表 Mapper 接口
 *
 * @author wdp
 * @create 2018-04-06
 */
public interface QuestionsMapper extends BaseMapper<Questions> {

	Questions selectQuestionDetail(Questions questions);
}
package com.chens.exam.wms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.bpm.controller.BaseWfWebController;
import com.chens.exam.core.entity.wms.Questions;
import com.chens.exam.core.enums.WfProcessDefinitionKeyEnum;
import com.chens.exam.wms.service.IQuestionsService;

/**
 *
 * 题目表 控制器
 *
 * @author wdp
 * @create 2018-04-06
 */
@Controller
@RequestMapping("/questionsController")
public class QuestionsController extends BaseWfWebController<IQuestionsService,Questions> {

	@Autowired
	private IQuestionsService questionsService;

	@Override
	protected void init(Questions questions) {
		questions.setProcessDefinitionKey(WfProcessDefinitionKeyEnum.QUESTION_APPROVE.getCode());
		questions.setTaskName(questions.getName());
	}
	
}

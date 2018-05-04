package com.chens.exam.wms.controller;


import com.chens.core.constants.CommonConstants;
import com.chens.core.context.BaseContextHandler;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.share.vo.AbstractShare;
import com.chens.share.vo.service.IAbstractShareService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.chens.bpm.controller.BaseWfWebController;
import com.chens.exam.core.entity.wms.Questions;
import com.chens.exam.core.enums.WfProcessDefinitionKeyEnum;
import com.chens.exam.wms.service.IQuestionsService;

import java.util.Date;

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

	@Override
	protected String getProcessDefinitionKey() {
		return WfProcessDefinitionKeyEnum.QUESTION_APPROVE.getCode();
	}

	@Override
	protected String getProcessTaskName(Questions questions) {
		return questions.getName();
	}

}

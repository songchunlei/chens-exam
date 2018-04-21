package com.chens.exam.wms.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.bpm.controller.BaseWfWebController;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
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
	
	
	/**
	 * 获取题目详情
	 * @param questions
	 * @return
	 */
	@PostMapping("/selectQuestionDetail")
    public ResponseEntity<Result> selectQuestionDetail(@RequestBody Questions questions) {
        if(questions != null && StringUtils.isNotBlank(questions.getId())){
            return doSuccess("查询成功",questionsService.selectById(questions.getId()));
        } else {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }
	
}

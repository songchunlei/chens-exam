package com.chens.exam.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.bpm.controller.WfBaseController;
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
public class QuestionsController extends WfBaseController<IQuestionsService,Questions> {

	@Autowired
	private IQuestionsService questionsService;
	
	@Override
	protected void init(Questions questions) {
		questions.setProcessDefinitionKey(WfProcessDefinitionKeyEnum.QUESTION_APPROVE.getCode());
	}

	/**
	 * 保存题目  包含新增和修改
	 * @param questions
	 * @return
	 */
	@PostMapping("/saveQuestions")
    public ResponseEntity<Result> saveQuestions(@RequestBody @Validated Questions questions) {
        if(questions != null){
        	this.doInit(questions);
            return doSuccess("保存成功",questionsService.saveQuestions(workFlowRequestParam));
        } else {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }
	
	
	/**
	 * 提交题目审批，包含新增提交和修改后提交
	 * @param questions
	 * @return
	 */
	@PostMapping("/submitQuestions")
    public ResponseEntity<Result> submitQuestions(@RequestBody @Validated Questions questions) {
        if(questions != null){
        	this.doInit(questions);
            return doSuccess("提交成功",questionsService.submitQuestions(workFlowRequestParam));
        } else {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }
}

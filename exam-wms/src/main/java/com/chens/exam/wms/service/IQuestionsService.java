package com.chens.exam.wms.service;

import com.chens.bpm.service.IWfBaseService;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.exam.core.entity.wms.Questions;

/**
 *
 * 题目表 服务接口
 *
 * @author wdp
 * @create 2018-04-06
 */
public interface IQuestionsService extends IWfBaseService<Questions> {
	
	/**
	 * 保存草稿
	 * @param workFlowRequestParam
	 * @return
	 */
	 String saveQuestions(WorkFlowRequestParam<Questions> workFlowRequestParam);
	 
	 /**
	  * 提交题目审批(框架接管)
	  * @param workFlowRequestParam
	  * @return
	  */
	 //boolean submitQuestions(WorkFlowRequestParam<Questions> workFlowRequestParam);
	 
}

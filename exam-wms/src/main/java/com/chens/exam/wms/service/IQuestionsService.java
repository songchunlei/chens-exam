package com.chens.exam.wms.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.chens.bpm.service.IWfBaseService;
import com.chens.bpm.vo.MyDoneTask;
import com.chens.bpm.vo.MyStartProcessInstance;
import com.chens.bpm.vo.MyTodoTask;
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
	 
	 /**
	  * 查询题目详细信息
	  * @param questions
	  * @return
	  */
	 Questions selectQuestionDetail(Questions questions);
	 
	 /**
	     * 我的待办分页
	     * @param page
	     * @param myTodoTask
	     * @return
	     */
	 Page<MyTodoTask> getMyTodoTaskPage(Page<MyTodoTask> page, MyTodoTask myTodoTask);
	 
	 /**
	     * 我的待办分页
	     * @param page
	     * @param myTodoTask
	     * @return
	     */
	 Page<MyDoneTask> getMyDoneTaskPage(Page<MyDoneTask> page, MyDoneTask myDoneTask);
	 
	 
	 /**
	     * 我的申请/我发起的流程分页
	     * @param page
	     * @param myTodoTask
	     * @return
	     */
	 Page<MyStartProcessInstance> getMyStartProcessInstancePage(Page<MyStartProcessInstance> page, MyStartProcessInstance myStartProcessInstance);
	 
}

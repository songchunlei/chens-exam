package com.chens.exam.wms.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.chens.bpm.vo.MyDoneTask;
import com.chens.bpm.vo.MyStartProcessInstance;
import com.chens.bpm.vo.MyTodoTask;
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
	
	/**
	 * 我的待办
	 * @param page
	 * @param myTodoTask
	 * @return
	 */
	List<MyTodoTask> getMyTodoTaskPage(Pagination page, MyTodoTask myTodoTask);
	
	
	/**
	 * 我的待办
	 * @param page
	 * @param myTodoTask
	 * @return
	 */
	List<MyDoneTask> getMyDoneTaskPage(Pagination page, MyDoneTask myDoneTask);
	
	
	 
	 /**
     * 我的申请/我发起的流程分页
     * @param page
     * @param myTodoTask
     * @return
     */
	List<MyStartProcessInstance> getMyStartProcessInstancePage(Pagination page, MyStartProcessInstance myStartProcessInstance);
}
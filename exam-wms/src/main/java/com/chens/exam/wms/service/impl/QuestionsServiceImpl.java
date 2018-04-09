package com.chens.exam.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.bpm.entity.ProcessBussinessRel;
import com.chens.bpm.enums.WfStatus;
import com.chens.bpm.service.IProcessBussinessRelService;
import com.chens.bpm.service.IWfEngineService;
import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.core.enums.YesNoEnum;
import com.chens.exam.core.entity.wms.Questions;
import com.chens.exam.core.entity.wms.QuestionsOption;
import com.chens.exam.core.entity.wms.QuestionsQuote;
import com.chens.exam.wms.mapper.QuestionsMapper;
import com.chens.exam.wms.service.IQuestionsOptionService;
import com.chens.exam.wms.service.IQuestionsQuoteService;
import com.chens.exam.wms.service.IQuestionsService;

/**
 * 
 * 题目表 服务实现类
 *
 * @author wdp
 * @create 2018-04-06
 */
@Service
public class QuestionsServiceImpl extends BaseWfServiceImpl<QuestionsMapper, Questions> implements IQuestionsService {

	@Autowired
	private IProcessBussinessRelService processBussinessRelService;	
	@Autowired
	private IQuestionsOptionService questionsOptionService;	
	@Autowired
	private IQuestionsQuoteService questionsQuoteService;
	@Autowired
	private IWfEngineService wfEngineService;
	@Autowired
	private QuestionsMapper questionMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String saveQuestions(WorkFlowRequestParam<Questions> workFlowRequestParam) {
		Questions questions = workFlowRequestParam.getT();
		if(StringUtils.isNotBlank(questions.getId())){
			deleteRelationShip(questions);
			buildRelationShip(questions);
			this.updateById(questions);			
		}else{
			this.insert(questions);
			buildRelationShip(questions);
			/**
			 * 保存业务数据
			 */
			//保存流程业务关联关系表
	        ProcessBussinessRel processBussinessRel = new ProcessBussinessRel();
			//任务名称
	        processBussinessRel.setTaskName(workFlowRequestParam.getTaskName());
			//草稿状态
	        processBussinessRel.setStatus(WfStatus.WAITING.getCode());
	        processBussinessRel.setProcessDefinitionKey(workFlowRequestParam.getProcessDefinitionKey());
			//业务数据id
	        processBussinessRel.setBusinessKey(questions.getId());
			//逻辑删除
	        processBussinessRel.setIsDelete(YesNoEnum.NO.getCode());
			//业务表名
	        processBussinessRel.setTableName(workFlowRequestParam.getTableName());
	        processBussinessRelService.insert(processBussinessRel);  
		}
                     
        return questions.getId();
    }
	
	/**
	 * 删除题目资源和题目选项关联关系
	 * @param questions
	 */
	public void deleteRelationShip(Questions questions){
		//删除题目资源关联关系
		QuestionsQuote questionsQuote = new QuestionsQuote();
		questionsQuote.setQuestionId(questions.getId());
		EntityWrapper<QuestionsQuote> qqEw = new EntityWrapper<QuestionsQuote>(questionsQuote);		
		questionsQuoteService.delete(qqEw);
		//删除题目选项选项关联关系
		QuestionsOption questionsOption = new QuestionsOption();
		questionsOption.setQuestionId(questionsOption.getId());
		EntityWrapper<QuestionsOption> qoEw = new EntityWrapper<QuestionsOption>(questionsOption);
		questionsOptionService.delete(qoEw);
	}
	
	/**
	 * 建立题目资源和题目选项关联关系
	 * @param questions
	 */
	public void buildRelationShip(Questions questions){
		//创建题目-选项关联关系
		List<QuestionsOption> questionsOptionList = questions.getQuestionsOptionList();
		if(CollectionUtils.isNotEmpty(questionsOptionList)){
			List<QuestionsOption> questionsOptionForInsertList = new ArrayList<QuestionsOption>();
			for(QuestionsOption questionsOption : questionsOptionList){
				questionsOption.setQuestionId(questions.getId());
				questionsOptionForInsertList.add(questionsOption);
			}		
			questionsOptionService.insertBatch(questionsOptionForInsertList);
		}
		//创建题目-资源关联关系
		List<QuestionsQuote> questionsQuoteList = questions.getQuestionsQuoteList();
		if(CollectionUtils.isNotEmpty(questionsQuoteList)){
			List<QuestionsQuote> questionsQuoteForInsertList = new ArrayList<QuestionsQuote>();
			for(QuestionsQuote questionsQuote : questionsQuoteList){
				questionsQuote.setQuestionId(questions.getId());
				questionsQuoteForInsertList.add(questionsQuote);
			}	
			questionsQuoteService.insertBatch(questionsQuoteForInsertList);
		}
	}

	@Override
	public Questions selectQuestionDetail(Questions questions) {
		return questionMapper.selectQuestionDetail(questions);
	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean beforeSubmit(WorkFlowRequestParam<Questions> workFlowRequestParam) {
		Questions questions = workFlowRequestParam.getT();
		if(StringUtils.isNotBlank(questions.getId())){
			this.deleteRelationShip(questions);
			this.buildRelationShip(questions);
			this.updateById(questions);
		}else{
			this.insert(questions);
			this.buildRelationShip(questions);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean afterSubmit(WorkFlowRequestParam<Questions> workFlowRequestParam) {
		return true;
	}
}

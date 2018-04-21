package com.chens.exam.wms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.chens.exam.core.entity.wms.QuestionsQuote;
import com.chens.exam.wms.service.IQuestionsQuoteService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.exam.core.entity.wms.Questions;
import com.chens.exam.core.entity.wms.QuestionsOption;
import com.chens.exam.wms.mapper.QuestionsMapper;
import com.chens.exam.wms.service.IQuestionsOptionService;
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
	private IQuestionsOptionService questionsOptionService;
	@Autowired
	private IQuestionsQuoteService questionsQuoteService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Questions saveEntity(Questions questions) {
		if(StringUtils.isNotBlank(questions.getId())){
			this.deleteRelationShip(questions);
			this.buildRelationShip(questions);
			this.updateById(questions);
		}else {
			this.insert(questions);
			this.buildRelationShip(questions);
		}
		return questions;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean beforeSubmit(WorkFlowRequestParam<Questions> workFlowRequestParam) {
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean afterSubmit(WorkFlowRequestParam<Questions> workFlowRequestParam) {
		return true;
	}
	
	@Override
	public Questions selectById(Serializable id) {

		//查询题目
		Questions questions = super.selectById(id);

		if(questions!=null)
		{
			//放入题目选项
			QuestionsOption queryQuestionsOption = new QuestionsOption();
			queryQuestionsOption.setQuestionId((String)id);
			questions.setQuestionsOptionList(questionsOptionService.selectList(new EntityWrapper<QuestionsOption>(queryQuestionsOption)));

			//放入题目-资源关系
			QuestionsQuote queryQuestionsQuote = new QuestionsQuote();
			queryQuestionsQuote.setDataId((String)id);
			questions.setQuestionsQuoteList(questionsQuoteService.selectList(new EntityWrapper<QuestionsQuote>(queryQuestionsQuote)));

			return questions;
		}
		return null;
	}

	/**
	 * 删除题目资源和题目选项关联关系
	 * @param questions
	 */
	@Transactional(rollbackFor = Exception.class)
	public void deleteRelationShip(Questions questions){
		//删除题目资源关联关系
		QuestionsQuote questionsQuote = new QuestionsQuote();
		questionsQuote.setDataId(questions.getId());
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
	@Transactional(rollbackFor = Exception.class)
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
			List<QuestionsQuote> questionsQuoteForInsertList = new ArrayList<>();
			for(QuestionsQuote questionsQuote : questionsQuoteList){
				questionsQuote.setDataId(questions.getId());
				questionsQuoteForInsertList.add(questionsQuote);
			}
			questionsQuoteService.insertBatch(questionsQuoteForInsertList);
		}
	}
	
	
}

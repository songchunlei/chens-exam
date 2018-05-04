package com.chens.exam.wms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.chens.exam.core.entity.wms.*;
import com.chens.exam.wms.service.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.core.util.UUIDUtil;
import com.chens.exam.wms.mapper.QuestionsMapper;

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
	@Autowired
	private IQuestionsOptionQuoteService questionsOptionQuoteService;
	@Autowired
	private ISourceService sourceService;


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
	public Questions selectById(Serializable id) {

		//查询题目
		Questions questions = super.selectById(id);

		if(questions != null)
		{
			//放入题目选项
			QuestionsOption queryQuestionsOption = new QuestionsOption();
			queryQuestionsOption.setQuestionId((String)id);
			List<QuestionsOption> optionList = questionsOptionService.selectList(new EntityWrapper<QuestionsOption>(queryQuestionsOption));
			List<Source> questionsOptionSourceList = new ArrayList<Source>();
			for(QuestionsOption questionsOption : optionList){
				//加入题目选项-资源关联关系
				QuestionsOptionQuote queryQuestionsOptionQuote = new QuestionsOptionQuote();
				queryQuestionsOptionQuote.setDataId(questionsOption.getId());
				List<String> questionsOptionQuoteList = questionsOptionQuoteService.getQuoteFileIdListByDataId(queryQuestionsOptionQuote);
				questionsOption.setQuoteRels(questionsOptionQuoteList);
				if(CollectionUtils.isNotEmpty(questionsOptionSourceList))
				{
					//选项-资源
					EntityWrapper<Source> sourceEntityWrapper = new EntityWrapper<Source>(new Source());
					sourceEntityWrapper.in("id",questionsOptionQuoteList);
					questionsOption.setSources(sourceService.selectList(sourceEntityWrapper));
				}

			}
			questions.setQuestionsOptionList(optionList);

			//放入题目-资源关系
			QuestionsQuote queryQuestionsQuote = new QuestionsQuote();
			queryQuestionsQuote.setDataId((String)id);
			List<String> quoteRels = questionsQuoteService.getQuoteFileIdListByDataId(queryQuestionsQuote);
			questions.setQuoteRels(quoteRels);
			if(CollectionUtils.isNotEmpty(quoteRels))
			{
				//选项-资源
				EntityWrapper<Source> sourceEntityWrapper = new EntityWrapper<Source>(new Source());
				sourceEntityWrapper.in("id",quoteRels);
				questions.setSources(sourceService.selectList(sourceEntityWrapper));
			}
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
		//删除题目选项-关联资源
		List<QuestionsOption> questionsOptionList = questionsOptionService.selectList(qoEw);
		if(CollectionUtils.isNotEmpty(questionsOptionList)){
			for(QuestionsOption option : questionsOptionList){
				QuestionsOptionQuote questionsOptionQuote = new QuestionsOptionQuote();
				questionsOptionQuote.setDataId(option.getId());
				EntityWrapper<QuestionsOptionQuote> qoqEw = new EntityWrapper<QuestionsOptionQuote>(questionsOptionQuote);
				questionsOptionQuoteService.delete(qoqEw);		
			}
		}
		
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
			//选项关联资源
			List<QuestionsOptionQuote> questionsOptionQuoteForInsertList = new ArrayList<QuestionsOptionQuote>();

			for(QuestionsOption questionsOption : questionsOptionList){
				questionsOption.setQuestionId(questions.getId());
				questionsOption.setId(UUIDUtil.getUUID());
				questionsOptionForInsertList.add(questionsOption);
				List<String> questionsOptionQuoteIdRels = questionsOption.getQuoteRels();
				if(CollectionUtils.isNotEmpty(questionsOptionQuoteIdRels)){
					for(String quoteRelId : questionsOptionQuoteIdRels){
						QuestionsOptionQuote questionsOptionQuote = new QuestionsOptionQuote();
						questionsOptionQuote.setDataId(questionsOption.getId());
						questionsOptionQuote.setFileId(quoteRelId);
						questionsOptionQuoteForInsertList.add(questionsOptionQuote);
					}
				}
			}
			questionsOptionService.insertBatch(questionsOptionForInsertList);
			if(CollectionUtils.isNotEmpty(questionsOptionQuoteForInsertList)){
				questionsOptionQuoteService.insertBatch(questionsOptionQuoteForInsertList);
			}
		}
		//创建题目-资源关联关系
		List<String> questionsQuoteIdList = questions.getQuoteRels();
		if(CollectionUtils.isNotEmpty(questionsQuoteIdList)){
			List<QuestionsQuote> questionsQuoteForInsertList = new ArrayList<>();
			for(String quoteRelId : questionsQuoteIdList){
				QuestionsQuote questionsQuote = new QuestionsQuote();
				questionsQuote.setFileId(quoteRelId);
				questionsQuote.setDataId(questions.getId());
				questionsQuoteForInsertList.add(questionsQuote);
			}
			questionsQuoteService.insertBatch(questionsQuoteForInsertList);
		}
	}
	
	
}

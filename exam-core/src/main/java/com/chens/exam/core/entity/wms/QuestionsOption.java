package com.chens.exam.core.entity.wms;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;

/**
 *
 * 题目选项表 实体
 *
 * @author wdp
 * @create 2018-04-06
 */
@TableName("t_questions_option")
public class QuestionsOption extends BaseEntity<QuestionsOption> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9113579367203163681L;
	/**
     * 题目id
     */
	@TableField("question_id")
	private String questionId;
    /**
     * 选项顺序
     */
	@TableField("option_seq")
	private Integer optionSeq;
    /**
     * 选项内容
     */
	@TableField("option_content")
	private String optionContent;
    /**
     * 备注
     */
	private String remark;
    /**
     * 逻辑删除
     */
	@TableField("is_delete")
	private String isDelete;
	
	/**
     * 是否正确答案
     */
	@TableField("is_right")
	private String isRight;

	/**
	 * 题目资源关联关系
	 */
	@TableField(exist = false)
	private List<QuestionsOptionQuote> questionsOptionQuoteList;
	


	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public Integer getOptionSeq() {
		return optionSeq;
	}

	public void setOptionSeq(Integer optionSeq) {
		this.optionSeq = optionSeq;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getIsRight() {
		return isRight;
	}

	public void setIsRight(String isRight) {
		this.isRight = isRight;
	}

	public List<QuestionsOptionQuote> getQuestionsOptionQuoteList() {
		return questionsOptionQuoteList;
	}

	public void setQuestionsOptionQuoteList(List<QuestionsOptionQuote> questionsOptionQuoteList) {
		this.questionsOptionQuoteList = questionsOptionQuoteList;
	}
	
	

}

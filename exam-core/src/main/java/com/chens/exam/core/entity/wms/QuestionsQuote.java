package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;

/**
 *
 * 题目资源关系表 实体
 *
 * @author wdp
 * @create 2018-04-06
 */
@TableName("t_questions_quote")
public class QuestionsQuote extends BaseEntity<QuestionsQuote> {


	private static final long serialVersionUID = 1780123310266247556L;
	/**
     * 对应题目Id
     */
	@TableField("question_id")
	private String questionId;
    /**
     * 引用类型
     */
	private String type;
    /**
     * 对应数据id
     */
	@TableField("data_id")
	private String dataId;
    /**
     * 资源id
     */
	@TableField("source_id")
	private String sourceId;
    /**
     * 资源顺序
     */
	@TableField("source_seq")
	private Integer sourceSeq;
    /**
     * 备注
     */
	private String remark;
    /**
     * 逻辑删除
     */
	@TableField("is_delete")
	private String isDelete;


	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getSourceSeq() {
		return sourceSeq;
	}

	public void setSourceSeq(Integer sourceSeq) {
		this.sourceSeq = sourceSeq;
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

}

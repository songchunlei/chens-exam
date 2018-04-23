package com.chens.exam.core.entity.wms;

import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.bpm.vo.BaseWfEntity;
import com.chens.file.vo.FolderFileInfo;
import com.chens.exam.core.enums.ExamFileTypeEnum;

/**
 *
 * 题目表 实体
 *
 * @author wdp
 * @create 2018-04-06
 */
@TableName("t_questions")
public class Questions extends BaseWfEntity<Questions> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6676483172208196039L;
	/**
     * 所在文件夹id
     */
	@TableField("folder_id")
	private String folderId;
    /**
     * 所属学科
     */
	@TableField("belong_subject")
	private String belongSubject;
    /**
     * 题目类型
     */
	private String type;
    /**
     * 题目名称
     */
	private String name;
    /**
     * 题目内容
     */
	private String content;
    /**
     * 难度 
     */
	private String difficulty;
    /**
     * 分数
     */
	private BigDecimal points;
    /**
     * 级别
     */
	private String level;

    /**
     * 上级题目id
     */
	@TableField("parent_id")
	private String parentId;
	private Integer seq;
    /**
     * 二维码
     */
	@TableField("qr_code")
	private String qrCode;
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
	 * 题目选项
	 */
	@TableField(exist = false)
	private List<QuestionsOption> questionsOptionList;
	
	/**
	 * 题目资源关联关系
	 */
	@TableField(exist = false)
	private List<QuestionsQuote> questionsQuoteList;

	/**
	 * 题目标签关联关系
	 */
	@TableField(exist = false)
	private List<String> tags;

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public String getBelongSubject() {
		return belongSubject;
	}

	public void setBelongSubject(String belongSubject) {
		this.belongSubject = belongSubject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public BigDecimal getPoints() {
		return points;
	}

	public void setPoints(BigDecimal points) {
		this.points = points;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
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

	public List<QuestionsOption> getQuestionsOptionList() {
		return questionsOptionList;
	}

	public void setQuestionsOptionList(List<QuestionsOption> questionsOptionList) {
		this.questionsOptionList = questionsOptionList;
	}

	public List<QuestionsQuote> getQuestionsQuoteList() {
		return questionsQuoteList;
	}

	public void setQuestionsQuoteList(List<QuestionsQuote> questionsQuoteList) {
		this.questionsQuoteList = questionsQuoteList;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public FolderFileInfo getFolderInfo()
	{
		return new FolderFileInfo(id, ExamFileTypeEnum.QUESTIONS.getCode(),name,null,updateTime);
	}
}

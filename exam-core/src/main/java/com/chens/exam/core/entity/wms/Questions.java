package com.chens.exam.core.entity.wms;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.bpm.vo.BaseWfEntity;
import com.chens.core.annotation.InsertValid;
import com.chens.core.annotation.UpdateValid;
import com.chens.core.enums.YesNoEnum;
import com.chens.folder.vo.FolderFileInfo;
import com.chens.exam.core.enums.ExamFileTypeEnum;
import com.chens.tag.entity.Tag;

import javax.validation.constraints.NotNull;

/**
 *
 * 题目表 实体
 *
 * @author wdp
 * @create 2018-04-06
 */
@TableName("t_questions")
public class Questions extends BaseWfEntity<Questions>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6676483172208196039L;
	/**
     * 所在文件夹id
     */
	@NotNull(message = "{folder.null}",groups = {InsertValid.class, UpdateValid.class})
	@TableField("folder_id")
	private String folderId;

    /**
     * 题目类型
     */
	private String type;
    /**
     * 题目名称
     */
	@NotNull(message = "{questions.name.null}",groups = {InsertValid.class, UpdateValid.class})
	private String name;
    /**
     * 题目内容
     */
	@NotNull(message = "{questions.content.null}",groups = {InsertValid.class, UpdateValid.class})
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

	/**
	 * 排序
	 */
	private Integer seq;

	/**
	 * 答案
	 */
	private String answer;

	/**
	 * 答案解析
	 */
	private String analysis;

    /**
     * 逻辑删除
     */
	@TableField("is_delete")
	@TableLogic
	private String isDelete = YesNoEnum.NO.getCode();
	
	/**
	 * 题目选项
	 */
	@TableField(exist = false)
	private List<QuestionsOption> questionsOptionList;

	/**
	 * 题目下的资源
	 */
	@TableField(exist = false)
	private List<Source> sources;

	/**
	 * 题目下的标签
	 */
	@TableField(exist = false)
	private List<Tag> tags;
	
	/**
	 * 题目资源引用关联关系
	 */
	@TableField(exist = false)
	private List<String> quoteRels;

	/**
	 * 题目标签关联关系
	 */
	@TableField(exist = false)
	private List<String> tagRels;


	public Questions() {
	}


	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
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

	public List<Source> getSources() {
		return sources;
	}

	public void setSources(List<Source> sources) {
		this.sources = sources;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<String> getQuoteRels() {
		return quoteRels;
	}

	public void setQuoteRels(List<String> quoteRels) {
		this.quoteRels = quoteRels;
	}

	public List<String> getTagRels() {
		return tagRels;
	}

	public void setTagRels(List<String> tagRels) {
		this.tagRels = tagRels;
	}

	public FolderFileInfo getFolderInfo()
	{
		return new FolderFileInfo(id, ExamFileTypeEnum.QUESTIONS.getCode(),name,null,updateTime);
	}
}

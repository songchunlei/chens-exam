package com.chens.exam.core.entity.book;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;
import com.chens.core.vo.FolderFileInfo;
import com.chens.exam.core.enums.ExamFileTypeEnum;

import javax.validation.constraints.NotNull;

/**
 *
 * 试卷 实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@TableName("t_exam_paper")
public class ExamPaper extends BaseEntity<ExamPaper> {

    private static final long serialVersionUID = 1L;

    /**
     * 试卷名称
     */
    @NotNull
	private String name;

    /**
     * 试卷考试时间（分钟）
     */
	@NotNull
	private Integer duration;

	/**
	 * 文件夹id
	 */
	@TableField("folder_id")
	private String folderId;

    /**
     * 总分
     */
	@TableField("total_point")
	private Integer totalPoint;

	/**
     * 通过分数
     */
	@TableField("pass_point")
	private Integer passPoint;

	/**
	 * 试卷分类-真题，模拟，专家
	 */
	@TableField("paper_type")
	private String paperType;

	/**
     * 试卷简介
     */
	private String summary;

	/**
	 * 内容（xml存储）
	 */
	private String content;

	/**
	 * 答案（xml存储）
	 */
	@TableField("answer_sheet")
	private String answerSheet;


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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}

	public Integer getPassPoint() {
		return passPoint;
	}

	public void setPassPoint(Integer passPoint) {
		this.passPoint = passPoint;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getAnswerSheet() {
		return answerSheet;
	}

	public void setAnswerSheet(String answerSheet) {
		this.answerSheet = answerSheet;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public FolderFileInfo getForderInfo()
	{
		return new FolderFileInfo(id, ExamFileTypeEnum.EXAM_PAPER.getCode(),name,updateTime);
	}
}

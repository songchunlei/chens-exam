package com.chens.exam.core.entity.book;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;

/**
 *
 *  实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@TableName("t_exampaper_question")
public class ExampaperQuestion extends BaseEntity<ExampaperQuestion> {

    private static final long serialVersionUID = 1L;

	@TableField("exam_paper_id")
	private String examPaperId;
	@TableField("question_id")
	private String questionId;

	public ExampaperQuestion(String examPaperId, String questionId) {
		this.examPaperId = examPaperId;
		this.questionId = questionId;
	}

	public ExampaperQuestion() {
	}

	public String getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(String examPaperId) {
		this.examPaperId = examPaperId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

}

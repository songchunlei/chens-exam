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
@TableName("t_booksection_question")
public class BooksectionQuestion extends BaseEntity<BooksectionQuestion> {

    private static final long serialVersionUID = 1L;

	@TableField("book_section_id")
	private String bookSectionId;
	@TableField("question_id")
	private String questionId;


	public String getBookSectionId() {
		return bookSectionId;
	}

	public void setBookSectionId(String bookSectionId) {
		this.bookSectionId = bookSectionId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

}

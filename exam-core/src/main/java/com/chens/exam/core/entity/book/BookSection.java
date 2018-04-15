package com.chens.exam.core.entity.book;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;

import javax.validation.constraints.NotNull;

/**
 *
 *  实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@TableName("t_book_section")
public class BookSection extends BaseEntity<BookSection> {

    private static final long serialVersionUID = 1L;

    /**
     * 章节名称
     */
    @NotNull
	private String name;
    /**
     * 书本id
     */
	@NotNull
	@TableField("book_id")
	private String bookId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

}

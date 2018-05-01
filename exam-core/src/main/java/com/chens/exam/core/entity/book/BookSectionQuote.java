package com.chens.exam.core.entity.book;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.quote.vo.AbstractFileQuote;

/**
 *
 *  书本章节-资源关系实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("sys_file_quote")
public class BookSectionQuote extends AbstractFileQuote<BookSectionQuote> {

    private static final long serialVersionUID = 1L;

	public BookSectionQuote() {
		this.type = ExamDataTypeEnum.BOOK_SECTION.getCode();
		this.fileType = ExamDataTypeEnum.SOURCE.getCode();
	}

	@Override
	public String getType() {
		return ExamDataTypeEnum.BOOK_SECTION.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = ExamDataTypeEnum.BOOK_SECTION.getCode();
	}

	@Override
	public String getFileType() {
		return ExamDataTypeEnum.SOURCE.getCode();
	}

	@Override
	public void setFileType(String fileType) {
		this.fileType =  ExamDataTypeEnum.SOURCE.getCode();
	}
}

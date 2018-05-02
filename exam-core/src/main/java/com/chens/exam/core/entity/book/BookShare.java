package com.chens.exam.core.entity.book;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.share.vo.AbstractShare;

/**
 *
 *  题目分享
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName(ExamConstants.SHARE_TABLE_NAME)
public class BookShare extends AbstractShare<BookShare> {

    private static final long serialVersionUID = 1L;

	public BookShare() {
		this.dataType = ExamDataTypeEnum.BOOK.getCode();
	}

	@Override
	public String getDataType() {
		return ExamDataTypeEnum.BOOK.getCode();
	}

	@Override
	public void setDataType(String dataType) {
		this.dataType = ExamDataTypeEnum.BOOK.getCode();
	}
}

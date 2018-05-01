package com.chens.exam.core.entity.book;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.quote.vo.AbstractFileQuote;

/**
 *
 *  课程章节-资源关系实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("sys_file_quote")
public class CourseSectionQuote extends AbstractFileQuote<CourseSectionQuote> {

    private static final long serialVersionUID = 1L;

	public CourseSectionQuote() {
		this.type = ExamDataTypeEnum.COURSE_SECTION.getCode();
	}

	@Override
	public String getType() {
		return ExamDataTypeEnum.COURSE_SECTION.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = ExamDataTypeEnum.COURSE_SECTION.getCode();
	}
}

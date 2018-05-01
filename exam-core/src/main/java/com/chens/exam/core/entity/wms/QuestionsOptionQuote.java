package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.quote.vo.AbstractFileQuote;

/**
 *
 *  题目资源管来拿实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("sys_file_quote")
public class QuestionsOptionQuote extends AbstractFileQuote<QuestionsOptionQuote> {

    private static final long serialVersionUID = 1L;

	public QuestionsOptionQuote() {
		this.type = ExamDataTypeEnum.QUESTIONS_OPTION.getCode();
	}

	@Override
	public String getType() {
		return ExamDataTypeEnum.QUESTIONS_OPTION.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = ExamDataTypeEnum.QUESTIONS_OPTION.getCode();
	}
}

package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.quote.vo.AbstractFileQuote;

import java.io.Serializable;

/**
 *
 *  题目资源管来拿实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("sys_file_quote")
public class QuestionsQuote extends AbstractFileQuote<QuestionsQuote>{

    private static final long serialVersionUID = 1L;

	public QuestionsQuote() {
		this.type = ExamDataTypeEnum.QUESTIONS.getCode();
		this.fileType = ExamDataTypeEnum.SOURCE.getCode();
	}

	@Override
	public String getType() {
		return ExamDataTypeEnum.QUESTIONS.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = ExamDataTypeEnum.QUESTIONS.getCode();
	}

	@Override
	public String getFileType() {
		return ExamDataTypeEnum.SOURCE.getCode();
	}

	@Override
	public void setFileType(String fileType) {
		this.fileType = ExamDataTypeEnum.SOURCE.getCode();
	}
}

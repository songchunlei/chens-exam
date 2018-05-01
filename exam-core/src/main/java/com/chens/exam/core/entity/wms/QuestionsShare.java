package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.share.vo.AbstractShare;

/**
 *
 *  题目分享
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_share")
public class QuestionsShare extends AbstractShare<QuestionsShare> {

    private static final long serialVersionUID = 1L;

	public QuestionsShare() {
		this.dataType = ExamDataTypeEnum.QUESTIONS.getCode();
	}

	@Override
	public String getDataType() {
		return ExamDataTypeEnum.QUESTIONS.getCode();
	}

	@Override
	public void setDataType(String dataType) {
		this.dataType = ExamDataTypeEnum.QUESTIONS.getCode();
	}
}

package com.chens.exam.core.entity.book;

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
public class ExamPaperShare extends AbstractShare<ExamPaperShare> {

    private static final long serialVersionUID = 1L;

	public ExamPaperShare() {
		this.dataType = ExamDataTypeEnum.EXAM_PAPER.getCode();
	}

	@Override
	public String getDataType() {
		return ExamDataTypeEnum.EXAM_PAPER.getCode();
	}

	@Override
	public void setDataType(String dataType) {
		this.dataType = ExamDataTypeEnum.EXAM_PAPER.getCode();
	}
}

package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.TagTypeEnum;
import com.chens.exam.core.vo.AbstractTag;

/**
 *
 *  试卷标签实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_tag")
public class ExamTag extends AbstractTag<ExamTag> {

    private static final long serialVersionUID = 1L;

	public ExamTag() {
		this.type = TagTypeEnum.EXAM.getCode();
	}

	@Override
	public String getType() {
		return TagTypeEnum.EXAM.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = TagTypeEnum.EXAM.getCode();
	}
}

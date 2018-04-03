package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.TagTypeEnum;
import com.chens.exam.core.vo.Tag;

/**
 *
 *  试卷标签实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_tag")
public abstract class ExamTag extends Tag {

    private static final long serialVersionUID = 1L;

    private Enum type = TagTypeEnum.EXAM;


	public Enum getType() {
		return type;
	}

	public void setType(Enum type) {
		this.type = type;
	}
}

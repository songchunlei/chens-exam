package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.TagTypeEnum;
import com.chens.exam.core.vo.AbstractTag;

/**
 *
 *  课程标签实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_tag")
public class CourseTag extends AbstractTag<CourseTag> {

    private static final long serialVersionUID = 1L;

	public CourseTag() {
		this.type = TagTypeEnum.COURSE.getCode();
	}

	@Override
	public String getType() {
		return TagTypeEnum.COURSE.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = TagTypeEnum.COURSE.getCode();
	}
}

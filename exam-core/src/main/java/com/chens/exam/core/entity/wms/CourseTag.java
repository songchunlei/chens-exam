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

    private String type = TagTypeEnum.COURSE.getCode();


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

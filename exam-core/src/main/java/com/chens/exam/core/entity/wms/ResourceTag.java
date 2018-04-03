package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;
import com.chens.exam.core.enums.TagTypeEnum;
import com.chens.exam.core.vo.Tag;

/**
 *
 *  资源标签实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_tag")
public abstract class ResourceTag extends Tag {

    private static final long serialVersionUID = 1L;

    private Enum type = TagTypeEnum.RESOURCE;


	public Enum getType() {
		return type;
	}

	public void setType(Enum type) {
		this.type = type;
	}
}

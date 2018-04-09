package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.TagTypeEnum;
import com.chens.exam.core.vo.AbstractTag;

/**
 *
 *  资源标签实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_tag")
public class SourceTag extends AbstractTag<SourceTag> {

    private static final long serialVersionUID = 1L;

    private String type = TagTypeEnum.SOURCE.getCode();


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
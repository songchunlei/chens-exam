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

	public SourceTag() {
		this.type = TagTypeEnum.SOURCE.getCode();
	}

	@Override
	public String getType() {
		return TagTypeEnum.SOURCE.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = TagTypeEnum.SOURCE.getCode();
	}
}

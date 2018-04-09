package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.TagTypeEnum;
import com.chens.exam.core.vo.AbstractForder;

/**
 *
 *  资源文件夹实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_forder")
public class SourceForder extends AbstractForder<SourceForder> {

    private static final long serialVersionUID = 1L;

	public SourceForder() {
		this.forderType = TagTypeEnum.SOURCE.getCode();
	}

	@Override
	public String getForderType() {
		return TagTypeEnum.SOURCE.getCode();
	}

	@Override
	public void setForderType(String forderType) {
		this.forderType = TagTypeEnum.SOURCE.getCode();
	}
}

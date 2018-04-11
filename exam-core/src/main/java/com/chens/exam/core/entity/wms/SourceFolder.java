package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.FolderTypeEnum;
import com.chens.exam.core.enums.TagTypeEnum;
import com.chens.exam.core.vo.AbstractFolder;

/**
 *
 *  资源文件夹实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_folder")
public class SourceFolder extends AbstractFolder<SourceFolder> {

    private static final long serialVersionUID = 1L;

	public SourceFolder() {
		this.type = TagTypeEnum.SOURCE.getCode();
	}

	@Override
	public String getType() {
		return FolderTypeEnum.SOURCE.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = TagTypeEnum.SOURCE.getCode();
	}
}

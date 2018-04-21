package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.ExamFileTypeEnum;
import com.chens.file.vo.AbstractFolder;

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
		this.type = ExamFileTypeEnum.SOURCE.getCode();
	}

	@Override
	public String getType() {
		return ExamFileTypeEnum.SOURCE.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = ExamFileTypeEnum.SOURCE.getCode();
	}
}

package com.chens.exam.core.entity.book;

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
public class CourseFolder extends AbstractFolder<CourseFolder> {

    private static final long serialVersionUID = 1L;

	public CourseFolder() {
		this.type = ExamFileTypeEnum.COURSE.getCode();
	}

	@Override
	public String getType() {
		return ExamFileTypeEnum.COURSE.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = ExamFileTypeEnum.COURSE.getCode();
	}
}

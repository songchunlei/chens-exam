package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.ExamFileTypeEnum;
import com.chens.exam.core.enums.TagTypeEnum;
import com.chens.file.vo.AbstractFolder;

/**
 *
 *  资源文件夹实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_folder")
public class QuestionsFolder extends AbstractFolder<QuestionsFolder> {

    private static final long serialVersionUID = 1L;

	public QuestionsFolder() {
		this.type = ExamFileTypeEnum.QUESTIONS.getCode();
	}

	@Override
	public String getType() {
		return ExamFileTypeEnum.QUESTIONS.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = ExamFileTypeEnum.QUESTIONS.getCode();
	}
}

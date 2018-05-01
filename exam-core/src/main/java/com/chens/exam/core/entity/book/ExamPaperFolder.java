package com.chens.exam.core.entity.book;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.ExamFileTypeEnum;
import com.chens.folder.vo.AbstractFolder;

/**
 *
 *  资源文件夹实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName("t_folder")
public class ExamPaperFolder extends AbstractFolder<ExamPaperFolder> {

    private static final long serialVersionUID = 1L;

	public ExamPaperFolder() {
		this.type = ExamFileTypeEnum.EXAM_PAPER.getCode();
	}

	@Override
	public String getType() {
		return ExamFileTypeEnum.EXAM_PAPER.getCode();
	}

	@Override
	public void setType(String type) {
		this.type = ExamFileTypeEnum.EXAM_PAPER.getCode();
	}
}

package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.share.vo.AbstractShare;

/**
 *
 *  资源分享
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName(ExamConstants.SHARE_TABLE_NAME)
public class SourceShare extends AbstractShare<SourceShare> {

    private static final long serialVersionUID = 1L;

	public SourceShare() {
		this.dataType = ExamDataTypeEnum.SOURCE.getCode();
	}

	@Override
	public String getDataType() {
		return ExamDataTypeEnum.SOURCE.getCode();
	}

	@Override
	public void setDataType(String dataType) {
		this.dataType = ExamDataTypeEnum.SOURCE.getCode();
	}
}

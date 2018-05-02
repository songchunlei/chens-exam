package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.share.vo.AbstractShare;

/**
 *
 *  所有分享
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@TableName(ExamConstants.SHARE_TABLE_NAME)
public class AllShare extends AbstractShare<AllShare> {

    private static final long serialVersionUID = 1L;

}

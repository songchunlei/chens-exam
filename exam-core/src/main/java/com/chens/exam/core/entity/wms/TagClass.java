package com.chens.exam.core.entity.wms;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;

/**
 *
 *  实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-10
 */
@TableName("t_tag_class")
public class TagClass extends BaseEntity<TagClass> {

    private static final long serialVersionUID = 1L;

	@TableField("class_name")
	private String className;
    /**
     * 备注
     */
	private String comment;


	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}

package com.chens.exam.core.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;

/**
 *
 *  抽象实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
public abstract class Tag extends BaseEntity<Tag> {

    private static final long serialVersionUID = 1L;

    /**
     * 描述
     */
	private String comment;
    /**
     * 标签名称
     */
	@TableField("tag_name")
	private String tagName;


	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

}
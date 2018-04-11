package com.chens.exam.core.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.chens.core.vo.BaseEntity;
import com.chens.exam.core.enums.TagTypeEnum;

import javax.validation.constraints.NotNull;

/**
 *
 *  抽象实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
public abstract class AbstractTag<T extends AbstractTag> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

	/**
	 * 类型
	 */
	protected String type ;

    /**
     * 描述
     */
	protected String comment;
    /**
     * 标签名称
     */
	@NotNull
	@TableField("tag_name")
	protected String tagName;


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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}

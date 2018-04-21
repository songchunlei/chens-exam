package com.chens.exam.core.vo;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotations.TableField;
import com.chens.core.vo.BaseEntity;

/**
 *
 *  抽象实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractTag<T extends AbstractTag> extends BaseEntity<T> {

	private static final long serialVersionUID = -4754273073121186898L;

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

	/**
	 * 分类id
	 */
	@TableField("class_id")
	protected String classId;


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

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
}

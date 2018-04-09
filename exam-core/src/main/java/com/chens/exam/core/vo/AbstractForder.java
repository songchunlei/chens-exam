package com.chens.exam.core.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.chens.core.vo.BaseEntity;
import com.chens.exam.core.enums.TagTypeEnum;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <p>
 * 文件夹表
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public class AbstractForder<File,T extends AbstractForder> extends BaseEntity<T> {


	@TableField(exist = false)
	private static final long serialVersionUID = 1815815883025805854L;



	/**
	 * 文件夹类型
	 */
	@TableField("forder_type")
	protected String forderType ;

    /**
     * 等级
     */
    private Integer lvl;

    /**
     * 文件夹名称
     */
    @TableField("forder_name")
    @NotNull(message = "{forder.forderName.null}")
    private String forderName;

    /**
     * 上级文件夹id
     */
    @TableField("parent_id")
    private String parentId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
    @TableLogic
    private String isDelete;

	/**
	 * 多个id用英文逗号拼接，用于批量操作场景
	 */
	@TableField(exist = false)
	private String idStr;

	/**
	 * 父文件夹
	 */
	private T parentForder;

	/**
	 * 文件夹下的文件
	 */
	@TableField(exist = false)
	private List<File> files;

	/**
	 * 文件夹下的子文件夹
	 */
	@TableField(exist = false)
	private List<T> childForders;

	public String getForderType() {
		return forderType;
	}

	public void setForderType(String forderType) {
		this.forderType = TagTypeEnum.SOURCE.getCode();
	}


	public String getIdStr() {
		return idStr;
	}
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getForderName() {
		return forderName;
	}
	public void setForderName(String forderName) {
		this.forderName = forderName;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getLvl() {
		return lvl;
	}

	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}

	public T getParentForder() {
		return parentForder;
	}

	public void setParentForder(T parentForder) {
		this.parentForder = parentForder;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public List<T> getChildForders() {
		return childForders;
	}

	public void setChildForders(List<T> childForders) {
		this.childForders = childForders;
	}
}
package com.chens.exam.core.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.chens.core.annotation.InsertValid;
import com.chens.core.annotation.UpdateValid;
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
public class AbstractForder<T extends AbstractForder> extends BaseEntity<T> {


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
    @NotNull(message = "{forder.lvl.null}",groups = {InsertValid.class, UpdateValid.class})
    private Integer lvl;

    /**
     * 文件夹名称
     */
    @TableField("forder_name")
    @NotNull(message = "{forder.forderName.null}",groups = {InsertValid.class, UpdateValid.class})
    private String forderName;

    /**
     * 上级文件夹id
     */
    @TableField("parent_id")
	@NotNull(message = "{forder.parentId.null}",groups = {InsertValid.class, UpdateValid.class})
    private String parentId;

	/**
	 * 语意id，默认启始1000000
	 */
	@TableField("cascade_id")
	private String cascadeId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除
     */
	@TableField("is_delete")
    private String isDelete;

	/**
	 * 多个id用英文逗号拼接，用于批量操作场景
	 */
	@TableField(exist = false)
	private String idStr;

	/**
	 * 父文件夹
	 */
	@TableField(exist = false)
	private T parentForder;

	/**
	 * 文件夹下的文件
	 */
	@TableField(exist = false)
	private List<ForderInfo> files;

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

	public List<ForderInfo> getFiles() {
		return files;
	}

	public void setFiles(List<ForderInfo> files) {
		this.files = files;
	}

	public List<T> getChildForders() {
		return childForders;
	}

	public void setChildForders(List<T> childForders) {
		this.childForders = childForders;
	}

	public String getCascadeId() {
		return cascadeId;
	}

	public void setCascadeId(String cascadeId) {
		this.cascadeId = cascadeId;
	}
}

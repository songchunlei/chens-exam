package com.chens.exam.core.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.chens.core.annotation.InsertValid;
import com.chens.core.annotation.UpdateValid;
import com.chens.core.vo.BaseEntity;
import com.chens.core.vo.FolderFileInfo;
import com.chens.core.enums.FileType;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 文件夹表
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public abstract class AbstractFolder<T extends AbstractFolder> extends BaseEntity<T> {


	@TableField(exist = false)
	private static final long serialVersionUID = 1815815883025805854L;

	/**
	 * 文件夹类型
	 */
	@TableField("type")
	protected String type ;

    /**
     * 等级
     */
    private Integer lvl;

    /**
     * 文件夹名称
     */
    @TableField("name")
    @NotNull(message = "{folder.folderName.null}",groups = {InsertValid.class, UpdateValid.class})
    private String name;

    /**
     * 上级文件夹id
     */
    @TableField("parent_id")
	@NotNull(message = "{folder.parentId.null}",groups = {InsertValid.class, UpdateValid.class})
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIdStr() {
		return idStr;
	}
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCascadeId() {
		return cascadeId;
	}

	public void setCascadeId(String cascadeId) {
		this.cascadeId = cascadeId;
	}

	public FolderFileInfo getForderFileInfo()
	{
		return new FolderFileInfo(this.getId(), FileType.FOLDER.getCode(),this.getName(), this.getUpdateTime());
	}
}

package com.chens.exam.core.entity.wms;

import com.chens.core.vo.BaseEntity;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;

/**
 * <p>
 * 文件夹表
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@TableName("t_forder")
public class Forder extends BaseEntity<Forder> {


	@TableField(exist = false)
	private static final long serialVersionUID = 1815815883025805854L;
	
	/**
	 * 多个id用英文逗号拼接，用于批量操作场景
	 */
	@TableField(exist = false)
	private String idStr;

    /**
     * 机构ID
     */
    @TableField("zone_id")
    private String zoneId;

    /**
     * 文件夹类型
     */
    @TableField("forder_type")
    private String forderType;
    /**
     * 文件夹名称
     */
    @TableField("forder_name")
    @NotNull(message = "{forder.forderName.null}")
    private String forderName;
    /**
     * 文件夹节点语意ID
     */
    @TableField("forder_cascade_id")
    private String forderCascadeId;
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
    @TableField(value = "is_delete", fill = FieldFill.INSERT)
    @TableLogic
    private String isDelete;
	public String getIdStr() {
		return idStr;
	}
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	public String getZoneId() {
		return zoneId;
	}
	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getForderType() {
		return forderType;
	}
	public void setForderType(String forderType) {
		this.forderType = forderType;
	}
	public String getForderName() {
		return forderName;
	}
	public void setForderName(String forderName) {
		this.forderName = forderName;
	}
	public String getForderCascadeId() {
		return forderCascadeId;
	}
	public void setForderCascadeId(String forderCascadeId) {
		this.forderCascadeId = forderCascadeId;
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

  
    
    
}

package com.chens.exam.core.entity.wms;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 文件夹表
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@TableName("t_forder")
public class Forder implements Serializable {


	@TableField(exist = false)
	private static final long serialVersionUID = 1815815883025805854L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    /**
     * 机构ID
     */
    @TableField("zone_id")
    private Long zoneId;
    /**
     * 租户id
     */
    @TableField(value = "tennat_id", fill = FieldFill.INSERT)
    private Long tennatId;
    /**
     * 文件夹类型
     */
    @TableField("forder_type")
    private String forderType;
    /**
     * 文件夹名称
     */
    @TableField("forder_name")
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
    private Long parentId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;
    /**
     * 修改人
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 是否删除
     */
    @TableField(value = "is_delete", fill = FieldFill.INSERT)
    @TableLogic
    private String isDelete;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getTennatId() {
        return tennatId;
    }

    public void setTennatId(Long tennatId) {
        this.tennatId = tennatId;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Forder{" +
        "id=" + id +
        ", zoneId=" + zoneId +
        ", tennatId=" + tennatId +
        ", forderType=" + forderType +
        ", forderName=" + forderName +
        ", forderCascadeId=" + forderCascadeId +
        ", parentId=" + parentId +
        ", remark=" + remark +
        ", createTime=" + createTime +
        ", createBy=" + createBy +
        ", updateBy=" + updateBy +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        "}";
    }
}

package com.chens.exam.book.entity;

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
 * 练习册
 * </p>
 *
 * @author wdp
 * @since 2018-03-01
 */
@TableName("t_training")
public class Training implements Serializable {

	/**
	 * 
	 */
	@TableField(exist = false)
	private static final long serialVersionUID = 2334965242592865309L;
	/**  */
	
	@TableId(type = IdType.ID_WORKER)
    private Long id;
    /**
     * 练习册名称
     */
    @TableField("training_name")
    private String trainingName;
    /**
     * 练习册描述
     */
    private String description;
    /**
     * 是否私有
     */
    @TableField("is_private")
    private String isPrivate;
    
    
    @TableField("field_id")
    private String fieldId;
    /**
     * 练习册状态
     */
    private String status;
    /**
     * 生效时间
     */
    @TableField("effective_time")
    private Date effectiveTime;
    /**
     * 失效时间
     */
    @TableField("expiry_time")
    private Date expiryTime;
    /**
     * 是否删除
     */
    @TableField("is_delete")
    @TableLogic   //逻辑删除注解
    private String isDelete;
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
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 修改人
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;
    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "Training{" +
        ", id=" + id +
        ", trainingName=" + trainingName +
        ", description=" + description +
        ", isPrivate=" + isPrivate +
        ", fieldId=" + fieldId +
        ", status=" + status +
        ", effectiveTime=" + effectiveTime +
        ", expiryTime=" + expiryTime +
        ", isDelete=" + isDelete +
        ", createTime=" + createTime +
        ", createBy=" + createBy +
        ", updateTime=" + updateTime +
        ", updateBy=" + updateBy +
        ", tenantId=" + tenantId +
        "}";
    }
}

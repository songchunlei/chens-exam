package com.chens.exam.core.entity.book;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.chens.core.vo.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 练习册
 * </p>
 *
 * @author wdp
 * @since 2018-03-01
 */
@TableName("t_training")
public class Training extends BaseEntity<Training> {

	/**
	 * 
	 */
	@TableField(exist = false)
	private static final long serialVersionUID = 2334965242592865309L;

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

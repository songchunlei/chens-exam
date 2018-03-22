package com.chens.exam.core.entity.wms;

import java.util.Date;

import com.chens.core.vo.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableLogic;
import java.io.Serializable;

/**
 * <p>
 * 资源素材表
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@TableName("t_source")
public class Source extends BaseEntity<Forder> {

	@TableField(exist = false)
	private static final long serialVersionUID = -7496356762631622092L;
	
	/**
	 * 多个id用英文逗号拼接，用于批量操作场景
	 */
	@TableField(exist = false)
	private String idStr;

    /**
     * 机构id
     */
    @TableField("zone_id")
    private Long zoneId;
    /**
     * 文件夹id
     */
    @TableField("forder_id")
    private Long forderId;

    /**
     * 资源类型
     */
    private String type;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源内容
     */
    private String content;
    /**
     * 资源文件名
     */
    @TableField("file_name")
    private String fileName;
    /**
     * 资源文件类型
     */
    @TableField("file_type")
    private String fileType;
    /**
     * 资源文件保存目录
     */
    @TableField("file_forder")
    private String fileForder;
    /**
     * 资源地址
     */
    private String path;
    /**
     * 资源状态
     */
    private String status;
    /**
     * 资源二维码
     */
    @TableField("qr_code")
    private String qrCode;
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

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getForderId() {
        return forderId;
    }

    public void setForderId(Long forderId) {
        this.forderId = forderId;
    }

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileForder() {
        return fileForder;
    }

    public void setFileForder(String fileForder) {
        this.fileForder = fileForder;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
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

    @Override
    public String toString() {
        return "Source{" +
        "id=" + id +
        ", zoneId=" + zoneId +
        ", forderId=" + forderId +
        ", tenantId=" + tenantId +
        ", type=" + type +
        ", name=" + name +
        ", content=" + content +
        ", fileName=" + fileName +
        ", fileType=" + fileType +
        ", fileForder=" + fileForder +
        ", path=" + path +
        ", status=" + status +
        ", qrCode=" + qrCode +
        ", remark=" + remark +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        ", updateBy=" + updateBy +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        "}";
    }

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
}

package com.chens.exam.core.entity.wms;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.chens.bpm.enums.WfStatus;
import com.chens.bpm.vo.BaseWfEntity;
import com.chens.exam.core.enums.SourceTypeEnum;
import com.chens.file.vo.FolderFileInfo;

/**
 * <p>
 * 资源素材表
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@TableName("t_source")
public class Source extends BaseWfEntity<Source> {

	@TableField(exist = false)
	private static final long serialVersionUID = -7496356762631622092L;

    /**
     * 文件夹id
     */
    @TableField("folder_id")
    private String folderId;

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
     * url链接/文件地址
     */
    private String path;

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
    @TableField(value = "is_delete")
    private String isDelete;


    public Source() {
    }

    /**
     * 链接类
     * @param name
     * @param path
     */
    public Source(String name,String path) {
        this.name = name;
        this.path = path;
        this.type = SourceTypeEnum.LINK.getCode();
    }

    /**
     * 图文类
     * @param name
     * @param content
     * @param folderId
     */
    public Source(String name,String content,String folderId) {
        this.content = content;
        this.content = content;
        this.folderId = folderId;
        this.type = SourceTypeEnum.IMAGE_TEXT.getCode();
    }

    /**
     * 文件类
     * @param name
     * @param fileName
     * @param fileType
     * @param path
     * @param folderId
     */
    public Source(String name,String fileName,String fileType,String path,String folderId) {
        this.name = name;
        this.fileName = fileName;
        this.fileType = fileType;
        this.path = path;
        this.folderId = folderId;
        this.type = SourceTypeEnum.IMAGE_TEXT.getCode();
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

	public FolderFileInfo getForderInfo()
    {
        return new FolderFileInfo(id,fileType,name,updateTime);
    }
}

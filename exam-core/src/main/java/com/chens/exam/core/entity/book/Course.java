package com.chens.exam.core.entity.book;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.bpm.vo.BaseWfEntity;
import com.chens.file.vo.FolderFileInfo;
import com.chens.exam.core.enums.ExamFileTypeEnum;

/**
 *
 * 练习册 实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@TableName("t_course")
public class Course extends BaseWfEntity<Course> {

    private static final long serialVersionUID = 1L;

    /**
     * 课程名称
     */
	private String name;
    /**
     * 练习册描述
     */
	private String description;
    /**
     * 是否私有
     */
	@TableField("is_private")
	private String isPrivate;
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
	private String isDelete;

	/**
	 * 文件夹id
	 */
	@TableField("folder_id")
	private String folderId;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public FolderFileInfo getForderInfo()
	{
		return new FolderFileInfo(id, ExamFileTypeEnum.COURSE.getCode(),name,updateTime);
	}

}

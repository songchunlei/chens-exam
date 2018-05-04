package com.chens.exam.core.entity.book;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.bpm.vo.BaseWfEntity;
import com.chens.core.annotation.InsertValid;
import com.chens.core.annotation.UpdateValid;
import com.chens.folder.vo.FolderFileInfo;
import com.chens.exam.core.enums.ExamFileTypeEnum;

import javax.validation.constraints.NotNull;

/**
 *
 * 练习册 实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@TableName("t_book")
public class Book extends BaseWfEntity<Book> {

    private static final long serialVersionUID = 1L;

    /**
     * 书本名称
     */
    @NotNull(message = "{book.name.null}",groups = {InsertValid.class, UpdateValid.class})
	private String name;

    /**
     * 书本描述
     */
	private String description;
    /**
     * 是否私有
     */
	@TableField("is_private")
	private String isPrivate;
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
	@TableLogic
	private String isDelete;

	/**
	 * 文件夹id
	 */
	@TableField("folder_id")
	@NotNull(message = "{folderId.null}",groups = {InsertValid.class, UpdateValid.class})
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

	public FolderFileInfo getFolderInfo()
	{
		return new FolderFileInfo(id, ExamFileTypeEnum.BOOK.getCode(),name,null,updateTime);
	}
}

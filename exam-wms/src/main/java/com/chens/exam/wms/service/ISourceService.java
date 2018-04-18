package com.chens.exam.wms.service;

import com.chens.bpm.service.IWfBaseService;
import com.chens.core.vo.UserInfo;
import com.chens.exam.core.entity.wms.Source;
import com.chens.file.vo.FileData;

/**
 * <p>
 * 资源素材表 服务类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public interface ISourceService extends IWfBaseService<Source> {

	/**
	 * 新建文件资源
	 * @param fileData 文件数据
	 * @return
	 */
	Source uploadFile(FileData fileData,String folderId);
}

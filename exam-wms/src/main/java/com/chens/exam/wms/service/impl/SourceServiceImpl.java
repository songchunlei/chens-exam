package com.chens.exam.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.wms.mapper.SourceMapper;
import com.chens.exam.wms.service.ISourceService;
import com.chens.file.entity.SysFile;
import com.chens.file.exception.FileException;
import com.chens.file.exception.FileExceptionEnum;
import com.chens.file.service.IFileService;
import com.chens.file.vo.FileData;

/**
 * <p>
 * 资源素材表 服务实现类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@Service
public class SourceServiceImpl extends BaseWfServiceImpl<SourceMapper, Source> implements ISourceService {

	@Autowired
	private IFileService fileService;


	@Override
	@Transactional(rollbackFor = Exception.class)
	public Source uploadFile(FileData fileData,String folderId) {
		Source source;
		SysFile sysFile = fileService.upload(fileData);
		if (sysFile == null)
		{
			throw new FileException(FileExceptionEnum.FILE_SAVE_ERROR);
		}
		else {
			source = new Source(sysFile.getName(),sysFile.getOriginalName(),fileData.getType(),sysFile.getUrl(),folderId);
			super.saveDraft(source);
		}
		return source;
	}
	
	public List<Source> setSourceStatusBatch(List<Source> sourceList, String status){
		List<Source> list = new ArrayList<Source>();
		for(Source source: sourceList){
			list.add(source);
		}	
		return list;
	}


	@Override
	public Source saveEntity(Source source) {
		if(source!=null)
		{
			this.insertOrUpdate(source);
		}
		return source;
	}

	@Override
	public boolean beforeSubmit(WorkFlowRequestParam<Source> workFlowRequestParam) {
		return true;
	}

	@Override
	public boolean afterSubmit(WorkFlowRequestParam<Source> workFlowRequestParam) {
		return true;
	}
}

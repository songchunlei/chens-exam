package com.chens.exam.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.chens.bpm.vo.WorkFlowRequestParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.UserInfo;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.core.enums.SourceStatusEnum;
import com.chens.exam.core.utils.StringUtil;
import com.chens.exam.wms.mapper.SourceMapper;
import com.chens.exam.wms.service.ISourceService;

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

	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String save(Source source, UserInfo userInfo) {
		String id = source.getId();
		if(id == null){
			if(this.insert(source)){
				return source.getId();
			}else{
				throw new BaseException(BaseExceptionEnum.NO_SAVE.getCode(), BaseExceptionEnum.NO_SAVE.getMessage());
			}
		}else{
			if(this.updateById(source)){
				return source.getId();
			}else{
				throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), BaseExceptionEnum.NO_UPDATE.getMessage());
			}			
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean delete(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<String> idList = StringUtil.string2List(idStr);
			for(String id : idList){
				if(!this.deleteById(id)){
					throw new BaseException(BaseExceptionEnum.NO_DELETE.getCode(), BaseExceptionEnum.NO_DELETE.getMessage());
				}
			}
			return true;
		}else{
			//throw new BaseException(BaseExceptionEnum.NO_DELETE.getCode(), ErrorMsgContants.ID_NULL);
			throw new BaseException(BaseExceptionEnum.NO_DELETE);
		}	
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean submit(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<String> idList = StringUtil.string2List(idStr);
			List<Source> sourceList = this.selectBatchIds(idList);
			if(CollectionUtils.isEmpty(sourceList)){
				throw new BaseException(BaseExceptionEnum.NO_UPDATE);
			}else{
				sourceList = this.setSourceStatusBatch(sourceList, SourceStatusEnum.SUBMIT.getCode());
				if(this.updateBatchById(sourceList)){
					return true;
				}else{
					throw new BaseException(BaseExceptionEnum.NO_UPDATE);
				}
			}
		}else{
			throw new BaseException(BaseExceptionEnum.NO_UPDATE);
		}	
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean online(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<String> idList = StringUtil.string2List(idStr);
			List<Source> sourceList = this.selectBatchIds(idList);
			if(CollectionUtils.isEmpty(sourceList)){
				throw new BaseException(BaseExceptionEnum.NO_UPDATE);
			}else{
				sourceList = this.setSourceStatusBatch(sourceList, SourceStatusEnum.ONLINE.getCode());
				if(this.updateBatchById(sourceList)){
					return true;
				}else{
					throw new BaseException(BaseExceptionEnum.NO_UPDATE);
				}
			}
		}else{
			throw new BaseException(BaseExceptionEnum.NO_UPDATE);
		}	
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean offline(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<String> idList = StringUtil.string2List(idStr);
			List<Source> sourceList = this.selectBatchIds(idList);
			if(CollectionUtils.isEmpty(sourceList)){
				throw new BaseException(BaseExceptionEnum.NO_UPDATE);
			}else{
				sourceList = this.setSourceStatusBatch(sourceList, SourceStatusEnum.OFFFLINE.getCode());
				if(this.updateBatchById(sourceList)){
					return true;
				}else{
					throw new BaseException(BaseExceptionEnum.NO_UPDATE);
				}
			}
		}else{
			throw new BaseException(BaseExceptionEnum.NO_UPDATE);
		}	
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean abandon(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<String> idList = StringUtil.string2List(idStr);
			List<Source> sourceList = this.selectBatchIds(idList);
			if(CollectionUtils.isEmpty(sourceList)){
				//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.DATA_NULL);
				throw new BaseException(BaseExceptionEnum.NO_UPDATE);
			}else{
				sourceList = this.setSourceStatusBatch(sourceList, SourceStatusEnum.ABANDON.getCode());
				if(this.updateBatchById(sourceList)){
					return true;
				}else{
					//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.ABANDON_FAIL);
					throw new BaseException(BaseExceptionEnum.NO_UPDATE);
				}
			}
		}else{
			//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.ID_NULL);
			throw new BaseException(BaseExceptionEnum.NO_UPDATE);
		}	
	}
	
	public List<Source> setSourceStatusBatch(List<Source> sourceList, String status){
		List<Source> list = new ArrayList<Source>();
		for(Source source: sourceList){
			list.add(source);
		}	
		return list;
	}


	@Override
	public boolean beforeSubmit(WorkFlowRequestParam<Source> workFlowRequestParam) {
		Source source = workFlowRequestParam.getT();
		if(source!=null)
		{
			this.insertOrUpdate(source);
		}
		return true;
	}

	@Override
	public boolean afterSubmit(WorkFlowRequestParam<Source> workFlowRequestParam) {
		return true;
	}
}

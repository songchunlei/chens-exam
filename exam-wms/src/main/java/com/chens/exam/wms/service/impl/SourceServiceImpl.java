package com.chens.exam.wms.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.UserInfo;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.core.enums.SourceStatusEnum;
import com.chens.exam.core.utils.StringUtil;
import com.chens.exam.wms.mapper.SourceMapper;
import com.chens.exam.wms.service.ISourceService;
import org.springframework.util.CollectionUtils;

/**
 * <p>
 * 资源素材表 服务实现类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@Service
public class SourceServiceImpl extends ServiceImpl<SourceMapper, Source> implements ISourceService {

	
	@Override
	@Transactional
	public Long save(Source source, UserInfo userInfo) {
		Long id = source.getId();
		if(id == null){
			source.setStatus(SourceStatusEnum.DRAFT.getCode());
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
	@Transactional
	public boolean delete(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<Long> idList = StringUtil.string2List(idStr);
			for(Long id : idList){
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
	@Transactional
	public boolean submit(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<Long> idList = StringUtil.string2List(idStr);
			List<Source> sourceList = this.selectBatchIds(idList);
			if(CollectionUtils.isEmpty(sourceList)){
				//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.DATA_NULL);
				throw new BaseException(BaseExceptionEnum.NO_UPDATE);
			}else{
				sourceList = this.setSourceStatusBatch(sourceList, SourceStatusEnum.SUBMIT.getCode());
				if(this.updateBatchById(sourceList)){
					return true;
				}else{
					//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.SUBMIT_FAIL);
					throw new BaseException(BaseExceptionEnum.NO_UPDATE);
				}
			}
		}else{
			//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.ID_NULL);
			throw new BaseException(BaseExceptionEnum.NO_UPDATE);
		}	
	}

	@Override
	@Transactional
	public boolean online(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<Long> idList = StringUtil.string2List(idStr);
			List<Source> sourceList = this.selectBatchIds(idList);
			if(CollectionUtils.isEmpty(sourceList)){
				//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.DATA_NULL);
				throw new BaseException(BaseExceptionEnum.NO_UPDATE);
			}else{
				sourceList = this.setSourceStatusBatch(sourceList, SourceStatusEnum.ONLINE.getCode());
				if(this.updateBatchById(sourceList)){
					return true;
				}else{
					//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.ONLINE_FAIL);
					throw new BaseException(BaseExceptionEnum.NO_UPDATE);
				}
			}
		}else{
			//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.ID_NULL);
			throw new BaseException(BaseExceptionEnum.NO_UPDATE);
		}	
	}

	@Override
	@Transactional
	public boolean offline(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<Long> idList = StringUtil.string2List(idStr);
			List<Source> sourceList = this.selectBatchIds(idList);
			if(CollectionUtils.isEmpty(sourceList)){
				//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.DATA_NULL);
				throw new BaseException(BaseExceptionEnum.NO_UPDATE);
			}else{
				sourceList = this.setSourceStatusBatch(sourceList, SourceStatusEnum.OFFFLINE.getCode());
				if(this.updateBatchById(sourceList)){
					return true;
				}else{
					//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.OFFLINE_FAIL);
					throw new BaseException(BaseExceptionEnum.NO_UPDATE);
				}
			}
		}else{
			//throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), ErrorMsgContants.ID_NULL);
			throw new BaseException(BaseExceptionEnum.NO_UPDATE);
		}	
	}

	@Override
	@Transactional
	public boolean abandon(Source source) {
		String idStr = source.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<Long> idList = StringUtil.string2List(idStr);
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
			source.setStatus(status);
			list.add(source);
		}	
		return list;
	}

	@Override
	public Page<Source> selectSourcePage(Page<Source> page, EntityWrapper<Source> entityWrapper) {
		return this.selectPage(page, entityWrapper);
	}
	
	

}

package com.chens.exam.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.core.constants.ErrorMsgContants;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.UserInfo;
import com.chens.core.vo.ZTree;
import com.chens.exam.core.entity.wms.Forder;
import com.chens.exam.core.enums.NodeTypeEnum;
import com.chens.exam.core.enums.TopIdEnum;
import com.chens.exam.core.utils.StringUtil;
import com.chens.exam.wms.mapper.ForderMapper;
import com.chens.exam.wms.service.IForderService;

/**
 * <p>
 * 文件夹表 服务实现类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@Service
public class ForderServiceImpl extends ServiceImpl<ForderMapper, Forder> implements IForderService{
	
	@Override
	@Transactional
	public Long save(Forder forder, UserInfo userInfo) {
		String userName = userInfo.getUsername();
		//文件夹名称唯一性校验，同一个文件夹目录下是否重名
		Forder query = new Forder();
		query.setTenantId(userInfo.getTenantId());
		query.setParentId(forder.getParentId());
		query.setForderName(forder.getForderName());
		query.setCreateBy(userName);
		EntityWrapper<Forder> ew = new EntityWrapper<Forder>(query);
		List<Forder> forderList= this.selectList(ew);
		Long id = forder.getId();
		if(id == null){
			if(CollectionUtils.isNotEmpty(forderList)){
				throw new BaseException(BaseExceptionEnum.VALIDATE_NOPASS.getCode(), ErrorMsgContants.FORDER_NAME_VALIDATE_NOPASS);
			}else{
				if(this.insert(forder)){
					return forder.getId();
				}else{
					throw new BaseException(BaseExceptionEnum.NO_SAVE.getCode(), BaseExceptionEnum.NO_SAVE.getMessage());
				}
			}
		}else{
			if(CollectionUtils.isNotEmpty(forderList) && (forderList.size() > 1 || (forderList.size() == 1 && !forderList.get(0).getId().equals(id)))){
				throw new BaseException(BaseExceptionEnum.VALIDATE_NOPASS.getCode(), ErrorMsgContants.FORDER_NAME_VALIDATE_NOPASS);
			}else{
				if(this.updateById(forder)){
					return forder.getId();
				}else{
					throw new BaseException(BaseExceptionEnum.NO_UPDATE.getCode(), BaseExceptionEnum.NO_UPDATE.getMessage());
				}
			}
		}
	}

	@Override
	public List<ZTree> loadForderTree(Forder forder) {
		List<ZTree> ztreeList = new ArrayList<ZTree>();
		//添加根节点
		ZTree top = new ZTree(TopIdEnum.TOP_SOURCE.getCode(),null,TopIdEnum.TOP_SOURCE.getDisplay(),NodeTypeEnum.SOURCE_ROOT.getCode(),true);//资源根节点
		ztreeList.add(top);		
		//查询全部资源目录，资源目录权限，同租户下所有资源可见
		EntityWrapper<Forder> ew = new EntityWrapper<Forder>(forder);
		ew.orderBy("create_time", false);//创建时间降序
		List<Forder> forderList = this.selectList(ew);
		if(CollectionUtils.isNotEmpty(forderList)){
			for (Forder temp : forderList) {
				ZTree zTreeTemp = new ZTree();
				zTreeTemp.setId(temp.getId());
				zTreeTemp.setName(temp.getForderName());
				zTreeTemp.setpId(temp.getParentId());
				ztreeList.add(zTreeTemp);				
			}
		}
		return ztreeList;
	}

	@Override
	@Transactional
	public boolean delete(Forder forder) {
		String idStr = forder.getIdStr();
		if(StringUtils.isNotBlank(idStr)){
			List<Long> idList = StringUtil.string2List(idStr);
			for(Long id : idList){
				if(!this.deleteById(id)){
					throw new BaseException(BaseExceptionEnum.NO_DELETE.getCode(), BaseExceptionEnum.NO_DELETE.getMessage());
				}
			}
			return true;
			
		}else{
			throw new BaseException(BaseExceptionEnum.NO_DELETE.getCode(), ErrorMsgContants.ID_NULL);
		}			
	}

}

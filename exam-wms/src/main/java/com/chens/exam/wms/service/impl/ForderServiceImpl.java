package com.chens.exam.wms.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.core.entity.Result;
import com.chens.core.entity.UserInfo;
import com.chens.core.util.ResultHelper;
import com.chens.exam.core.entity.wms.Forder;
import com.chens.exam.core.enums.YesNoEnum;
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
public class ForderServiceImpl extends ServiceImpl<ForderMapper, Forder> implements IForderService {
	

	@Override
	public Result save(Forder forder, UserInfo userInfo) {
		String userName = userInfo.getUsername();
		//文件夹名称唯一性校验，同一个文件夹目录下是否重名
		Forder query = new Forder();
		query.setParentId(forder.getParentId());
		query.setForderName(forder.getForderName());
		query.setCreateBy(userName);
		query.setIsDelete(YesNoEnum.NO.getCode());
		EntityWrapper<Forder> ew = new EntityWrapper<Forder>(query);
		List<Forder> forderList= this.selectList(ew);
		Long id = forder.getId();
		if(id == null){
			if(CollectionUtils.isNotEmpty(forderList)){
				return ResultHelper.getError("在同一目录下已存在相同名称的文件夹，请修改！");
			}else{
				this.insert(forder);
				return ResultHelper.getSuccess("保存成功！",forder.getId());
			}
		}else{
			if(CollectionUtils.isNotEmpty(forderList) && (forderList.size() > 1 || (forderList.size() == 1 && !forderList.get(0).getId().equals(id)))){
				return ResultHelper.getError("在同一目录下已存在相同名称的文件夹，请修改！");
			}else{
				this.updateById(forder);
				return ResultHelper.getSuccess("修改成功！",forder.getId());
			}
		}
	}

}

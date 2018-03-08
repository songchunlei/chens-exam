package com.chens.exam.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.core.entity.Result;
import com.chens.core.entity.UserInfo;
import com.chens.core.entity.ZTree;
import com.chens.core.util.ResultHelper;
import com.chens.exam.core.entity.wms.Forder;
import com.chens.exam.core.enums.NodeTypeEnum;
import com.chens.exam.core.enums.TopIdEnum;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ForderServiceImpl.class);

	@Override
	@Transactional
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

	@Override
	public Result loadForderTree(Forder forder) {
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
		return ResultHelper.getSuccess("查询成功！",ztreeList);
	}

	@Override
	@Transactional
	public Result delete(Forder forder) {
		try {
			this.deleteById(forder.getId());
			return ResultHelper.getSuccess("删除成功！");
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return ResultHelper.getError("删除失败，原因：" + e.getMessage());
		}
	}

}

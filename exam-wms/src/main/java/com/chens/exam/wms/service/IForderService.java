package com.chens.exam.wms.service;

import com.baomidou.mybatisplus.service.IService;
import com.chens.core.entity.Result;
import com.chens.core.entity.UserInfo;
import com.chens.exam.core.entity.wms.Forder;

/**
 * <p>
 * 文件夹表 服务类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public interface IForderService extends IService<Forder> {
	
	/**
	 * 保存文件夹
	 * @param forder
	 * @param userInfo
	 * @return
	 */
	Result save(Forder forder, UserInfo userInfo);
	
	/**
	 * 获取我的资源目录树
	 * @param forder
	 * @return
	 */
	Result loadForderTree(Forder forder);
	
	/**
	 * 删除文件夹，逻辑删除
	 * @param forder
	 * @return
	 */
	Result delete(Forder forder);

}

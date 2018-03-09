package com.chens.exam.wms.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.chens.core.vo.UserInfo;
import com.chens.core.vo.ZTree;
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
	Long save(Forder forder, UserInfo userInfo);
	
	/**
	 * 获取我的资源目录树
	 * @param forder
	 * @return
	 */
	List<ZTree> loadForderTree(Forder forder);
	
	/**
	 * 删除文件夹，逻辑删除
	 * @param forder
	 * @return
	 */
	boolean delete(Forder forder);

}

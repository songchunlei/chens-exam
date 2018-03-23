package com.chens.exam.wms.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.chens.auth.client.vo.UserInfo;
import com.chens.exam.core.entity.wms.Source;

/**
 * <p>
 * 资源素材表 服务类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public interface ISourceService extends IService<Source> {

	
	/**
	 * 保存资源
	 * @param source
	 * @param userInfo
	 * @return
	 */
	Long save(Source source, UserInfo userInfo);

	/**
	 * 删除资源
	 * @param source
	 * @return
	 */
	boolean delete(Source source);
	
	
	/**
	 * 提交资源
	 * @param source
	 * @return
	 */
	boolean submit(Source source);
	
	
	/**
	 * 上架资源
	 * @param source
	 * @return
	 */
	boolean online(Source source);
	
	
	/**
	 * 下架资源
	 * @param source
	 * @return
	 */
	boolean offline(Source source);
	
	/**
	 * 废除资源
	 * @param source
	 * @return
	 */
	boolean abandon(Source source);
	
	/**
	 * 资源分页
	 * @param page
	 * @param entityWrapper
	 * @return
	 */
	Page<Source> selectSourcePage(Page<Source> page, EntityWrapper<Source> entityWrapper);
}
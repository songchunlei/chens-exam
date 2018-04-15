package com.chens.exam.wms.service;

import com.chens.bpm.service.IWfBaseService;
import com.chens.core.vo.UserInfo;
import com.chens.exam.core.entity.wms.Source;

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
}

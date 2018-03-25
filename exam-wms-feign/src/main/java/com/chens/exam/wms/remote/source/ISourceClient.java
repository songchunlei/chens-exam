package com.chens.exam.wms.remote.source;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.wms.remote.source.hystrix.SourceClientHystrix;
/**
 * @ClassName: IForderClient 
 * @Description: 计费对外接口实现类
 * @author WDP
 * @date 2018年3月7日
 */
@FeignClient(path = "source", value = "exam-wms",fallback=SourceClientHystrix.class)
public interface ISourceClient {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	@RequestMapping(value="/save")
	String save(@RequestBody Map<String, Object> map);

	
	/**
	 * 删除文件夹
	 * @param forder
	 * @return
	 */
	@RequestMapping(value="/delete")
	boolean delete(@RequestBody Source source);
	
	

	/**
	 * 提交资源
	 * @param source
	 * @return
	 */
	@RequestMapping(value="/submit")
	boolean submit(@RequestBody Source source);
	
	
	/**
	 * 上架资源
	 * @param source
	 * @return
	 */
	@RequestMapping(value="/online")
	boolean online(@RequestBody Source source);
	
	
	/**
	 * 下架资源
	 * @param source
	 * @return
	 */
	@RequestMapping(value="/offline")
	boolean offline(@RequestBody Source source);
	
	/**
	 * 废除资源
	 * @param source
	 * @return
	 */
	@RequestMapping(value="/abandon")
	boolean abandon(@RequestBody Source source);

}
package com.chens.exam.wms.remote.forder;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.core.entity.Result;
import com.chens.exam.wms.remote.forder.hystrix.ForderClientHystrix;
/**
 * @ClassName: IForderClient 
 * @Description: 计费对外接口实现类
 * @author WDP
 * @date 2018年3月7日
 */
@FeignClient(path = "forder", value = "exam-wms",fallback=ForderClientHystrix.class)
public interface IForderClient {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	@RequestMapping(value="/save")
	Result save(@RequestBody Map<String, Object> map);


}
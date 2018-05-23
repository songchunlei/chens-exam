package com.chens.exam.wms.remote.forder;

import java.util.List;
import java.util.Map;

import com.chens.exam.core.entity.wms.SourceFolder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.core.vo.TreeVo;
import com.chens.exam.wms.remote.forder.hystrix.SourceForderClientHystrix;
/**
 * @ClassName: IForderClient 
 * @Description: 计费对外接口实现类
 * @author WDP
 * @date 2018年3月7日
 */
@FeignClient(path = "sourceforder", value = "exam-wms",fallback= SourceForderClientHystrix.class)
public interface ISourceForderClient {

	/**
	 * 将对象保存，返回该条记录的操作数量，保存成功之后，将主键填充到参数对象中
	 */
	@RequestMapping(value="/save")
	String save(@RequestBody Map<String, Object> map);

	/**
	 * 获取全部资源目录，同租户下目录树
	 * @param sourceForder
	 * @return
	 */
	@RequestMapping(value="/loadForderTree")
	List<TreeVo> loadForderTree(@RequestBody SourceFolder sourceForder);
	
	/**
	 * 删除文件夹
	 * @param sourceForder
	 * @return
	 */
	@RequestMapping(value="/delete")
	boolean delete(@RequestBody SourceFolder sourceForder);

}
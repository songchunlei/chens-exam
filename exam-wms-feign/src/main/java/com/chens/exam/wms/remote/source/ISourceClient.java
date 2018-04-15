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
@FeignClient(path = "sourceRpc", value = "exam-wms",fallback=SourceClientHystrix.class)
public interface ISourceClient {

}
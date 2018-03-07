package com.chens.exam.wms.remote.forder.hystrix;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.chens.core.entity.Result;
import com.chens.exam.wms.remote.forder.IForderClient;
@Component
public class ForderClientHystrix implements IForderClient {
	private static final Logger logger = LoggerFactory.getLogger(ForderClientHystrix.class);

	@Override
	public Result save(Map<String, Object> map) {
		logger.error("----调用保存方法出错-----");
		throw new MybatisPlusException("调用保存方法出错");
	}

	

}

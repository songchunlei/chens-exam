package com.chens.exam.wms.remote.source.hystrix;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.wms.remote.source.ISourceClient;
@Component
public class SourceClientHystrix implements ISourceClient {
	private static final Logger logger = LoggerFactory.getLogger(SourceClientHystrix.class);

	@Override
	public String save(Map<String, Object> map) {
		logger.error("----调用保存方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(),"调用保存方法出错");
	}

	@Override
	public boolean delete(Source source) {
		logger.error("----调用删除方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(),"调用删除方法出错");
	}

	@Override
	public boolean submit(Source source) {
		logger.error("----调用提交方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(),"调用提交方法出错");
	}

	@Override
	public boolean online(Source source) {
		logger.error("----调用上架方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(),"调用上架方法出错");
	}

	@Override
	public boolean offline(Source source) {
		logger.error("----调用下架方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(),"调用下架方法出错");
	}

	@Override
	public boolean abandon(Source source) {
		logger.error("----调用废弃方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(),"调用废弃方法出错");
	}



	

}

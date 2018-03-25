package com.chens.exam.wms.remote.forder.hystrix;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.ZTree;
import com.chens.exam.core.entity.wms.Forder;
import com.chens.exam.wms.remote.forder.IForderClient;
@Component
public class ForderClientHystrix implements IForderClient {
	private static final Logger logger = LoggerFactory.getLogger(ForderClientHystrix.class);

	@Override
	public String save(Map<String, Object> map) {
		logger.error("----调用保存方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(), "调用保存方法出错");
	}

	@Override
	public List<ZTree> loadForderTree(Forder forder) {
		logger.error("----调用获取资源目录方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(), "调用获取资源目录方法出错");
	}

	@Override
	public boolean delete(Forder forder) {
		logger.error("----调用删除 方法出错-----");
		throw new BaseException(BaseExceptionEnum.REQUEST_NULL.getCode(), "调用删除 方法出错");
	}

	

}

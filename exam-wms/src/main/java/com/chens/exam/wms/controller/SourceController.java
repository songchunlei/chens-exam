package com.chens.exam.wms.controller;


import com.chens.bpm.controller.WfBaseController;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.core.web.BaseWebController;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.wms.service.ISourceService;

/**
 * <p>
 * 资源素材表 前端控制器
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@RestController
@RequestMapping("/sourceController")
public class SourceController extends WfBaseController<ISourceService,Source> {

	@Override
	protected void init() {
		WF_DEF_KEY = "11111";
	}

	/**
	 * 提交资源
	 * @param source
	 * @return
	 */
	@PutMapping("/submit")
	public ResponseEntity<Result> submit(@RequestBody Source source) {
			if(source != null && StringUtils.isNotBlank(source.getIdStr())){
				return doSuccess("提交成功",service.submit(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}
	}
	
	/**
	 * 上架资源
	 * @param source
	 * @return
	 */
	@PutMapping("/online")
	public ResponseEntity<Result> online(@RequestBody Source source) {
			if(source != null && StringUtils.isNotBlank(source.getIdStr())){
				return doSuccess("上架成功",service.publish(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	/**
	 * 下架资源
	 * @param source
	 * @return
	 */
	@PutMapping("/offline")
	public ResponseEntity<Result> offline(@RequestBody Source source) {
			if(source != null && StringUtils.isNotBlank(source.getIdStr())){
				return doSuccess("下架成功",service.offline(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	/**
	 * 废弃资源
	 * @param source
	 * @return
	 */
	@PutMapping("/abandon")
	public ResponseEntity<Result> abandon(@RequestBody Source source) {
			if(source != null && StringUtils.isNotBlank(source.getIdStr())){
				return doSuccess("废弃成功",service.abandon(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}

}


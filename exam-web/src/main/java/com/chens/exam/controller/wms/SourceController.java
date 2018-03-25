package com.chens.exam.controller.wms;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.auth.vo.UserInfo;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.core.web.BaseController;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.wms.remote.source.ISourceClient;

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
public class SourceController extends BaseController {
		
	@Autowired
	private ISourceClient sourceService;
	
	
	@RequestMapping("/save")
	public ResponseEntity<Result> save(Source source) {
			if(source != null){
				source.setName("英语");
			//	source.setForderId(971583536198893569L);
				//用户信息需要从缓存 中获取，待后续修改
				UserInfo userInfo = new UserInfo();
//				userInfo.setUsername("wudepeng");
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("source", source);
				map.put("userInfo", userInfo);
				String id = sourceService.save(map);		
				return doSuccess(id);
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	
	/**
	 * 删除资源, 逻辑删除
	 * @param source
	 * @return
	 */
	@RequestMapping("/delete")
	public ResponseEntity<Result> delete(Source source) {
			if(source != null && source.getId() != null){		
				;
				return doSuccess(sourceService.delete(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}
	}
	
	
	/**
	 * 提交资源
	 * @param source
	 * @return
	 */
	@RequestMapping("/submit")
	public ResponseEntity<Result> submit(Source source) {
			if(source != null && source.getId() != null){
				return doSuccess(sourceService.submit(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}
	}
	
	/**
	 * 上架资源
	 * @param source
	 * @return
	 */
	@RequestMapping("/online")
	public ResponseEntity<Result> online(Source source) {
			if(source != null && source.getId() != null){
				return doSuccess(sourceService.online(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	/**
	 * 下架资源
	 * @param source
	 * @return
	 */
	@RequestMapping("/offline")
	public ResponseEntity<Result> offline(Source source) {
			if(source != null && source.getId() != null){
				return doSuccess(sourceService.offline(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	/**
	 * 废弃资源
	 * @param source
	 * @return
	 */
	@RequestMapping("/abandon")
	public ResponseEntity<Result> abandon(Source source) {
			if(source != null && source.getId() != null){
				return doSuccess(sourceService.abandon(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	
	/**
	 * 资源分页
	 * @param source
	 * @return
	 */
	/*
	@RequestMapping("/page")
	public ResponseEntity<Result> page(Source source) {
		 Page<Source> page = this.createPage(request,10);		 
		 EntityWrapper<Source> ew = new EntityWrapper<Source>(new Source());
		 //资源名称模糊查询
		 if(StringUtils.isNotBlank(source.getName())){
			 ew.like("name", source.getName());
		 }
		 ew.and("forder_id = {0}", source.getForderId());
		 
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("page", page);
		 map.put("ew", ew);
		 page = sourceService.selectSourcePage(map);	 
		 Map<String,Object> resultMap = new HashMap<String,Object>();
		 resultMap.put("page", page);	 
		 return doSuccess(SuccessMsgContants.QUERY_SUCCESS, resultMap);	 
	}
	*/
}


package com.chens.exam.controller.wms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.core.vo.UserInfo;
import com.chens.core.vo.ZTree;
import com.chens.core.web.BaseController;
import com.chens.exam.core.entity.wms.Forder;
import com.chens.exam.wms.remote.forder.IForderClient;

/**
 * <p>
 * 文件夹表 前端控制器
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@RestController
@RequestMapping("/forderController")
public class ForderController extends BaseController {
	
	@Autowired
	private IForderClient forderService;
	
	
	@RequestMapping("/save")
	public ResponseEntity<Result> save(Forder forder) {
			if(forder != null){
//				forder.setForderName("小学劳技");
//				forder.setId(972037445715595265L);
//				forder.setParentId(971338448474591233L);
				//用户信息需要从缓存 中获取，待后续修改
				UserInfo userInfo = new UserInfo();	
				userInfo.setUsername("wudepeng");
//				userInfo.setTenantId(1L);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("forder", forder);
				map.put("userInfo", userInfo);
				Long id = forderService.save(map);
				return doSuccess(id);
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	/*
	 * 获取的全部资源目录树
	 */
	@RequestMapping("/loadForderTree")
	public ResponseEntity<Result> loadForderTree() {
		//用户信息需要从缓存 中获取，待后续修改
		List<ZTree> ztreeList = forderService.loadForderTree(new Forder());
		return doSuccess(ztreeList);

	}
	
	/**
	 * 删除文件夹, 逻辑删除
	 * @param forder
	 * @return
	 * @throws BaseException 
	 */
	@RequestMapping("/delete")
	public ResponseEntity<Result> delete(Forder forder) {
//		forder.setIdStr("972037445715595265,971995178036420610");
		if(forder != null && StringUtils.isNotBlank(forder.getIdStr())){
			return doSuccess(forderService.delete(forder));
		} else {
			throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
		}
	}
	
}


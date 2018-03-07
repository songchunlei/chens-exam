package com.chens.exam.wms.remote.forder;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.core.entity.Result;
import com.chens.core.entity.UserInfo;
import com.chens.exam.core.entity.wms.Forder;
import com.chens.exam.core.utils.JsonUtils;
import com.chens.exam.wms.service.IForderService;
/**
 * 对外文件夹接口
 * @author WDP
 *
 */
@RestController
@RequestMapping(value="/forder")
public class ForderClientImpl implements IForderClient {

	@Autowired
	private IForderService forderService;

	@Override
	public Result save(@RequestBody Map<String, Object> map) {		
		Forder forder = JsonUtils.conveterObject(map.get("forder"), Forder.class);  		
		UserInfo userInfo = JsonUtils.conveterObject(map.get("userInfo"), UserInfo.class);  	
		return forderService.save(forder, userInfo);
	}
	
	

}

package com.chens.exam.controller.wms;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.core.entity.Result;
import com.chens.core.entity.UserInfo;
import com.chens.core.util.ResultHelper;
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

	 private Logger logger = LogManager.getLogger(ForderController.class);
	
	@Autowired
	private IForderClient forderService;
	
	
	@RequestMapping("/save")
	public Result save(Forder forder) {
		try{
			if(forder != null){
				//用户信息需要从缓存 中获取，待后续修改
				UserInfo userInfo = new UserInfo();			
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("forder", forder);
				map.put("userInfo", userInfo);
				return forderService.save(map);		
			} else {
				return ResultHelper.getError("数据传输失败！");
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			return ResultHelper.getError(e.getMessage());
		}

	}
	
}


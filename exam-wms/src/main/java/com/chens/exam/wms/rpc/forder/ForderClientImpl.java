package com.chens.exam.wms.rpc.forder;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.core.vo.UserInfo;
import com.chens.core.vo.ZTree;
import com.chens.exam.core.entity.wms.Forder;
import com.chens.exam.core.utils.JsonUtils;
import com.chens.exam.wms.remote.forder.IForderClient;
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
	public String save(@RequestBody Map<String, Object> map) {		
		Forder forder = JsonUtils.conveterObject(map.get("forder"), Forder.class);  		
		UserInfo userInfo = JsonUtils.conveterObject(map.get("userInfo"), UserInfo.class);
		return forderService.save(forder, userInfo);
	}

	@Override
	public List<ZTree> loadForderTree(@RequestBody Forder forder) {
		return forderService.loadForderTree(forder);
	}

	@Override
	public boolean delete(@RequestBody Forder forder) {
		return forderService.delete(forder);
	}
	
	

}

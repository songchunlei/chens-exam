package com.chens.exam.wms.rpc.source;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.auth.vo.UserInfo;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.core.utils.JsonUtils;
import com.chens.exam.wms.remote.source.ISourceClient;
import com.chens.exam.wms.service.ISourceService;
/**
 * 对外资源接口
 * @author WDP
 *
 */
@RestController
@RequestMapping(value="/source")
public class SourceClientImpl implements ISourceClient {

	@Autowired
	private ISourceService sourceService;

	@Override
	public String save(@RequestBody Map<String, Object> map) {		
		Source source = JsonUtils.conveterObject(map.get("source"), Source.class);  		
		UserInfo userInfo = JsonUtils.conveterObject(map.get("userInfo"), UserInfo.class);
		return sourceService.save(source, userInfo);
	}


	@Override
	public boolean delete(@RequestBody Source source) {
		return sourceService.delete(source);
	}


	@Override
	public boolean submit(@RequestBody Source source) {
		return sourceService.submit(source);
	}


	@Override
	public boolean online(@RequestBody Source source) {
		return sourceService.online(source);
	}


	@Override
	public boolean offline(@RequestBody Source source) {
		return sourceService.offline(source);
	}


	@Override
	public boolean abandon(@RequestBody Source source) {
		return sourceService.abandon(source);
	}
	

}

package com.chens.exam.wms.rpc.source;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.core.vo.UserInfo;
import com.chens.exam.core.entity.wms.Source;
import com.chens.core.util.JsonUtils;
import com.chens.exam.wms.remote.source.ISourceClient;
import com.chens.exam.wms.service.ISourceService;
/**
 * 对外资源接口
 * @author WDP
 *
 */
@RestController
@RequestMapping(value="/sourceRpc")
public class SourceClientImpl implements ISourceClient {

	

}

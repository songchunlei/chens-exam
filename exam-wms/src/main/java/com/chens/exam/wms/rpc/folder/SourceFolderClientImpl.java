package com.chens.exam.wms.rpc.folder;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.core.vo.TreeVo;
import com.chens.exam.core.entity.wms.SourceFolder;
import com.chens.exam.wms.remote.forder.ISourceForderClient;

/**
 * 对外文件夹接口
 * @author WDP
 *
 */
@RestController
@RequestMapping(value="/forder")
public class SourceFolderClientImpl implements ISourceForderClient {

//	@Autowired
//	private ISourceFolderService sourceForderService;

	@Override
	public String save(@RequestBody Map<String, Object> map) {
		return null;
	}

	@Override
	public List<TreeVo> loadForderTree(@RequestBody SourceFolder sourceForder) {
		return null;
	}

	@Override
	public boolean delete(@RequestBody SourceFolder sourceForder) {
		return true;
	}
	
	

}

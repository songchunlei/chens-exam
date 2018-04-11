package com.chens.exam.wms.service.impl;

import com.chens.exam.core.entity.wms.SourceFolder;
import com.chens.exam.core.enums.FolderTypeEnum;
import com.chens.exam.wms.mapper.SourceForderMapper;
import com.chens.exam.wms.service.ISourceForderService;
import com.chens.exam.wms.vo.service.impl.AbstractForderServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 *  服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@Service
public class SourceForderServiceImpl extends AbstractForderServiceImpl<SourceForderMapper, SourceFolder> implements ISourceForderService {

    @Override
    protected void init() {
        folderType = FolderTypeEnum.SOURCE.getCode();
    }
}

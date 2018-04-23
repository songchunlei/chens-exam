package com.chens.exam.wms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.exam.core.enums.ExamFileTypeEnum;
import com.chens.file.vo.FolderFileInfo;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.core.entity.wms.SourceFolder;
import com.chens.exam.wms.mapper.SourceFolderMapper;
import com.chens.exam.wms.service.ISourceFolderService;
import com.chens.exam.wms.service.ISourceService;
import com.chens.file.vo.service.impl.AbstractFolderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *  资源服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@Service
public class SourceFolderServiceImpl extends AbstractFolderServiceImpl<SourceFolderMapper, SourceFolder> implements ISourceFolderService {

    @Autowired
    private ISourceService sourceService;

    @Override
    protected String initType() {
        return ExamFileTypeEnum.SOURCE.getCode();
    }

    @Override
    protected List<FolderFileInfo> getFileInfoListByFolderId(String folderId) {
        List<FolderFileInfo> folderFileInfoList = new ArrayList<>();
        Source source = new Source();
        source.setFolderId(folderId);
        EntityWrapper<Source> sourceEntityWrapper = new EntityWrapper<>(source);
        List<Source> sourceList = sourceService.selectList(sourceEntityWrapper);
        for (Source file:sourceList)
        {
            folderFileInfoList.add(file.getFolderInfo());
        }
        return folderFileInfoList;
    }
}

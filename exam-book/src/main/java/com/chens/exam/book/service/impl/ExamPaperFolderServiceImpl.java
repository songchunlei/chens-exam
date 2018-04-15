package com.chens.exam.book.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.core.vo.FolderFileInfo;
import com.chens.exam.core.entity.book.ExamPaper;
import com.chens.exam.core.entity.book.ExamPaperFolder;
import com.chens.exam.book.mapper.ExamPaperFolderMapper;
import com.chens.exam.book.service.IExamPaperFolderService;
import com.chens.exam.book.service.IExamPaperService;
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
public class ExamPaperFolderServiceImpl extends AbstractFolderServiceImpl<ExamPaperFolderMapper, ExamPaperFolder> implements IExamPaperFolderService {

    @Autowired
    private IExamPaperService examPaperService;

    @Override
    protected List<FolderFileInfo> getFileInfoListByFolderId(String folderId) {
        List<FolderFileInfo> folderFileInfoList = new ArrayList<>();
        ExamPaper examPaper = new ExamPaper();
        examPaper.setFolderId(folderId);
        EntityWrapper<ExamPaper> examPaperEntityWrapper = new EntityWrapper<>(examPaper);
        List<ExamPaper> examPaperList = examPaperService.selectList(examPaperEntityWrapper);
        for (ExamPaper file:examPaperList)
        {
            folderFileInfoList.add(file.getForderInfo());
        }
        return folderFileInfoList;
    }
}

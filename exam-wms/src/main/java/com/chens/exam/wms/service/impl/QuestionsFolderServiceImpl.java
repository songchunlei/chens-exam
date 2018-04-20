package com.chens.exam.wms.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.file.vo.FolderFileInfo;
import com.chens.exam.core.entity.wms.Questions;
import com.chens.exam.core.entity.wms.QuestionsFolder;
import com.chens.exam.wms.mapper.QuestionsFolderMapper;
import com.chens.exam.wms.service.IQuestionsFolderService;
import com.chens.exam.wms.service.IQuestionsService;
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
public class QuestionsFolderServiceImpl extends AbstractFolderServiceImpl<QuestionsFolderMapper, QuestionsFolder> implements IQuestionsFolderService {

    @Autowired
    private IQuestionsService questionsService;

    @Override
    protected List<FolderFileInfo> getFileInfoListByFolderId(String folderId) {
        List<FolderFileInfo> folderFileInfoList = new ArrayList<>();
        Questions questions = new Questions();
        questions.setFolderId(folderId);
        EntityWrapper<Questions> questionsEntityWrapper = new EntityWrapper<>(questions);
        List<Questions> sourceList = questionsService.selectList(questionsEntityWrapper);
        for (Questions file:sourceList)
        {
            folderFileInfoList.add(file.getFolderInfo());
        }
        return folderFileInfoList;
    }
}

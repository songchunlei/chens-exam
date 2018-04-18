package com.chens.exam.book.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.core.util.StringUtils;
import com.chens.exam.core.entity.book.ExamPaper;
import com.chens.exam.book.mapper.ExamPaperMapper;
import com.chens.exam.book.service.IExamPaperService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.exam.core.entity.book.ExampaperQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 试卷 服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Service
public class ExamPaperServiceImpl extends BaseWfServiceImpl<ExamPaperMapper, ExamPaper> implements IExamPaperService {


    @Override
    public List<ExamPaper> getPapperListByQuestionId(String questionId) {
        return baseMapper.getPapperListByQuestionId(questionId);
    }

    @Override
    public ExamPaper saveEntity(ExamPaper examPaper) {
        this.insertOrUpdate(examPaper);
        return examPaper;
    }

    @Override
    public boolean beforeSubmit(WorkFlowRequestParam<ExamPaper> workFlowRequestParam) {
        return false;
    }

    @Override
    public boolean afterSubmit(WorkFlowRequestParam<ExamPaper> workFlowRequestParam) {
        return false;
    }
}

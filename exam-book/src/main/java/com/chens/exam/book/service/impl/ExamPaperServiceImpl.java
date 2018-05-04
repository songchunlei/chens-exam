package com.chens.exam.book.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.stereotype.Service;

import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.exam.book.mapper.ExamPaperMapper;
import com.chens.exam.book.service.IExamPaperService;
import com.chens.exam.core.entity.book.ExamPaper;

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
    public List<ExamPaper> getExamPaperListByQuestionId(String questionId) {
        return baseMapper.getExamPaperListByQuestionId(questionId);
    }

    @Override
    public Page<ExamPaper> getDeletedExamPaperList(Page<ExamPaper> page, ExamPaper examPaper) {
        List<ExamPaper> examPaperList = baseMapper.getDeletedExamPaperList(page,examPaper);
        page.setRecords(examPaperList);
        return page;
    }


    @Override
    public ExamPaper saveEntity(ExamPaper examPaper) {
        this.insertOrUpdate(examPaper);
        return examPaper;
    }
}

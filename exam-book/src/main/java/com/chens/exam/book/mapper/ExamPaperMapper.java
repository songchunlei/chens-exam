package com.chens.exam.book.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.chens.exam.core.entity.book.ExamPaper;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 *
 * 试卷 Mapper 接口
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
public interface ExamPaperMapper extends BaseMapper<ExamPaper> {

    /**
     * 根据题目id获得试卷列表
     * @param questionId
     * @return
     */
    List<ExamPaper> getExamPaperListByQuestionId(String questionId);

    /**
     * 回收试卷列表
     * @param page 分页
     * @param examPaper 试卷参数
     * @return
     */
    List<ExamPaper> getDeletedExamPaperList(Page<ExamPaper> page,ExamPaper examPaper);
}
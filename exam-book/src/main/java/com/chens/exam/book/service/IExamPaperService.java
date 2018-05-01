package com.chens.exam.book.service;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.chens.bpm.service.IWfBaseService;
import com.chens.exam.core.entity.book.ExamPaper;

/**
 *
 * 试卷 服务接口
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
public interface IExamPaperService extends IWfBaseService<ExamPaper> {

    /**
     * 根据题目id查询试卷
     * @param questionId
     * @return
     */
    List<ExamPaper> getExamPaperListByQuestionId(String questionId);

    /**
     * 回收箱
     * @param page
     * @param examPaper
     * @return
     */
    Page<ExamPaper> getDeletedExamPaperList(Page<ExamPaper> page, ExamPaper examPaper);

}

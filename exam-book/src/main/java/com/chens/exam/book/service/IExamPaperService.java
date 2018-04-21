package com.chens.exam.book.service;

import java.util.List;

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
     * @return
     */
    List<ExamPaper> getPapperListByQuestionId(String questionId);


}

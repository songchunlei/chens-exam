package com.chens.exam.book.service;

import com.chens.exam.core.entity.book.ExamPaper;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 *
 * 试卷 服务接口
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
public interface IExamPaperService extends IService<ExamPaper> {

    /**
     * 根据题目id查询试卷
     * @return
     */
    List<ExamPaper> getPapperListByQuestionId(String questionId);


}

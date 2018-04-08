package com.chens.exam.book.service;

import com.chens.exam.core.entity.book.ExampaperQuestion;
import com.baomidou.mybatisplus.service.IService;

/**
 *
 *  服务接口
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
public interface IExampaperQuestionService extends IService<ExampaperQuestion> {

    /**
     * 增加题目
     * @param papperId
     * @param questionIds
     * @return
     */
    boolean addQuestionsInPapper(String papperId,String questionIds);

    /**
     * 删除题目
     * @param papperId
     * @param questionIds
     * @return
     */
    boolean deleteQuestionsInPapper(String papperId,String questionIds);
}

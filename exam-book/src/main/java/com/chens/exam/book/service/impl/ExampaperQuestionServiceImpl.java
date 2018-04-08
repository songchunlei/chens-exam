package com.chens.exam.book.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.core.util.StringUtils;
import com.chens.exam.core.entity.book.ExampaperQuestion;
import com.chens.exam.book.mapper.ExampaperQuestionMapper;
import com.chens.exam.book.service.IExampaperQuestionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *  服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Service
public class ExampaperQuestionServiceImpl extends ServiceImpl<ExampaperQuestionMapper, ExampaperQuestion> implements IExampaperQuestionService {

    private final String DEFAULT_QUESTION_ID_SPLIT_FLG=",";

    @Override
    public boolean addQuestionsInPapper(String papperId, String questionIds) {
        boolean  flag = false;
        if (StringUtils.isNotEmpty(questionIds)) {
            List<ExampaperQuestion> exampaperQuestionList = new ArrayList<>();
            String[] checkedStr = questionIds.split(DEFAULT_QUESTION_ID_SPLIT_FLG);
            for (String s : checkedStr) {
                ExampaperQuestion exampaperQuestion = new ExampaperQuestion(papperId,s);
                exampaperQuestionList.add(exampaperQuestion);
            }
            // 将选中角色id进行保存处理
            flag = this.insertBatch(exampaperQuestionList);
        }
        return flag;
    }

    @Override
    public boolean deleteQuestionsInPapper(String papperId, String questionIds) {
        if (StringUtils.isNotEmpty(questionIds)) {
            String[] checkedStr = questionIds.split(DEFAULT_QUESTION_ID_SPLIT_FLG);
            for (String s : checkedStr) {
                ExampaperQuestion exampaperQuestion = new ExampaperQuestion(papperId,s);
                this.delete(new EntityWrapper<>(exampaperQuestion));
            }
        }
        return true;
    }
}

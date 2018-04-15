package com.chens.exam.book.controller;

import com.chens.bpm.controller.BaseWfWebController;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.exam.book.service.IExampaperQuestionService;
import com.chens.exam.core.enums.WfProcessDefinitionKeyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.chens.exam.book.service.IExamPaperService;
import com.chens.exam.core.entity.book.ExamPaper;


import com.chens.core.web.BaseWebController;

import javax.validation.constraints.NotNull;

/**
 *
 * 试卷 控制器
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Controller
@RequestMapping("/examPaperController")
public class ExamPaperController extends BaseWfWebController<IExamPaperService,ExamPaper> {

    @Autowired
    private IExampaperQuestionService exampaperQuestionService;


    @Override
    protected void init(ExamPaper examPaper) {
        examPaper.setProcessDefinitionKey(WfProcessDefinitionKeyEnum.EXAM_PAPER_APPROVE.getCode());
    }

    /**
     * 获取根据题目id试卷列表
     * @param questionId
     * @return
     */
    @GetMapping("/getPapperListByQuestionId")
    public ResponseEntity<Result> getPapperListByQuestionId(String questionId) {
        if(questionId!=null){
            return doSuccess(service.getPapperListByQuestionId(questionId));
        } else {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }

    /**
     * 增加题目
     * @param questionIds
     * @param questionIds
     * @return
     */
    @PostMapping("/addQuestions")
    public ResponseEntity<Result> addQuestions(@NotNull(message = "{papper.id.null}") String papperId,@NotNull(message = "{papper.questions.null}") String questionIds) {
        return doSuccess(exampaperQuestionService.addQuestionsInPapper(papperId,questionIds));
    }

    /**
     * 删除题目
     * @param papperId
     * @param questionIds
     * @return
     */
    @DeleteMapping("/deleteQuestions")
    public ResponseEntity<Result> deleteQuestionsInPapper(@NotNull(message = "{papper.id.null}") String papperId,@NotNull(message = "{papper.questions.null}") String questionIds) {
        return doSuccess(exampaperQuestionService.deleteQuestionsInPapper(papperId,questionIds));
    }
}

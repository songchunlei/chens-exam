package com.chens.exam.wms.controller;

import com.chens.exam.core.entity.wms.QuestionsFolder;
import com.chens.exam.wms.service.IQuestionsFolderService;
import com.chens.folder.vo.controller.AbstractFolderController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 题目文件夹
 *
 * @author songchunlei@qq.com
 * @create 2018/4/9
 */
@Controller
@RequestMapping("/questionsFolderController")
public class QuestionsFolderController extends AbstractFolderController<IQuestionsFolderService,QuestionsFolder> {

}

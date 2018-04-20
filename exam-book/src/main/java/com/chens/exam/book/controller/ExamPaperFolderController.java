package com.chens.exam.book.controller;

import com.chens.exam.core.entity.book.ExamPaperFolder;
import com.chens.exam.book.service.IExamPaperFolderService;
import com.chens.file.vo.controller.AbstractFolderController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 题目文件夹
 *
 * @author songchunlei@qq.com
 * @create 2018/4/9
 */
@Controller
@RequestMapping("/examPaperFolderController")
public class ExamPaperFolderController extends AbstractFolderController<IExamPaperFolderService,ExamPaperFolder> {

}

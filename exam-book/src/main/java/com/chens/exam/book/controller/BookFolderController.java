package com.chens.exam.book.controller;

import com.chens.exam.core.entity.book.BookFolder;
import com.chens.exam.book.service.IBookFolderService;
import com.chens.file.vo.controller.AbstractForderController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 题目文件夹
 *
 * @author songchunlei@qq.com
 * @create 2018/4/9
 */
@Controller
@RequestMapping("/bookFolderController")
public class BookFolderController extends AbstractForderController<IBookFolderService,BookFolder> {

}

package com.chens.exam.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.bpm.controller.BaseWfWebController;
import com.chens.exam.book.service.IBookService;
import com.chens.exam.core.entity.book.Book;
import com.chens.exam.core.enums.WfProcessDefinitionKeyEnum;

/**
 *
 * 练习册 控制器
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Controller
@RequestMapping("/bookController")
public class BookController extends BaseWfWebController<IBookService,Book> {


    @Override
    protected void init(Book book) {
        book.setProcessDefinitionKey(WfProcessDefinitionKeyEnum.BOOK_APPROVE.getCode());
        book.setTaskName(book.getName());
    }

    
}

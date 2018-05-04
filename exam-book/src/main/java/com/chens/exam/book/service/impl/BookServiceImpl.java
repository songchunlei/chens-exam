package com.chens.exam.book.service.impl;

import org.springframework.stereotype.Service;

import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.exam.book.mapper.BookMapper;
import com.chens.exam.book.service.IBookService;
import com.chens.exam.core.entity.book.Book;

/**
 * 
 * 练习册 服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Service
public class BookServiceImpl extends BaseWfServiceImpl<BookMapper, Book> implements IBookService {

    @Override
    public Book saveEntity(Book book) {
        this.insertOrUpdate(book);
        return book;
    }

}

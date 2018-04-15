package com.chens.exam.book.service.impl;

import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.exam.core.entity.book.Book;
import com.chens.exam.book.mapper.BookMapper;
import com.chens.exam.book.service.IBookService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    public boolean beforeSubmit(WorkFlowRequestParam<Book> workFlowRequestParam) {
        return false;
    }

    @Override
    public boolean afterSubmit(WorkFlowRequestParam<Book> workFlowRequestParam) {
        return false;
    }
}

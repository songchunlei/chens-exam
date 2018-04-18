package com.chens.exam.book.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.exam.book.service.IBookSectionQuoteService;
import com.chens.exam.core.entity.book.BookSection;
import com.chens.exam.book.mapper.BookSectionMapper;
import com.chens.exam.book.service.IBookSectionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.exam.core.entity.book.BookSectionQuote;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class BookSectionServiceImpl extends ServiceImpl<BookSectionMapper, BookSection> implements IBookSectionService {

    @Autowired
    private IBookSectionQuoteService bookSectionQuoteService;

    /**
     * 删除书本-资源关联关系
     * @param bookSection
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRelationShip( BookSection bookSection){
        //删除题目资源关联关系
        BookSectionQuote bookSectionQuote = new BookSectionQuote();
        bookSectionQuote.setDataId(bookSection.getId());
        EntityWrapper<BookSectionQuote> qqEw = new EntityWrapper<>(bookSectionQuote);
        return bookSectionQuoteService.delete(qqEw);
    }

    /**
     * 建立书本-资源关联关系
     * @param bookSection
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean buildRelationShip(BookSection bookSection){
        List<BookSectionQuote> bookSectionQuoteList = bookSection.getBookSectionQuoteList();
        if(CollectionUtils.isNotEmpty(bookSectionQuoteList)){
            List<BookSectionQuote> bookSectionQuoteForInsertList = new ArrayList<>();
            for(BookSectionQuote bookSectionQuote : bookSectionQuoteList){
                bookSectionQuote.setDataId(bookSection.getId());
                bookSectionQuoteForInsertList.add(bookSectionQuote);
            }
            bookSectionQuoteService.insertBatch(bookSectionQuoteForInsertList);
        }
        return true;
    }
}

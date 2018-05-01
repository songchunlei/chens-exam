package com.chens.exam.book.service.impl;


import com.chens.exam.core.entity.book.BookShare;
import com.chens.exam.book.mapper.BookShareMapper;
import com.chens.exam.book.service.IBookShareService;
import com.chens.share.vo.service.impl.AbstractShareServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 *  资源服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@Service
public class BookShareServiceImpl extends AbstractShareServiceImpl<BookShareMapper, BookShare> implements IBookShareService {


}

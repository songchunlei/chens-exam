package com.chens.exam.book.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.file.vo.FolderFileInfo;
import com.chens.exam.core.entity.book.Book;
import com.chens.exam.core.entity.book.BookFolder;
import com.chens.exam.book.mapper.BookFolderMapper;
import com.chens.exam.book.service.IBookFolderService;
import com.chens.exam.book.service.IBookService;
import com.chens.file.vo.service.impl.AbstractFolderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *  资源服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@Service
public class BookFolderServiceImpl extends AbstractFolderServiceImpl<BookFolderMapper, BookFolder> implements IBookFolderService {

    @Autowired
    private IBookService bookService;

    @Override
    protected List<FolderFileInfo> getFileInfoListByFolderId(String folderId) {
        List<FolderFileInfo> folderFileInfoList = new ArrayList<>();
        Book book = new Book();
        book.setFolderId(folderId);
        EntityWrapper<Book> bookEntityWrapper = new EntityWrapper<>(book);
        List<Book> bookList = bookService.selectList(bookEntityWrapper);
        for (Book file:bookList)
        {
            folderFileInfoList.add(file.getFolderInfo());
        }
        return folderFileInfoList;
    }
}

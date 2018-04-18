package com.chens.exam.book.service;

import com.chens.exam.core.entity.book.BookSection;
import com.baomidou.mybatisplus.service.IService;

/**
 *
 *  服务接口
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
public interface IBookSectionService extends IService<BookSection> {
    /**
     * 删除书本-资源关联关系
     * @param bookSection
     */
    boolean deleteRelationShip(BookSection bookSection);


    /**
     * 建立书本-资源关联关系
     * @param bookSection
     */
    boolean buildRelationShip(BookSection bookSection);
}

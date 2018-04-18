package com.chens.exam.book.service;

import com.chens.exam.core.entity.book.CourseSection;
import com.baomidou.mybatisplus.service.IService;

/**
 *
 *  服务接口
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
public interface ICourseSectionService extends IService<CourseSection> {


    /**
     * 删除课程-资源关联关系
     * @param courseSection
     */
    boolean deleteRelationShip(CourseSection courseSection);


    /**
     * 建立课程-资源关联关系
     * @param courseSection
     */
    boolean buildRelationShip(CourseSection courseSection);
}

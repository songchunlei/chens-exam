package com.chens.exam.book.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.exam.book.service.ICourseSectionQuoteService;
import com.chens.exam.core.entity.book.CourseSection;
import com.chens.exam.book.mapper.CourseSectionMapper;
import com.chens.exam.book.service.ICourseSectionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.exam.core.entity.book.CourseSectionQuote;
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
public class CourseSectionServiceImpl extends ServiceImpl<CourseSectionMapper, CourseSection> implements ICourseSectionService {
    @Autowired
    private ICourseSectionQuoteService courseSectionQuoteService;

    /**
     * 删除课程-资源关联关系
     * @param courseSection
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteRelationShip(CourseSection courseSection){
        //删除题目资源关联关系
        CourseSectionQuote courseSectionQuote = new CourseSectionQuote();
        courseSectionQuote.setDataId(courseSection.getId());
        EntityWrapper<CourseSectionQuote> qqEw = new EntityWrapper<>(courseSectionQuote);
        return courseSectionQuoteService.delete(qqEw);
    }

    /**
     * 建立课程-资源关联关系
     * @param courseSection
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean buildRelationShip(CourseSection courseSection){
        List<CourseSectionQuote> courseSectionQuoteList = courseSection.getCourseSectionQuoteList();
        if(CollectionUtils.isNotEmpty(courseSectionQuoteList)){
            List<CourseSectionQuote> courseSectionQuoteForInsertList = new ArrayList<>();
            for(CourseSectionQuote courseSectionQuote : courseSectionQuoteList){
                courseSectionQuote.setDataId(courseSection.getId());
                courseSectionQuoteForInsertList.add(courseSectionQuote);
            }
            courseSectionQuoteService.insertBatch(courseSectionQuoteForInsertList);
        }
        return true;
    }
}

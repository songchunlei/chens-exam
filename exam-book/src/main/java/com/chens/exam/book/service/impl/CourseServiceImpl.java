package com.chens.exam.book.service.impl;

import org.springframework.stereotype.Service;

import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.exam.book.mapper.CourseMapper;
import com.chens.exam.book.service.ICourseService;
import com.chens.exam.core.entity.book.Course;

/**
 * 
 * 练习册 服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Service
public class CourseServiceImpl extends BaseWfServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public Course saveEntity(Course course) {
        this.insertOrUpdate(course);
        return course;
    }
}

package com.chens.exam.book.service.impl;

import com.chens.bpm.service.impl.BaseWfServiceImpl;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.exam.core.entity.book.Course;
import com.chens.exam.book.mapper.CourseMapper;
import com.chens.exam.book.service.ICourseService;
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
public class CourseServiceImpl extends BaseWfServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public Course saveEntity(Course course) {
        this.insertOrUpdate(course);
        return course;
    }

    @Override
    public boolean beforeSubmit(WorkFlowRequestParam<Course> workFlowRequestParam) {
        return false;
    }

    @Override
    public boolean afterSubmit(WorkFlowRequestParam<Course> workFlowRequestParam) {
        return false;
    }
}

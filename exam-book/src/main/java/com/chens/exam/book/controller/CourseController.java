package com.chens.exam.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.bpm.controller.BaseWfWebController;
import com.chens.exam.book.service.ICourseService;
import com.chens.exam.core.entity.book.Course;
import com.chens.exam.core.enums.WfProcessDefinitionKeyEnum;

/**
 *
 * 课程 控制器
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Controller
@RequestMapping("/courseController")
public class CourseController extends BaseWfWebController<ICourseService,Course> {


    @Override
    protected void init(Course course) {
        course.setProcessDefinitionKey(WfProcessDefinitionKeyEnum.COURSE_APPROVE.getCode());
        course.setTaskName(course.getName());
    }
}

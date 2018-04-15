package com.chens.exam.book.controller;

import com.chens.bpm.controller.BaseWfWebController;
import com.chens.exam.core.enums.WfProcessDefinitionKeyEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.chens.core.web.BaseController;
import com.chens.exam.book.service.ICourseService;
import com.chens.exam.core.entity.book.Course;


import com.chens.core.web.BaseWebController;

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
    }
}

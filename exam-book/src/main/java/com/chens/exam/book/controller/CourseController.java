package com.chens.exam.book.controller;

import com.chens.core.constants.CommonConstants;
import com.chens.core.context.BaseContextHandler;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.exam.core.enums.ExamDataTypeEnum;
import com.chens.share.vo.AbstractShare;
import com.chens.share.vo.service.IAbstractShareService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.bpm.controller.BaseWfWebController;
import com.chens.exam.book.service.ICourseService;
import com.chens.exam.core.entity.book.Course;
import com.chens.exam.core.enums.WfProcessDefinitionKeyEnum;

import java.util.Date;

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

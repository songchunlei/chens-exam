package com.chens.exam.wms.controller;

import com.chens.exam.core.entity.wms.CourseTag;
import com.chens.exam.wms.service.ICourseTagService;
import com.chens.exam.wms.vo.controller.AbstractTagController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 课程标签控制器
 *
 * @author songchunlei@qq.com
 * @create 2018/4/3
 */
@Controller
@RequestMapping("/courseTagController")
public class CourseTagController extends AbstractTagController<ICourseTagService,CourseTag> {


}

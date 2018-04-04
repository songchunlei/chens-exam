package com.chens.exam.book.controller;

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
 * 练习册 控制器
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Controller
@RequestMapping("/courseController")
public class CourseController extends BaseWebController<ICourseService,Course> {


}

package com.chens.exam.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.chens.core.web.BaseController;
import com.chens.exam.book.service.ICourseSectionService;
import com.chens.exam.core.entity.book.CourseSection;


import com.chens.core.web.BaseWebController;

/**
 *
 *  控制器
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Controller
@RequestMapping("/courseSectionController")
public class CourseSectionController extends BaseWebController<ICourseSectionService,CourseSection> {


}

package com.chens.exam.wms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.core.web.BaseWebController;
import com.chens.exam.core.entity.wms.TagClass;
import com.chens.exam.wms.service.ITagClassService;

/**
 *
 *  控制器
 *
 * @author chunlei.song@live.com
 * @create 2018-04-10
 */
@Controller
@RequestMapping("/tagClassController")
public class TagClassController extends BaseWebController<ITagClassService,TagClass> {


}

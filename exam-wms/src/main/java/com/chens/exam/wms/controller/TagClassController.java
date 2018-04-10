package com.chens.exam.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import com.chens.core.web.BaseController;
import com.chens.exam.wms.service.ITagClassService;
import com.chens.exam.core.entity.wms.TagClass;


import com.chens.core.web.BaseWebController;

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

package com.chens.exam.wms.controller;

import com.chens.exam.core.entity.wms.Tag;
import com.chens.exam.wms.service.ITagService;
import com.chens.exam.wms.vo.controller.AbstractTagController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资源标签控制器
 *
 * @author songchunlei@qq.com
 * @create 2018/4/3
 */
@Controller
@RequestMapping("/tagController")
public class TagController extends AbstractTagController<ITagService,Tag> {


}

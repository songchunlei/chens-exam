package com.chens.exam.wms.controller;

import com.chens.exam.core.entity.wms.SourceTag;
import com.chens.exam.wms.vo.controller.AbstractTagController;
import com.chens.exam.wms.service.ISourceTagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资源标签控制器
 *
 * @auther songchunlei@qq.com
 * @create 2018/4/3
 */
@Controller
@RequestMapping("/sourceTagController")
public class SourceTagController extends AbstractTagController<ISourceTagService,SourceTag> {


}

package com.chens.exam.wms.controller;

import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.core.entity.wms.SourceForder;
import com.chens.exam.wms.service.ISourceForderService;
import com.chens.exam.wms.vo.controller.AbstractForderController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资源文件夹
 *
 * @auther songchunlei@qq.com
 * @create 2018/4/9
 */
@Controller
@RequestMapping("/sourceForderController")
public class SourceForderController extends AbstractForderController<Source,ISourceForderService,SourceForder> {

}

package com.chens.exam.wms.controller;

import com.chens.exam.core.entity.wms.SourceFolder;
import com.chens.exam.wms.service.ISourceForderService;
import com.chens.exam.wms.vo.controller.AbstractForderController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资源文件夹
 *
 * @author songchunlei@qq.com
 * @create 2018/4/9
 */
@Controller
@RequestMapping("/sourceFolderController")
public class SourceFolderController extends AbstractForderController<ISourceForderService,SourceFolder> {

}

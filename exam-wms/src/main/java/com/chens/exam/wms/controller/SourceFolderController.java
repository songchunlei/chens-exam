package com.chens.exam.wms.controller;

import com.chens.exam.core.entity.wms.SourceFolder;
import com.chens.exam.wms.service.ISourceFolderService;
import com.chens.folder.vo.controller.AbstractFolderController;
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
public class SourceFolderController extends AbstractFolderController<ISourceFolderService,SourceFolder> {

}

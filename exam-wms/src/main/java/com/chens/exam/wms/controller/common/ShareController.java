package com.chens.exam.wms.controller.common;

import com.chens.core.constants.CommonConstants;
import com.chens.core.vo.Result;
import com.chens.exam.core.config.WebConfig;
import com.chens.exam.wms.service.ISourceService;
import com.chens.share.controller.AbstractShareController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 二维码生成器
 *
 * @author songchunlei@qq.com
 * @create 2018/4/28
 */
@Controller
@RequestMapping("/shareController")
public class ShareController extends AbstractShareController {

    @Autowired
    private ISourceService sourceService;

    @GetMapping("/source/{id}")
    public ResponseEntity<Result> url(@PathVariable("id") String id) {
        return doSuccess(CommonConstants.QUERY_SUCCESS,sourceService.getShareURL(id));
    }




}

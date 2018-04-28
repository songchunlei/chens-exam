package com.chens.exam.wms.controller.common;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.coder.BaseQRController;
import com.chens.coder.exception.CoderExceptionEnum;
import com.chens.core.constants.CommonConstants;
import com.chens.core.exception.FileException;
import com.chens.core.vo.Result;
import com.chens.exam.wms.service.ISourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * 二维码生成器
 *
 * @author songchunlei@qq.com
 * @create 2018/4/28
 */
@Controller
@RequestMapping("/coderController")
public class CoderController extends BaseQRController {

    @Autowired
    private ISourceService sourceService;

    @GetMapping("/sourceQRCode/{id}")
    public ResponseEntity<Result> url(@PathVariable("id") String id) {
        return doSuccess(CommonConstants.QUERY_SUCCESS,sourceService.getShareURL(id));
    }



}

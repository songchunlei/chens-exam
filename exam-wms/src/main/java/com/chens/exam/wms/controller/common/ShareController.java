package com.chens.exam.wms.controller.common;

import com.chens.auth.client.annotation.IgnoreUserToken;
import com.chens.core.constants.CommonConstants;
import com.chens.core.vo.Result;
import com.chens.core.web.BaseController;
import com.chens.exam.wms.service.ISourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 二维码生成器
 *
 * @author songchunlei@qq.com
 * @create 2018/4/28
 */
@Controller
@RequestMapping("/shareController")
public class ShareController extends BaseController {

    @Autowired
    private ISourceService sourceService;

    @IgnoreUserToken
    @GetMapping("/share")
    public ResponseEntity<Result> url(@RequestParam("id") String id) {
        return doSuccess(CommonConstants.QUERY_SUCCESS,sourceService.getShareURL(id));
    }


}

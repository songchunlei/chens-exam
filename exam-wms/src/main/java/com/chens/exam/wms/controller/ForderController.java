package com.chens.exam.wms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chens.core.vo.Result;
import com.chens.core.web.BaseWebController;
import com.chens.exam.core.entity.wms.Forder;
import com.chens.exam.wms.service.IForderService;

/**
 * 文件夹
 *
 * @auther songchunlei@qq.com
 * @create 2018/3/22
 */
@Controller
@RequestMapping("/forderController")
public class ForderController extends BaseWebController<IForderService,Forder> {

    @GetMapping("/loadForderTree")
    public ResponseEntity<Result> loadForderTree(Forder forder) {
    	//同一租户下的资源可见	
   // 	forder.setTenantId(BaseContextHandler.getTenantId());
    	forder.setTenantId("1");//暂时写死
        return doSuccess(service.loadForderTree(forder));
    }

}

package com.chens.exam.wms.vo.controller;

import com.chens.core.constants.CommonConstants;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.core.web.BaseWebController;
import com.chens.exam.core.vo.AbstractForder;
import com.chens.exam.wms.vo.service.IForderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 文件标签控制器
 * @auther songchunlei@qq.com
 * @create 2018/4/3
 */
public abstract class AbstractForderController<S extends IForderService<T>, T extends AbstractForder<T>> extends BaseWebController<S,T> {

    /**
     * 根据id获取实体对象
     * @param id
     * @return
     */
    @Override
    @GetMapping("/info/{id}")
    public ResponseEntity<Result> getInfo(@PathVariable String id) {
        if(id!=null)
        {
            return doSuccess(CommonConstants.QUERY_SUCCESS,service.selectForderById(id));
        }
        else{
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }
}

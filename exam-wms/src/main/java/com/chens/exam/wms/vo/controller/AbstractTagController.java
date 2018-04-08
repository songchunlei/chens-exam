package com.chens.exam.wms.vo.controller;

import com.chens.core.vo.Result;
import com.chens.core.web.BaseWebController;
import com.chens.exam.core.vo.Tag;
import com.chens.exam.wms.vo.service.ITagService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 抽象标签控制器
 * 暂时没有通用的方法，待后续完善
 * @auther songchunlei@qq.com
 * @create 2018/4/3
 */
public abstract class AbstractTagController<S extends ITagService<T>, T extends Tag<T>> extends BaseWebController<S,T> {

    /**
     * 新增标签
     * @param t
     * @return
     */
    @PostMapping("/createTag")
    public ResponseEntity<Result> createTag(@RequestBody @Validated T t) {
        return this.create(t);
    }

}

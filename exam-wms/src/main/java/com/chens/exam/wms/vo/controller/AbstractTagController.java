package com.chens.exam.wms.vo.controller;

import com.chens.core.web.BaseWebController;
import com.chens.exam.core.vo.AbstractTag;
import com.chens.exam.wms.vo.service.IAbstractTagService;

/**
 * 抽象标签控制器
 * @auther songchunlei@qq.com
 * @create 2018/4/3
 */
public abstract class AbstractTagController<S extends IAbstractTagService<T>, T extends AbstractTag<T>> extends BaseWebController<S,T> {


}

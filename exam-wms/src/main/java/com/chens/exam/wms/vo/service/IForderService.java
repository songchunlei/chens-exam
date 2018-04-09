package com.chens.exam.wms.vo.service;

import com.baomidou.mybatisplus.service.IService;
import com.chens.exam.core.vo.AbstractForder;


/**
 * <p>
 * 文件夹表 服务类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public interface IForderService<T extends AbstractForder<T>> extends IService<T> {

    T selectForderById(String id);
}

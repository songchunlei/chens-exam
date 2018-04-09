package com.chens.exam.wms.vo.service;

import com.baomidou.mybatisplus.service.IService;
import com.chens.exam.core.vo.Forder;

import java.io.Serializable;


/**
 * <p>
 * 文件夹表 服务类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public interface IForderService<File,T extends Forder<File,T>> extends IService<T> {

    T selectForderById(String id);
}

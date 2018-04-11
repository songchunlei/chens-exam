package com.chens.exam.wms.vo.service;

import com.baomidou.mybatisplus.service.IService;
import com.chens.core.vo.FolderFileInfo;
import com.chens.exam.core.vo.AbstractFolder;


/**
 * <p>
 * 文件夹表 服务类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public interface IAbstractFolderService<T extends AbstractFolder<T>> extends IService<T> {

    FolderFileInfo selectForderById(String id);
}
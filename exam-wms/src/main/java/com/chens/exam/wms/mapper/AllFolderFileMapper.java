package com.chens.exam.wms.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.chens.file.vo.FolderFileInfo;

/**
 * 所有文件夹/文件
 *
 * @author songchunlei@qq.com
 * @create 2018/4/22
 */
public interface AllFolderFileMapper {

    Page<FolderFileInfo> QueryAll(Page<FolderFileInfo> page,FolderFileInfo folderFileInfo);
}

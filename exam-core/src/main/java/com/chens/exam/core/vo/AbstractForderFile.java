package com.chens.exam.core.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.chens.bpm.vo.WfBaseEntity;

/**
 * 文件夹下的文件
 *
 * @auther songchunlei@qq.com
 * @create 2018/4/9
 */
public abstract class AbstractForderFile<T extends AbstractForderFile> extends WfBaseEntity<T> {
    /**
     * 文件夹id
     */
    @TableField("forder_id")
    private String forderId;



}

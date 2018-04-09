package com.chens.exam.core.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件夹下文件信息
 *
 * @auther songchunlei@qq.com
 * @create 2018/4/9
 */
public class ForderInfo implements Serializable{
    private String id;
    private String name;
    private Date updateTime;

    public ForderInfo() {
    }

    public ForderInfo(String id, String name, Date updateTime) {
        this.id = id;
        this.name = name;
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

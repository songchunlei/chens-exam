package com.chens.exam.wms.exception;

import com.chens.core.enums.IBaseEnum;

/**
 * 错误异常枚举
 * Created by songchunlei on 2018/3/8.
 */
public enum WmsExceptionEnum implements IBaseEnum {



    FILE_PARENT_ID_IS_NULL(5001,"父文件夹id为空");


    private Integer code;

    private String message;

    WmsExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }


}

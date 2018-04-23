package com.chens.exam.core.enums;

import com.chens.file.enums.IBaseFolderTypeEnum;

/**
 * 文件类型
 *
 * @author songchunlei@qq.com
 * @create 2018/4/15
 */
public enum ExamFileTypeEnum implements IBaseFolderTypeEnum {

    SOURCE("资源","SOURCE"),
    QUESTIONS("题目","QUESTIONS"),
    EXAM_PAPER("试卷","EXAM_PAPER"),
    COURSE("课程","COURSE"),
    BOOK("书本","BOOK");

    private String display;
    private String code;

    private ExamFileTypeEnum(String display, String code) {
        this.display = display;
        this.code = code;

    }

    @Override
    public String getDisplay() {
        return display;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package com.chens.exam.core.enums;

/**
 * 文件类型
 *
 * @author songchunlei@qq.com
 * @create 2018/4/15
 */
public enum ExamFileTypeEnum  {

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

    public String getDisplay() {
        return display;
    }

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

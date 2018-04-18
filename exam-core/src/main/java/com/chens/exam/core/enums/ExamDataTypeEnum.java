package com.chens.exam.core.enums;

/**
 * 数据类型(主要用于分享，文件关联等业务场景)
 *
 * @author songchunlei@qq.com
 * @create 2018/4/15
 */
public enum ExamDataTypeEnum {

    SOURCE("资源","SOURCE"),
    QUESTIONS("题目","QUESTIONS"),
    QUESTIONS_OPTION("题目选项","QUESTIONS_OPTION"),
    EXAM_PAPER("试卷","EXAM_PAPER"),
    COURSE("课程","COURSE"),
    COURSE_SECTION("课程章节","COURSE_SECTION"),
    BOOK("书本","BOOK"),
    BOOK_SECTION("书本章节","BOOK_SECTION");

    private String display;
    private String code;

    private ExamDataTypeEnum(String display, String code) {
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

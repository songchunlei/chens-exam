package com.chens.exam.core.enums;

/**
 * 标签类型
 * @auther songchunlei
 * @create 2018/4/1
 */
public enum TagTypeEnum {
    SOURCE("素材", "SOURCE"),
    QUESTIONS("题目","QUESTIONS"),
    EXAM("试卷","EXAM"),
    COURSE("课程","COURSE"),
    BOOK("书本","BOOK");

    private String display;
    private String code;

    private TagTypeEnum(String display, String code) {
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

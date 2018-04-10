package com.chens.exam.core.enums;

/**
 * exam枚举
 *
 * @auther songchunlei@qq.com
 * @create 2018/4/3
 */
public enum  WfProcessDefinitionKeyEnum {

    SOURCE_APPROVE("资源审批流程","SOURCE_APPROVE"),
    QUESTION_APPROVE("题目审批流程","QUESTION_APPROVE"),
    EXAM_PAPER_APPROVE("试卷审批流程","EXAM_PAPER_APPROVE"),
    COURSE_APPROVE("课程审批流程","COURSE_APPROVE"),
    BOOK_APPROVE("书本审批流程","BOOK_APPROVE");

    private String display;
    private String code;

    private WfProcessDefinitionKeyEnum(String display, String code) {
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

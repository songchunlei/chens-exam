package com.chens.exam.core.entity.book;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.core.vo.BaseEntity;

/**
 *
 *  实体
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@TableName("t_course_section")
public class CourseSection extends BaseEntity<CourseSection> {

    private static final long serialVersionUID = 1L;

    /**
     * 章节名称
     */
	private String name;
    /**
     * 书本id
     */
	@TableField("course_id")
	private String courseId;

	/**
	 * 课程章节-资源关系
	 */
	@TableField(exist = false)
	private List<CourseSectionQuote> courseSectionQuoteList;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public List<CourseSectionQuote> getCourseSectionQuoteList() {
		return courseSectionQuoteList;
	}

	public void setCourseSectionQuoteList(List<CourseSectionQuote> courseSectionQuoteList) {
		this.courseSectionQuoteList = courseSectionQuoteList;
	}
}

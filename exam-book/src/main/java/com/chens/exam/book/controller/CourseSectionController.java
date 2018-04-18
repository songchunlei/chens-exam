package com.chens.exam.book.controller;

import com.chens.core.annotation.InsertValid;
import com.chens.core.constants.CommonConstants;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.chens.core.web.BaseController;
import com.chens.exam.book.service.ICourseSectionService;
import com.chens.exam.core.entity.book.CourseSection;


import com.chens.core.web.BaseWebController;

/**
 *
 *  控制器
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Controller
@RequestMapping("/courseSectionController")
public class CourseSectionController extends BaseWebController<ICourseSectionService,CourseSection> {

    /**
     * 删除课程章节-资源关系
     * @param courseSection
     * @return
     */
    @DeleteMapping("/deleteRelationShip")
    public ResponseEntity<Result> deleteRelationShip(@RequestBody CourseSection courseSection) {
        if(courseSection != null){
            return doSuccess(CommonConstants.DELETE_SUCCESS,service.deleteRelationShip(courseSection));
        } else {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }

    /**
     * 保存课程章节-资源关系
     * @param courseSection
     * @return
     */
    @PostMapping("/buildRelationShip")
    public ResponseEntity<Result> buildRelationShip(@RequestBody CourseSection courseSection) {
        if(courseSection != null){
            return doSuccess(CommonConstants.SAVE_SUCCESS,service.buildRelationShip(courseSection));
        } else {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }
}

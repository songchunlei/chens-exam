package com.chens.exam.book.controller;

import com.chens.core.constants.CommonConstants;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.core.web.BaseWebController;
import com.chens.exam.book.service.IBookSectionService;
import com.chens.exam.book.service.ICourseSectionService;
import com.chens.exam.core.entity.book.BookSection;
import com.chens.exam.core.entity.book.CourseSection;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *  控制器
 *
 * @author chunlei.song@live.com
 * @create 2018-04-04
 */
@Controller
@RequestMapping("/bookSectionController")
public class BookSectionController extends BaseWebController<IBookSectionService,BookSection> {

    /**
     * 删除书本章节-资源关系
     * @param bookSection
     * @return
     */
    @DeleteMapping("/deleteRelationShip")
    public ResponseEntity<Result> deleteRelationShip(@RequestBody BookSection bookSection) {
        if(bookSection != null){
            return doSuccess(CommonConstants.DELETE_SUCCESS,service.deleteRelationShip(bookSection));
        } else {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }

    /**
     * 保存书本章节-资源关系
     * @param bookSection
     * @return
     */
    @PostMapping("/buildRelationShip")
    public ResponseEntity<Result> buildRelationShip(@RequestBody BookSection bookSection) {
        if(bookSection != null){
            return doSuccess(CommonConstants.SAVE_SUCCESS,service.buildRelationShip(bookSection));
        } else {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }
}

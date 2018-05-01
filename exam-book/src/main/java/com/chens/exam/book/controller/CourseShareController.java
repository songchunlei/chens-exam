package com.chens.exam.book.controller;

import com.chens.exam.book.service.ICourseShareService;
import com.chens.exam.core.config.WebConfig;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.entity.book.CourseShare;
import com.chens.share.vo.controller.AbstractShareController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 题目文件夹
 *
 * @author songchunlei@qq.com
 * @create 2018/4/9
 */
@Controller
@RequestMapping("/courseShareController")
public class CourseShareController extends AbstractShareController<ICourseShareService,CourseShare> {

    @Autowired
    private WebConfig webConfig;

    @Override
    protected String getRootURL() {
        return webConfig.getWmsurl()+ExamConstants.SHARE_ROOT_URL;
    }

    @Override
    protected String getQRSavePath() {
        return ExamConstants.SAVE_QR_CODER_PATH;
    }
}

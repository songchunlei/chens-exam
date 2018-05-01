package com.chens.exam.wms.controller;

import com.chens.exam.core.config.WebConfig;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.entity.wms.SourceShare;
import com.chens.exam.wms.service.ISourceShareService;
import com.chens.share.vo.controller.AbstractShareController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资源分享
 *
 * @author songchunlei@qq.com
 * @create 2018/4/9
 */
@Controller
@RequestMapping("/sourceShareController")
public class SourceShareController extends AbstractShareController<ISourceShareService,SourceShare> {

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

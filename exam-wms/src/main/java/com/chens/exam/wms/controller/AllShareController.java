package com.chens.exam.wms.controller;

import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.QueryPageEntity;
import com.chens.core.vo.Result;
import com.chens.exam.core.config.WebConfig;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.entity.wms.AllShare;
import com.chens.exam.wms.service.IAllShareService;
import com.chens.share.vo.controller.AbstractShareController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 资源分享
 *
 * @author songchunlei@qq.com
 * @create 2018/4/9
 */
@Controller
@RequestMapping("/allShareController")
public class AllShareController extends AbstractShareController<IAllShareService,AllShare> {

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

    /**
     * 只查自己的分享
     * @param spage
     * @return
     */
    @PostMapping("/pagelist")
    @Override
    public ResponseEntity<Result> pagelist(@RequestBody QueryPageEntity<AllShare> spage) {
        if(spage!=null)
        {
            spage.getPage().setMy(true);
            return super.pagelist(spage);
        }
        else
        {
            throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
        }
    }
}

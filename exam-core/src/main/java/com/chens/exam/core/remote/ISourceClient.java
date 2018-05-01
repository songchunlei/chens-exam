package com.chens.exam.core.remote;


import com.chens.core.vo.AuthRequest;
import com.chens.core.vo.UserInfo;
import com.chens.exam.core.constants.ExamConstants;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 用户查询接口
 *
 * @author songchunlei@qq.com
 * @create 2018/3/8
 */
@FeignClient(path = ExamConstants.SOURCE_RPC,value = ExamConstants.EXAM_WMS_SERVER_NAME)
public interface ISourceClient {

    /**
     * 根据请求串获取账户
     * @param authRequest
     * @return
     */
    @RequestMapping(value="/getSourceList",method = RequestMethod.POST)
    UserInfo findByUsername(@RequestBody AuthRequest authRequest);

    /**
     * 根据用户id获取账户
     * @param id
     * @return
     */
    @RequestMapping(value="/getSourceById",method = RequestMethod.GET)
    UserInfo findByUserId(String id);
}

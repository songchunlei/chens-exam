package com.chens.exam.filters;

import com.alibaba.fastjson.JSONObject;
import com.chens.auth.client.jwt.IJwtInfo;
import com.chens.auth.client.jwt.JwtTokenProvider;
import com.chens.auth.client.util.UserAuthUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Token鉴权
 *
 * @auther songchunlei@qq.com
 * @create 2018/3/22
 */
@Component
public class TokenValidateFilter extends ZuulFilter {

    // token工具
    private UserAuthUtil userAuthUtil;

    @Override
    public String filterType() {
        // pre 在发起请求之前会执行这个filter
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 这个是执行顺序，因为同一个类型的filter可能有多个。 值越小越靠前
        return 6;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        // zuul中，将当前请求的上下文信息存在线程变量中。取出来
        RequestContext ctx = RequestContext.getCurrentContext();
        // 从上下文中获取httprequest对象
        HttpServletRequest request = ctx.getRequest();
        // 从头部信息中获取Authentication的值，也就是我们的token
        String token = userAuthUtil.getJwtTokenProvider().getToken(request);
        if(token == null) {
            forbidden();
            return null;
        }
        // 检验token是否正确
        // 这里只是通过使用key对token进行解码是否成功，并没有对有效期、已经token里面的内容进行校验。
        IJwtInfo jwtInfo = null;
        try {
            jwtInfo = userAuthUtil.getUserInfo(token);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (jwtInfo == null) {
            forbidden();
            return null;
        }

        return null;
    }

    // 设置response的状态码为403
    void forbidden() {
        // zuul中，将请求附带的信息存在线程变量中。
        RequestContext.getCurrentContext().setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        ReflectionUtils.rethrowRuntimeException(new ZuulException("无访问权限", HttpStatus.FORBIDDEN.value(), "token校验不通过"));
    }
}

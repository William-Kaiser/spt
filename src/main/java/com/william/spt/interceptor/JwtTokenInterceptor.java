package com.william.spt.interceptor;


import io.jsonwebtoken.SignatureException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 生成jwt的拦截器
 */
public class JwtTokenInterceptor implements HandlerInterceptor {
    /**
     * 请求之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //自动排除生成token的路径,并且如果是options请求是cors跨域预请求，设置allow对应头信息
        if(request.getRequestURI().equals("/token") || RequestMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }

        //其他请求获取头信息
        final String authHeader = request.getHeader("token");
        try {
            //如果没有header信息
            if (authHeader == null || authHeader.trim() == "") {
                throw new SignatureException("not found token.");
            }
        } catch (Exception e) {
            PrintWriter writer = response.getWriter();
            writer.write(e.getMessage());
            writer.close();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

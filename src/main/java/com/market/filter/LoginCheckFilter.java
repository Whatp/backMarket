//package com.market.filter;
//
//import cn.hutool.http.server.HttpServerRequest;
//import cn.hutool.jwt.JWTUtil;
//import com.alibaba.fastjson.JSONObject;
//import com.market.common.Result;
//import jakarta.servlet.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//public class LoginCheckFilter implements Filter {
//
//    /**
//     * 登录校验的逻辑，相对复杂
//     * @param servletRequest
//     * @param servletResponse
//     * @param filterChain
//     * @throws IOException
//     * @throws ServletException
//     */
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
////        强转
//        HttpServerRequest req = (HttpServerRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
////        1.获取请求的URL
//        String url = req.getURI().toString();
//        log.info("请求的URL：{}",url);
//
////        2.判断请求URL是否包含login，如果包含，说明是登录操作，放行
//        if(url.contains("login")) {
//            log.info("登录操作，直接放行");
//            filterChain.doFilter(servletRequest,servletResponse);
//            return;
//        }
//
////        3.获取请求头中的令牌
//        String jwt = req.getHeader("token");
//
////        4.判断令牌是否存在，如果不存在，返回错误结果
//        if(!StringUtils.hasLength(jwt)) {
//            log.info("请求头token为空，返回未登录的信息");
//            Result error = Result.error("NOT LOGIN");
//            // 手动转换为json ，阿里的fastjson
//            String notLOGIN = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLOGIN);
//            return;
//        }
//
////        5.解析token，如果解析失败，返回错误结果
//        try {
//            JWTUtil.parseToken(jwt);
//        }catch (Exception e) {
//            e.printStackTrace();
//            log.info("解析令牌失败，返回");
//            Result error = Result.error("NOT LOGIN");
//            // 手动转换为json
//            String notLOGIN = JSONObject.toJSONString(error);
//            resp.getWriter().write(notLOGIN);
//            return;
//        }
//
////        6.放行
//        log.info("令牌合法，放行");
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//}

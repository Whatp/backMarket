//package com.market.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//
//import java.io.IOException;
//
///**
// * 过滤器的一个demo
// */
//
//@WebFilter(urlPatterns = "/*")
//public class DemoFilter implements Filter{
//
//
//    @Override   //初始化的方法，只调用一次
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("初始化方法被调用");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("拦截到了请求");
//        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("放行啦");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("销毁方法被调用");
//    }
//}

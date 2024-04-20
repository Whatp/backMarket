package com.market.common;

import java.lang.annotation.*;

/**
 * 自定义注解，对应JwtInterceptor中的  “如果不是映射到方法直接通过”，  在想要放行的方法上面加上
 * 自定义注解，就可以放该方法。
 * JwtInterceptor加上下面的代码
 * // 如果不是映射到方法直接通过
 *         if (handler instanceof HandlerMethod) {
 *             AuthAccess annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthAccess.class);
 *             if (annotation != null) {
 *                 return true;
 *             }
 *         }
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthAccess {
}

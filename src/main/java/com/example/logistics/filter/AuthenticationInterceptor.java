package com.example.logistics.filter;

import com.example.logistics.annotation.LoginRequired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author hexiaobo
 * @title: AuthenticationInterceptor
 * @projectName csa-biz-service
 * @description: AuthenticationInterceptor
 * @date 2019/5/9 15:05
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        //校验是否登录
//        if (methodAnnotation != null) {
//            String token = request.getHeader(Constant.CSA_TOKEN);
//            if (StringUtils.isBlank(token)) {
//                throw new BusinessException(CsaBizResponseCode.NO_LOGIN);
//            }
//            UserTokenService userTokenService = (UserTokenService) SpringUtil.getApplicationContext().getBean("userTokenServiceImpl");
//            UserToken userToken = userTokenService.queryTokenInfo(token);
//            if (Objects.isNull(userToken)) {
//                throw new BusinessException(CsaBizResponseCode.NO_LOGIN);
//            }
//            return true;
//        }
        return true;
    }
}
package com.example.logistics.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 *
 * @Auther: hexiaobo
 * @Date: 2018/12/13 15:13
 * @Description: WebConfiguration
 */
@Configuration
public class WebConfiguration {
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
    class MyFilter implements Filter{

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("filter init");
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("current Time"+System.currentTimeMillis());
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {
            System.out.println("filer destory");
        }
    }
}

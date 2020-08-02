package com.example.jp.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@Order(2)
public class ApiSecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Do something ...
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Do something: Check authentication, authorization, ...
        String header = request.getHeader("accessToken");
        // ...

        log.info("++++++++++++++++++++ ApiSecondFilter.doFilter() ++++++++++++++++++++");

        //call next filter in the filter chain
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Do something ...
    }
}

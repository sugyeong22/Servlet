package com.sudal.common;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

// 해당 필터를 거쳐갈 서블릿에 대한 url path 패턴 적용
// /servlet 시작하는 url mapping된 서블릿만 적용
//@WebFilter("/servlet/**") // 서블릿으로 시작하고 그 이후는 상관 없다.

// 모든 servlet이 거쳐가게하기
@WebFilter("/*")
public class EncodingFilter implements Filter {

    // 공통적으로 처리되는 항목을 처리함
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 공통으로 처리될 항목
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        chain.doFilter(request, response);
    }
}

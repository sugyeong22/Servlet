package com.sudal._01_servlet.ex;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex01Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 현재 날짜 시간을 보여주는 페이지

        // 결과에 대한 정보 설정
        // Response Headder
        // Character set : utf-8
        response.setCharacterEncoding("utf-8");
        // 전달되는 데이터의 타입 (content type)
        // MIME : 데이터의 타입을 구분하기 위한 정해진 문자열 규격
        response.setContentType("text/plain");

        // 결과물
        // Response Bady
        PrintWriter out = response.getWriter();

        // 현재 날짜 시간 관리 객체
        Date date = new Date();

        out.println(date);

        // Date 객체의 날짜 시간 정보를 원하는 규격의 문자열로 만들기
        // 2025년 08월 6일 8:42:11
        // H : 24시 표현
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy년 MM월 d일 h:m:s");
        String dateTimeString = formatter.format(date);

        out.println(dateTimeString);

    }

}

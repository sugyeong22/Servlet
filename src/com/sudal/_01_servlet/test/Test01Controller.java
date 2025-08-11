package com.sudal._01_servlet.test;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        Date date = new Date();
        out.println(date);

        //오늘의 날짜는 2021년 5월 20일
        SimpleDateFormat formatter = new SimpleDateFormat("오늘의 날짜는 yyyy년 M월 dd일");
        String dateString = formatter.format(date);
        out.println(dateString);
    }

}

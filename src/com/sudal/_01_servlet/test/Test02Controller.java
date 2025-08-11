package com.sudal._01_servlet.test;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Test02Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse responce) throws IOException {
        responce.setCharacterEncoding("utf-8");
        responce.setContentType("text/plane");

        PrintWriter out = responce.getWriter();

        Date date = new Date();
        out.println(date);

        //현재 시간은 14시 52분 43초 입니다.
        SimpleDateFormat formatter = new SimpleDateFormat("현재 시간은 HH시 mm분 ss초 입니다.");
        String timeString = formatter.format(date);
        out.println(timeString);

    }
}

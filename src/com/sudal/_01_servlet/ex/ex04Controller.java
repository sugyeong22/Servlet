package com.sudal._01_servlet.ex;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet/ex04")
public class ex04Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        // 이름과 생년월일을 전달 받고,
        // 이름과 나이를 html
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String birthString = request.getParameter("birth");

        int year = Integer.parseInt(birthString.substring(0,4));

        int age = 2025 - year + 1;

        out.println("" +
                "<html>\n" +
                "   <head><title>정보</title></head>\n" +
                "   <body>");

        out.println("" +
                "       <h3>이름 : " + name + "</h3>\n" +
                "        <h3>나이 : " + age +"</h3>\n");

        out.println("" +
                "</body>\n" +
                "</html>");


    }
}

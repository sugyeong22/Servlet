package com.sudal._01_servlet.ex;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/ex05")
public class Ex05Controller extends HttpServlet {

    // 파라미터로 전달 받을 값이
    // 보안적으로 예민한 데이터,
    // 주소로 표현하기 김 데이터,
    // 파일 형태인 경우  Post로 해야함. 그 외에는 다 Get
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // common에 공통을 만들어둠
//        response.setCharacterEncoding("utf-8");
//        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");


        // 이름과 생년월일(보안적으로 민감한 데이터)은 전달 받고, 이름과 나이를 html 로 구성
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String birthString = request.getParameter("birthday");

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

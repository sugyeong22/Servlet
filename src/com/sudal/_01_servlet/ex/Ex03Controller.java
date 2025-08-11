package com.sudal._01_servlet.ex;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/ex03")
public class Ex03Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html");
        response.setContentType("application/json");

        //이름과 생년월일을 전달 받고
        //이름과 나이를 html로 구성

        PrintWriter out = response.getWriter();

        // request에서 name 이란 파라미터 이름으로 값을 꺼내 쓸테니 name이라는 이름으로 이름을 전달!
        String name = request.getParameter("name");
        // request에서 birthday란 파라미터 이름으로 200310008형식으로 생년월일을 꺼내 쓸테니
        // birthday라는 이므으로 생년월일을 전달!
        String birthday = request.getParameter("birthday");

        String yearString = birthday.substring(0,4);
        int year = Integer.parseInt(yearString);

        int age = 2025 - year + 1;

//        out.println("" +
//                "<html>\n" +
//                "   <head><title>정보</title></head>\n" +
//                "   <body>\n" +
//                "       <h3> 이름 : " + name + "</h3>\n" +
//                "       <h3> 나이 : " + age + "</h3>\n" +
//                "   </body>\n" +
//                "</html>");

        // 이름과 나이 데이터를 응답에 담는다.
        // 김인규, 32
        // 응답에 데이터를 담기 위한 !!문자열!! 규격
        // JSON(Javascript Object Notation) : 자바스크립의 객체를 표현하는 규격을 그대로 본따서 만든 문자열 규격임
        // 리스트 : ["김인규", "지석진", "유재석"]
        // 키밸류 : {"name":"김인규", "birthday" : "20020723"}

        out.println("{\"name\":\"김인규\", \"birthday\" : \"20020723\"}");



    }

}

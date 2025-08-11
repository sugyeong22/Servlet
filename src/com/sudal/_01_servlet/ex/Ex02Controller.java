package com.sudal._01_servlet.ex;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/ex02")
public class Ex02Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");


        // 1 ~ 10 까지 합을 구해서 html로 구성
        PrintWriter out = response.getWriter();

        int sum = 0;
        for(int i = 0 ; i <= 10 ; i++){
            sum += i;
        }
        out.println("" +
                "<html>\n" +
                "   <head> <title>합계</title></head>\n" +
                "   <body>"+
                "       <h2>" + sum + "</h2>"+
                "   </body>"+
                "</html>");

    }

}

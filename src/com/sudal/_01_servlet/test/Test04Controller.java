package com.sudal._01_servlet.test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/test/test04")
public class Test04Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest requset, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("" +
                "<html>" +
                "   <ul>");

        for(int i = 1 ; i <= 30 ; i++ ){
            out.print("<li>" + i +"번째 리스트 </li> \n");
        }

        out.println("" +
                "</ul>" +
                "</html>");

    }
}

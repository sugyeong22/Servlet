package com.sudal._01_servlet.test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet/test09")
public class Test09Controller extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String prText = request.getParameter("prText");

        out.println("" +
                "<html>\n" +
                "   <head><title>입사지원</title></head>\n" +
                "   <body>");

        out.println("" +
                "<h1>" +name + "님 지원이 완료 되었습니다.</h1>\n" +
                "<hr>\n" +
                "<div>지원 내용</div> \n" +
                "<div>"+ prText +"</div>");


        out.println("" +
                "   </body>\n" +
                "</html>");
    }
}

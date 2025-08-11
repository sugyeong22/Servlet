package com.sudal._01_servlet.test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/servlet/text/text03")
public class Test03Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest reauest, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String dateTime = formatter.format(now);

        out.println("" +
                "<html>" +
                "   <header>" +
                "       <h1> [단독] 고양이가 야옹해 \n </h1>" +
                "           <div> 기사 입력 시간 : " + dateTime +"</div>"+
                "           <hr>" +
                        "   <div>끝</div>" +
                        "<html>");


    }
}

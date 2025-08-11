package com.sudal._01_servlet.test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servelt/test07")
public class Test07Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String address = request.getParameter("address");
        String card = request.getParameter("card");
        String price = request.getParameter("price");

        out.println("" +
                "<html>\n" +
                "   <head><title>예제07</title></head>\n" +
                "   <body>\n");

        if(!address.contains("서울시")) {
            out.println("배달 불가 지역입니다.(");
        } else{
            out.println("<h2>" + address + " 로 배달 준비중 </h2>\n");
        }
        if(card.equals("신한카드")) {
            out.println("결제 불가 카드입니다.");
        } else{
            out.println("</hr>" +
                    "결제 금액 : " + price+ " 원");
        }

        out.println("" +
                "</body>\n" +
                "</html>");


    }
}

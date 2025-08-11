package com.sudal._01_servlet.test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/servelt/test08")
public class Test08Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("" +
                "<html>\n" +
                "   <head><title>test08</title></head>\n" +
                "   <body>");

        List<String> list = new ArrayList<>(Arrays.asList(
                "강남역 최고 맛집 소개 합니다.",
                "오늘 기분 좋은 일이 있었네요.",
                "역시 맛집 데이트가 제일 좋네요.",
                "집에 가는 길에 동네 맛집 가서 안주 사갑니다.",
                "자축 저 오늘 생일 이에요."));

        String serch = request.getParameter("serch");

        for(int i = 0 ; i < list.toArray().length; i++){
            String review = list.get(i);
            if(review.contains(serch)){
//                String string1 = list.get(i).

                out.println("" + list.get(i)+"\n" +
                        "</br>" +
                        "<hr>");

            }
        }

        out.print("</body>\n" +
                "</html>");
    }
}

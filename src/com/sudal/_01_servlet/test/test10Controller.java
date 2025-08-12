package com.sudal._01_servlet.test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/servlet/test10")
public class test10Controller extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        out.println("" +
                "<html>\n" +
                "   <head><title>test10</title></head>\n" +
                "   <body>");

        if (!id.equals(userMap.get("id"))) {
            out.println("id가 일치하지 않습니다.");
        } else if (!password.equals(userMap.get("password"))) {
            out.println("password가 일치하지 않습니다.");
        } else {
            out.println("<h1>" + userMap.get("name") + "님 환영 합니다.</h1>");
        }


        out.println("" +
                "   </body>\n" +
                "</html>");
    }

    // doPost 메소드 바깥쪽에 위치
    private final Map<String, String> userMap = new HashMap<String, String>() {
        {
            put("id", "hagulu");
            put("password", "asdf");
            put("name", "김인규");
        }
    };
}

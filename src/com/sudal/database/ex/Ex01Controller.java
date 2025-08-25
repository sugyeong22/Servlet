package com.sudal.database.ex;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/db/ex/ex01")
public class Ex01Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        // used_goods 테이블의 모든 행 조회해서 정해진 규격의 문자열로 response에 담는다.

        try {
            // database 접속
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // 접속 정보 준비
            // 서버 접속 주소, 포트, 사용할 데이터 베이스, 사용자이름, 비밀번호
            String url = "jdbc:mysql://localhost:3306/test01";
            String username = "root";
            String password = "root";

            // 접속 및 접속 관리 객체 얻기
            Connection connection = DriverManager.getConnection(url, username, password);

            // 쿼리 수행
            String query = "SELECT * FROM `used_goods`;";
            Statement statement = connection.createStatement();

            // 조회된 결과 다루기
            ResultSet resultSet = statement.executeQuery(query);

            // 처음에는 가상인데, next를 통해서 첫번째 행을 가르킴
//            resultSet.next();
//
//            String title = resultSet.getString("title");
//            int price = resultSet.getInt("price");
//            String description = resultSet.getString("description");
//
//            out.println("제목 : " + title + " 가격 : " + price + " 설명 : " + description );

            // 반복문
            while (resultSet.next()){
                String title = resultSet.getString("title");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");

                out.println("제목 : " + title + " 가격 : " + price + " 설명 : " + description );

            }

            //데이터 베이스에 접속해서 기능 수행후에는 접속을 꼭 끊어 줘야함.
            statement.close();

            // INSERT
//            query = "INSERT INTO'used_goods'\n" +
//                    "('seller_id','title','price','descriotion')\n" +
//                    "VALUE\n" +
//                    "(3, '고양이 간식 팝니다', '3000','ㅇㅇㅇ');";
//            statement = connection.createStatement();
//
//            // INSERT, UPDATE, DELETE
//            // 실행된 행의 개수가 반환 됌.
//            int count = statement.executeUpdate(query);
//
//            out.println("실행 결과 : " + count);
//
            statement.close();
            connection.close();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
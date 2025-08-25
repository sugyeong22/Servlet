package com.sudal.database.test;

import jakarta.servlet.Servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/db/test/test01")
public class test01Controller extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        try{

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            String url = "jdbc:mysql://localhost:3306/test01";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);

            // 쿼리 수행
            // insert
//            String query = "INSERT INTO `real_estate`\n" +
//                    "(`realtor_id`,`address`,`area`,`type`,`price`,`rent_price`)\n" +
//                    "VALUE\n" +
//                    "(3,'헤라펠리스 101동 5305호',350,'매매','1500000',null);";
//            Statement statement = connection.createStatement();
//
//            int count = statement.executeUpdate(query);
//
//            out.println("실행 결과 : " + count);


            // select
//            insert 수행 후, 전체 매물 리스트 중 다음 컬럼만 포함하세요
//            매물 주소
//            면적
//            거래 종류(type)
            String query = "SELECT `address`,`area`,`type` FROM `real_estate`\n" +
                    "ORDER BY `id` DESC LIMIT 10;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                String address = resultSet.getString("address");
                String area = resultSet.getString("area");
                String type = resultSet.getString("type");

                out.println("매물 주소 : " + address + " 면적 : " + area + " 거래종류 : "+ type);

            };

            statement.close();
            connection.close();

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}

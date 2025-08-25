package com.sudal.common;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MysqlService {
    
    // 클래스를 만든 사람이 해당 클래스의 객체가 무분별하게 만들어지는 것을 제어
    // 하나의 객체를 만들어서 이를 공용으로 활용하게 한다.
    // 디자인 패턴
    // singleton Pattern :
    // static 변수 : 객체 생성 없이 사용할 수 있는 멤버변수.
    private static MysqlService mysqlService = null;

    private Connection connection;
    
    // 해당 클래스의 객체를 return 하는 메서드
    // 객체를 사용하고자 하는 곳에서 생성자 대신 사용할 메서드
    // 딱 한번만 생성하고, 그 이후로는 있는거를 가져다가 씀
    // static 메서드 : 객체 생성 없이 호출할 수 있는 메서드
    public static MysqlService getInstance(){
        if(mysqlService == null ){
            mysqlService = new MysqlService();
        }
        return mysqlService;
    }
    
    // 데이터 베이스 접속 기능
        public boolean connect(){
            // database 접속
            try {
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                // 접속 정보 준비
                // 서버 접속 주소, 포트, 사용할 데이터 베이스, 사용자이름, 비밀번호
                String url = "jdbc:mysql://localhost:3306/test01";
                String username = "root";
                String password = "root";

                // 접속 및 접속 관리 객체 얻기
                connection = DriverManager.getConnection(url, username, password);

            } catch (SQLException e) {
                // 접속 실패
                return false;
            }
            return true;
        };

    // select 쿼리 수행 기능
    public List<Map<String,Object>> select(String query){
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            // 조회된 결과 컬럼 목록 얻어오기
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            // 컬럼 이름 list
            List<String> columnList = new ArrayList<>();
            for(int i = 1; i <= columnCount; i++){
                String name = rsmd.getColumnName(i);
                columnList.add(name);
            }

            List<Map<String,Object>> resultList = new ArrayList<>();
            while(resultSet.next()){
                // 한 행의 정보
                // 한 행의 정보를 Map으로 재구성
                Map<String,Object> row = new HashMap<>();

                for(String column : columnList){
                    row.put(column, resultSet.getObject(column));
                }

                resultList.add(row);
            }
            statement.close();
            return resultList;
        } catch (SQLException e) {
            return null;
            // 객체를 리턴할때는 null을 리턴함으로써 되지 않았다는것을 표현
        }
    }

    // insert,update,delete
    public int update(String query){

        try {
            Statement statement = connection.createStatement();

            int count = statement.executeUpdate(query);
            statement.close();

            return count;
        } catch (SQLException e) {
            return -1;
        }
    }

    // 접속 끊기
    public boolean disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}

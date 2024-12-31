package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  DBcon {
    private static Connection dbConn;

    public static Connection getConnection() {
        if (dbConn == null) {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbUrl = "jdbc:mysql://localhost:3306/vending";
            String dbUser = "root";
            String dbPassWord = "1111";
            try {
                Class.forName(dbDriver);
                dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassWord);
//                System.out.println("DB 연결 성공");
            } catch (ClassNotFoundException e) {
                System.out.println("DB 연결 실패");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("DB 연결 실패");
                e.printStackTrace();
            }catch (Exception e) {
                System.out.println("DB 연결 실패");
                e.printStackTrace();
            }
        }
        return dbConn;
    }
    public static void close(){
        if (dbConn != null) {
            try {
                if (dbConn.isClosed()) {
                    dbConn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


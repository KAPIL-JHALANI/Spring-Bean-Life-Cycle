package com.example.DaoAndSpringPool;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component
public class studentDao {

    @Value("${mysql.driver}")
    private String driver;

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.userName}")
    private String userName;

    @Value("${mysql.pass}")
    private String pass;

    Connection conn;

    @PostConstruct  // this annotation just call and say hey spring if bean is created for this object please call this method so that i d not need to manually call it
    public void init() throws SQLException {  // we create init() method for bestter code practise so baiscally we wrtite all our initializations here
        startjdbcConnection();
    }

    public void startjdbcConnection() throws SQLException {
        conn= DriverManager.getConnection(url,userName,pass);
    }

    public void selectAllRows() throws ClassNotFoundException, SQLException {

        System.out.println("Retrive all data");

        //load the driver (in springboot it automatically handle the class loading)
//        Class.forName(driver);

        //get a connetion
//        Connection conn= DriverManager.getConnection(url,userName,pass);

        //execute query
        Statement statement= conn.createStatement();

        ResultSet rs=statement.executeQuery("select * from School");

        while(rs.next()){
            int studentId=rs.getInt(1);
            String studentName=rs.getString(2);
            double studentFees=rs.getDouble(3);
            String studentfood=rs.getString(4);

            System.out.println(studentId+" "+studentName+ " "+studentFees+" "+studentfood);

        }
        conn.close();
    }

    public void deleterow(int studentId) throws SQLException, ClassNotFoundException {

        System.out.println("delete studentId: "+studentId);
//        Class.forName(driver);
//        Connection conn= DriverManager.getConnection(url,userName,pass);

        //execute query
        Statement statement= conn.createStatement();

        statement.executeUpdate("delete  from School where studentid="+studentId);

        conn.close();
    }

    public void closejdbcconnection() throws SQLException {
        System.out.println("connection dstroyed");
        conn.close();
    }

    @PreDestroy // this annoation is used to call the methods just before the bean or object is destroyed (If container is destroy then first it's beans are destroyed)
    public void destroy() throws SQLException {
        closejdbcconnection();
    }
}

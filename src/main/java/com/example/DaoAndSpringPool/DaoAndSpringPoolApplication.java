package com.example.DaoAndSpringPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;


public class DaoAndSpringPoolApplication {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		SpringApplication.run(DaoAndSpringPoolApplication.class, args);

		ApplicationContext context=new AnnotationConfigApplicationContext(StudentConfig.class);
		studentDao dao=context.getBean("studentDao", studentDao.class);

//		dao.startjdbcConnection();
		dao.selectAllRows();
//		dao.closejdbcconnection();

		((AnnotationConfigApplicationContext)context).close();

	}

}

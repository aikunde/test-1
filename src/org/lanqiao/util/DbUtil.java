package org.lanqiao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//工具类：工具类中的方法一般设计成静态的，主要是为了方便调用
public class DbUtil {
	static Connection conn = null;
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String user = "scott";
	static String password = "Qq34594765";
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

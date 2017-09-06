package org.lanqiao.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.junit.Test;

public class JdbcTest {
	@Test
	public void updateUser() throws Exception{
		//1.加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.创建连接
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "Qq34594765";
		Connection conn = DriverManager.getConnection(url, user, password);
		//3.创建发送指令的PreparedStatement对象；
		String sql = "update users set uname=?,uJob=?,uemail=?,udate=? where uuid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "肖小");
		ps.setString(2, "老板");
		ps.setString(3, "111@qq.com");
		String date =  "2016-03-15";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(date);
		Date sqldate = new Date(utilDate.getTime());
		System.out.println(sqldate);
		ps.setDate(4, sqldate);
		ps.setString(5, "2");
		//4.提交执行指令
		ps.executeUpdate();
		//5.关闭资源
		ps.close();
		conn.close();
	}
	@Test
	public void addUser() throws Exception{
		//1.创建连接(Connection)
		//a.加载Oracle驱动；
		String className="oracle.jdbc.driver.OracleDriver";
		Class.forName(className);
		//b.通过驱动程序管理器拿到连接对象
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "Qq34594765";
		Connection conn =  DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		//2.创建一个发送指令（sql）的对象（PreparedStatement）
		String sql = "insert into users values(?,?,?,?,?,?)";
		PreparedStatement ps  = conn.prepareStatement(sql);
		//给参数赋值
		ps.setString(1, UUID.randomUUID().toString());
		ps.setString(2, "小张");
		ps.setString(3, "Java高级工程师");
		ps.setString(4,"张张");
		ps.setString(5, "3454@163.com");
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		ps.setDate(6, sqlDate);
		//3.使用PreparedStatement向数据库发送操作指令
		ps.executeUpdate();
		//4.关闭相关对象->释放对象
		ps.close();
		conn.close();
	}
	@Test
	public void delete() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "Qq34594765";
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "delete from users where uuid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "a75b032b-c1d7-47ec-84fd-414440d0dc61");
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	@Test
	public void search() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "Qq34594765";
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "select * from dept";
		PreparedStatement ps = conn.prepareStatement(sql);
		//执行查询
		ResultSet rs = ps.executeQuery();
		//从结果中取数据
		while(rs.next()){
			System.out.print("deptno:"+rs.getInt("deptno")+"  ");
			System.out.print("dname:"+rs.getString("dname")+"  ");
			System.out.println("loc:"+rs.getString("loc"));
		}
		rs.close();
		ps.close();
		conn.close();
		
			
		
	}
}

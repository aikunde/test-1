package org.lanqiao.test;

import java.util.List;
import org.junit.Test;
import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;

public class UserDaoImplTest {

	@Test
	public void listtest() {
		UserDao ud = new UserDaoImpl();
		List<User> list = ud.list();
		System.out.println(list);
	}
	@Test
	public void addtest(){
		UserDao ud = new UserDaoImpl();
		String uuid = "2";
		String uname = "汤姆";
		String ujob = "java工程师";
		String unick = "小汤";
		String email = "2121@163.com";
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		String umessage = "蓝桥公司的工程师";
		User user = new User(uuid, uname, ujob, unick, email, date,umessage);
		ud.add(user);
	}
	@Test
	public void deleteTest(){
		UserDao ud = new UserDaoImpl();
		ud.delete("2");
	}
	@Test
	public void updateTest(){
		UserDao ud = new UserDaoImpl();
		String uuid = "2";
		String uname = "汤姆";
		String ujob = "架构师";
		String unick = "老汤";
		String email = "2121@163.com";
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		String umessage = "蓝桥公司的架构师";
		User user = new User(uuid, uname, ujob, unick, email, date,umessage);
		ud.update(user);
	}
	@Test
	public void serachTest(){
		UserDao ud = new UserDaoImpl();
		User user = ud.search("张张");
		System.out.println(user);
	}

}

package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.UserDao;
import org.lanqiao.dao.impl.UserDaoImpl;
import org.lanqiao.entity.User;
import org.lanqiao.service.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public List<User> list() {
		UserDao ud = new UserDaoImpl();
		return ud.list();
	}

	@Override
	public void add(User user) {
		UserDao ud = new UserDaoImpl();
		ud.add(user);
	}

	@Override
	public void delete(String uuid) {
		UserDao ud = new UserDaoImpl();
		ud.delete(uuid);
	}

	@Override
	public void update(User user) {
		UserDao ud = new UserDaoImpl();
		ud.update(user);
	}

	@Override
	public User search(String keyword) {
		UserDao ud = new UserDaoImpl();
		return ud.search(keyword);
	}

	@Override
	public void exports(String url) {
		UserDao ud = new UserDaoImpl();
		ud.exports(url);
	}

	@Override
	public void imports(String url) {
		UserDao ud = new UserDaoImpl();
		ud.imports(url);
	}

}

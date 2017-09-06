package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.User;

public interface UserService {
	public List<User> list();
	public void add(User user);
	public void delete(String uuid);
	public void update(User user);
	public User search(String keyword);
	public void exports(String url);
	public void imports(String url);
}

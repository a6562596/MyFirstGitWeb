package com.hrt.service;

import java.util.List;

import com.hrt.pojo.User;

public interface UserService {

	//插入用户姓名年龄
	void addUser(String name,Integer age);
	
	//查询用户信息
	List<User> selectUserAll();
	
	//更新用户之前的查询，并将数据在页面中回显
	//根据id去查询用户
	User findUserById(Integer id);
	
	//数据更新
	void updateUser(User user);
	
	//删除用户
	void deleteUserById(Integer id);
}

package com.hrt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrt.mapper.UserMapper;
import com.hrt.pojo.User;
import com.hrt.service.UserService;

@Service
@Transactional  //事务
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public void addUser(String name,Integer age) {
		userMapper.addUser(name,age);
	}

	@Override
	public List<User> selectUserAll() {
		return userMapper.selectUserAll();
	}

	@Override
	public User findUserById(Integer id) {
		return userMapper.selectUserById(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userMapper.deleteUserById(id);
	}

	

}

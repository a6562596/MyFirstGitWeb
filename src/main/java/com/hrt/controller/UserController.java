package com.hrt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrt.pojo.User;
import com.hrt.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 页面跳转
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	//添加用户
	@RequestMapping("/addUser")
	public String addUser(String name,Integer age){
		userService.addUser(name,age);
		return "ok";
	}
	
	//查询用户信息
	@RequestMapping("/selectUser")
	public String selectUser(Model model){
		List<User> list = userService.selectUserAll();
		model.addAttribute("list",list);
		return "showuser";
	}
	
	//根据id去查询用户  Moden(回显)
	@RequestMapping("/findUserById")
	public String findUserById(Integer id,Model model){//此处的id是showuser页面通过url传递过来的
		User user = userService.findUserById(id);//然后findUserById拿到传过来的id去查找用户的信息
		model.addAttribute("user",user);//把查找到的信息传入到model中回显到html页面
		return "updateuser";
	}
	
	//数据更新
	@RequestMapping("/updateUser")
	public String updateUser(User user){
		userService.updateUser(user);
		return "redirect:/user/selectUser";
	}
	
	//删除用户
	@RequestMapping("/delUser")
	public String deUser(Integer id){
		userService.deleteUserById(id);
		return "redirect:/user/selectUser";
	}
}

package cn.sh.website.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.dto.User;
import cn.sh.dto.common.CommonRetDto;
import cn.sh.website.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/login.do")
	public User login(String userName, String password, HttpServletRequest request) throws Exception {
		User user = userService.login(userName, password);
		return user;
	}

	@PostMapping("/save.do")
	public CommonRetDto save(User user) throws Exception {
		return userService.saveUser(user);
	}
}
package cn.sh.website.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.dto.User;
import cn.sh.dto.common.CommonRetDto;
import cn.sh.website.service.system.RoleService;
import cn.sh.website.service.system.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@PostMapping("/login.do")
	public User login(String userName, String possword, HttpServletRequest request) throws Exception {
		User user = userService.login(userName, possword);
		request.getSession().setAttribute("login_user", user);
		return user;
	}

	@PostMapping("/index.do")
	public User index(HttpServletRequest request) throws Exception {
		User user = (User)(request.getSession().getAttribute("login_user"));
		return userService.initIndex(user.getId());
	}

	@GetMapping("/userPage.do")
	public User userPage(String sEcho, String iDisplayLength, HttpServletRequest request) throws Exception {
		return null;
	}

	@PostMapping("/save.do")
	public CommonRetDto save(User user) throws Exception {
		return userService.saveUser(user);
	}
}
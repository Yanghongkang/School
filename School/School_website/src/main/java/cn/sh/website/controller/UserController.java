package cn.sh.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.dto.User;
import cn.sh.dto.common.CommonRetDto;
import cn.sh.dto.common.PageRetDto;
import cn.sh.dto.common.PagerRetDto;
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
		User user = (User) (request.getSession().getAttribute("login_user"));
		if (user.getResourceList() == null) {
			user = userService.initIndex(user.getId());
			request.getSession().setAttribute("login_user", user);
		} else {
			return user;
		}
		return user;
	}

	@GetMapping("/logout.do")
	public CommonRetDto logout(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return new CommonRetDto("000", "true");
	}

	@PostMapping("/userPage.do")
	public PageRetDto<User> userPage(User user, PagerRetDto pager) throws Exception {
		return userService.userPage(user, pager);
	}

	@PostMapping("/save.do")
	public CommonRetDto save(User user) throws Exception {
		return userService.saveUser(user);
	}
}
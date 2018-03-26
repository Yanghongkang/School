package cn.sh.restful.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sh.db.mapper.UserMapper;
import cn.sh.dto.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserMapper usermapper;

	@RequestMapping("/all")
	public List<User> view() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setUserName("asa");
		map.put("user", user);
		return usermapper.queryUserByPage(map);
	}
}
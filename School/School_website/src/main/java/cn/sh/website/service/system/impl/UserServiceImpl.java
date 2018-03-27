package cn.sh.website.service.system.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.db.mapper.ResourceMapper;
import cn.sh.db.mapper.RoleMapper;
import cn.sh.db.mapper.UserMapper;
import cn.sh.dto.Resource;
import cn.sh.dto.Role;
import cn.sh.dto.User;
import cn.sh.dto.common.CommonRetDto;
import cn.sh.website.service.system.UserService;
import cn.sh.website.util.MD5Util;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper usermapper;
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	ResourceMapper resourceMapper;

	@Override
	public User login(String userName, String userPassword) throws Exception {
		User user = usermapper.queryUserByName(userName);
		if (user == null) {
			user = new User();
			user.setErrMsg("找不到该用户");
			return user;
		}
		if (LOCAK == user.getIslock()) {
			user = new User();
			user.setErrMsg("用户锁定");
			return user;
		}
		if (user.getUserPassword() == null) {
			user = new User();
			user.setErrMsg("未设置密码!");
			return user;
		}
		if (!user.getUserPassword().equals(MD5Util.MD5(userPassword))) {
			user = new User();
			user.setErrMsg("密码错误");
			return user;
		}
		return user;
	}

	@Override
	public User initIndex(Long userId) throws Exception {
		Set<Resource> resource = new HashSet<Resource>();
		User user = usermapper.queryUserById(userId);
		user.setRoelList(roleMapper.queryRoleByUserId(userId));
		for (Role role : user.getRoelList()) {
			resource.addAll(resourceMapper.queryResourceByRole(role.getId()));
		}
		user.setResourceList(new ArrayList<>(resource));
		return user;
	}

	@Override
	public List<User> userPage(User user, int page, int count) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommonRetDto saveUser(User user) throws Exception {
		CommonRetDto ret = new CommonRetDto();
		if (user == null && user.getUserName() == null) {
			ret.setErrCode(ret.FAIL);
			ret.setErrMsg("用户信息不能为空");
		} else {
			boolean flag = usermapper.saveUser(user);
			if (flag) {
				ret.setErrCode(ret.SUCCESS);
			} else {
				ret.setErrCode(ret.FAIL);
				ret.setErrMsg("操作失败");
			}
		}
		return ret;
	}

	@Override
	public Long userPageCount(User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

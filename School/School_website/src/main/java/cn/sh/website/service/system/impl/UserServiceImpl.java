package cn.sh.website.service.system.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import cn.sh.dto.common.PageRetDto;
import cn.sh.dto.common.PagerRetDto;
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
		System.out.println(System.currentTimeMillis());
		Set<Resource> parentresource = new HashSet<Resource>();
		Set<Resource> parentChild = new HashSet<Resource>();
		User user = usermapper.queryUserById(userId);
		user.setRoelList(roleMapper.queryRoleByUserId(userId));
		for (Role role : user.getRoelList()) {
			parentChild = new HashSet<>(resourceMapper.queryResourceByRole(role.getId()));
			for (Resource resource2 : parentChild) {
				if (resource2.getParentId() == 0l) {
					parentresource.add(resource2);
				}
			}
			for (Resource parent : parentresource) {
				parentChild.remove(parent);
				for (Resource child : parentChild) {
					if (parent.getId() == child.getParentId()) {
						if (parent.getChildResource() == null)
							parent.setChildResource(new ArrayList<>());
						parent.getChildResource().add(child);
					}
				}
			}
		}
		user.setResourceList(new ArrayList<>(parentresource));
		System.out.println(System.currentTimeMillis());
		return user;
	}

	@Override
	public PageRetDto<User> userPage(User user, PagerRetDto pager) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("start", pager.getPage());
		map.put("size", pager.getRecPerPage());
		if (user.getUserName() != null && user.getUserName() != "")
			map.put("userName", user.getUserName());
		List<User> result = usermapper.queryUserByPage(map);
		PageRetDto<User> response = new PageRetDto<User>();
		response.setResult("success");
		response.setData(result);
		pager.setRecTotal(usermapper.queryUserCount(user));
		response.setPagerdto(pager);
		return response;
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

}

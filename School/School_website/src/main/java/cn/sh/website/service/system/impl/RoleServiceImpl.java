package cn.sh.website.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sh.db.mapper.ResourceMapper;
import cn.sh.db.mapper.RoleMapper;
import cn.sh.dto.Resource;
import cn.sh.dto.Role;
import cn.sh.website.service.system.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public List<Role> getRole(Long userId) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.queryRoleByUserId(userId);
	}

	@Override
	public List<Resource> getResource(Long RoleId) throws Exception {
		// TODO Auto-generated method stub
		return resourceMapper.queryResourceByRole(RoleId);
	}
}

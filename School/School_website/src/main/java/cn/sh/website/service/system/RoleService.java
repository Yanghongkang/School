package cn.sh.website.service.system;

import java.util.List;

import cn.sh.dto.Resource;
import cn.sh.dto.Role;

public interface RoleService {

	List<Role> getRole(Long userId) throws Exception;
	
	List<Resource> getResource(Long RoleId)throws Exception;

}
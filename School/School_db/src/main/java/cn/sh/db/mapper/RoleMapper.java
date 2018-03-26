package cn.sh.db.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.sh.dto.Role;
import cn.sh.dto.User;

@Mapper
public interface RoleMapper {

	@Select("select * from school_role")
	List<Role> queryRoleList(Role role) throws Exception;

	/**
	 * 根据ID查找角色
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Select("select * from school_role where id=#{id}")
	List<Role> queryRoleById(Long id) throws Exception;

	@Insert("insert into school_role(role_name,create_date,update_date,remark,islock,seq)"
			+ "values(#{roleName},#{createDate},#{updateDate},#{remark},#{islock},#{seq})")
	boolean saveRole(Role role) throws Exception;

	/**
	 * 根系角色
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@Update("update school_role set user_name=#{userName},user_password=#{userPassword} where id=#{id}")
	User updateRoleById(Role role) throws Exception;

	/**
	 * 根据ID删除角色
	 * 
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@Delete("delete from school_role where id=#{id}")
	boolean delRoleById(Long roleId) throws Exception;

	/**
	 * 插入关联表
	 * 
	 * @param roleId
	 * @param resourceId
	 * @return
	 * @throws Exception
	 */
	@Insert("insert into school_role_resource(role_id,resource_id) values (#{roleId},#{resourceId})")
	boolean saveUserRole(@Param("roleId") Long roleId, @Param("resourceId") Long resourceId) throws Exception;

	/**
	 * 根据用户ID找角色
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Select("SELECT r.* FROM school_role r LEFT JOIN school_user_role ur ON ur.role_id = r.id WHERE ur.user_id = #{userId}")
	@ResultMap("cn.sh.db.mapper.RoleMapper.roleResult")
	List<Role> queryRoleByUserId(@Param("userId") Long userId) throws Exception;

}

package cn.sh.db.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.sh.dto.User;

@Mapper
public interface UserMapper {


	Long queryUserCount(User user) throws Exception;

	List<User> queryUserByPage(Map<String, Object> map) throws Exception;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Select("select * from school_user where id=#{id}")
	User queryUserById(Long id) throws Exception;

	/**
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	@Select("select * from school_user where user_name=#{userName}")
	@ResultMap("cn.sh.db.mapper.UserMapper.userResult")
	User queryUserByName(String userName) throws Exception;

	@Insert("insert into school_user(user_name,user_password,email,we_chat,common_phone,urgent_phone,update_date,create_date,lost_login_date,dingtalk,age) "
			+ "values(#{userName},#{userPassword},#{email},#{weChat},#{commonPhone},#{urgentPhone},#{updateDate},#{createDate},#{lostLoginDate},#{lostLoginDate},#{age})")
	boolean saveUser(User user) throws Exception;

	@Update("update school_user set user_name=#{userName},user_password=#{userPassword} where id=#{id}")
	User updateUserById(User user) throws Exception;

	@Delete("delete from school_user where id=#{id}")
	boolean delUserById(Long userId) throws Exception;

	@Insert("insert into school_user_role(user_id,role_id) values (#{userId},#{roleId})")
	boolean saveUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId) throws Exception;

	

}

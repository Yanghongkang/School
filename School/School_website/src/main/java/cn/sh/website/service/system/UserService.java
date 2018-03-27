package cn.sh.website.service.system;

import java.util.List;

import cn.sh.dto.User;
import cn.sh.dto.common.CommonRetDto;

public interface UserService {

	public static final String LOCAK = "1";

	public static final String NULOCK = "0";

	/**
	 * 登录
	 * @param userName
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	public User login(String userName, String userPassword) throws Exception;
	
	/**
	 * 首页初始化
	 * @param userName
	 * @param userPassword
	 * @return
	 * @throws Exception
	 */
	public User initIndex(Long userId) throws Exception;

	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public CommonRetDto saveUser(User user) throws Exception;

	/**
	 * 
	 * @param user
	 * @param page
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public List<User> userPage(User user, int page, int count) throws Exception;

	/**
	 * 
	 * @param user
	 * @param page
	 * @param count
	 * @return
	 * @throws Exception
	 */
	public Long userPageCount(User user) throws Exception;
}

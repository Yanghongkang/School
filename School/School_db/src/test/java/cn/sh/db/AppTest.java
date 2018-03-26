package cn.sh.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.sh.db.mapper.RoleMapper;
import cn.sh.db.mapper.UserMapper;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = AppTestSqlApplication.class)
public class AppTest extends TestCase {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void testfindAllUsers() throws Exception {
		// User aa = new User();
		// aa.setUserName("asa");
		// //userMapper.saveUserById(aa);
		// userMapper.queryUserById(1l);
		// System.out.println(userMapper.queryUserByPage(aa).size());
		// User admin = new User();
		// admin.setUserName("Admin");
		// admin.setCreateDate(new Date());
		// admin.setEmail("111@11.com");
		// admin.setAge(23l);
		// admin.setCommonPhone("13838383823");
		// userMapper.saveUser(admin);
		//User uu = userMapper.queryUserByName("Admin");

		//userMapper.queryRoleByUser(uu.getId());
//		List<Role> aa = roleMapper.queryRoleList(new Role());
//		for (Role role : aa) {
//			System.out.println(role.getId());
//			userMapper.saveUserRole(uu.getId(), role.getId());
//		}
		
	}
}

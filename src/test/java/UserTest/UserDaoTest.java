package UserTest;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.dao.IUserInfoDao;
import com.pms.entity.UserInfo;
import com.pms.mapper.UserInfoMapper;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class UserDaoTest {
	
//	@Autowired
//	private IUserDao userDao;
	
	@Autowired
	private SqlSession sqlSession;
	@Test
	public void test1(){
		UserInfoMapper mapper =sqlSession.getMapper(UserInfoMapper.class);
//		mapper.selectByPrimaryKey();
	}
	
	@Test
	public void test2(){
		UserInfoMapper mapper =sqlSession.getMapper(UserInfoMapper.class);
		UserInfo user=new UserInfo();
		user.setAge(1);
		user.setUserName("test");
		//mapper.insert(user);
	}
	
	@Test
	public void test3(){
		UserInfoMapper mapper =sqlSession.getMapper(UserInfoMapper.class);
		Map<String ,Object> map=new HashMap<String,Object>();
		map.put("userName", "test");
		mapper.select(map);
	}
}

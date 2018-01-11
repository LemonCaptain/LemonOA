package cn.itcast.oa.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cn.itcast.oa.dao.RoleDao;
import cn.itcast.oa.dao.UserDao;
import cn.itcast.oa.dao.impl.RoleDaoImpl;
import cn.itcast.oa.dao.impl.UserDaoImpl;

class BaseDaoTest {

	@Test
	void testSave() {
		UserDao userDao=new UserDaoImpl();
		RoleDao roleDao=new RoleDaoImpl();
		
		
	}

}

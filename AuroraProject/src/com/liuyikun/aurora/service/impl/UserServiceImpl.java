package com.liuyikun.aurora.service.impl;

import com.liuyikun.aurora.dao.UserDao;
import com.liuyikun.aurora.dao.impl.UserDaoImpl;
import com.liuyikun.aurora.domain.User;
import com.liuyikun.aurora.service.UserService;

/**
 * @author liuyikun
 * @date 2020/7/9 - 16:46
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean registUser(User user) {
		//1.根据用户名查询用户对象
		User u = userDao.findUserByLoginName(user.getLogin_name());
		//判断u是否为null
		if(u != null){
			//用户名存在
			return false;
		}
		//2.保存用户信息
		userDao.save(user);
		return true;
	}
}

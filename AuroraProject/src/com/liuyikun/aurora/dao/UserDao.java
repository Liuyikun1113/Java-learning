package com.liuyikun.aurora.dao;

import com.liuyikun.aurora.domain.User;

/**
 * @author liuyikun
 * @date 2020/7/9 - 16:46
 */
public interface UserDao {
	//通过用户名查找用户
	User findUserByLoginName(String login_name);
	//保存用户信息
	void save(User user);
}

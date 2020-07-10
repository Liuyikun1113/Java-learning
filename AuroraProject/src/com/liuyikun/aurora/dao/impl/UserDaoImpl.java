package com.liuyikun.aurora.dao.impl;

import com.liuyikun.aurora.dao.UserDao;
import com.liuyikun.aurora.domain.User;
import com.liuyikun.aurora.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuyikun
 * @date 2020/7/9 - 16:46
 */
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

	@Override
	public User findUserByLoginName(String login_name) {
		User user = null;
		try {
			//1.定义sql
			String sql = "select * from account where login_name = ?";
			//2.执行sql
			user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), login_name);
		} catch (DataAccessException e) {
		}
		return user;
	}

	@Override
	public void save(User user) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_time = sdf.format(new Date());
		//1.定义sql
		String sql = "insert into account(login_name,password,phone,email,create_date) values(?,?,?,?,"+create_time+")";
		//2.执行sql
		jdbcTemplate.update(sql, user.getLogin_name(), user.getPassword(), user.getPhone(), user.getEmail());
	}
}

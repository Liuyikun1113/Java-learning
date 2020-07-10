package com.liuyikun.aurora.domain;

import java.util.Date;

/**
 * @author liuyikun
 * @date 2020/7/9 - 16:32
 */
public class User {

	private Integer id;
	private String login_name;
	private String password;
	private String phone;
	private String email;
	private Date create_date;
	private String nick_name;
	private String real_name;
	private String gender;
	private Date birthday;
	private String head_pic;
	private Integer is_phone_check;
	private Integer is_email_check;
	private Date last_login_time;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHead_pic() {
		return head_pic;
	}

	public void setHead_pic(String head_pic) {
		this.head_pic = head_pic;
	}

	public Integer getIs_phone_check() {
		return is_phone_check;
	}

	public void setIs_phone_check(Integer is_phone_check) {
		this.is_phone_check = is_phone_check;
	}

	public Integer getIs_email_check() {
		return is_email_check;
	}

	public void setIs_email_check(Integer is_email_check) {
		this.is_email_check = is_email_check;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

package com.liuyikun.aurora.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuyikun.aurora.domain.ResultInfo;
import com.liuyikun.aurora.domain.User;
import com.liuyikun.aurora.service.UserService;
import com.liuyikun.aurora.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author liuyikun
 * @date 2020/7/9 - 16:27
 */
@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
	private UserService userService = new UserServiceImpl();
	//注册方法
	public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		//验证码校验
		String check = req.getParameter("checkcode");
		//从session中获取验证码
		HttpSession session = req.getSession();
		String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
		session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
		//比较
		if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
			//验证码错误
			ResultInfo info = new ResultInfo();
			//注册失败
			info.setFlag(false);
			info.setErrorMsg("验证码错误！");
			//将info对象序列化为json
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(info);
			resp.setContentType("application/json;charset=utf-8");
			resp.getWriter().write(json);
			return;
		}

		//1.获取到页面信息
		Map<String, String[]> map = req.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		//2.调用service中的方法进行注册
		boolean flag = userService.registUser(user);
		ResultInfo info = new ResultInfo();
		//4.响应结果
		if(flag){
			//注册成功
			info.setFlag(true);
		}else{
			//注册失败
			info.setFlag(false);
			info.setErrorMsg("用户名已占用！");
		}

		//将info对象序列化为json
		String json = writeValueAsString(info);
		//将json数据写回客户端
		//设置content-type
		resp.setContentType("application/json;charset=utf-8");
		resp.getWriter().write(json);
	}
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.
	}
}

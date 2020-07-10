package com.liuyikun.aurora.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liuyikun
 * @date 2020/7/7 - 19:40
 */
public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//完成方法分发
		//1.获取请求路径
		String uri = req.getRequestURI();   //   /travel/user/add
		//2.获取方法名称
		String methodName = uri.substring(uri.lastIndexOf('/') + 1);
		//3.获取方法对象Method
		//this :谁调用我，我代表谁
		//System.out.println(this);//UserServlet对象，因为这个service方法是在UserServlet中的add和find方法调用的
		try {
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//4.执行方法
			method.invoke(this, req,resp);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private ObjectMapper mapper = new ObjectMapper();

	/*
		直接将传入的对象序列化为json，并且写回客户端
	 */
	public void writeValue(Object obj, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json;charset=utf-8");
		mapper.writeValue(resp.getOutputStream(), obj);
	}
	/*
		将传入的对象序列化为json，返回给调用者
	 */
	public String writeValueAsString(Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}
}

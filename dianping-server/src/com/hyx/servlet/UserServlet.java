package com.hyx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;
import com.hyx.dao.UserDao;
import com.hyx.dao.impl.UserDaoImpl;
import com.hyx.enity.ResponseObject;
import com.hyx.enity.User;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String flag = request.getParameter("flag");
		UserDao uDao = new UserDaoImpl();
		ResponseObject result = null;
		if ("register".equals(flag)) {
			// ע��
			if (!"".equals(name) && !"".equals(pwd)) {
				User user = uDao.register(name, pwd);
				if (user != null) {
					// ע��ɹ�
					result = new ResponseObject("ע��ɹ�", 1, user);
				} else {
					result = new ResponseObject("ע��ʧ��,�û��Ѿ�����", 0);
				}
			} else {
				result = new ResponseObject("ע��ʧ��", 0);
			}
		} else if ("login".equals(flag)) {
			if (!"".equals(name) && !"".equals(pwd)) {
				User user = uDao.login(name, pwd);
				if (user != null) {
					// ע��ɹ�
					result = new ResponseObject("��¼�ɹ�", 1, user);
				} else {
					result = new ResponseObject("��¼ʧ��", 0);
				}
			} else {
				result = new ResponseObject("��¼ʧ��", 0);
			}
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();

	}

}

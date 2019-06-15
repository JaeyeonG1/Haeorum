package com.haeorum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haeorum.controller.*;
import com.haeorum.dao.*;
import com.haeorum.dto.*;

public class UserRegisterCommand implements Command {
	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDAO dao = new UserDAO();
		User user = new User();
		CommandForward forward = new CommandForward();
		
		boolean result = false;
		
		try {
			String id = request.getParameter("id"); // jsp���� ���� �޾ƿ�
			String pw = request.getParameter("pwd");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");

			user.setId(id); // dto�� ����
			user.setPw(pw);
			user.setName(name);
			user.setPhone(phone);
			user.setEmail(email);
			user.setTypeId(1);

			result = dao.UserRegister(user); // dao�� ����

			if (result == false) {
				System.out.println("ȸ�����Խ���");
				return null;
			}
			System.out.println("ȸ�����Լ���");

			forward.setRedirect(true);
			forward.setPath("./Login.do");
			return forward;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}

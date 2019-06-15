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
			String id = request.getParameter("id"); // jsp에서 값을 받아옴
			String pw = request.getParameter("pwd");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");

			user.setId(id); // dto에 저장
			user.setPw(pw);
			user.setName(name);
			user.setPhone(phone);
			user.setEmail(email);
			user.setTypeId(1);

			result = dao.UserRegister(user); // dao로 보냄

			if (result == false) {
				System.out.println("회원가입실패");
				return null;
			}
			System.out.println("회원가입성공");

			forward.setRedirect(true);
			forward.setPath("./Login.do");
			return forward;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}

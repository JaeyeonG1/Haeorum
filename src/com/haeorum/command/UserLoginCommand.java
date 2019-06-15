package com.haeorum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haeorum.controller.*;
import com.haeorum.dao.*;
import com.haeorum.dto.*;

public class UserLoginCommand implements Command {
	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserDAO dao = new UserDAO();
		User user = new User();
		CommandForward forward = new CommandForward();

		String result = "";

		try {
			String id = request.getParameter("id"); // jsp���� ���� �޾ƿ�
			String pw = request.getParameter("pwd");

			user.setId(id); // dto�� ����
			user.setPw(pw);
			result = dao.UserLogin(user); // dao�� ����

			String[] arr = result.split("\t");

			HttpSession session = request.getSession();

			System.out.println(result);

			if (arr[0].equals("true")) {
				session.setAttribute("master", arr[1]);
				session.setAttribute("name", arr[2]);
				session.setAttribute("id", arr[3]);
				System.out.println("�α��� �Ϸ�");
				forward.setRedirect(true);
				forward.setPath("./Main.do");
				return forward;
			} else {
				System.out.print("�α��ν���");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}

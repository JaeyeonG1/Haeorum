package com.haeorum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haeorum.controller.*;

public class UserLogoutCommand implements Command {
	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommandForward forward = new CommandForward();

		HttpSession session = request.getSession();
		session.invalidate();
		
		forward.setRedirect(true);
		forward.setPath("./Main.do");
		return forward;
	}

}

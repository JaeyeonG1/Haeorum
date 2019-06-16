package com.haeorum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haeorum.controller.*;

public class DrawUpCommand implements Command {
	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommandForward forward = new CommandForward();

		String boardValue = request.getParameter("board");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("board", boardValue);
		System.out.println(boardValue);
		
		forward.setRedirect(true);
		forward.setPath("./DrawUp.jsp");
		return forward;
	}

}

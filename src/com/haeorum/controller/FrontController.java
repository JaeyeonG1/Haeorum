package com.haeorum.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.haeorum.command.*;

public class FrontController extends HttpServlet {

	protected void doCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String commURI = RequestURI.substring(contextPath.length());
		CommandForward forward = null;
		Command command = null;

		if (commURI.equals("/Main.do")) {
			forward = new CommandForward();
			forward.setRedirect(false);
			forward.setPath("./Main.jsp");
		} else if (commURI.equals("/Register.do")) {
			forward = new CommandForward();
			forward.setRedirect(false);
			forward.setPath("./Register.jsp");
		} else if (commURI.equals("/Login.do")) {
			forward = new CommandForward();
			forward.setRedirect(false);
			forward.setPath("./Login.jsp");
		} else if (commURI.equals("/Introduce.do")) {
			forward = new CommandForward();
			forward.setRedirect(false);
			forward.setPath("./Introduce.jsp");
		} else if (commURI.equals("/Business.do")) {
			forward = new CommandForward();
			forward.setRedirect(false);
			forward.setPath("./Business.jsp");
		} else if (commURI.equals("/Gallery.do")) {
			forward = new CommandForward();
			forward.setRedirect(false);
			forward.setPath("./Gallery.jsp");
		} else if (commURI.equals("/Counsel.do")) {
			forward = new CommandForward();
			forward.setRedirect(false);
			forward.setPath("./Counsel.jsp");
		} else if (commURI.equals("/Notice.do")) {
			forward = new CommandForward();
			forward.setRedirect(false);
			forward.setPath("./Notice.jsp");
		} else if (commURI.equals("/DrawUp.do")) {
			command = new DrawUpCommand();
			try {
				forward = command.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (commURI.equals("/UserRegisterCommand.do")) {
			command = new UserRegisterCommand();
			try {
				forward = command.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (commURI.equals("/UserLoginCommand.do")) {
			command = new UserLoginCommand();
			try {
				forward = command.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (commURI.equals("/UserLogoutCommand.do")) {
			command = new UserLogoutCommand();
			try {
				forward = command.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (commURI.equals("/PostRegisterCommand.do")) {
			command = new PostRegisterCommand();
			try {
				forward = command.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (commURI.equals("/NoticeListCommand.do")) {
			command = new NoticeListCommand();
			try {
				forward = command.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 전송방식처리 => forward방식 또는 sendRedirect방식 선택
		if (forward.isRedirect()) {
			response.sendRedirect(forward.getPath());
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doCommand(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doCommand(request, response);
	}
}

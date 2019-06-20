package com.haeorum.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haeorum.controller.*;
import com.haeorum.dao.*;
import com.haeorum.dto.*;

public class NoticeInquiryCommand implements Command {
	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommandForward forward = new CommandForward();

		PostDAO dao = new PostDAO();
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		Post post = dao.PostInquiry(id);
		
		request.setAttribute("title", post.getTitle());
		request.setAttribute("writer", post.getUserId());
		request.setAttribute("time", post.getTime());
		
		String cnts = post.getContents().replace("\r\n", "<br>");
		
		request.setAttribute("contents", cnts);
		
		request.setAttribute("id", post.getId());
		
		forward.setRedirect(false);
		forward.setPath("./NoticeList.jsp");
		return forward;
	}

}

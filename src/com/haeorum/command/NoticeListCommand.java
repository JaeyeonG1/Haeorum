package com.haeorum.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haeorum.controller.*;
import com.haeorum.dao.*;
import com.haeorum.dto.*;

public class NoticeListCommand implements Command {
	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommandForward forward = new CommandForward();
		
		PostDAO dao = new PostDAO();

		ArrayList<Post> list = dao.PostListInquiry();
		
		request.setAttribute("list", list);
		
		forward.setRedirect(true);
		forward.setPath("./Notice.jsp");
		return forward;
	}

}

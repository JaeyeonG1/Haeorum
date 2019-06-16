package com.haeorum.command;

import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haeorum.controller.*;
import com.haeorum.dao.*;
import com.haeorum.dto.*;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class PostRegisterCommand implements Command {
	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PostDAO dao = new PostDAO();
		Post post = new Post();
		CommandForward forward = new CommandForward();

		MultipartRequest multi = null;

		int sizeLimit = 100 * 1024 * 1024; // 100메가
		String path = request.getRealPath("/upload");

		HttpSession session = request.getSession();
		LocalDateTime currTime = LocalDateTime.now();
		boolean result = false;

		try {
			multi = new MultipartRequest(request, path, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

			ArrayList<Post> list = dao.PostListInquiry();
			int num = 0;
			if (list.size() == 0) {
			} else {
				Post tmp = list.get(0);
				num = tmp.getId();
			}

			int id = num + 1;
			String title = multi.getParameter("title");
			String contents = multi.getParameter("contents");
			Timestamp time = Timestamp.valueOf(currTime);
			int hits = 1;
			int boardId = Integer.parseInt((String) session.getAttribute("board"));
			String userId = (String) session.getAttribute("id");

			post.setId(id);
			post.setTitle(title);
			post.setContents(contents);
			post.setTime(time);
			post.setHits(hits);
			post.setBoardId(boardId);
			post.setUserId(userId);

			result = dao.PostRegister(post); // dao로 보냄

			if (result == false) {
				System.out.println("글 등록 실패");
				return null;
			}
			System.out.println("글 등록 성공");

			forward.setRedirect(true);
			forward.setPath("./Notice.do");
			return forward;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}

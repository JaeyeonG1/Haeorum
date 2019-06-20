package com.haeorum.command;

import java.awt.List;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haeorum.controller.Command;
import com.haeorum.controller.CommandForward;
import com.haeorum.dao.CommentDAO;
import com.haeorum.dto.Comment;
import com.haeorum.dto.Post;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CommentRegisterCommand implements Command {
	@Override
	public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CommentDAO dao = new CommentDAO();
		Comment comment = new Comment();
		CommandForward forward = new CommandForward();

		HttpSession session = request.getSession();
		LocalDateTime currTime = LocalDateTime.now();
		boolean result = false;

		ArrayList<Comment> list = dao.getCommentList();// 전체 댓글 리스트 (시퀀스)

		Timestamp time = Timestamp.valueOf(currTime);
		String contents = request.getParameter("contents");
		String pid = (String)request.getParameter("id");
		int postid = Integer.parseInt(pid);
		String user_id = (String) session.getAttribute("user_id");

		comment.setId(0); // 0넣어야 시퀀스가 매겨짐
		comment.setPost_id(postid);
		comment.setUser_id(user_id);
		comment.setTime(time);
		comment.setContents(contents);

		result = dao.commentRegister(user_id, postid, comment);

		if (result == false) {
			System.out.println("댓글 등록 실패");
			return null;
		} else
			System.out.println("댓글 등록 성공");

		forward.setRedirect(true);
		forward.setPath("./NoticeInquiry.do?id="+postid);
		return forward;
	}

}
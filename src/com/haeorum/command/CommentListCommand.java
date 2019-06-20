package com.haeorum.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.haeorum.controller.Command;
import com.haeorum.controller.CommandForward;
import com.haeorum.dao.CommentDAO;
import com.haeorum.dao.PostDAO;
import com.haeorum.dto.Comment;
import com.haeorum.dto.Post;

public class CommentListCommand implements Command {

   @Override
   public CommandForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      CommandForward forward = new CommandForward();
      
      CommentDAO dao = new CommentDAO();
//      int post_id = Integer.parseInt(request.getParameter("Post_id"));
      ArrayList<Comment> list = dao.getCommentList();
      
      request.setAttribute("list", list);
      
      forward.setRedirect(true);
      forward.setPath("./NoticeList.jsp");
      return forward;
   }

}
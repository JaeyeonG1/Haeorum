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

		PageMaker maker = new PageMaker();
		PostDAO dao = new PostDAO();

		String nowPage = request.getParameter("pageNum");
		System.out.println(nowPage);
		int pageNum = Integer.parseInt(nowPage);

		// 페이지 객체에 새로운 정보 다시 지정해주는 부분
		maker.setTotalcount(dao.AllPostListInquiry().size()); // 전체 게시글 개수를 지정한다
		maker.setPagenum(pageNum - 1); // 현재 몇번 페이지인지 PageMaker에 세팅한다
		maker.setCurrentblock(pageNum); // 현재 페이지블록이 몇번인지 현재 페이지 번호를 통해서 지정한다
		maker.setLastblock(maker.getTotalcount()); // 마지막 블록 번호를 전체 게시글 수를 통해서 정한다

		maker.prevnext(pageNum);// 현재 페이지 번호로 화살표 나타낼지 결정한다
		maker.setStartPage(maker.getCurrentblock());// 시작페이지 번호를 현재 페이지 블록으로 정한다
		maker.setEndPage(maker.getLastblock(), maker.getCurrentblock());
		// 현재 블록 번호와 마지막 블록 번호를 보내서 대조하고 페이지 블록의 마지막 번호를 지정한다

		ArrayList<Post> list = dao.PagedPostListInquiry(maker.getPagenum() * maker.getContentnum(),
				maker.getContentnum());

		request.setAttribute("list", list);
		request.setAttribute("page", maker);

		forward.setRedirect(false);
		forward.setPath("./Notice.jsp");
		return forward;
	}

}

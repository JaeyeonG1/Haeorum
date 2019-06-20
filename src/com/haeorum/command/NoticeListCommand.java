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

		// ������ ��ü�� ���ο� ���� �ٽ� �������ִ� �κ�
		maker.setTotalcount(dao.AllPostListInquiry().size()); // ��ü �Խñ� ������ �����Ѵ�
		maker.setPagenum(pageNum - 1); // ���� ��� ���������� PageMaker�� �����Ѵ�
		maker.setCurrentblock(pageNum); // ���� ����������� ������� ���� ������ ��ȣ�� ���ؼ� �����Ѵ�
		maker.setLastblock(maker.getTotalcount()); // ������ ��� ��ȣ�� ��ü �Խñ� ���� ���ؼ� ���Ѵ�

		maker.prevnext(pageNum);// ���� ������ ��ȣ�� ȭ��ǥ ��Ÿ���� �����Ѵ�
		maker.setStartPage(maker.getCurrentblock());// ���������� ��ȣ�� ���� ������ ������� ���Ѵ�
		maker.setEndPage(maker.getLastblock(), maker.getCurrentblock());
		// ���� ��� ��ȣ�� ������ ��� ��ȣ�� ������ �����ϰ� ������ ����� ������ ��ȣ�� �����Ѵ�

		ArrayList<Post> list = dao.PagedPostListInquiry(maker.getPagenum() * maker.getContentnum(),
				maker.getContentnum());

		request.setAttribute("list", list);
		request.setAttribute("page", maker);

		forward.setRedirect(false);
		forward.setPath("./Notice.jsp");
		return forward;
	}

}

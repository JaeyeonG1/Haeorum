package com.haeorum.controller;

import javax.servlet.http.*;

public interface Command {
	public CommandForward execute(HttpServletRequest request,HttpServletResponse response)
			throws Exception;
}

package com.haeorum.dao;

import javax.naming.*;
import javax.sql.DataSource;
import com.haeorum.dto.*;

public class memberDAO {
	DataSource dataSource;
	
	public memberDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/mysql");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void registerMember(memberDTO member) {
		
	}
	
	public void inquiryMember(memberDTO member) {
		
	}
}

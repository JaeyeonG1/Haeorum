package com.haeorum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.*;
import javax.sql.DataSource;

import com.haeorum.dto.User;

public class UserDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String returns = "";

	public UserDAO() {
		try {
			Context init = new InitialContext();
			Context env = (Context) init.lookup("java:comp/env");
			DataSource ds = (DataSource) env.lookup("jdbc/MySQL");
			con = ds.getConnection();
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}

	public boolean UserRegister(User user) {
		String sql = "";

		int result = 0;

		try {
			pstmt = con.prepareStatement("select * from user");
			rs = pstmt.executeQuery();

			sql = "insert into user(id,pw,name,phone,email,typeId)values(?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getEmail());
			pstmt.setInt(6, user.getTypeId());

			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("UserRegister 에러 : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}

	public String UserLogin(User user) // 로그인
	{
		String id = user.getId();
		String pw = user.getPw();

		try {
			String sql = "SELECT id,pw,name,typeId FROM user where id=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 로그인
				if (pw.equals(rs.getString("pw"))) {
					returns = true + "\t" + rs.getString("typeId") + "\t" + rs.getString("name") + "\t"
							+ rs.getString("id");
				} else {
					System.out.println("비번틀림");
				}
				System.out.println(returns);
			}
		} catch (SQLException e) {
			System.out.println("login실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returns;
	}
}

package com.haeorum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import com.haeorum.dto.*;

public class PostDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String returns = "";

	public PostDAO() {
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

	public boolean PostRegister(Post post) {
		String sql = "";

		int result = 0;

		try {
			pstmt = con.prepareStatement("select * from post");
			rs = pstmt.executeQuery();

			sql = "insert into post(id,title,contents,time,hits,boardId,userId)values(?,?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, post.getId());
			pstmt.setString(2, post.getTitle());
			pstmt.setString(3, post.getContents());
			pstmt.setTimestamp(4, post.getTime());
			pstmt.setInt(5, post.getHits());
			pstmt.setInt(6, post.getBoardId());
			pstmt.setString(7, post.getUserId());

			result = pstmt.executeUpdate();
			if (result == 0)
				return false;

			return true;
		} catch (Exception ex) {
			System.out.println("PostRegister 에러 : " + ex);
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

	public ArrayList<Post> PagedPostListInquiry(int start, int count) {
		ArrayList<Post> list = new ArrayList<Post>();
		
		try {
			pstmt = con.prepareStatement("select * from post order by id desc limit ?,?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContents(rs.getString("contents"));
				post.setTime(rs.getTimestamp("time"));
				post.setHits(rs.getInt("hits"));
				post.setBoardId(rs.getInt("boardId"));
				post.setUserId(rs.getString("userId"));
				list.add(post);
			}
		} catch (Exception e) {
			System.out.println("리스트 생성 실패");
			e.printStackTrace();
		}
		System.out.println(list.size());
		return list;
	}
	
	public ArrayList<Post> AllPostListInquiry() {
		ArrayList<Post> list = new ArrayList<Post>();
		
		try {
			pstmt = con.prepareStatement("select * from post order by id desc");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContents(rs.getString("contents"));
				post.setTime(rs.getTimestamp("time"));
				post.setHits(rs.getInt("hits"));
				post.setBoardId(rs.getInt("boardId"));
				post.setUserId(rs.getString("userId"));
				list.add(post);
			}
		} catch (Exception e) {
			System.out.println("리스트 생성 실패");
			e.printStackTrace();
		}
		System.out.println(list.size());
		return list;
	}
}

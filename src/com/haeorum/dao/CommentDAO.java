package com.haeorum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.haeorum.dto.Comment;
import com.haeorum.dto.*;

public class CommentDAO {

   Connection con;
   PreparedStatement pstmt;
   ResultSet rs;
   String returns = "";

   public CommentDAO() {
      try {
         Context init = new InitialContext();
         DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
         con = ds.getConnection();
      } catch (Exception ex) {
         System.out.println("DB 연결 실패 : " + ex);
         return;
      }
   }

   public boolean commentRegister(String user_id,int post_id , Comment comment) {
      String sql = "";

      int result = 0;

      try {
         pstmt = con.prepareStatement("select * from comment");
         rs = pstmt.executeQuery();

         sql = "insert into comment values(?,?,?,?,?)";
         
//         Timestamp timestamp = new Timestamp(System.currentTimeMillis());
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, 0); //자동 시퀀스
         pstmt.setString(2, comment.getContents());
         pstmt.setTimestamp(3, comment.getTime());
         pstmt.setInt(4, post_id);
         pstmt.setString(5, user_id);
         
         result = pstmt.executeUpdate();
         
         if (result == 0)
            return false;

         return true;
      } catch (Exception ex) {
         System.out.println("CommentRegister 등록실패 : " + ex);
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

   public ArrayList<Comment> getCommentList() {
      try {
         String sql;
         sql = "SELECT * FROM comment";
         //else {sql = "SELECT * FROM comment WHERE id = "+"'"+post_id+"'"+"order by id desc";}
         pstmt = con.prepareStatement(sql);
         rs = pstmt.executeQuery();

         ArrayList<Comment> list = new ArrayList<Comment>();

         while (rs.next()) {
            Comment comment = new Comment();
            comment.setId(rs.getInt("id"));
            comment.setUser_id(rs.getString("User_id"));
            comment.setPost_id(rs.getInt("Post_id"));
            comment.setTime(rs.getTimestamp("time"));
            comment.setContents(rs.getString("contents"));
            list.add(comment);
         }
         
         return list;
      } catch (Exception e) {
         System.out.println("댓글 등록 실패");
         e.printStackTrace();
      }
      return null;
   }

}
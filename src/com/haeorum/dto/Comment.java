package com.haeorum.dto;

import java.sql.*;

public class Comment {
   private int id;
   private int post_id;
   private String user_id;
   private Timestamp time;
   private String contents;

   
   public Comment() {}
   public Comment(int id, int post_id, String user_id, Timestamp time, String contents) {
      super();
      this.id = id;
      this.post_id = post_id;
      this.user_id = user_id;
      this.time = time;
      this.contents = contents;
   
   }
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
   public int getPost_id() {
      return post_id;
   }
   public void setPost_id(int post_id) {
      this.post_id = post_id;
   }
   public String getUser_id() {
      return user_id;
   }
   public void setUser_id(String user_id) {
      this.user_id = user_id;
   }
   public Timestamp getTime() {
      return time;
   }
   public void setTime(Timestamp time) {
      this.time = time;
   }
   public String getContents() {
      return contents;
   }
   public void setContents(String contents) {
      this.contents = contents;
   }
   
   @Override
   public String toString() {
      return "Comment [id=" + id + ", post_id=" + post_id + ", user_id=" + user_id + ", time=" + time + ", contents="
            + contents +"]";
   }
   
   
   
   

}
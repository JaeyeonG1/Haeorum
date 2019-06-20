<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>해오름 ENG</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<%
		String title = (String) request.getAttribute("title");
		String writer = (String) request.getAttribute("writer");
		Timestamp time = (Timestamp) request.getAttribute("time");
		String contents = (String) request.getAttribute("contents");
	%>
	<div class="container">
		<div class="Content-container101">
			<div class="Header-container101">
				<h3 class="introduction101">
					<img src="images/title.PNG"> 공지사항
				</h3>
			</div>

			<div class="Write-Info101"
				style="padding-left: 20px; padding-right: 20px;">

				<h4 class="subject">${title }</h4>

				<div class="desc">
					작성자: <i class="fa fa-user" id="desc2" title="회원"> <strong
						class="who">${writer }</strong> 님 <br> 작성일시: <strong>${time }</strong>
						&nbsp;&nbsp;&nbsp;
					</i>
				</div>
			</div>

			<section class="Admin-Content101" style="font-size: 15px">
				${contents }</section>
			<script>
				//글자수 제한
				var char_min = parseInt(0); //최소
				var char_max = parseInt(0); //최대
			</script>
			<section class="User-Coment101">
				<h4>
					<i class="fa fa-coments" aria-hidden="true"></i> 댓글목록

				</h4>
				<p class="no-coments101">등록된 댓글이 없습니다.</p>

			</section>

			<div class="TextArea101">
				<textarea class="textArea101"></textarea>
				<button style="margin-left: 20px;">
					<a href="#" class="replyDelete101">댓글삭제</a>
				</button>
				<button style="margin-left: 10px;">
					<a href="#" class="replyModify101">댓글수정</a>
				</button>
				<button style="float: right">
					<a href="#" class="reply101">댓글작성</a>
				</button>
			</div>

			<div class="back-button101">
				<div class="back-inbutton101">
					<button>
						<a href="#" class="modify101">수정</a>
					</button>
					<button>
						<a href="#" class="delete101">삭제</a>
					</button>
					<button>
						<a href="#" class="back101">목록으로</a>
					</button>
				</div>

			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>해오름 공지사항</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container">
		<div class="Content-container102">
			<div class="Header-container102">
				<h3 class="introduction102">
					<img src="images/title.PNG"> 공지사항
				</h3>
			</div>

			<div class="Content-containerB102">
				<div class="BoardList">
					<table class="table table-striped" id="dsds102">
						<thead>
							<tr>
								<th style="text-align: center">번호</th>
								<th style="text-align: center">제목</th>
								<th style="text-align: center">작성자</th>
								<th style="text-align: center">날짜</th>
								<th style="text-align: center">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${list }">
								<tr>
									<td>${list.num }</td>
									<td>${list.title }</td>
									<td>${list.userId }</td>
									<td>${list.time }</td>
									<td>${list.hits }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr>
					<div class="text-center">
						<ul class="pagination">
							<li><a href="#">1</a></li>
						</ul>
					</div>
					<div class="Make-Button102">
						<form action="./DrawUp.do">
							<input type="hidden" name="board" value="0"> <input
								type="submit" class="Make102" value="글쓰기">
						</form>
					</div>
				</div>
			</div>

			<fieldset class="Search-container102">
				<select class="FormList102">
					<option value="subject">제목</option>
					<option value="content">내용</option>
					<option value="subject+content">제목+내용</option>
					<option value="Maker">작성자</option>
				</select> <input type="text" class="Search-bar102" maxlength="20"
					placeholder="검색어">
				<button type="submit" class="Search-button102">검색</button>
			</fieldset>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
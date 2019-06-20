<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script type="text/javascript">
	function page(idx){
		var pagenum = idx;           
		location.href="${pageContext.request.contextPath}/Notice.do?pageNum="+pagenum+"&board=0";    
}
</script>
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
								<th style="text-align: center">작성자</th>
								<th style="text-align: center">제목</th>
								<th style="text-align: center">날짜</th>
								<th style="text-align: center">조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${list }">
								<tr style="cursor:pointer" onclick="location.href='./NoticeInquiry.do?id=${list.getId() }'">
									<td style="width: 10%">${list.getId() }</td>
									<td style="width: 10%">${list.getUserId() }</td>
									<td style="width: 50%">${list.getTitle() }</td>
									<td style="width: 20%">${list.getTime() }</td>
									<td style="width: 10%">${list.getHits() }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr>
					<div class="text-center">
						<ul class="pagination">
							<c:if test="${page.isPrev() }">
								<li><a href='javascript:void(0);'
									onclick="page(${page.getStartPage()-1});">&laquo;</a>
							</c:if>
							<c:forEach begin="${page.getStartPage()}"
								end="${page.getEndPage()}" var="idx">
								<li><a href='javascript:void(0);' onclick="page(${idx});">${idx }</a></li>
							</c:forEach>
							<c:if test="${page.isNext() }">
								<li><a href='javascript:void(0);'
									onclick="page(${page.getEndPage()+1});">&raquo;</a>
							</c:if>
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
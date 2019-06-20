<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width" initial-scale="1">
<title>해오름 ENG</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
</head>

<body>

	<section class="User-Coment101">
		<!--<h4>
			<i class="fa fa-coments" aria-hidden="true"></i> 댓글목록
			<table class="table table-striped" id="dsds102">
				<c:forEach var="comment" items="${requestScope.commentList}">
					<tr>
						<td width="150">
							<div>
								${comment.id}<br> <font size="2" color="lightgray">$comment.time</font>
							</div>
						</td>
					</tr>

				</c:forEach>
			</table>
		</h4>  -->
		<p class="no-coments101">등록된 댓글이 없습니다.</p>

	</section>
<%
int postid = (int) request.getAttribute("id");
System.out.println(postid);
%>
	<form class="TextArea101" action="./CommentRegister.do" method="post">
		<textarea class="textArea101"></textarea>
		<button style="margin-left: 20px;">
			<a href="#" class="replyDelete101">댓글삭제</a>
		</button>
		<button style="margin-left: 10px;">
			<a href="#" class="replyModify101">댓글수정</a>
		</button>
		<input type="hidden" name="postid" value=${postid }>
		<button style="float: right" onclick="this.parentNode.submit(); return false;">댓글작성
		</button>
	</form>

	</div>
</body>
</html>
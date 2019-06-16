<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" ,initial-scale="1">
<title>메인 페이지</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
</head>

<body>
	<header>
		<nav class="topbar">
			<div class="container">
				<%
					// 인증된 세션이 없는경우, 해당페이지를 볼 수 없게 함.
					String id = (String) session.getAttribute("id");
					if (id == null || id.equals("")) {
				%>
				<form action="./Login.do">
					<input type="submit" class="button btn-right" value="로그인">
				</form>
				<%
					} else {
				%>
				<form action="./UserLogoutCommand.do">
					<input type="submit" class="button btn-right" value="로그아웃">
				</form>
				<%
					}
				%>
			</div>
		</nav>

		<div class="mainbar">
			<div class="container">
				<div class="wrapper">
					<div class="brand">
						<a href="./Main.jsp"> <img src="images/LogoText.png"
							alt="해오름이엔지">
						</a>
					</div>
					<div class="phone-wrapper">
						<div class="phone">
							☎ 전화문의 : <span>010-1234-5678</span>
						</div>
					</div>
				</div>
			</div>
		</div>

		<nav class="navbar">
			<div class="container">
				<div class="navbarInner">
					<ul class="navbarUl">
						<li><a href="./Main.jsp">홈</a></li>
						<li><a href="./Introduce.jsp">사업 소개</a></li>
						<li><a href="./Business.jsp">주요 업무</a></li>
						<li><a href="gallery.html">사업 실적</a></li>
						<li><a href="Counsel.html">고객상담실</a></li>
						<li>
							<form id="ntc" action="./NoticeListCommand.do" method="post">
								<a href=# onclick="this.parentNode.submit(); return false;">공지사항</a>
							</form>
						</li>
						<li><a href="./WayCome.jsp">찾아오시는 길</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<script src="js/main.js"></script>
</body>
</html>
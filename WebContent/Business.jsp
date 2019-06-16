<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<title>Insert Title Here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<%@include file="header.jsp"%>

	<div class="content">
		<div class="container">
			<div class="panel panel-mainbusiness">
				<h2 class="panel-heading">
					<span class="glyphicon glyphicon-briefcase"></span>&nbsp;&nbsp;주요
					업무
				</h2>
				<hr>
				<div class="row">
					<div class="col-xs-6">
						<div class="panel panel-destruction">
							<div class="panel-heading">
								<h3 class="panel-heading">
									<span class="glyphicon glyphicon-remove"></span> &nbsp;&nbsp;철거
								</h3>
							</div>
							<div class="panel-body">
								<div class="media">
									<div class="media-top">
										<a href="#"> <img class="media-object" src="images/철거.jpg"
											width='500' height='375' alt="개발자 이미지">
										</a>
									</div>
									<div class="media-body">
										<br>
										<h4 class="media-heading">&nbsp;&nbsp;철거 전문</h4>
										<br> &nbsp;고객님들을 위해서 <strong>안전하게</strong> 철거해드립니다.
									</div>
								</div>
							</div>
						</div>
						<table class="table table-destruction">

							<tbody>
								<tr>
									<td>주택, 상가, 사무실, 학원철거</td>
								</tr>
								<tr>
									<td>건물공사 철거 및 철구조물 해체</td>
								</tr>
								<tr>
									<td>건물내부 인테리어 및 석면 철거</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="col-xs-6">
						<div class="panel panel-disposal">
							<div class="panel-heading">
								<h3 class="panel-heading">
									<span class="glyphicon glyphicon-home"></span> &nbsp;&nbsp;판넬공사
								</h3>
							</div>
							<div class="panel-body">
								<div class="media">
									<div class="media-top">
										<a href="#"> <img class="media-object" src="images/저장.jpg"
											width='500' height='375' alt="개발자 이미지">
										</a>
									</div>
									<div class="media-body">
										<br>
										<h4 class="media-heading">&nbsp;&nbsp;판넬 공사 전문</h4>
										<br> &nbsp;고객님들을 위해서 <strong>깔끔하게</strong> 만들어 드립니다.
									</div>
								</div>
							</div>
						</div>
						<table class="table table-destruction">

							<tbody>
								<tr>
									<td>조립식 판넬 집 시공</td>
								</tr>
								<tr>
									<td>창고 판넬 공사</td>
								</tr>
								<tr>
									<td>공장 내부 판넬 시공</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>
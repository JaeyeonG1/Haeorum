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
			<div class="article">
				<div class="articleHead">
					<span class="articleTitle">&nbsp;&nbsp;찾아오시는 길</span>
				</div>
				<div class="articleBody">
					<div class="splitNone">
						<p>&nbsp;&nbsp;&nbsp;주소 : 경상북도 구미시 상모사곡동 572-3</p>
						<div class="mapContainer">
							<iframe
								src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d3223.9113491511075!2d128.355788!3d36.095649!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3565c0e3b21850e1%3A0x63074fa3b00f2728!2z6rK97IOB67aB64-EIOq1rOuvuOyLnCDsg4Hrqqjsgqzqs6Hrj5kgNTcyLTM!5e0!3m2!1sko!2skr!4v1559230213363!5m2!1sko!2skr"
								width="1100" height="350" frameborder="0" style="border: 0"
								allowfullscreen></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="footer.jsp"%>
</body>
</html>
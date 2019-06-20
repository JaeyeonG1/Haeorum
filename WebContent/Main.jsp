<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	
	<div class="content">
		<div class="container">
			<div id="sliderWrapper">
				<ul id="slider">
					<li><img src="images/main_img1.jpg"></li>
					<li><img src="images/main_img2.jpg"></li>
					<li><img src="images/main_img3.jpg"></li>
				</ul>
				<div class="sliderBtns" id="next">
					<span>▶</span>
				</div>
				<div class="sliderBtns" id="previous">
					<span>◀</span>
				</div>
				<div id="sliderPagination">
					<ul>
					</ul>
				</div>
			</div>
		</div>
		<br>
		<section class="container">
			<div class="split20">
				<div class="imageCont">
					<img src="images/1.png" width="80px">
				</div>
				<h1 class="siteName" style="font-size: 15px; font-weight: bold;">해오름이엔지</h1>
				<p class="siteDescription"
					style="font-size: 13px; font-weight: 500;">철거/판넬 공사</p>
			</div>
			<div class="split80">
				<div class="siteEmphasize">
					<span>구미시 근방 및 경상북도 전역 문의주시면 누구보다 더 빠르고 신속하게 처리하겠습니다!<br>
						철거/판넬 공사 전문 문의 010-1234-5678
					</span>
				</div>
			</div>
		</section>
		<section class="container">
			<div class="incontainer">
				<div class="splitNone">
					<div class="pannel">
						<div class="pannelHead">
							<h3 class="pannelTitle">최근사업실적</h3>
							<div class="pannelMore">
								<a href="#">더보기</a>
							</div>
						</div>
						<div class="pannelBody">
							<div class="pannelContent">
								<div class="splitSeven">
									<img src="images/1.jpg" width="100%">
								</div>
								<div class="splitSeven">
									<img src="images/2.jpg" width="100%">
								</div>
								<div class="splitSeven">
									<img src="images/3.jpg" width="100%">
								</div>
								<div class="splitSeven">
									<img src="images/4.jpg" width="100%">
								</div>
								<div class="splitSeven">
									<img src="images/5.jpg" width="100%">
								</div>
								<div class="splitSeven">
									<img src="images/6.jpg" width="100%">
								</div>
								<div class="splitSeven">
									<img src="images/7.jpg" width="100%">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>

	<section class="container">
		<div class="splitFour">
			<div class="borderer">
				<img src="images/main_bn1.jpg" width="100%" height="100%">
			</div>
		</div>
		<div class="splitFour">
			<div class="borderer">
				<img src="images/main_bn2.png" width="100%" height="100%">
			</div>
		</div>
		<div class="splitFour">
			<div class="borderer">
				<img src="images/main_bn3.jpg" width="100%" height="100%">
			</div>
		</div>
		<div class="splitFour">
			<div class="borderer">
				<img src="images/main_bn4.jpg" width="100%" height="100%"
					usemap="#main_bn4.jpg">
				<map name="main_bn4.jpg">
					<area shape="rect" coords="0,0,135,78" href="Introduce.html"
						target="_self">
					<area shape="rect" coords="139,0,363,78" href="business.html"
						target="_self">
					<area shape="rect" coords="0,82,135,155" href="Counsel.html"
						target="_self">
					<area shape="rect" coords="139,82,363,155" href="WayCome.html"
						target="_self">
				</map>
			</div>
		</div>
	</section>
	<%@include file="footer.jsp"%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<title>회원가입</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/main.css">
<script src="js/registerForm.js"></script>
</head>

<body>
	<jsp:include page="header.jsp" flush="false"/>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-12">
								<a href="#" class="active" id="register-form-link">회원가입</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="register-form" method="post" role="form"
									style="display: block;">
									<div class="form-group">
										<input type="text" name="userid" id="userid" tabindex="1"
											class="form-control" placeholder="아이디" value="">
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password"
											tabindex="2" class="form-control" placeholder="비밀번호">
									</div>
									<div class="form-group">
										<input type="password" name="confirm_password"
											id="confirm_password" tabindex="3" class="form-control"
											placeholder="비밀번호확인">
									</div>
									<div class="form-group">
										<input type="email" name="email" id="email" tabindex="4"
											class="form-control" placeholder="이메일" value="">
									</div>
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="5"
											class="form-control" placeholder="성명">
									</div>
									<div class="form-group">
										<input type="tel" name="tel" id="tel" tabindex="6"
											class="form-control" placeholder="연락처" autocomplete="off">
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit"
													id="register-submit" tabindex="7"
													class="form-control btn btn-register" value="회원가입"
													onclick="validate()">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="false"/>
</body>

</html>
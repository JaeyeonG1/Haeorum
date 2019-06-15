// $(function() {

//     $('#login-form-link').click(function(e) {
// 		$("#login-form").delay(100).fadeIn(100);
//  		$("#register-form").fadeOut(100);
// 		$('#register-form-link').removeClass('active');
// 		$(this).addClass('active');
// 		e.preventDefault();
// 	});
// 	$('#register-form-link').click(function(e) {
// 		$("#register-form").delay(100).fadeIn(100);
//  		$("#login-form").fadeOut(100);
// 		$('#login-form-link').removeClass('active');
// 		$(this).addClass('active');
// 		e.preventDefault();
// 	});

// });

function validate() {
	var re = /^[a-z][a-z\d]{3,11}$/ //아이디와 패스워드가 적합한지 검사할 정규식
	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 이메일이 적합한지 검사할 정규식
	var re3 = /^[가-힣]{2,5}/; //이름이 한글2~5자리인지 검사할 정규식
	var re4 = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/; //휴대폰번호 
	var re5 = /^[a-zA-Z0-9가-힣]{4,12}/;

	var userid = document.getElementById("userid");
	var pwd1 = document.getElementById("password");
	var confirm_password = document.getElementById("confirm_password");
	var email = document.getElementById("email");
	var username = document.getElementById("username");
	var birth = document.getElementById("birth");

	if (!check(re, userid, "아이디는 4~12자의 영문 대소문자와 숫자로만 입력해야만 합니다.")) {
		return false;
	}
	if (!check(re, pwd1, "비밀번호는 4~12자의 영문 대소문자와 숫자로만 입력해야만 합니다.")) {
		return false;
	}
	if (pwd1.value != confirm_password.value) {
		alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
		confirm_password.value = "";
		confirm_password.focus();
		return false;
	}
	if (email.value == "") {
		alert("이메일을 입력해 주세요");
		email.focus();
		return false;
	}
	if (username.value == "") {
		alert("이름을 입력해 주세요");
		username.focus();
		return false;
	}

	if (!check(re3, username, "이름은 2~5자 한글입니다")) {
		return false;
	}
	if (!check(re4, tel, "휴대폰번호를 제대로 작성해주십시오")) {
		return false;
	}

	if (!check(re2, email, "적합하지 않은 이메일 형식입니다.")) {
		return false;
	}
	else alert("회원가입이 완료되었습니다.");

}

function check(re, what, message) {
	if (re.test(what.value)) {
		return true;
	}
	alert(message);
	what.value = "";
	what.focus();
	//return false;
}


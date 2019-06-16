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
  <div class="container">
        <div class="Content-container104">
            <div class="Header-container104">
                <h3 class="introduction104">
                    <img src="images/title.PNG">
                    고객상담실
                </h3>
            </div>
            <div class="Write-Info104" style="padding-left:20px; padding-right:20px;">
                <h4 class="subject104">
                    안녕하십니까
                </h4>
                <div class="desc104">
                    작성자:
                    <i class="fa fa-user" id="descZ104" title="회원">
                        <strong class="who">관리자</strong>
                        님
                        <br>
                        작성일시:
                        <span class="sound_only">작성일</span>
                        <strong>2019-05-14 08:27:35</strong>
                        &nbsp;&nbsp;&nbsp;
                    </i>
                </div>
            </div>
            <section class="Admin-Content104" style="font-size:15px">
                안녕하십니까
                <br>
                완벽공사
                <br>
                ㅋㅋㅋㅋㅋ
                <br>
                ㅎㅎㅎㅎㅎㅎㅎㅎㅎ
                <br>
                ㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ
                <br>
                ................
                <br>
                ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
                <br>
            </section>
            <script>
                //글자수 제한
                var char_min = parseInt(0); //최소
                var char_max = parseInt(0); //최대
            </script>
            <section class="User-Coment104">
                <h4>
                    <i class="fa fa-coments" aria-hidden="true"></i>
                    댓글목록
                    
                </h4>
                <p class="no-coments104">등록된 댓글이 없습니다.</p>
            </section>
            <div class="TextArea104">
                <textarea class="textArea104"></textarea>
                <button style="margin-left: 20px;"><a href="#" class="replyDelete104" >댓글삭제</a></button>
                <button style="margin-left: 10px;"><a href="#" class="replyModify104" >댓글수정</a></button>
                <button style="float:right"><a href="#" class="reply104">댓글작성</a></button>
            </div>

            <div class="back-button104">
                <div class="back-inbutton104">
                    <button><a href="#" class="modify104">수정</a></button>
                    <button><a href="#" class="delete104">삭제</a></button>
                    <button><a href="#" class="back104" >목록으로</a></button>
                </div>
            </div>
        </div>
    </div>
   <%@include file="footer.jsp"%>
</body>
</html>




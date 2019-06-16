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
        <div class="Content-container">
            <div class="Header-container">
                <h3 class="introduction">
                    <img src="images/title.PNG">
                    글쓰기
                </h3>
            </div>

            <div class="Content-container2">  
                <div class="Info5">
                    <label class="Info_Title">제목</label>
                    <input type="text" class="Title_content" maxlength="255" placeholder="제목을 입력해주세요">
                </div>

                <div class="Text_Area-container">
                    <textarea class="Text_Area" maxlength="65536"></textarea>
                </div>

                <div class="File-container">
                    <div class="File1">
                        <label class="File_1">파일#1</label>
                        <input type="text" class="File1_content" placeholder="1,048,576 바이트 이하의 파일만 업로드 가능" readonly>
                        <button class="File1_button">파일선택</button>
                    </div>
                    <div class="File2">
                        <label class="File_2">파일#2</label>
                        <input type="text" class="File2_content" placeholder="1,048,576 바이트 이하의 파일만 업로드 가능" readonly>
                        <button class="File2_button">파일선택</button>
                    </div>
                </div>
                <div class="Random_Number-container"></div>
            </div>
            <hr>
            <div class="Button-container">
                <button style="padding-bottom: 6px;padding-top: 6px;padding-left: 20px; padding-right: 20px;">
                    <a href="javascript:history.back()" class="back_button">취소</a></button>
                <input type="submit" class="Complete_button" value="작성완료">
            </div>
        </div>
    </div>
   <%@include file="footer.jsp"%>
</body>
</html>
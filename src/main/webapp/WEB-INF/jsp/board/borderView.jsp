<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <title>Document</title>
    <style>
        .mytable
        {
            border: 1px solid black;
            width: 800px;
            margin:50px auto 0px auto;
        }
        
        .mytable .td1
        {
            width:100px;
        }
        .mytable .td2
        {
            width:700px;
        }
        .mytable .td3
        {
            vertical-align: 0px;
        }
        .mytable .td4
        {
            text-align: right;
        }

        .mytable .mytextarea
        {
            height:500px;
            resize: none;
        }
    </style>
</head>
<body>
    <table class="mytable">
        <tr>
            <td class="td1">작성자</td>
            <td class="td2">${resultList[0].NICKNAME}</td>
        </tr>
        <tr>
            <td class="td1">제목</td>
            <td><input type="text" class="td2" name="title" readonly value="${resultList[0].TITLE}"></td>
        </tr>
        <tr>
            <td class="td1 td3">내용</td>
            <td><textarea class="td2 mytextarea" name="mytextarea" readonly>${resultList[0].BORDERTEXT}</textarea></td>
        </tr>
        <tr>
            <td class="td1 td3">파일</td>
            <!-- 파일 다운로드를 원할경우 링크형식으로 변경 (javascript로 파일존재시만 링크주기 등등 제어가능)-->
            <!-- <td><a href="${resultList[0].FILEURL}">파일 다운로드</a></td> -->
            <td><img src="${resultList[0].FILEURL}"></td>
        </tr>
        <tr>
            <td colspan="2" class="td4">
            <!-- javascript로 사용자에게 안보여지게 처리필요. -->
                <input type="button" value="수정" name="userBtn" onClick="editDo()">
                <input type="button" value="삭제" name="userBtn" onClick="removeDo()">
                <a href="borderReply.do?no=${resultList[0].BORDERID}"><input type="button" value="답글"></a>
                <a href="borderList.do"><input type="button" value="목록보기"></a>
            </td>
        </tr>
    </table>
</body>
<script type="text/javascript">

var userId = "${userId}";
var nickName = "${resultList[0].NICKNAME}";

$(document).ready(function () {
	console.log("document ready!");
	init();
});

function init(){
	console.log("userId = " + userId);
	console.log("nickName = " + nickName);
	if(userId == "" || userId == null || userId != nickName){
		$("input[name='userBtn']").hide();	
	} else {
		console.log("버튼 숨길필요없음");	
	}
}

function editDo(){
	console.log("editDo 실행");
	location.href="borderEdit.do?no=${resultList[0].BORDERID}";
}

function removeDo(){
	console.log("removeDo 실행");
	location.href="borderRemove.do?no=${resultList[0].BORDERID}";
}

</script>
</html>

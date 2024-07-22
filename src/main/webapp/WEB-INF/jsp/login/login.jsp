<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> <!-- lang="en" -->
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Login</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
    <script src="<%=request.getContextPath() %>/jquery/jquery-1.12.4.min.js"></script>
    <%-- <%=request.getContextPath() %> --%> 
    <!-- 경로값인 /Egov_WEB를 담고 있음. -->
</head>
<body>
	<!-- 로그인 "loginSubmission.do" 프로시저 테스트 "prcd.do" -->
	<!-- 1-1강 로그인 파트 -->
	<!-- 
	<form action="loginSubmission.do" method="post">
		<input type="text" name="id">
		<input type="password" name="pw">
		<input type="submit" value="제출">
	</form> 
	-->
	<div>${userId}</div><br />
	<div>${userPw}</div><br />
	<div class="login">
		<div class="login_left">
            <img src="<%=request.getContextPath() %>/images/lefimg.jpg" class="img1">
        </div>
        <div class="login_right">
        	<form name="LoginForm" id="LoginForm" class="LoginForm" action="submitLogin.do" method="post">
        		<div><span style="color:green;"> RVT 108 </span></div>
        		<div style="height: 20px;"></div>
        		<div>
        			아이디
        		</div>
        		<input type="text" id="userId" name="userId" placeholder="아이디"  autocomplete="off" onkeyup="chkCharCode(event)"/><br/>
        		<span id="warnning" style="font-size:9pt; color:red;"></span>
        		<div>
        			비밀번호
    			</div>
    			<input type="password" id="userPw" name="userPw" placeholder="비밀번호"  autocomplete="off"/>
        		<div class="captchamargin1"></div> <!-- 뭐지???? -->
       			<!-- <img src="/River_WEB/captcha.do" class="captchaimg" alt="캡차 이미지" title="클릭시 새로고침"/> -->
       			<input type="text" id="captcha" class="captchatxt" name="captcha" placeholder="위에있는 글자를 입력해주세요" autocomplete="off"/>
            	<div class="captchamargin2"></div>
            	<input type="button" value="로그인" id="loginbtn" disabled onClick="loginClick()">
            	<!-- 추후 자동로그인 개발? -->
            	<div style="height: 20px;"></div>
            	<div style="font-size:11pt;">
            		<a href="" class="login_right_a">아이디찾기</a> / 
            		<a href="" class="login_right_a">비밀번호찾기</a>&nbsp;&nbsp;
            		<a href="<%=request.getContextPath() %>/usercondition.do" class="login_right_a">
            			회원가입
            		</a>
           		</div>
        		
        	</form>
        </div>
        	
	</div>
</body>
<script type="text/javascript">

$(document).ready(function(){ // $(function(){
	
	$("#userId, #userPw").on("keyup", checkEmpty);
	init();
}); 

/* 페이지 로드 */
function init(){
	console.log("테스트");
};

/* 로그인 클릭 */
function loginClick(){
	console.log("클릭");
	var userId = document.getElementById("userId").value; // $("#userId").val();
	var userPw = document.getElementById("userPw").value; // $("#userPw").val();
	
	if(!validation(userId, userPw)){
		console.log("로그인막힘");
		return;
	} else {
		console.log("로그인통과");
	}
	alert("로그인됐습니다.");
	console.log("로그인됐습니다.");
	$("form#LoginForm").submit(); // loginsubmit.do 호출
	
	
	
}

/* 유효성 체크 */
function validation(id, pw){
	//var warnText = ""; //"로그인 눌렀을때 보여줄 경고문" // 아이디가 틀렸습니다. 비밀번호가 틀렸습니다. 해당 계정은 없는 계정입니다.
	if(id.length > 20){ 
		$("#userId").css("border-color", "red");
		$("#warnning").text("아이디를 10자 이내로 입력해주세요.");
		return false;
	} else if(pw.length > 20){
		$("#userPw").css("border-color", "red");
		$("#warnning").text("비밀번호를 10자 이내로 입력해주세요.");
		return false;
	} else {
		return true;
	}	
}


/* 로그인버튼 비활성화 체크 */
function checkEmpty(){
	// 입력 시에는 경고문 초기화
	$("#warnning").text(""); 
	$("#userId, #userPw").removeAttr("style"); // .css("border-color", "initial"); // 처음상태로 돌려놓음
	var idLength = $("#userId").val().length;
	var pwLength = $("#userPw").val().length;
	
	if(idLength == 0 || pwLength == 0){
		$("#loginbtn").prop("disabled", true);	
	} else {
		$("#loginbtn").prop("disabled", false);
	}
	
}

/* 한글 및 기호 입력 막기 */
function chkCharCode(event) {
  	const regExp = /[^0-9a-zA-Z]/g;
  	const ele = event.target;
  	if (regExp.test(ele.value)) {
    	ele.value = ele.value.replace(regExp, '');
  	}
};


</script>
</html>
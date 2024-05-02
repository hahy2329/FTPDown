<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	
	var isValidName = false; //ID관련 체크
	var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
	
	var isValidEmail = false; //이메일관련 체크
	
	var pattern1 = /[0-9]/;
    var pattern2 = /[a-zA-Z]/;
    var pattern3 = /[~!@\#$%<>^&*]/;
	
	$().ready(function(){
		
		$(document).on("click", "#btnOverlappedId", function(){
			
			$(".answer").empty();
			
			var name = $("#name").val();
			
			if(name == ''){ //아이디 빈칸 체크
				alert("ID를 입력해주세요.");
				$(".answer").append("<p style='color: red;'>" + "ID를 입력해 주세요." + "</p>");
				return;
			}
			if(name.length < 6 || name.length > 15){ //아이디가 6자리 이상 15자리 이하인지 체크
				alert("6자리 이상 15자리 이하로 입력해 주세요.");
				$(".answer").append("<p style='color: red;'>" + "6자리 이상 15자리 이하로 입력해주세요." + "</p>");
				return;
			}
			if(name.search(/\s/) != -1){ //아이디 공백 체크
				alert("공백은 허용할 수 없습니다.");
				$(".answer").append("<p style='color: red;'>" + "공백은 허용할 수 없습니다." + "</p>");
				return;
			}
			if(special_pattern.test(name) == true){
				alert("특수문자는 허용할 수 없습니다.");
				$(".answer").append("<p style='color: red;'>" + "특수문자는 사용할 수 없습니다." + "</p>");
				return;
			} //특수문자 체크
			
			$.ajax({
				type : "get",
				url : "${contextPath}/user/checkDuplicatedId?name=" + name,
				success : function(data){
					if(data == "notDuplicate"){
						$(".answer").empty();
						alert("사용할 수 있는 ID입니다.");
						$(".answer").append("<p style='color: green;'>" + "중복체크 완료" + "</p>");
						isValidName = true;
					}else{
						$(".answer").empty();
						alert("이미 존재하는 ID입니다.");
						$(".answer").append("<p style='color: red;'>" + "이미 존재하는 ID입니다." + "</p>")
						isValidName = false;
					}
				}	
			});		
		});
		
		$(document).on("click", "#btnOverlappedEmail", function(){
			$(".answer2").empty();
			
			var email = $("#email").val();
			
			if(email == ''){
				alert("이메일을 입력해 주세요.");
				$(".answer2").append("<p style='color: red;'>" + "이메일을 입력해 주세요." + "</p>");
				return;
			}
			if(email.length > 30){ //아이디가 6자리 이상 15자리 이하인지 체크
				alert("30자리 이하로 입력해 주세요.");
				$(".answer2").append("<p style='color: red;'>" + "30자리 이하로 입력해 주세요." + "</p>");
				return;
			}
			
			if(email.search(/\s/) != -1){ //아이디 공백 체크
				alert("공백은 허용할 수 없습니다.");
				$(".answer2").append("<p style='color: red;'>" + "공백은 허용할 수 없습니다." + "</p>");
				return;
			}
			
			$.ajax({
				type : "get",
				url : "${contextPath}/user/checkDuplicatedEmail?email=" + email,
				success : function(data){
					if(data == "notDuplicate"){
						$(".answer2").empty();
						alert("사용할 수 있는 이메일입니다.");
						$(".answer2").append("<p style='color: green;'>" + "중복체크 완료" + "</p>");
						isValidEmail = true;
					}else{
						$(".answer2").empty();
						alert("이미 등록된 이메일입니다.");
						$(".answer2").append("<p style='color: red;'>" + "이미 존재하는 이메일입니다." + "</p>")
						isValidEmail = false;
					}
				}	
			});
		});
		
		$("form").submit(function(){
			if(isValidId == false){
				alert("ID를 확인해 주세요.");
				return false;
			}
			if(isValidEmail == false){
				alert("이메일을 확인해 주세요.");
				return false;
			}
			if($("#password").val()==''){
				alert("패스워드를 입력해 주세요.");
				return false;
			}
			if(isValidId == true && isValidEmail == true){
				if($("#password").val() == $("#confirmPasswd").val()){
					if(!pattern1.test($("#password").val())||!pattern2.test($("#password").val())||!pattern3.test($("#password").val())||$("#password").val().length<8||$("#password").val().length>50){
						alert("영문+숫자+특수기호를 혼합한 8자리 이상으로 구성하여야 합니다.");
						return false;
					}else{
						return true;
					}					
				}else{
					alert("패스워드를 다시 확인해 주세요.");
					return false;
				}
			}
		});
	});

</script>
</head>
<body>
	<!-- Contact Start -->
        <div class="container-xxl py-6">
            <div class="container">
                <div class="mx-auto text-center wow fadeInUp" data-wow-delay="0.1s" style="max-width: 600px;">
                    <div class="d-inline-block border rounded-pill text-primary px-4 mb-3">FTPDown</div>
                    <h2 class="mb-5">유저 회원가입</h2>
                </div>
                <div class="row justify-content-center">
                    <div class="col-lg-7 wow fadeInUp" data-wow-delay="0.3s">
                        <form action="${contextPath }/user/register" method="post">
                            <div class="row g-3">
                                <div class="col-md-8">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="name" name="name" placeholder="Your Name" required="required">
                                        <label>아이디</label> <button type="button" id="btnOverlappedId" class="btn shadow-none position-absolute top-0 end-0 mt-1 me-2"><i class="fa fa-paper-plane text-primary fs-4"></i></button>
                                        <p class="answer"></p>
                                        <br>
                                    </div>
                                    <div class="form-floating">
                                        <input type="password" class="form-control" id="password" name="password" required="required">
                                        <label>비밀번호</label><br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="password" class="form-control" id="confirmPasswd" required="required">                    
                                        <label>비밀번호 재확인</label><br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="text" class="form-control" id="nickname" name="nickname" required="required">                    
                                        <label>닉네임</label><br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="email" class="form-control" id="email" name="email" required="required"> <button type="button" id="btnOverlappedEmail" class="btn shadow-none position-absolute top-0 end-0 mt-1 me-2"><i class="fa fa-paper-plane text-primary fs-4"></i></button>                    
                                        <label>이메일</label><br>
                                        <p class="answer2"></p>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="text" class="form-control" id="zipcode" name="zipcode" required="required">                    
                                        <label>우편번호</label> <button type="button" onclick="execDaumPostcode();" class="btn shadow-none position-absolute top-0 end-0 mt-1 me-2"><i class="fa fa-paper-plane text-primary fs-4"></i></button>
                                        <br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="text" class="form-control" id="roadAddress" name="roadAddress" required="required">                    
                                        <label>도로명 주소</label><br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="text" class="form-control" id="jibunAddress" name="jibunAddress" required="required">                    
                                        <label>지번 주소</label><br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="text" class="form-control" id="namujiAddress" name="namujiAddress" required="required">                    
                                        <label>나머지 주소</label><br>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button class="btn btn-primary w-100 py-3" type="submit">회원가입</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
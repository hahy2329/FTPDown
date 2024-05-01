<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Contact Start -->
        <div class="container-xxl py-6">
            <div class="container">
                <div class="mx-auto text-center wow fadeInUp" data-wow-delay="0.1s" style="max-width: 600px;">
                    <div class="d-inline-block border rounded-pill text-primary px-4 mb-3">FTPDown</div>
                    <h2 class="mb-5">회원가입</h2>
                </div>
                <div class="row justify-content-center">
                    <div class="col-lg-7 wow fadeInUp" data-wow-delay="0.3s">
                        <form>
                            <div class="row g-3">
                                <div class="col-md-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" id="name" name="name" placeholder="Your Name" required="required">
                                        <label>아이디</label> <button type="button" id="btnOverlapped" class="btn shadow-none position-absolute top-0 end-0 mt-1 me-2"><i class="fa fa-paper-plane text-primary fs-4"></i></button>
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
                                    	<input type="email" class="form-control" id="email" name="email" required="required">                    
                                        <label>이메일</label><br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="text" class="form-control" id="zipcode" name="zipcode" required="required">                    
                                        <label>우편번호</label> <button type="button" onclick="execDaumPostcode();" class="btn shadow-none position-absolute top-0 end-0 mt-1 me-2"><i class="fa fa-paper-plane text-primary fs-4"></i></button>
                                        <br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="email" class="form-control" id="roadAddress" name="roadAddress" required="required">                    
                                        <label>도로명 주소</label><br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="email" class="form-control" id="jibunAddress" name="jibunAddress" required="required">                    
                                        <label>지번 주소</label><br>
                                    </div>
                                    <div class="form-floating">
                                    	<input type="email" class="form-control" id="namujiAddress" name="namujiAddress" required="required">                    
                                        <label>나머지 주소</label><br>
                                    </div>
                                </div>
                                <div class="col-12">
                                    <button class="btn btn-primary w-100 py-3" type="submit">Send Message</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
</body>
</html>
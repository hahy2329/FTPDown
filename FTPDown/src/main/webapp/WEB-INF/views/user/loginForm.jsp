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
                    <div class="d-inline-block border rounded-pill text-primary px-4 mb-3">회원가입</div>
                    <h2 class="mb-5">저희 FTPDown 회원으로 등록해 주셔서 감사합니다.</h2>
                </div>
                <div class="row justify-content-center">
                    <div class="col-lg-7 wow fadeInUp" data-wow-delay="0.3s">
                        <p class="text-center mb-4">저희 FTPDown은 여러가지 파일을 공유할 수 있으며 필요한 자료는 제공받고, 공유하고 싶은 자료는 업로드하여 서로 공유하는 서비스입니다. </p>
                        <form>
                            <div class="row g-3">
                                <div class="col-6">
                                    <div class="form-floating">
                                        <input type="text" class="form-control" name="userId" id="userId" placeholder="Your Name">
                                        <label for="userId">Your ID</label> <input  type="button" class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5" id="btnOverlapped" value="중복확인">
                                    	<p class="answer"></p>
                                    </div>
                                	<br>
                                    <div class="form-floating">
                                        <input type="email" class="form-control" id="email" placeholder="Your Email">
                                        <label for="email">Your Email</label>
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
        <!-- Contact End -->
	
</body>
</html>
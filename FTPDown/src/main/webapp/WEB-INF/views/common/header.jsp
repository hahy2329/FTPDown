<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Navbar & Hero Start -->
        <div class="container-xxl position-relative p-0">
            <nav class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0">
                <a href="index.html" class="navbar-brand p-0">
                    <h1 class="m-0">FTPDown</h1>
                    <!-- <img src="img/logo.png" alt="Logo"> -->
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="fa fa-bars"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto py-0">
                        <a href="index.html" class="nav-item nav-link">Home</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">게시판</a>
                            <div class="dropdown-menu m-0">
                                <a href="feature.html" class="dropdown-item">공지사항</a>
                                <a href="quote.html" class="dropdown-item">자유게시판</a>
                                <a href="quote.html" class="dropdown-item">문의사항</a>
                            </div>
                        </div>
                        <a href="service.html" class="nav-item nav-link">고객지원</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">다운로드</a>
                            <div class="dropdown-menu m-0">
                                <a href="feature.html" class="dropdown-item">문서파일</a>
                                <a href="" class="dropdown-item">그림파일</a>
                                <a href="team.html" class="dropdown-item">실행파일</a>
                                <a href="testimonial.html" class="dropdown-item">기타</a>
                            </div>
                        </div>
                        <a href="contact.html" class="nav-item nav-link"></a>
                    </div>
                    <sec:authorize access="isAnonymous()">
                    	<a href="${contextPath }/user/loginForm.do" class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5">로그인</a>
                	</sec:authorize>
                	
                	<sec:authorize access="isAuthenticated()">
                		<form action="{contextPath}/user/logout" method="POST">
                			<input type="submit" value="로그아웃">
                		</form>
                	</sec:authorize>
                </div>
            </nav>

            <div class="container-xxl bg-primary page-header">
                <div class="container text-center">
                    <h1 class="text-white animated zoomIn mb-3">방문해 주셔서 감사합니다.</h1>
                </div>
            </div>
        </div>
</body>
</html>
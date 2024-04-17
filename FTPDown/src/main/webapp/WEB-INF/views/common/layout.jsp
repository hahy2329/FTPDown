<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <title>BizConsult - Consulting HTML Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="${contextPath }/resources/bizconsult-1.0.0/img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600&family=Inter:wght@700;800&display=swap" rel="stylesheet"> 

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="${contextPath }/resources/bizconsult-1.0.0/lib/animate/animate.min.css" rel="stylesheet">
    <link href="${contextPath }/resources/bizconsult-1.0.0/lib/bizconsult-1.0.0/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="${contextPath }/resources/bizconsult-1.0.0/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="${contextPath }/resources/bizconsult-1.0.0/css/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>

	<!-- Header Section Begin -->
		<tiles:insertAttribute name="header" />
	<!-- Header Section End -->
	
	<!-- Body Section Begin -->
		<tiles:insertAttribute name="body"/>
	<!-- Body Section End -->
	
	<!-- Footer Section Begin -->
		<tiles:insertAttribute name="footer"/>
	<!-- Footer Section End -->
	

	<!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="${contextPath }/resources/bizconsult-1.0.0/lib/wow/wow.min.js"></script>
    <script src="${contextPath }/resources/bizconsult-1.0.0/lib/easing/easing.min.js"></script>
    <script src="${contextPath }/resources/bizconsult-1.0.0/lib/waypoints/waypoints.min.js"></script>
    <script src="${contextPath }/resources/bizconsult-1.0.0/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Template Javascript -->
    <script src="${contextPath }/resources/bizconsult-1.0.0/js/main.js"></script>
</body>
</html>
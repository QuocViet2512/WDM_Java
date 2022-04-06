   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="HeaderPage.jsp"></jsp:include>
<!-- 404Error -->
    <img src='<c:url value ="./Resources/Image/404Error.png"></c:url>' class="four-0-four-image" alt="">
    <p class="four-0-four-msg">Ôi không !! Không tìm thấy trang <a href="index.html">Trở lại trang chủ</a></p>
    <jsp:include page="Footer.jsp"></jsp:include>
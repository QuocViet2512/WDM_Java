<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></c:url>"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"></script>
<script
	src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></c:url>"></script>


<title>Document</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css?family=Roboto');

body {
	font-family: 'Roboto', sans-serif;
}

* {
	margin: 0;
	padding: 0;
}
.container-wrap-full{
	width: 100%;
	height: auto;
	margin: 0 auto;
}
.top-name-inf {
	display: flex;
	height: 60px;
	width: 100%;
	background-color: rgba(0, 0, 0, 0.82);
	overflow: hidden;
	position: relative;
}

.top-name-inf .ul-ad {
	display: flex;
	column-gap: 1%;
	list-style: none;
	align-items: center;
	width: 60%;
	height: 99%;
	margin-left: 3%;
}

.top-name-inf .ul-ad li {
	padding: 5px;
	height: 100%;
	transition: border .1s, background .3s;
	display: flex;
	align-items: center;


}

.top-name-inf .ul-ad li a {
	font-size: 100%;
	text-decoration: none;
	color: white;
	font-family: sans-serif;
	font-weight: bold;
	min-width: fit-content;
}

.top-name-inf .ul-ad li:hover {
	border-bottom: solid;
	border-width: 5px;
	border-color: coral;
	
	
}

.top-name-inf .if-log {
	max-width: 40%;
	min-width: 30%;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	height: 100%;
	position: absolute;
	right: 0;
	top: 0;
	display: flex;
	align-items: center;
	margin-left: 5%;
}

.if-log .img-ad {
	width: 35px;
	height: 35px;
	border-radius: 50%;
	margin-right: 4%;
	background-color: aqua;
}

.if-log .h5-ad {
	color: aliceblue;
	font-family: sans-serif;
	margin-right: 80px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 100%;
	display: block;
}

.pop-log {
	width: 200px;
	height: 100px;
	display: none;
	z-index: 1;
	position: absolute;
	top: 52px;
	right: 22%;
	background-color: aliceblue;
	border-radius: 15px;
	transition: all .5s;
	overflow: hidden;
}

.pop-log .wrap-log {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	row-gap: 5px;
}

.pop-log .wrap-log .btn-op {
	width: 80%;
	height: 40px;
	border-radius: 10px;
	background-color: cadetblue;
	font-weight: bold;
	font-family: sans-serif;
	border: none;
}

.pop-log .wrap-log .btn-op:last-child {
	background-color: salmon;
}

.title-op {
	display: block;
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	margin: 10px;
	color: black;
}
</style>
<body>
	<div class = "container-wrap-full">
		<nav class="top-name-inf">
			<ul class="ul-ad">
				<li><a href="../admin/prdad">Sản phẩm</a></li>
				<li><a href="../admin/catead">Loại sản phẩm</a></li>
				<li><a href="../admin/billad">Đơn hàng</a></li>
				<li><a>Tài khoản</a></li>
				<li><a>Hãng sản xuất</a></li>
				<li><a href="../admin/billcplad">Thống kê</a></li>

			</ul>
			<div class="if-log">
				<img class="img-ad"
					src="https://img.icons8.com/external-flaticons-flat-flat-icons/344/external-user-web-flaticons-flat-flat-icons-2.png"
					onclick="ocllog()" />
				<h5 class="h5-ad">xin chao:<span style="margin-left: 10px">${AccAD.getTenNV()}</span></h5>
			</div>

		</nav>

		<div class="pop-log" id="log">
			<div class="wrap-log">
				<button onclick="Logout()" class="btn-op">Đăng xuất</button>
				<button class="btn-op" onclick="close_log()">Đóng</button>
			</div>
		</div>
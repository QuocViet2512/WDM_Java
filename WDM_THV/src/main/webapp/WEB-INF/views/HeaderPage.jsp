<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>THVLShop</title>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="<c:url value="/Resources/Content/style.css"></c:url>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/Resources/Content/LoginStyle.css"></c:url>" />

<!-- FONT AWESOME -->
<link rel="stylesheet" type="text/css" href="<c:url value="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"></c:url>" />
<link rel="stylesheet" type="text/css" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></c:url>" />

<link rel="stylesheet" type="text/css" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"></c:url>"/>

<link rel="stylesheet" type="text/css" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css" ></c:url>" />


<script src="<c:url value="/Resources/Javascript/PageSupport.js"></c:url>"></script>

<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></c:url>"></script>

<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></c:url>"></script>
<script src="<c:url value="/Resources/Javascript/main.js"></c:url>"></script>
<script src="<c:url value="/Resources/Javascript/LoginJS.js"></c:url>"></script>
<script type="text/javascript">
function getcart(){
	if(sessionStorage.getItem("emailKH")!=null){
		location.href = "./cartpage";	
	}
	else{
		showlogin();
		return ;
	}
	
}


</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-3">
				<div class="header_logo">
					<a href="./index"><span>THVL</span>Shop</a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header_menu">
					<ul>
						<li class="active"><a href="./index">Trang chủ</a></li>
						<li><a href="./listproduct">Sản phẩm</a></li>
						<li><a href="./index">Về chúng tôi</a></li>
						<li><a href="./index">Tin tức</a></li>
						<li><a href="./index">Liên hệ</a></li>
						<li><a href="./index">Đánh giá</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header_right">
					<div class="header_right_auth" style="display: flex;">
						<a onclick="showlogin()" id="login" href="#"><i
							class="fa fa-user-circle-o"></i></a> 
							
							
							<a onclick="logout()" id="logout" style="display: none"><i
							class="fa fa-sign-out"></i></a> 
							
							
							<a onclick="getcart()"><i
							class="fa fa-shopping-cart"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
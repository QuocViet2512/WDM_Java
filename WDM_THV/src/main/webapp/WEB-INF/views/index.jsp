<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="HeaderPage.jsp"></jsp:include>
<!-- Category -->
<style>
.home .home-banner-1, .home .home-banner-2, .home .home-banner-3 {
	background-repeat: no-repeat;
	background-size: cover;
	background-position: center;
	min-height: 650px;
	position: relative;
}

.home .home-banner-1 {
	background-image: url('./Resources/Image/Banner01.jpg');
}

.home .home-banner-2 {
	background-image: url('./Resources/Image/Banner02.jpg');
}

.home .home-banner-3 {
	background-image: url('./Resources/Image/Banner03.jpg');
}

.home .home-banner .home-banner-text {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-110%, -50%);
}

.home .home-banner .home-banner-text h1 {
	font-size: 6rem;
}

.home .carousel-control-next-icon, .home .carousel-control-prev-icon {
	background: transparent;
}

.bot-page {
	width: 100%;
	height: 30px;
	display: flex;
	justify-content: center;
	column-gap: 10px;
	
}

.but-page {
	min-width: 30px;
	width: fit-content;
	border: 1px solid rgb(98, 166, 233);
	border-radius: 10px;
	background-color: aliceblue;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
}

</style>
<section id="home" class="home overflow-hidden">
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<div class="home-banner home-banner-1">
					<div class="home-banner-text">
						<h1>Tủ lạnh</h1>
						<h2>Giảm thêm 2 triệu</h2>
						<a href="#" class="btn btn-danger text-uppercase mt-4">Xem
							ngay</a>
					</div>
				</div>
			</div>
			<div class="carousel-item">
				<div class="home-banner home-banner-2">
					<div class="home-banner-text">
						<h1>Máy giặt</h1>
						<h2>Giảm đến 50%</h2>
						<a href="#" class="btn btn-danger text-uppercase mt-4">Xem
							ngay</a>
					</div>
				</div>
			</div>
			<div class="carousel-item">
				<div class="home-banner home-banner-3">
					<div class="home-banner-text">
						<h1>Tivi</h1>
						<h2>Trải nghiệm đỉnh cao</h2>
						<a href="#" class="btn btn-danger text-uppercase mt-4">Xem
							ngay</a>
					</div>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"> <span
				class="ti-angle-left slider-icon"></span>
		</span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"> <span
				class="ti-angle-right slider-icon"></span>
		</span> <span class="sr-only">Next</span>
		</a>
	</div>
</section>


<!-- Product -->
<section class="product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="section-title">
					<h4>Sản phẩm nổi bật</h4>
				</div>
			</div>
		</div>
		<div class="row property_gallery" id="product-show"
			onload="LoadProduct()">
			<!--item-->

			<!--end item-->
		</div>
		<div id="bot-page" class="bot-page">
	
		</div>
	</div>
</section>



<!-- Discount -->
<section class="discount spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 p-0">
				<div class="discount_pic">
					<img src="<c:url value="/Resources/Image/discount.jpg"></c:url>"
						class="img-fluid" />
				</div>
			</div>
			<div class="col-lg-6 p-0">
				<div class="discount_text">
					<div class="discount_text_title">
						<span>Giảm giá</span>
						<h2>Mùa xuân 2022</h2>
						<h5>
							<span>Giảm đến</span> 50%
						</h5>
					</div>
					<div class="discount_countdown">
						<div class="countdown_item">
							<span>122</span>
							<p>ngày</p>
						</div>
						<div class="countdown_item">
							<span>18</span>
							<p>giờ</p>
						</div>
						<div class="countdown_item">
							<span>46</span>
							<p>phút</p>
						</div>
						<div class="countdown_item">
							<span>05</span>
							<p>giây</p>
						</div>
					</div>
					<a href="#">Mua ngay</a>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- shop-method -->
<section class="shop-method-area spad">
	<div class="container">
		<div class="row d-flex justify-content-between">
			<div class="col-lg-3 col-md-6 col-sm-12">
				<div class="single-method mb-40">
					<i class="fa fa-shopping-bag"></i>
					<h6>Giao hàng toàn quốc</h6>
					<p>Siêu thị Điện máy Xanh mua sắm thiết bị điện tử điện lạnh,
						gia dụng, sản phẩm công nghệ. Mua online tại thvlshop.com giá tốt
						phục vụ chuyên nghiệp tận nhà.</p>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12">
				<div class="single-method mb-40">
					<i class="fa fa-lock"></i>
					<h6>Bảo mật thông tin</h6>
					<p>Bảo mật thông tin khách hàng chính là đảm bảo những thông
						trên luôn được lưu trữ và sử dụng an toàn trong nội bộ doanh
						nghiệp theo như đúng cam kết đã thực hiện.</p>
				</div>
			</div>
			<div class="col-lg-3 col-md-6 col-sm-12">
				<div class="single-method mb-40">
					<i class="fa fa-comments"></i>
					<h6>Chăm sóc khách hàng</h6>
					<p>Trả lời cuộc gọi một cách chuyên nghiệp, cung cấp thông tin
						về sản phẩm và dịch vụ theo yêu cầu của khách</p>
				</div>
			</div>
		</div>
	</div>
</section>

<!-- newsletter -->
<section class="newsletter-area spad">
	<div class="container">
		<form method="post" action="#">
			<p class="text-center">Đăng ký email của bạn để cập nhật sản phẩm
				mới, ưu đãi đặc biệt và các thông tin giảm giá khác.</p>
			<div class="row subscribe-sec">
				<div class="col-md-9">
					<input type="email" class="form-control" id="email" name=""
						placeholder="Nhập email của bạn..." required="" id="search" />
				</div>
				<div class="col-md-3">
					<button type="submit" class="btn submit">Đăng ký</button>
				</div>
			</div>
		</form>
	</div>
</section>

<!-- footer -->
<section class="footer spad" id="PageFooter"></section>
<!--Login-->

<!--endlogin-->
<div class="footer_bottom text-center py-4">
	<p class="mb-0">
		Copyright © 2022 - Product of <a href="index.html">THVLShop</a>
	</p>
</div>
<!-- jQuery library -->

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- OWL CAROUSEL -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"
	integrity="sha512-bPs7Ae6pVvhOSiIcyUClR7/q2OAsRiovw4vAkX+zJbw3ShAeeqezq50RIIcIURq7Oa20rW2n2q+fyXBNcU9lrw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<!-- COUNTDOWN -->
<script type="text/javascript" src="js/jquery.countdown.min.js"></script>
<!--function fisrt on load page-->
<script>
	function LoadProduct(page) {
		$
				.ajax({
					url : "http://localhost:8081/Lab_01/mathang/getall?page="+page,
					type : "GET",
					//  data: { a_classname, a_classfal, a_classin, a_classout },
					success : function(valuert) {
						let product = "";
						$
								.each(
										valuert,
										function(i, item) {
											
											product += '<div class="col-lg-3 col-md-4 col-sm-6" >'
													+ ' <div class="product_item">'
													+ ' <div class="product_item_pic" style="width:100%">'
													+ '  <img src="' 
													+item.hinhAnh 
               										+ '" alt="">'
													+ ' <div class="label sale">Giảm giá</div>'
													+ ' <ul class="product_hover">'
													+ '<li><a onclick="showdetail('
													+ item.maMH
													+ ')" ><i class="fa fa-arrows-alt"></i></a></li>'
													+ '<li><a onclick="addtocart('
													+ item.maMH
													+ ')"><i class="fa fa-heart"></i></a></li>'
													+ ' <li><a onclick="addtocart('
													+ item.maMH
													+ ')"><i class="fa fa-shopping-bag"></i></a></li>'
													+ "</ul>"
													+ " </div>"
													+ '<div class="product_item_text">'
													+ ' <h6><a href="#">'
													+ item.tenMH
													+ "</a></h6>"
													+ '<div class="rating">'
													+ ' <i class="fa fa-star" aria-hidden="true"></i>'
													+ '<i class="fa fa-star" aria-hidden="true"></i>'
													+ ' <i class="fa fa-star" aria-hidden="true"></i>'
													+ '<i class="fa fa-star" aria-hidden="true"></i>'
													+ '<i class="fa fa-star" aria-hidden="true"></i>'
													+ " </div>"
													+ '<div class="product_price">'
													+ item.giaBan
															.toLocaleString("vi-VN")
													+ " VND</div>"
													+ "</div>"
													+ "</div>" + "</div>";
										});
						document.getElementById("product-show").innerHTML = product;
					},
					error : function(err) {
						alert("Có lỗi trong quá trình tải trang");
					},
				});
	}



	function setbotpage (select) {
		$
		.ajax({
			url : "http://localhost:8081/Lab_01/mathang/totalcountprd",
			type : "GET",
			//  data: { a_classname, a_classfal, a_classin, a_classout },
			success : function(valuert) {
				let page ="";
				var countpage = 0;
				if(valuert.length % select == 0  ){
					countpage = (valuert.length/select);
				}else{
					countpage = (Math.floor(valuert.length/select))+1;
				}
				console.log(valuert.length);
				for(let i = 0; i<countpage;i++){
					page+='<button onclick="sendpage('+i+')" class="but-page">'+(i+1)+'</button>';
				}				
				document.getElementById("bot-page").innerHTML = page;
			},
			error : function(err) {
				alert("Có lỗi trong quá trình tải trang");
			},
		});
	}
	
	function showdetail(id) {
		location.href = "./detail?id=" + id;
	}
	
	function sendpage(page) {
		LoadProduct(page);
		 $('html, body').animate({
		        scrollTop: $("#product-show").offset().top
		    }, 1000);
	}
	
	LoadProduct(0);
	setbotpage (4);
</script>
<jsp:include page="Footer.jsp"></jsp:include>
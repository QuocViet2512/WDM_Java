
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="HeaderPage.jsp"></jsp:include>
<<style>
.bot-vmore{
width: 70%;
height: auto;
display: flex;
justify-content:center; 
float: right;


}
.but-vmore{
	width: 200px;
	height: 40px;
	display: flex;
	justify-content: center;
	align-items: center;
	border: none;
	border-radius: 10px;
	background-color: rgba(242, 158, 148, 0.8);
}
</style>


<section class="product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="section-title">
					<h4>Danh sách sản phẩm</h4>
				</div>
			</div>
		</div>

		<div class="row sp float-left">
			<div class="checkboxes" style="margin-right: 50px">
				<div class="list-group-item">
					<div class="input-group">
						<input type="search" autocomplete="off" autocapitalize="none"
							class="form-control rounded" placeholder="Tìm kiếm..."
							aria-label="Search" aria-describedby="search-addon"
							id="searchbox" oninput="LoadProduct(0)" /> <span
							class="input-group-text border-0" id="search-addon"> <i
							class="fa fa-search"></i>
						</span>
					</div>
				</div>
				<div class="list-group-item">
					<h4 style="color: #000; font-size: 18px;">Sản phẩm</h4>
				</div>
				<div class="list-group-item" style="padding-right: 15px">
					<ul style="margin-left: 20px" id="CATEHere">


					</ul>
				</div>

				<div class="list-group-item">
					<h4 style="color: #000; font-size: 18px;">Khác</h4>
				</div>
				<div class="list-group-item" style="padding-right: 15px">
					<ul style="margin-left: 20px">
						<li class="checkbox-group-item mb-3"><input
							class="form-check-input me-1" type="checkbox" value=""
							aria-label="..." /> Mới nhất</li>
						<li class="checkbox-group-item mb-3"><input
							class="form-check-input me-1" type="checkbox" value=""
							aria-label="..." /> Phổ biến nhất</li>
					</ul>
				</div>
			</div>
		</div>


		<div class="row property_gallery" id="PRDHere">
			<!-- item -->
			<div class="col-lg-4 col-md-3 col-sm-6">
				<div class="product_item">
					<div class="product_item_pic">
						<img src="img/card1.jpg" alt="">
						<div class="label new">Mới</div>
						<ul class="product_hover">
							<li><a href="#"><i class="fa fa-arrows-alt"></i></a></li>
							<li><a href="#"><i class="fa fa-heart"></i></a></li>
							<li><a href="order.html"><i class="fa fa-shopping-bag"></i></a></li>
						</ul>
					</div>
					<div class="product_item_text">
						<h6>
							<a href="#">Tủ lạnh Inverter Sharp</a>
						</h6>
						<div class="rating">
							<i class="fa fa-star" aria-hidden="true"></i> <i
								class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star"
								aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i>
							<i class="fa fa-star" aria-hidden="true"></i>
						</div>
						<div class="product_price">4.850.000đ</div>
					</div>
				</div>
			</div>
			<!-- end item -->
		</div>
		<div class="bot-vmore">
			<button class="but-vmore" id="vmore" onclick="vmore()">Xem thêm ...</button>
		</div>
	</div>
</section>
<script>
	//ham set gia tri san pham
	function general(data) {
		let product = "";
		$
				.each(
						data,
						function(i, item) {
							product += '<div name="itemprd" class="col-lg-4 col-md-3 col-sm-6">'
									+ '<div class="product_item">'
									+ '<div class="product_item_pic">'
									+ '<img src="'+item.hinhAnh+'" alt="">'
									+ '<div class="label new">Mới</div>'
									+ '<ul class="product_hover">'
									+ '<li><a href="./detail?id='
									+ item.maMH
									+ '"><i class="fa fa-arrows-alt"></i></a></li>'
									+ '<li><a onclick="addtocart('
									+ item.maMH
									+ ')"><i class="fa fa-heart"></i></a></li>'
									+ '<li><a onclick="addtocart('
									+ item.maMH
									+ ')"><i class="fa fa-shopping-bag"></i></a></li>'
									+ '</ul>'
									+ '</div>'
									+ '<div class="product_item_text">'
									+ '<h6>'
									+ '<a href="#">'
									+ item.tenMH
									+ '</a>'
									+ '</h6>'
									+ '<i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> <i class="fa fa-star" aria-hidden="true"></i> '
									+ '</div>'
									+ '<div class="product_price">'
									+ item.giaBan.toLocaleString("vi-VN")
									+ ' VND </div>'
									+ '</div>'
									+ '</div>'
									+ '</div>';
						});
		return product;
	}
	
	//load san pham
	function LoadProduct(con) {
		var key = document.getElementById("searchbox").value;
		if( key==""){document.getElementById("vmore").style.display = "block";}else{document.getElementById("vmore").style.display ="none"}; 
		$
				.ajax({
					url : "http://localhost:8081/Lab_01/mathang/search?key="
							+ key + '&&count=' + con,
					type : "GET",
					//  data: { a_classname, a_classfal, a_classin, a_classout },
					success : function(valuert) {
						if (con == 0) {
							document.getElementById("PRDHere").innerHTML = general(valuert);
						} else {
							document.getElementById("PRDHere").innerHTML += general(valuert);
						}
					},
					error : function(err) {
						alert("Có lỗi trong quá trình tải trang");
					},
				});
	}

	//load loai san pham
	function LoadCate() {

		$
				.ajax({
					url : "http://localhost:8081/Lab_01/loaimathang/getall",
					type : "GET",
					//  data: { a_classname, a_classfal, a_classin, a_classout },
					success : function(valuert) {
						var idx = 0;
						let cate = "";
						$
								.each(
										valuert,
										function(i, item) {
											cate += '<li style="list-style:none" class="checkbox-group-item mb-3"><input id="'
													+ idx
													+ '" name="check" onclick="getbycate('
													+ idx
													+ ')" class="form-check-input me-1" type="checkbox" value="'
													+ item.maLMH
													+ '" aria-label="..." /> '
													+ item.tenLMH + '</li>';

											console.log(item.tenLMH);
											idx++;
										});
						document.getElementById("CATEHere").innerHTML = cate;
					},
					error : function(err) {
						alert("Có lỗi trong quá trình tải trang");
					},
				});
	}

	//load san pham theo loai
	function getbycate(id) {
		var count = document.getElementsByName("check");
		var va = document.getElementById(id);
		console.log(count.length);
		for (let index = 0; index < count.length; index++) {
			if (index != id) {
				document.getElementById(index).checked = false;
			}
		}
		if (va.checked == true) {
			document.getElementById("vmore").style.display ="none";
			$
					.ajax({
						url : "http://localhost:8081/Lab_01/mathang/getbycate?idlmh="
								+ va.value,
						type : "GET",
						//  data: { a_classname, a_classfal, a_classin, a_classout },
						success : function(valuert) {
							document.getElementById("PRDHere").innerHTML = general(valuert);
						},
						error : function(err) {
							alert("Có lỗi trong quá trình tải trang");
						},
					});
		} else {
			LoadProduct(0);
		}
	}

	//xem them
	function vmore() {
		var con = document.getElementsByName("itemprd").length;
		LoadProduct(con);

	}

	//khoi dau
	LoadProduct(0);
	LoadCate();
</script>
<jsp:include page="Footer.jsp"></jsp:include>
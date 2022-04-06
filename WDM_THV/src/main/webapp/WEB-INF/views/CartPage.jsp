
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="HeaderPage.jsp"></jsp:include>
<style>
.tb-cart {
	width: 80%;
	margin: 0 auto;
	margin-bottom: 50px;
}

.tb-main {
	width: 100%;
}

.tb-main thead {
	border-bottom: groove;;
	border-radius: 10px;
	overflow: hidden;
	margin-bottom: 20px;
}

.tb-main th {
	text-align: center;
	width: 20%;
}

.tb-main th tr {
	border-radius: 10px;
	overflow: hidden;
}

.tb-main tbody tr td {
	text-align: center;
	width: 20%;
}

.tb-main tfoot {
	border-top: groove;
}

.image-cart {
	width: 100px;
	height: 100px;
	background-color: green;
	border-radius: 15px;
	margin-bottom: 20px;
	margin-top: 20px;
}

.btn-removeprd {
	width: 80%;
	height: 40px;
	background-color: lightcoral;
	color:white;
	border-radius: 8px;
	text-align: center;
	padding: 10px 30px 10px 30px;
	text-decoration:none;
	font-weight: bold;
	
}
.note-wrap{
	width: 100%;
	height: auto;
	margin: 10px auto;
	background-color:rgba(0, 0, 0, 0.71);
	min-height: 90px;
	overflow: hidden;
	border-radius: 8px;
	margin-top: 80px;

}
.note-wrap textarea {
	width: 100%;
	min-height: 60px;
	padding:0 20px 0 20px;
	
}
</style>
<div class="tb-cart">
	<table class="tb-main">

		<thead style="">
			<tr>

				<th>Hình ảnh</th>
				<th>Tên sản phẩm</th>
				<th>Số lượng X Giá bán</th>
				<th>Tổng tiền</th>
				<th>Tác vụ</th>
			</tr>


		</thead>
		<tbody id="producthere">
			
		</tbody>
		<tfoot>
			<tr>
				<th colspan="4"><h5 id="totalhere"> </h5></th>
				<th colspan="1" style="padding: 20px" id="payhere"></th>
			</tr>
		</tfoot>
	</table>
	
	<div class="note-wrap">
	<h5 style="font-family: sans-serif; font-weight: bold;margin:10px; color:white">Ghi chú cho nhà bán hàng: </h5>
	<textarea placeholder="Thêm ghi chú gì đó tại đây..." id="notehere"></textarea>
	</div>
	

</div>
<script type="text/javascript">
	function loadcart() {
		if (sessionStorage.getItem("emailKH") != null) {
			var total = 0;
			var idhd = 0;
			$
					.ajax({
						url : "http://localhost:8081/Lab_01/cart?kh="+ sessionStorage.getItem("emailKH"),
						type : "GET",
						//  data: { a_classname, a_classfal, a_classin, a_classout },
						success : function(valuert) {
							let product = "";
							$.each(valuert,function(i, item) {
												total+=item.donGia;
												idhd = item.maHD;
												product +='<tr>'
													+'<td><img class="image-cart" alt="" src="'+item.hinhAnh+'"></td>'
													+'<td>'+item.tenMH+'</td>'
													+'<td>'+item.sl+' x '+item.giaBan.toLocaleString("vi-VN")+' vnd</td>'
													+'<td>'+item.donGia.toLocaleString("vi-VN")+' vnd</td>'
													+'<td><a class="btn-removeprd" onclick="removeproduct('+item.maMH+')" href="#">Xóa</a></td>'
												+'</tr>';
											});
							document.getElementById("producthere").innerHTML = product;
							document.getElementById("totalhere").textContent="Tổng cộng:\t"+total.toLocaleString("vi-VN") +"\tVND";
							document.getElementById("payhere").innerHTML= '<a href="#" class="btn-removeprd" style="color:white;background-color:black" onclick="paycart('+idhd+')">Đặt hàng</a>';
						},
						error : function(err) {
							alert("Có lỗi trong quá trình tải trang");
						},
					});
		}
		else {
			alert("ban chua co don hang nao");
		}
		
	}
	loadcart();
</script>
<jsp:include page="Footer.jsp"></jsp:include>
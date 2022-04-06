<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="HeaderAD.jsp"></jsp:include>

<style>
.container-ad {
	width: 90%;
	margin: 50px auto
}

.title-op {
	font-weight: bold;
	font-family: sans-serif;
	display: block;
	text-align: center;
	color: black;
}

.but-action {
	border-radius: 8px;
	height: 40px;
	width: fit-content;
	padding: 0 10px 0 10px;
	margin-left: 10px;
	border: none;
	font-weight: bold;
}

.but-action:first-child {
	background-color: rgba(222, 227, 71, 0.74);
}

.but-action:last-child {
	background-color: salmon;
}

.noitice {
	display: block;
	width: 100%;
	font-size: 15px;
	font-family: sans-serif;
	text-align: center;
	color: coral;
}
</style>
<div class="container-ad">
	<h1 class="title-op">Danh sách các sản phẩm</h1>
	<p class="noitice">${notifi}</p>
	<button onclick="location.href='./addnewprd'"
		style="background-color: rgba(0, 194, 125, 0.84); border: none; height: 40px; padding: 0 20px 0 20px; border-radius: 10px; margin: 20px 0 20px 0; font-weight: bold">Thêm
		mới sản phẩm</button>
	<table class="table" id="tb-prd">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th>
				<th>Hình ảnh</th>
				<th>Tên sản phẩm</th>
				<th>Giá bán</th>
				<th>Giá nhập</th>
				<th>Số lượng tồn</th>
				<th>Loại sản phẩm</th>
				<th style="text-align: center; width: 250px">Thao tác</th>
			</tr>
		</thead>
		<tbody id="prdadhere">
		</tbody>
	</table>
</div>


<script>
	function loadlistprd() {
		$
				.ajax({
					url : "http://localhost:8081/Lab_01/getproductmanager",
					type : "GET",
					//  data: { a_classname, a_classfal, a_classin, a_classout },
					success : function(valuert) {
						let prdad = "";
						var index = 1;
						$
								.each(
										valuert,
										function(i, item) {
											prdad += '<tr>'
													+ '<th scope="row">'
													+ index
													+ '</th>'
													+ '<td><img style="width: 100px; height: 100px; border-radius: 10px" src="'+item.hinhAnh+'" /></td>'
													+ '<td>'
													+ '<p>'
													+ item.tenMH
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ item.giaBan
															.toLocaleString("vi-VN")
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ item.giaNhap
															.toLocaleString("vi-VN")
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ item.soLuongTon
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ item.tenLoaiMH
													+ '</p>'
													+ '</td >'
													+ '<td><button onclick="update('
													+ item.maMH
													+ ')" class="but-action">Sửa</button>'
													+ '<button onclick="remove('
													+ item.maMH
													+ ')" class="but-action">Xóa sản phẩm</button></td>'
													+ '</tr>';
											index++;

										});

						document.getElementById("prdadhere").innerHTML = prdad;
						$('#tb-prd')
								.dataTable(
										{
											"language" : {
												"sProcessing" : "Đang xử lý...",
												"sLengthMenu" : "Xem _MENU_ mục",
												"sZeroRecords" : "Không tìm thấy dòng nào phù hợp",
												"sInfo" : "Đang xem _START_ đến _END_ trong tổng số _TOTAL_ mục",
												"sInfoEmpty" : "Đang xem 0 đến 0 trong tổng số 0 mục",
												"sInfoFiltered" : "(được lọc từ _MAX_ mục)",
												"sInfoPostFix" : "",
												"sSearch" : "Tìm:",
												"sUrl" : "",
												"oPaginate" : {
													"sFirst" : "Đầu",
													"sPrevious" : "Trước",
													"sNext" : "Tiếp",
													"sLast" : "Cuối"
												}
											},
											"processing" : true, // tiền xử lý trước
											"aLengthMenu" : [
													[ 5, 10, 20, 50 ],
													[ 5, 10, 20, 50 ] ], // danh sách số trang trên 1 lần hiển thị bảng

										//sắp xếp giảm dần theo cột thứ 1
										}); // dòng này để nhúng bảng biểu thành dạng bảng được phân trang

					},
					error : function(err) {
						alert("Có lỗi trong quá trình tải trang");
					},
				});

	}

	$(document).ready(function() {
		loadlistprd();

	});

	function remove(idmh) {
		if (rs = confirm("Bạn có chắc chắn muốn xóa sản phẩm này không") == true) {
			location.href = "./deleteprd?idmh=" + idmh;
		}
		return;

	}
	function update(idmh) {
		location.href = "./updateprd?idmh=" + idmh;
	}
</script>
<jsp:include page="FooterAD.jsp"></jsp:include>
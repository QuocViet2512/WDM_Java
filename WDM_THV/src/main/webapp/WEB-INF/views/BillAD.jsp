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
.but-action{
border-radius: 8px;
height: 40px;
width: fit-content;
padding:0 10px 0 10px;
background-color: rgba(90, 255, 153, 0.68);
border:none;
font-weight:bold;
}
</style>
<div class="container-ad">

	<h1 class="title-op">Danh sách hóa đơn chưa thanh toán</h1>
	<table class="table" id="tb-bill">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th>
				<th>Mã hóa đơn</th>
				<th>Email khách</th>
				<th>Ngày đặt</th>
				<th>Tổng hóa đơn</th>
				<th>Thanh toán</th>
				<th>Ghi chú</th>
				<th style="text-align: center">Thao tác</th>
			</tr>
		</thead>
		<tbody id="billadhere">

		</tbody>
	</table>



</div>


<script>

	
	
	function loadlistbill() {

		$
				.ajax({
					url : "http://localhost:8081/Lab_01/getbillmanager",
					type : "GET",
					//  data: { a_classname, a_classfal, a_classin, a_classout },
					success : function(valuert) {
						let billad = "";
						var index = 1;
						$
								.each(
										valuert,
										function(i, item) {
										
													
											billad += '<tr>'
													+ '<th scope="row">'
													+ index
													+ '</th>'
													+ '<td>'
													+ '<p>'
													+ item.maHD
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ item.emailKH
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ new Date(item.ngayMua).toLocaleDateString()
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ item.tongTien.toLocaleString("vi-VN")
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p style="color:red">'
													+ "Chưa thanh toán"
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ item.ghiChu
													+ '</p>'
													+ '</td>'
													+ '<td style="text-align:center">'
													+ '<input class="but-action" onclick="confirmbill('+item.maHD+')" type="button" value="Xác nhận thah toán"/>'
													+ '</td>' + '</tr>';
											index++;

										});
						document.getElementById("billadhere").innerHTML = billad;
						$('#tb-bill')
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
											"order" : [ [ 1, 'desc' ] ]
										//sắp xếp giảm dần theo cột thứ 1
										}).ajax.reload(); // dòng này để nhúng bảng biểu thành dạng bảng được phân trang

					},
					error : function(err) {
						alert("Có lỗi trong quá trình tải trang");
					},
				});

	}

	$(document).ready(function() {
		loadlistbill();
	});
	
	
	
	
	
	function confirmbill(idhd) {
		$
				.ajax({
					url : "http://localhost:8081/Lab_01/confirmbill?idhd="+idhd,
					type : "GET",
					//  data: { a_classname, a_classfal, a_classin, a_classout },
					success : function(valuert) {
						if(valuert=="ok"){
							alert("Đã xác nhận thanh toán !");
						} 
						else{
							alert("Không tìm thấy hóa đơn yêu cầu");
						}
						location.href = location.href;

					},
					error : function(err) {
						alert("Có lỗi trong quá trình tải trang");
					},
				});
	}

</script>
<jsp:include page="FooterAD.jsp"></jsp:include>
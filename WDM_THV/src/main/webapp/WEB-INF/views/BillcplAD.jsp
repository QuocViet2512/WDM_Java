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
background-color: rgba(39, 196, 235, 0.6);
border:none;
font-weight:bold;
}
</style>
<div class="container-ad">

	<h1 class="title-op">Danh sách hóa đơn chưa thanh toán</h1>
	<table class="table" id="tb-billcpl">
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
		<tbody id="billcpladhere">

		</tbody>
		<tfoot id="totalmonth">
			
		</tfoot>
	</table>



</div>


<script>

	
	
	function loadlistbillcpl() {

		$
				.ajax({
					url : "http://localhost:8081/Lab_01/getbillcplmanager",
					type : "GET",
					//  data: { a_classname, a_classfal, a_classin, a_classout },
					success : function(valuert) {
						let billcplad = "";
						var sumtotal = 0;
						var index = 1;
						$
								.each(
										valuert,
										function(i, item) {
										
											var date = new Date(item.ngayMua);
											if((date.getMonth()+1)==(new Date(Date.now()).getMonth()+1)&&(date.getFullYear())==(new Date(Date.now()).getFullYear())){
												sumtotal+=item.tongTien;
											}
											billcplad += '<tr>'
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
													+ '<p style="color:yellowgreen; font-weight:bold">'
													+ "Đã thanh toán"
													+ '</p>'
													+ '</td>'
													+ '<td>'
													+ '<p>'
													+ item.ghiChu
													+ '</p>'
													+ '</td>'
													+ '<td style="text-align:center">'
													+ '<input class="but-action" onclick="ViewDetail('+item.maHD+')" type="button" value="Xem chi tiết"/>'
													+ '</td>' + '</tr>';
											index++;

										});
						document.getElementById("billcpladhere").innerHTML = billcplad;
						let settotal='<th colspan="3" ># Doanh thu tháng : '+(new Date(Date.now()).getMonth()+1)+'</th>'
							+'<th style="text-align:center" colspan="5">'+sumtotal.toLocaleString("vi-VN")+' VND</th>';
						
						document.getElementById("totalmonth").innerHTML = settotal;

						$('#tb-billcpl')
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
										}); // dòng này để nhúng bảng biểu thành dạng bảng được phân trang

					},
					error : function(err) {
						alert("Có lỗi trong quá trình tải trang");
					},
				});

	}

	$(document).ready(function() {
		loadlistbillcpl();
	});
	
	function ViewDetail(idbill) {
		location.href="./viewdetail?idbill="+idbill;
		
	}
</script>
<jsp:include page="FooterAD.jsp"></jsp:include>
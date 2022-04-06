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
	padding: 0 30px 0 30px;
	margin-left: 20px;
	border: none;
	font-weight: bold;
}

.but-action:first-child {
	background-color: rgba(222, 227, 71, 0.74);
}

.but-action:last-child {
	background-color: salmon;
}
</style>
<div class="container-ad">

	<h1 class="title-op">Danh sách loại sản phẩm</h1>
	<button onclick="location.href='./addnewcate'"
		style="background-color: rgba(0, 194, 125, 0.84); border: none; height: 40px; padding: 0 20px 0 20px; border-radius: 10px; margin: 20px 0 20px 0; font-weight: bold">Thêm
		mới loại sản phẩm</button>
	<table class="table" id="tb-cate">
		<thead class="thead-dark">
			<tr>
				<th>#</th>
				<th>Tên loại</th>
				<th>Nhà sản xuất</th>
				<th style="text-align: center; width: 300px">Thao tác</th>
			</tr>
		</thead>
		<tbody id="cateadhere">
			<tr>
				<!-- <th></th> -->
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<script>
	function loadlistcate() {

	 $
	 .ajax({
	 url : "http://localhost:8081/Lab_01/getcategorymanager",
	 type : "GET",
	 //  data: { a_classname, a_classfal, a_classin, a_classout },
	 success : function(valuert) {
	 let catead = "";
	 var index = 1;
	 $
	 .each(
	 valuert,
	 function(i, item) {
	 catead += '<tr>'
	 + '<th scope="row">'
	 + index
	 + '</th>'
	 + '<td>'
	 + '<p>'
	 + item.tenLMH
	 + '</p>'
	 + '</td>'
	 + '<td>'
	 + '<p>'
	 + item.tenHangSX
	 + '</p>'
	 + '</td>'
	 + '<td style="text-align:center;width:300px">'
	 + '<input onclick="updatecate('+item.maLMH+')" class="but-action" type="button" value="Sửa"/>'
	 + '</td>' + '</tr>';
	 index++;

	 });
	 document.getElementById("cateadhere").innerHTML = catead;
	 $('#tb-cate')
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
		loadlistcate();
	});

	function updatecate(idlmh) {
		location.href="./updatecate?idlmh="+idlmh;
	}
</script>
<jsp:include page="FooterAD.jsp"></jsp:include>
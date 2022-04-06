<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="HeaderAD.jsp"></jsp:include>
<style>
.tb-cart {
	width: 80%;
	margin: 80px auto;
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
	background-color: rgba(18, 18, 18, 0.8);
}

.tb-main th {
	text-align: center;
	width: 20%;
	color:white;
	height: 30px;
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
	height: 40px;
	display:flex;
	background-color: lightcoral;
	color: white;
	border-radius: 8px;
	text-align: center;
	padding: 10px 30px 10px 30px;
	text-decoration: none;
	font-weight: bold;
	align-items: center;
	justify-content: center;
}

.note-wrap {
	width: 100%;
	height: auto;
	margin: 10px auto;
	background-color: rgba(0, 0, 0, 0.71);
	min-height: 90px;
	overflow: hidden;
	border-radius: 8px;
	margin-top: 80px;
}

.note-wrap textarea {
	width: 100%;
	min-height: 60px;
	padding: 0 20px 0 20px;
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

			</tr>


		</thead>
		<tbody id="producthere">
			<c:forEach var="item" items="${ldetail }">
				<tr>
					<td><img class="image-cart" alt="" src="${item.getHinhAnh() }"></td>
					<td>${item.getTenMH()}</td>
					<td>${ item.getSL()} x <fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${item.getGiaBan()}" /> vnd </td>
					<td><fmt:formatNumber type = "number"  maxFractionDigits = "3" value = "${item.getDonGia()}" />vnd</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

<div style="width: 100%;display: flex;justify-content: center;margin-top: 50px"> <button onclick="location.href='./billcplad'" class="btn-removeprd">Trở về</button></div>

</div>
<script type="text/javascript">
	
</script>
<jsp:include page="FooterAD.jsp"></jsp:include>
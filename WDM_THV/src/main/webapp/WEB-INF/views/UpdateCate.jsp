<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cập nhật danh mục</title>
</head>
<style>
body {
	background-color: rgb(169, 223, 223);
}

.container-inf {
	width: 80%;
	height: auto;
	text-align: center;
	margin: 0 auto;
}

.title-inf {
	display: block;
	text-align: center;
	font-family: sans-serif;
	font-weight: bold;
	color: cornflowerblue;
	font-size: 30px;
	width: 100%;
}

.form-inf {
	width: 60%;
	margin: 0 auto;
	padding: 20px;
	box-shadow: 0 0 20px 0 grey;
	border: none;
	border-radius: 20px;
	background-color: beige;
}

.form-inf .prop-row {
	width: 90%;
	margin: 15px auto;
}

.prop-row .input-inf {
	width: 100%;
	height: 35px;
	border: solid 2px lightslategray;
	border-radius: 10px;
	font-weight: 400;
	font-size: 15px;
	color: gray;
	padding-left: 10px;

}

.input-inf:focus {
	box-shadow: 0 0 10px 0 blue;
}

.area-inf {
	width: 100%;
	min-height: 60px;
	border: solid 2px lightslategray;
	border-radius: 10px;
	font-weight: 400;
	font-size: 15px;
	color: gray;
	padding-left: 10px;
}

.area-inf:focus {
	box-shadow: 0 0 10px 0 blue;
}

.prop-row .lable-inf {
	font-size: 18px;
	font-weight: bold;
	font-family: sans-serif;
	color: lightslategrey;
	margin-bottom: 6px;
	display: block;
	width: 100%;
	text-align: left;
}

.prop-row .img-preview {
	width: 300px;
	height: 300px;
	margin: 0 auto;
	border-radius: 10px;
	background-color: rgb(244, 215, 255);
	display: none;
	transition: all 1s;
}

.but-done {
	padding: 15px 20px 15px 20px;
	font-size: 15px;
	font-weight: bold;
	width: 30%;
	min-width: fit-content;
	background-color: rgb(58, 209, 153);
	border-radius: 10px;
	border: none;
	margin-top: 20px;
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

<body>

	<div class="container-inf">

		<form class="form-inf"
			action="../admin/updatecate/submit?idlmh=${cate.getMaLMH()} "
			method="post">
			<h1 class="title-inf">Sua danh mục sản phẩm</h1>
			<div class="prop-row">
				<label for="" class="lable-inf">Tên danh mục</label> <input
					type="text" name="TenLMH" required class="input-inf"
					placeholder="Nhập tên danh mục..." value="${cate.getTenLMH()}">
			</div>


			<div class="prop-row">
				<label for="" class="lable-inf">Nhà sản xuất</label> <select
					name="HangSX" class="input-inf">
					<c:forEach var="item" items="${listhsx}">

						<c:choose>

							<c:when test="${item.getMaHangSX()==cate.getHangSX() }">
								<option selected="selected" value="${item.getMaHangSX() }">${item.getTenHangSX()}</option>
							</c:when>

							<c:otherwise>
								<option value="${item.getMaHangSX()}">${item.getTenHangSX()}</option>
							</c:otherwise>
						</c:choose>

					</c:forEach>
				</select>
			</div>
			<div class="prop-row">
				<button class="but-done" onclick="location.href='./catead'" style="margin-right: 17%;background-color: coral" type="button">Hủy</button>
				<button class="but-done"  style="margin-left: 17%" type="submit">Cập nhật</button>
			</div>
		</form>
	</div>
</body>


</html>
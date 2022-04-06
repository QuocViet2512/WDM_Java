<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng nhập ADMIN</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
    body{
        background-color:rgb(148, 225, 225);
    }
.login-form {
    width: 340px;
    margin: 150px auto;
  	font-size: 15px;
}
.login-form form {
    margin-bottom: 15px;
    background: #f7f7f7;
    box-shadow: 0px 0px 30px 5px gray;
    padding: 30px;
    border: none;
    border-radius: 10px;
}
.login-form h2 {
    margin: 0 0 15px;
}
.form-control, .btn {
    min-height: 38px;
    border-radius: 2px;
    border-radius: 8px;
}
.btn {        
    font-size: 15px;
    font-weight: bold;
    border-radius: 8px;
}
</style>
</head>
<body>
<div class="login-form">
    <form action="./loginad/submit" method="post">
        <h2 class="text-center">Đăng nhập quản lý</h2>       
        <div class="form-group">
            <input type="text" class="form-control" name="MaNV" placeholder="Mã nhân viên" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="MatKhau" placeholder="Mật khẩu" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Xác nhận</button>
        </div>
        <div class="clearfix">
        
            <a href="#" class="float-right">Quên mật khẩu?</a>
        </div>        
    </form>
</div>
</body>
</html>
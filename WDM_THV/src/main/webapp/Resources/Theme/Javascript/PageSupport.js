function addtocart(idmh) {
	if (sessionStorage.getItem("emailKH") != null) {
		var mail = sessionStorage.getItem("emailKH");
		$.ajax({
			url: "http://localhost:8081/Lab_01/addcart?idmh="+idmh+"&mail="+mail,
			type: "GET",
			success: function(valuert) {
				if (valuert == "ok") {
					alert("Sản phẩm đã được thêm vào giỏ hàng của bạn");
				}
				else{
					alert("Hiện có lỗi, hãy thử lại trong giây lát!!");
				}
			},
			error: function(err) {
				alert("Có lỗi trong quá trình tải trang");
			},
		});
	} else {
		showlogin();
	}

}

function paycart(idhd){
	if (sessionStorage.getItem("emailKH") != null) {
		var note = document.getElementById("notehere").value;
		$.ajax({
			url: "http://localhost:8081/Lab_01/paycart?idhd="+idhd+"&note="+note,
			type: "GET",
			success: function(valuert) {
				if (valuert == "ok") {
					location.href="./thankpage";
				}
				else{
					alert("Thao tác không hợp lệ !");
				}
			},
			error: function(err) {
				alert("Có lỗi trong quá trình tải trang");
			},
		});
	} else {
		showlogin();
	}
}

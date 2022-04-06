
function logout(){
	if(confirm("Bạn có chắc chắn muốn đăng xuất không ?")==true){
		sessionStorage.clear();
			location.href="./index";
	setchecklogin();
	
	}else{
		return;
	}
		
}
function setchecklogin(){
	if(sessionStorage.getItem("emailKH")!=null){
		document.getElementById("login").style.display="none"
		document.getElementById("logout").style.display="inline"	
	}
	else{
		document.getElementById("login").style.display="inline"
		document.getElementById("logout").style.display="none"	
	}	
}

     $(function () {
       setchecklogin();	
      });
      
function RotateImg(img, val, option) {
	if (option == 0) {
		document.getElementById("" + img + "").style.transform =
			$("#" + val + "").val() == "" ? "rotate(0deg)" : "rotate(45deg)";
	} else {
		document.getElementById("" + val + "").value = "";
		document.getElementById("" + img + "").style.transform = "rotate(0deg)";
	}

}

function jsc() {
	RotateImg("LIUser", "LUser", 0);
	RotateImg("LIPass", "LPass", 0);
	RotateImg("SIUser", "SUser", 0);
	RotateImg("SIPass", "SPass", 0);
	RotateImg("SIPass2", "SPass2", 0);
}
function rm(option) {
	switch (option) {
		case 1:
			RotateImg("LIUser", "LUser", 1);
			break;
		case 2:
			RotateImg("LIPass", "LPass", 1);
			break;
		case 3:
			RotateImg("SIUser", "SUser", 1);
			break;
		case 4:
			RotateImg("SIPass", "SPass", 1);
			break;
		case 5:
			RotateImg("SIPass2", "SPass2", 1);
			break;
		default:
			break;
	}
}
function SignUp(option) {
	var SignIn = document.getElementById("LoginForm");
	var SignUp = document.getElementById("SignupForm");
	if (option == 0) {
		if (SignUp.style.display == "block") {
			alert("sjbdfkjsbd");
		} else {
			SignUp.style.display = "block";
			SignIn.style.display = "none";
		}
	}
	else {
		if (SignIn.style.display == "block") {
			var user = document.getElementById("LUser").value;
			var pass = document.getElementById("LPass").value;
	

				$.ajax({
					url: "http://localhost:8081/Lab_01/logincus/"+user+"/"+pass,
					type: "POST",
					success: function(valuert) {
						if (valuert != "404") {
							if (typeof (Storage) !== "undefined") {
								sessionStorage.setItem("emailKH", valuert.emailKH);
								alert("Đăng nhập hệ thống thành công");
									location.href="./index";
								setchecklogin();
							}
						}
						else{
							alert("Tài khoản hoặc mật khẩu không chính xác");
						}
	
					},
					error: function(err) {
						alert("Không thể kết nối tới máy chủ");
						return;
					},
				});
		} else {
			SignUp.style.display = "none";
			SignIn.style.display = "block";
		}
	}
}

function showlogin() {
	document.querySelector("#LoginModal").style.display = "block";
}

window.onclick = function(event) {
	if (event.target == document.querySelector("#LoginModal")) {
		document.querySelector("#LoginModal").style.display = "none";
	}
};

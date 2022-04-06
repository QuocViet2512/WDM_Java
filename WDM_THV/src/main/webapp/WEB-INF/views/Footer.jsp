   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- login -->
	<div class="modal" id="LoginModal">
	<div class="form">
		<div class="subform">
			<div id="LoginForm" style="transition: all 1s">
				<h1 class="tit">Login</h1>
				<div class="bd">
					<input type="text" class="ip" id="LUser" required="required" oninput="jsc()"
						placeholder="User Name" />
					<button class="bt" onclick="rm(1)">
						<img id="LIUser"
							src="<c:url value="/Resources/Image/add.png"></c:url>"
							class="ripbt" alt="" />
					</button>
				</div>
				<div class="bd">
					<input type="password" class="ip" id="LPass" required="required"  oninput="jsc()"
						placeholder="PassWord" />
					<button class="bt" onclick="rm(2)">
						<img id="LIPass"
							src="<c:url value="/Resources/Image/add.png"></c:url>"
							class="ripbt" alt="" />
					</button>
				</div>
			</div>

			<!--SignUp-->
			<div style="display: none; transition: all 1s" id="SignupForm">
				<h1 class="tit">Sign Up</h1>
				<div class="bd">
					<input type="text" class="ip" id="SUser" oninput="jsc()"
						placeholder="User Name" />
					<button class="bt" onclick="rm(3)">
						<img id="SIUser"
							src="<c:url value="/Resources/Image/add.png"></c:url>"
							class="ripbt" alt="" />
					</button>
				</div>
				<div class="bd">
					<input type="password" class="ip" id="SPass" oninput="jsc()"
						placeholder="PassWord" />
					<button class="bt" onclick="rm(4)">
						<img id="SIPass"
							src="<c:url value="/Resources/Image/add.png"></c:url>"
							class="ripbt" alt="" />
					</button>
				</div>
				<div class="bd">
					<input type="password" class="ip" id="SPass2" oninput="jsc()"
						placeholder="Confirm PassWord" />
					<button class="bt" onclick="rm(5)">
						<img id="SIPass2"
							src="<c:url value="/Resources/Image/add.png"></c:url>"
							class="ripbt" alt="" />
					</button>
				</div>
			</div>
			<!---->

			<div class="bbtn">
				<button onclick="SignUp(1)" class="botbut">Sign In</button>
				<button onclick="SignUp(0)" class="botbut"
					style="background-color: rgba(64, 227, 93, 0.77)">
					Sign Up</button>
			</div>
		</div>
	</div>
</div>
<!-- login -->
    <div class="container" style="margin-top: 80px">
        <div class="row">
          <div class="col-lg-4 col-md-6 col-sm-12">
            <div class="footer_about">
              <div class="footer_logo">
                <a href="index.html">THVL<span>Shop</span></a>
              </div>
              <p>Phân phối sản phẩm nội thất thương hiệu cao cấp</p>
              <div class="footer_social">
                <a href="#">
                  <i class="fa fa-facebook"></i>
                </a>
                <a href="#">
                  <i class="fa fa-twitter"></i>
                </a>
                <a href="#">
                  <i class="fa fa-linkedin"></i>
                </a>
              </div>
            </div>
          </div>
          <div class="col-lg-2 col-md-3">
            <div class="footer_widget">
              <h6>Về THVLShop</h6>
              <ul>
                <li><a href="#">Giới thiệu về THVL</a></li>
                <li><a href="#">Liên hệ hợp tác</a></li>
                <li><a href="#">Tuyển dụng</a></li>
                <li><a href="#">Liên hệ mua hàng</a></li>
              </ul>
            </div>
          </div>
          <div class="col-lg-2 col-md-3">
            <div class="footer_widget">
              <h6>Quản lý tài khoản</h6>
              <ul>
                <li><a href="#">Thay đổi thông tin</a></li>
                <li><a href="#">Lấy lại mật khẩu</a></li>
                <li><a href="#">Lịch sử mua hàng</a></li>
                <li><a href="#">Quản lý giỏ hàng</a></li>
              </ul>
            </div>
          </div>
          <div class="col-lg-2 col-md-3">
            <div class="footer_widget">
              <h6>Tuyên bố</h6>
              <p>
                Trang web phục vụ cho đồ án môn học, chúng tôi không chịu trách
                nhiệm về nội dung của trang web.
              </p>
            </div>
          </div>
          <div class="col-lg-2 col-md-3">
            <div class="footer_widget">
              <h6>Liên hệ với chúng tôi</h6>
              <ul>
                <li>thuanle1598@gmail.com</li>
                <li>hoaithu230600@gmail.com</li>
                <li>thanhvien3@gmail.com</li>
                <li>thanhvien4@gmail.com</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
</body>
</html>
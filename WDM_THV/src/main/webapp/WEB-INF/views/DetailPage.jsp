    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <jsp:include page="HeaderPage.jsp"></jsp:include>
 <section class="order spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6" >
                    <div style="width:100%;height:450px;display:flex;justify-content: center; overflow: hidden;margin-bottom: 60px">
             
                                <img  style="width:350px;height:100%;border-radius: 15px;" src="${product.getHinhAnh() }">
                           
                    </div>
                    <div class="banner_details">
                        <a href="#" class="details-radio-btn check">Hình ảnh</a>
                        <a href="#" class="details-radio-btn">Thông số</a>
                        <a href="#" class="details-radio-btn">Mô tả</a>
                        <a href="#" class="details-radio-btn">Đánh giá</a>
                    </div>
                </div>
          
                <div class="col-lg-6">
                    <div class="order_details dt-40">
                        <h4 class="details_title">${product.getTenMH()}</h4>
                        <p class="details_text">${product.getMoTa()}</p>
                        <p><strong>Mã sản phẩm:</strong> ${product.getMaMH()}</p>
                        <hr class="line">
                        <p class="details_product">Còn hàng</p>
                        <p>Giá hàng: <strong>${product.getGiaBan() }</strong></p>
                    </div>
                    <div class="order_button">
                        <button type="button" class="click-buy"><strong>MUA NGAY</strong> <br>Giao hàng tận nơi</button>
                        <button type="button" class="click-contact"><strong>GỌI CHO TÔI</strong><br>Đường dây nóng</button>
                    </div>
                    <div class="orther_button btn-40">
                        <button type="button" class="click-contribute1"><strong>MUA TRẢ GÓP 0%</strong> <br>Duyệt hồ sơ trong 5 phút</button>
                        <button type="button" class="click-contribute2"><strong>GÓP QUA THẺ TÍN DỤNG</strong> <br>Visa, Master card, JCB</button>
                    </div>
                    <table class="table tb-20">
                        <thead class="thead-light">
                          <tr>
                            <th scope="col"><i class="fa fa-gift"></i></th>
                            <th scope="col"><strong>Quà tặng kèm trị giá 7.000.000đ</strong></th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <th scope="row">1</th>
                            <td>Tặng Phiếu Mua Hàng 7.000.000đ Mua Kèm Lọc Nước, Bếp Điện Âm Và Nồi (xem chi tiết)</td>
                          </tr>
                          <tr>
                            <th scope="row">2</th>
                            <td>Mua Kèm Loa, Loa Kéo,  AmpLi Giảm 10 - 20% ( xem chi tiết)</td>
                          </tr>
                        </tbody>
                      </table>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="Footer.jsp"></jsp:include>
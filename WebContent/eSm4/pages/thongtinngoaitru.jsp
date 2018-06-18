<%@page import="eCore.model.SinhVien"%>
<%@page import="java.util.Date"%>
<%@page import="eSm4.model.DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eSm4.modelDao.DAO_DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eSm4.model.ThongTinNgoaiTru"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "ThongTinNgoaiTru";
	String tenTrang = "Thông tin ngoại trú";
	String trangDanhSach = "index.jsp?p=eSm4/pages/thongtinngoaitrus.jsp";
	String[] tk_value = { "maThongTinNgoaiTru", "sinhVien", "dotKeKhaiThongTinNgoaiTru", "hoVaTenChuNhaTro",
			"diaChiNhaTro", "soDienThoaiCuaChuNhaTro", "ngayDangKyCuTru", "ngayKeKhaiThongTin" };
	String[] tk_show = { "Mã thông tin ngoại trú", "Sinh viên", "Đợt kê khai thông tin ngoại trú",
			"Họ và tên chủ trọ", "Địa chỉ nhà trọ", "Số điện thoại chủ nhà trọ", "Ngày đăng ký cư trú",
			"Ngày kê khai thông tin" };
%>
<%@ include file="../../ePartial/code-header.jsp"%>

<%
	String mode = session.getAttribute("mode") + "";
	String tenTrangChiTiet = "";
	tenTrangChiTiet = mode.equals("addNew") ? "Thêm mới" : tenTrangChiTiet;
	tenTrangChiTiet = mode.equals("viewDetail") ? "Xem thông tin chi tiết" : tenTrangChiTiet;
	tenTrangChiTiet = mode.equals("viewDetailAndEdit") ? "Chỉnh sửa thông tin" : tenTrangChiTiet;
	tenTrangChiTiet = mode.equals("null") ? "" : tenTrangChiTiet;

	boolean modeView = mode.equals("viewDetail");
	boolean modeEdit = mode.equals("viewDetailAndEdit");
	
	// kiểm tra xem đang truy cập vào trang đăng ký bằng link p=eSm4/pages/thongtinngoaitru.jsp
		// hay vào trang đăng ký bằng nhấn nút thêm mới 
		// nếu vào bằng link trên thì set lại modeView =false để không bị lỗi khi vào xem chi tiết, sau đó vào trang thêm mới bằng link trên
		String p = request.getParameter("p")+"";
		if (p.equals("eSm4/pages/thongtinngoaitru.jsp"))
			modeView = false;

	ThongTinNgoaiTru obj = null;
	if (session.getAttribute("obj") != null) {
		if (session.getAttribute("obj") instanceof ThongTinNgoaiTru) {
			obj = (ThongTinNgoaiTru) session.getAttribute("obj");
		}
	}
%>
<div class="row">
	<div class="col-lg-12">
		<h4 class="page-header"><%=tenTrang%>
			-
			<%=tenTrangChiTiet%>
		</h4>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<form action="luuDuLieu<%=tenLop%>.action" method="post">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading" style="text-align: left;">
					<div class="row">
						<div class="col-md-5">
							<p style="color: red; display: inline;"><%=msg%></p>
						</div>
						<div class="col-md-7">
							<%@ include file="../../ePartial/processform.jsp"%>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="row" style="padding: 10px">
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Mã thông tin ngoại trú <span class="text-danger">(*)</span></label> <input
										class="form-control" name="maThongTinNgoaiTru"
										value="<%=(obj != null ? obj.getMaThongTinNgoaiTru() : System.currentTimeMillis())%>"
										readonly required="required">
								</div>
								<div class="form-group">
									<label>Ngày kê khai thông tin <span class="text-danger">(*)</span></label> <input type="date"
										class="form-control" name="ngayKeKhaiThongTin"
										value="<%=(obj != null ? Util_Date.dateToString(obj.getNgayKeKhaiThongTin())
					: Util_Date.dateToString(new Date()))%>"
										disabled required="required">
								</div>

								<div class="form-group">
									<label>Đợt kê khai thông tin ngoại trú <span class="text-danger">(*)</span></label> <select
										class="form-control" name="maDotKeKhaiThongTinNgoaiTru"
										<%=(modeView ? " disabled " : "")%> required="required">
										<%
											ObjectDAO objdao = new DAO_DotKeKhaiThongTinNgoaiTru();
											ArrayList<DotKeKhaiThongTinNgoaiTru> listDotKeKhaiThongTinNgoaiTru = objdao.listAll();
											Date currentDate = new Date();
											for (DotKeKhaiThongTinNgoaiTru dotKeKhai : listDotKeKhaiThongTinNgoaiTru) {
												if (currentDate.after(dotKeKhai.getNgayBatDau()) && currentDate.before(dotKeKhai.getNgayKetThuc())) {// nếu ngày hiện tại nằm trong khoảng thời gian của đợt đăng ký
													if (obj != null && obj.getDotKeKhaiThongTinNgoaiTru() != null && obj.getDotKeKhaiThongTinNgoaiTru()
															.getMaDotKeKhaiThongTinNgoaiTru().equals(dotKeKhai.getMaDotKeKhaiThongTinNgoaiTru())) {
										%>
										<option
											value="<%=dotKeKhai.getMaDotKeKhaiThongTinNgoaiTru()%> "
											selected="selected">
											<%=dotKeKhai.getTenDotKeKhaiThongTinNgoaiTru()%>
										</option>
										<%
											} else {
										%>
										<option
											value="<%=dotKeKhai.getMaDotKeKhaiThongTinNgoaiTru()%>"><%=dotKeKhai.getTenDotKeKhaiThongTinNgoaiTru()%></option>
										<%
											}
												} else { // nếu ngày hiện tại không nằm trong khoảng thời gian của đợt đăng ký
													if (obj != null && obj.getDotKeKhaiThongTinNgoaiTru() != null && obj.getDotKeKhaiThongTinNgoaiTru()
															.getMaDotKeKhaiThongTinNgoaiTru().equals(dotKeKhai.getMaDotKeKhaiThongTinNgoaiTru())) {
										%>
										<option
											value="<%=dotKeKhai.getMaDotKeKhaiThongTinNgoaiTru()%> "
											selected="selected">
											<%=dotKeKhai.getTenDotKeKhaiThongTinNgoaiTru()%>
										</option>
										<%
											}
												}

											}
										%>
									</select>
								</div>



								<div class="form-group">
									<%
										ObjectDAO objdao_TaiKhoan = new DAO_TaiKhoanSinhVien();
										String maDangNhap = session.getAttribute("maDangNhap").toString();
										ArrayList<TaiKhoanSinhVien> listTaiKhoan = objdao_TaiKhoan.listByColumns("maDangNhap", maDangNhap);
										if (listTaiKhoan.size() > 0) {
											TaiKhoanSinhVien taiKhoan = listTaiKhoan.get(0);
											SinhVien sinhVien = taiKhoan.getSinhVien();
									%>
									<label>Mã sinh viên <span class="text-danger">(*)</span></label> <input class="form-control"
										name="maSinhVien" readonly
										value="<%=obj != null && obj.getSinhVien() != null ? obj.getSinhVien().getMaSinhVien()
						: sinhVien.getMaSinhVien()%> " required="required">

									<%
										} else {
									%>
									<label>Mã sinh viên <span class="text-danger">(*)</span></label> <input class="form-control"
										name="maSinhVien" <%=(modeView ? " readonly " : "")%>
										value="<%=obj != null && obj.getSinhVien() != null ? obj.getSinhVien().getMaSinhVien() : ""%> " required="required">
									<%
										}
									%>
								</div>

								<div class="form-group">
									<label>Thuê nhà trọ <span class="text-danger">(*)</span></label> <select class="form-control"
										name="thueNhaTro" <%=(modeView ? " disabled " : "")%> required="required">
										<option value="true"
											<%=obj != null && obj.isThueNhaTro() == true ? "selected" : ""%>>
											Có</option>
										<option value="false"
											<%=obj != null && obj.isThueNhaTro() == false ? "selected" : ""%>>
											Không</option>
									</select>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Họ và tên chủ nhà trọ <span class="text-danger">(*)</span></label> <input
										class="form-control" name="hoVaTenChuNhaTro"
										value="<%=(obj != null ? obj.getHoVaTenChuNhaTro() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>
								<div class="form-group">
									<label>Địa chỉ nhà trọ <span class="text-danger">(*)</span></label> <input class="form-control"
										name="diaChiNhaTro"
										value="<%=(obj != null ? obj.getDiaChiNhaTro() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>
								<div class="form-group">
									<label>Số điện thoại của chủ nhà trọ <span class="text-danger">(*)</span></label> <input
										type="number" class="form-control"
										name="soDienThoaiCuaChuNhaTro"
										value="<%=(obj != null ? obj.getSoDienThoaiCuaChuNhaTro() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>
								<div class="form-group">
									<label>Ngày đăng ký cư trú <span class="text-danger">(*)</span></label> <input type="date"
										class="form-control" name="s_ngayDangKyCuTru"
										value="<%=(obj != null ? Util_Date.dateToString(obj.getNgayDangKyCuTru()) : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>

							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group">
									<label>Mô tả</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="moTa" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getMoTa() != null ? obj.getMoTa() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Ghi chú</label>
									<textarea class="form-control" cols="80" id="editor2" rows="5"
										name="ghiChu" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getGhiChu() != null ? obj.getGhiChu() : "")%></textarea>
								</div>
							</div>
						</div>
						<div class="panel-footer" style="text-align: left;">
							<div class="col-md-5"></div>
							<div class="col-md-7">
								<%@ include file="../../ePartial/processform.jsp"%>
							</div>
						</div>
						<!-- /.col-lg-6 (nested) -->
						<!-- /.col-lg-6 (nested) -->
					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</form>

<%session.removeAttribute("msg"); %>
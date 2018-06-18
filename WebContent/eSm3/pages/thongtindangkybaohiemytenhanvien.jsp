<%@page import="eCore.modelDao.DAO_TaiKhoanNhanVien"%>
<%@page import="eCore.model.TaiKhoanNhanVien"%>
<%@page import="eSm3.model.CoSoKhamChuaBenh"%>
<%@page import="eSm3.modelDao.DAO_CoSoKhamChuaBenh"%>
<%@page import="eSm3.model.ThongTinDangKyBaoHiemYTeNhanVien"%>
<%@page import="eCore.model.NhanVien"%>
<%@page import="eCore.modelDao.DAO_NhanVien"%>
<%@page import="java.util.Date"%>
<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiem"%>
<%@page import="eCore.util.Util_Number"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="eSm3.model.DotDangKyBaoHiem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "ThongTinDangKyBaoHiemYTeNhanVien";
	String tenTrang = "Thông tin đăng ký bảo hiểm y tế nhân viên";
	String trangDanhSach = "index.jsp?p=eSm3/pages/thongtindangkybaohiemytenhanviens.jsp";
	String[] tk_value = { "maThongTinDangKyBaoHiemYTe", "dotDangKyBaoHiem", "thoiGianDangKy", "nhanVien",
			"coSoKhamChuaBenh" };
	String[] tk_show = { "Mã thông tin đăng ký bảo hiểm y tế", "Đợt đăng ký bảo hiểm", "Thời gian đăng ký",
			"Nhân viên", "Cơ sở khám chữa bệnh" };
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

	// kiểm tra xem đang truy cập vào trang đăng ký bằng link p=eSm3/pages/thongtindangkybaohiemytenhanvien.jsp
	// hay vào trang đăng ký bằng nhấn nút thêm mới 
	// nếu vào bằng link trên thì set lại modeView =false để không bị lỗi khi vào xem chi tiết, sau đó vào trang thêm mới bằng link trên
	String p = request.getParameter("p") + "";
	if (p.equals("eSm3/pages/thongtindangkybaohiemytenhanvien.jsp"))
		modeView = false;

	ThongTinDangKyBaoHiemYTeNhanVien obj = null;
	if (session.getAttribute("obj") != null) {
		if (session.getAttribute("obj") instanceof ThongTinDangKyBaoHiemYTeNhanVien) {
			obj = (ThongTinDangKyBaoHiemYTeNhanVien) session.getAttribute("obj");
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
									<label>Mã thông tin đăng ký bảo hiểm y tế <span
										class="text-danger">(*)</span></label> <input class="form-control"
										name="maThongTinDangKyBaoHiemYTe"
										value="<%=(obj != null ? obj.getMaThongTinDangKyBaoHiemYTe() : System.currentTimeMillis())%>"
										readonly required="required">
								</div>
								<div class="form-group">
									<label>Đợt đăng ký bảo hiểm <span class="text-danger">(*)</span></label>
									<%
										ObjectDAO objdao = new DAO_DotDangKyBaoHiem();
										ArrayList<DotDangKyBaoHiem> listDotDangKyBaoHiem = objdao.listByColumnLike("loaiBaoHiem",
												"Bảo hiểm y tế nhân viên");
										Date currentDate = new Date();
										ArrayList<DotDangKyBaoHiem> list_remove = new ArrayList<DotDangKyBaoHiem>();
										for (DotDangKyBaoHiem dangKyBaoHiem : listDotDangKyBaoHiem) {
											if (!(currentDate.after(dangKyBaoHiem.getNgayBatDau())
													&& currentDate.before(dangKyBaoHiem.getNgayKetThuc()))) {
												// nếu ngày hiện tại không nằm trong khoảng thời gian của đợt đăng ký
												// => thêm đợt đăng ký đó vào list_remove để xóa
												list_remove.add(dangKyBaoHiem);
											}
										}
										listDotDangKyBaoHiem.removeAll(list_remove);
										// mặc định sẽ không nằm trong đợt đăng ký
										// nếu sau bước kiểm tra ở trên mà có đợt đăng ký nào trong ngày hiện tại => isTrongDotDangKy = true 
										boolean isTrongDotDangKy = false;
										if (listDotDangKyBaoHiem.size() > 0)
											isTrongDotDangKy = true;
									%>
									<select class="form-control" name="maDotDangKyBaoHiem"
										<%=(modeView || isTrongDotDangKy == false ? " disabled " : "")%>
										required="required">
										<%
											if (obj == null) {
												// trường hợp chưa đăng ký => lấy danh sách đợt đăng ký từ bảng đợt đăng ký
												for (DotDangKyBaoHiem dangKyBaoHiem : listDotDangKyBaoHiem) {
										%>
										<option value="<%=dangKyBaoHiem.getMaDotDangKyBaoHiem()%>"><%=dangKyBaoHiem.getTenDotDangKyBaoHiem()%></option>
										<%
											}
											}
											if (obj != null && obj.getDotDangKyBaoHiem() != null) {
												// trường hợp đã đăng ký => lấy đợt đăng ký từ thông tin đăng ký bảo hiểm
										%>
										<option
											value="<%=obj.getDotDangKyBaoHiem().getMaDotDangKyBaoHiem()%>"><%=obj.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem()%></option>
										<%
											}
										%>
									</select>
								</div>

								<div class="form-group">
									<label>Cơ sở khám chữa bệnh <span class="text-danger">(*)</span></label>
									<select class="form-control" name="coSoKhamChuaBenh"
										<%=(modeView ? " disabled " : "")%> required="required">
										<%
											// nếu trong đợt đăng ký bảo hiểm 
											// => liệt kê tất cả danh sách cơ sở khám chữa bệnh
											if (isTrongDotDangKy == true) {

												ObjectDAO obj_CoSoKhamChuaBenh = new DAO_CoSoKhamChuaBenh();
												ArrayList<CoSoKhamChuaBenh> listCoSoKhamChuaBenh = obj_CoSoKhamChuaBenh.listAll();
												for (CoSoKhamChuaBenh coSoKhamChuaBenh : listCoSoKhamChuaBenh) {
													String maCoSoKhamChuaBenh = coSoKhamChuaBenh.getMaCoSoKhamChuaBenh();
													String tenCoSoKhamChuaBenh = coSoKhamChuaBenh.getTenCoSoKhamChuaBenh();
										%>
										<option
											value="<%=maCoSoKhamChuaBenh%>-<%=tenCoSoKhamChuaBenh%>"
											<%=obj != null && obj.getMaCoSoKhamChuaBenh().equals(coSoKhamChuaBenh.getMaCoSoKhamChuaBenh())
									? "selected"
									: ""%>>
											<%=coSoKhamChuaBenh.getTenCoSoKhamChuaBenh()%>
										</option>
										<%
											}
											}
											if (isTrongDotDangKy == false && obj != null && obj.getDotDangKyBaoHiem() != null) {
												// nếu đã qua đợt đăng ký bảo hiểm => nhân viên xóa thông tin cơ sở khám chữa bệnh
												// và đã đăng ký bảo hiểm
												// => lấy thông tin cơ sở khám chữa bệnh từ thông tin đăng ký bảo hiểm y tế
										%>
										<option
											value="<%=obj.getMaCoSoKhamChuaBenh() + "-" + obj.getTenCoSoKhamChuaBenh()%>"><%=obj.getTenCoSoKhamChuaBenh()%></option>
										<%
											}
										%>
									</select>
								</div>

								<div class="form-group">
									<label>Quận/Huyện <span class="text-danger">(*)</span></label>
									<input class="form-control" name="huyen"
										value="<%=(obj != null && obj.getHuyen() != null ? obj.getHuyen() : "")%>"
										<%=(modeView ? " readonly " : "")%> required="required">
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Thời gian đăng ký <span class="text-danger">(*)</span></label>
									<input type="date" class="form-control" name="s_thoiGianDangKy"
										value="<%=(obj != null ? Util_Date.dateToString(obj.getThoiGianDangKy())
					: Util_Date.dateToString(new Date()))%>"
										disabled required="required">
								</div>

								<div class="form-group">
									<label>Nhân viên <span class="text-danger">(*)</span></label> <select
										class="form-control" name="maNhanVien"
										<%=(modeView ? " disabled " : "")%> required="required">
										<%
											ObjectDAO objdao_TaiKhoan = new DAO_TaiKhoanNhanVien();
											String maDangNhap = session.getAttribute("maDangNhap").toString();
											ArrayList<TaiKhoanNhanVien> listTaiKhoan = objdao_TaiKhoan.listByColumns("maDangNhap", maDangNhap);
											TaiKhoanNhanVien taiKhoan = listTaiKhoan.get(0);
											NhanVien nhanVien = taiKhoan.getNhanVien();
										%>
										<option value="<%=nhanVien.getMaNhanVien()%> ">
											<%=nhanVien.getTenNhanVien()%>
										</option>
									</select>
								</div>

								<div class="form-group">
									<label>Phường/Xã <span class="text-danger">(*)</span></label> <input
										class="form-control" name="xa"
										value="<%=(obj != null && obj.getXa() != null ? obj.getXa() : "")%>"
										<%=(modeView ? " readonly " : "")%> required="required">
								</div>

								<div class="form-group">
									<label>Tỉnh <span class="text-danger">(*)</span></label> <input
										class="form-control" name="tinh"
										value="<%=(obj != null && obj.getTinh() != null ? obj.getTinh() : "")%>"
										<%=(modeView ? " readonly " : "")%> required="required">
								</div>

							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group">
									<label>Địa chỉ <span class="text-danger">(*)</span></label> <input
										class="form-control" name="diaChi"
										value="<%=(obj != null && obj.getDiaChi() != null ? obj.getDiaChi() : "")%>"
										<%=(modeView ? " readonly " : "")%> required="required">
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
<%@page import="eSm3.model.DotDangKyBaoHiem"%>
<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiem"%>
<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiemYTe"%>
<%@page import="eSm3.model.DotDangKyBaoHiemYTe"%>
<%@page import="java.util.Date"%>
<%@page import="eCore.model.SinhVien"%>
<%@page import="eCore.modelDao.DAO_SinhVien"%>
<%@page import="eSm3.model.KeKhaiMinhChungBaoHiemSinhVien"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "KeKhaiMinhChungBaoHiemSinhVien";
	String tenTrang = "Quản lý kê khai minh chứng bảo hiểm sinh viên";
	String trangDanhSach = "index.jsp?p=eSm3/pages/kekhaiminhchungbaohiemsinhviens.jsp";
	String[] tk_value = { "maKeKhaiMinhChungDongBaoHiem", "dotDangKyBaoHiem", "sinhVien" };
	String[] tk_show = { "Mã kê khai minh chứng đóng bảo hiểm", "Đợt đăng ký bảo hiểm", "Sinh viên" };
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

	KeKhaiMinhChungBaoHiemSinhVien obj = null;
	if (session.getAttribute("obj") != null) {
		if (session.getAttribute("obj") instanceof KeKhaiMinhChungBaoHiemSinhVien) {
			obj = (KeKhaiMinhChungBaoHiemSinhVien) session.getAttribute("obj");
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
<form action="luuDuLieu<%=tenLop%>.action" method="post"
	enctype="multipart/form-data">
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
									<label>Mã kê khai minh chứng bảo hiểm <span
										class="text-danger">(*)</span></label> <input class="form-control"
										name="maKeKhaiMinhChungDongBaoHiem"
										value="<%=(obj != null ? obj.getMaKeKhaiMinhChungDongBaoHiem() : System.currentTimeMillis())%>"
										readonly required="required">
								</div>
								<div class="form-group">
									<label>Đợt đăng ký bảo hiểm <span class="text-danger">(*)</span></label>
									<%
										ObjectDAO objdao = new DAO_DotDangKyBaoHiem();
										ArrayList<DotDangKyBaoHiem> listDotDangKyBaoHiem = objdao.listByColumnLike("loaiBaoHiem",
												"Bảo hiểm y tế sinh viên");
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

							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Mã sinh viên <span class="text-danger">(*)</span></label>
									<input class="form-control" name="maSinhVien"
										value="<%=(obj != null ? obj.getSinhVien().getMaSinhVien() : "")%>"
										<%=(modeView ? " readonly " : "")%>
										required="required">
								</div>
								<div class="form-group">
									<label>Hình ảnh minh chứng <span class="text-danger">(*)</span></label>
									<input class="form-control" name="myFile"
										value="<%=(obj != null && obj.getHinhAnhMinhChung() != null ? obj.getHinhAnhMinhChung() : "")%>"
										type="<%=(modeView ? "hidden" : "file")%>" required="required"><img
										src="<%=obj != null && obj.getHinhAnhMinhChung() != null && modeView
					? "eSm3/images/sinhviens/" + obj.getHinhAnhMinhChung()
					: ""%>"
										height="<%=modeView ? 350 : 1%>"
										width="<%=modeView ? 350 : 1%>">
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

						<input type="hidden" name="s_hinhAnh"
							value="<%=obj != null && obj.getHinhAnhMinhChung() != null ? obj.getHinhAnhMinhChung() : ""%>">
						<input type="hidden" id="myFileName" name="myFileName"></input> <input
							type="hidden" name="myFolder"
							value="<%=request.getRealPath("eSm3/images/sinhviens")%>" />
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
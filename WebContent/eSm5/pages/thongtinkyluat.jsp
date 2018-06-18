<%@page import="eSm5.model.HinhThucKyLuat"%>
<%@page import="eSm5.modelDao.DAO_HinhThucKyLuat"%>
<%@page import="eSm5.model.ThongTinKyLuat"%>
<%@page import="java.util.Date"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "ThongTinKyLuat";
	String tenTrang = "Thông tin kỷ luật";
	String trangDanhSach = "index.jsp?p=eSm5/pages/thongtinkyluats.jsp";
	String[] tk_value = { "maThongTinKyLuat", "sinhVien", "noiDungKyLuat", "thoiGianKyLuat" };
	String[] tk_show = { "Mã thông tin kỷ luật", "Sinh viên", "Nội dung kỷ luật", "Thời gian kỷ luật" };
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

	ThongTinKyLuat obj = null;
	if (session.getAttribute("obj") != null) {
		if (session.getAttribute("obj") instanceof ThongTinKyLuat) {
			obj = (ThongTinKyLuat) session.getAttribute("obj");
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
									<label>Mã thông tin kỷ luật <span class="text-danger">(*)</span></label> <input class="form-control"
										name="maThongTinKyLuat"
										value="<%=(obj != null ? obj.getMaThongTinKyLuat() : System.currentTimeMillis())%>"
										readonly required="required">
								</div>

								<div class="form-group">
									<label>Mã sinh viên <span class="text-danger">(*)</span></label> <input class="form-control"
										name="maSinhVien"
										value="<%=(obj != null ? obj.getSinhVien().getMaSinhVien() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required" required="required">
								</div>

								<div class="form-group">
									<label>Hình thức kỷ luật <span class="text-danger">(*)</span></label> <select class="form-control"
										name="maHinhThucKyLuat" <%=(modeView ? " disabled " : "")%> required="required">
										<%
											ObjectDAO objdao = new DAO_HinhThucKyLuat();
											ArrayList<HinhThucKyLuat> listHinhThucKyLuat = objdao.listAll();
											for (HinhThucKyLuat hinhThucKyLuat : listHinhThucKyLuat) {
										%>
										<option value="<%=hinhThucKyLuat.getMaHinhThucKyLuat()%> "
											<%=obj != null && obj.getHinhThucKyLuat() != null && obj.getHinhThucKyLuat()
							.getMaHinhThucKyLuat().equals(hinhThucKyLuat.getMaHinhThucKyLuat()) ? "selected" : ""%>>
											<%=hinhThucKyLuat.getTenHinhThucKyLuat()%>
										</option>
										<%
											}
										%>
									</select>
								</div>

							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Nội dung kỷ luật <span class="text-danger">(*)</span></label> <input class="form-control"
										name="noiDungKyLuat"
										value="<%=(obj != null ? obj.getNoiDungKyLuat() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>
								<div class="form-group">
									<label>Thời gian kỷ luật <span class="text-danger">(*)</span></label> <input class="form-control"
										type="date" name="s_thoiGianKyLuat"
										value="<%=(obj != null ? Util_Date.dateToString(obj.getThoiGianKyLuat()) : "")%>"
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
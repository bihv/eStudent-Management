<%@page import="eSm5.model.ThongTinKhenThuong"%>
<%@page import="java.util.Date"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "ThongTinKhenThuong";
	String tenTrang = "Thông tin khen thưởng";
	String trangDanhSach = "index.jsp?p=eSm5/pages/thongtinkhenthuongs.jsp";
	String[] tk_value = { "maThongTinKhenThuong", "sinhVien", "noiDungKhenThuong", "thoiGianKhenThuong" };
	String[] tk_show = { "Mã thông tin khen thưởng", "Sinh viên", "Nội dung khen thưởng",
			"Thời gian khen thưởng" };
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

	ThongTinKhenThuong obj = null;
	if (session.getAttribute("obj") != null) {
		if (session.getAttribute("obj") instanceof ThongTinKhenThuong) {
			obj = (ThongTinKhenThuong) session.getAttribute("obj");
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
									<label>Mã thông tin khen thưởng <span class="text-danger">(*)</span></label> <input
										class="form-control" name="maThongTinKhenThuong"
										value="<%=(obj != null ? obj.getMaThongTinKhenThuong() : System.currentTimeMillis())%>"
										readonly required="required">
								</div>

								<div class="form-group">
									<label>Mã sinh viên <span class="text-danger">(*)</span></label> <input class="form-control"
										name="maSinhVien"
										value="<%=(obj != null ? obj.getSinhVien().getMaSinhVien() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>

							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Nội dung khen thưởng <span class="text-danger">(*)</span></label> <input class="form-control"
										name="noiDungKhenThuong"
										value="<%=(obj != null ? obj.getNoiDungKhenThuong() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>
								<div class="form-group">
									<label>Thời gian khen thưởng <span class="text-danger">(*)</span></label> <input
										class="form-control" type="date" name="s_thoiGianKhenThuong"
										value="<%=(obj != null ? Util_Date.dateToString(obj.getThoiGianKhenThuong()) : Util_Date.dateToString(new Date()))%>"
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
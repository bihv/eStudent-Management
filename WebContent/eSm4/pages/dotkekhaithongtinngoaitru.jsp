<%@page import="java.util.Date"%>
<%@page import="eSm4.model.DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eCore.util.Util_Number"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "DotKeKhaiThongTinNgoaiTru";
	String tenTrang = "Quản lý đợt kê khai thông tin ngoại trú";
	String trangDanhSach = "index.jsp?p=eSm4/pages/dotkekhaithongtinngoaitrus.jsp";
	String[] tk_value = { "maDotKeKhaiThongTinNgoaiTru", "tenDotKeKhaiThongTinNgoaiTru", "ngayBatDau",
			"ngayKetThuc" };
	String[] tk_show = { "Mã đợt kê khai thông tin ngoại trú", "Tên đợt kê khai thông tin ngoại trú",
			"Ngày bắt đầu", "Ngày kết thúc" };
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

	DotKeKhaiThongTinNgoaiTru obj = null;
	if (session.getAttribute("obj") != null) {
		if (session.getAttribute("obj") instanceof DotKeKhaiThongTinNgoaiTru) {
			obj = (DotKeKhaiThongTinNgoaiTru) session.getAttribute("obj");
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
									<label>Mã đợt kê khai <span class="text-danger">(*)</span></label> <input class="form-control"
										name="maDotKeKhaiThongTinNgoaiTru"
										value="<%=(obj != null ? obj.getMaDotKeKhaiThongTinNgoaiTru() : System.currentTimeMillis())%>"
										 readonly required="required">
								</div>
								<div class="form-group">
									<label>Tên đợt kê khai <span class="text-danger">(*)</span></label> <input class="form-control"
										name="tenDotKeKhaiThongTinNgoaiTru"
										value="<%=(obj != null ? obj.getTenDotKeKhaiThongTinNgoaiTru() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>

							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Ngày bắt đầu <span class="text-danger">(*)</span></label> <input type="date"
										class="form-control" name="s_ngayBatDau"
										value="<%=(obj != null ? Util_Date.dateToString(obj.getNgayBatDau()) : Util_Date.dateToString(new Date()))%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>
								<div class="form-group">
									<label>Ngày kết thúc <span class="text-danger">(*)</span></label> <input type="date"
										class="form-control" name="s_ngayKetThuc"
										value="<%=(obj != null ? Util_Date.dateToString(obj.getNgayKetThuc()) : Util_Date.dateToString(new Date()))%>"
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
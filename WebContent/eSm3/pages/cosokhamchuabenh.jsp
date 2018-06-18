<%@page import="eSm3.model.CoSoKhamChuaBenh"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "CoSoKhamChuaBenh";
	String tenTrang = "Quản lý cơ sở khám chữa bệnh";
	String trangDanhSach = "index.jsp?p=eSm3/pages/cosokhamchuabenhs.jsp";
	String[] tk_value = { "maCoSoKhamChuaBenh", "tenCoSoKhamChuaBenh", "diaChi",
			"thongTinDangKyKhamChuaBenhBanDau" };
	String[] tk_show = { "Mã cơ sở khám chữa bệnh", "Tên cơ sở khám chữa bệnh", "Địa chỉ",
			"Thông tin đăng ký khám chữa bệnh ban đầu" };
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

	CoSoKhamChuaBenh obj = null;
	if (session.getAttribute("obj") != null) {
		if (session.getAttribute("obj") instanceof CoSoKhamChuaBenh) {
			obj = (CoSoKhamChuaBenh) session.getAttribute("obj");
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
									<label>Mã cơ sở khám chữa bệnh <span class="text-danger">(*)</span></label> <input class="form-control"
										name="maCoSoKhamChuaBenh"
										value="<%=(obj != null ? obj.getMaCoSoKhamChuaBenh() : "")%>"
										<%=(modeView || modeEdit ? " readonly " : "")%> required="required">
								</div>
								<div class="form-group">
									<label>Tên cơ sở khám chữa bệnh <span class="text-danger">(*)</span></label> <input class="form-control"
										name="tenCoSoKhamChuaBenh"
										value="<%=(obj != null ? obj.getTenCoSoKhamChuaBenh() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>

							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Địa chỉ <span class="text-danger">(*)</span></label> <input 
										class="form-control" name="diaChi"
										value="<%=(obj != null ? obj.getDiaChi() : "")%>"
										<%=(modeView ? " disabled " : "")%> required="required">
								</div>
								<div class="form-group">
									<label>Thông tin đăng ký khám chữa bệnh ban đầu <span class="text-danger">(*)</span></label> <input 
										class="form-control" name="thongTinDangKyKhamChuaBenhBanDau"
										value="<%=(obj != null ? obj.getThongTinDangKyKhamChuaBenhBanDau() : "")%>"
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
<%@page import="eCore.model.Lop"%>
<%@page import="eCore.model.DonVi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.modelDao.DAO_DonVi"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@page import="eCore.model.ChucNang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "DonVi";
	String tenTrang = "Quản lý Đơn Vị";
	String trangDanhSach = "index.jsp?p=eCore/pages/donvis.jsp";
	String[] tk_value = { "maDonVi", "tenDonVi", "email", "soDienThoai", "diaChiLienHe", "donViCha" };
	String[] tk_show = { "Mã đơn vị", "Tên đơn vị", "Email", "Số điện thoại", "Địa chỉ liên hệ", "Đơn vị cha" };
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

	DonVi obj = session.getAttribute("obj") != null ? (DonVi) session.getAttribute("obj") : null;
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
									<label>Mã đơn vị</label> <input class="form-control"
										name="maDonVi"
										value="<%=(obj != null ? obj.getMaDonVi() : "")%>"
										<%=(modeView || modeEdit ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Tên đơn vị</label> <input class="form-control"
										name="tenDonVi"
										value="<%=(obj != null ? obj.getTenDonVi() : "")%>"
										<%=(modeView ? " disabled " : "")%>>
								</div>
								<div class="form-group">
									<label>Email</label> <input class="form-control" name="email"
										value="<%=(obj != null && obj.getEmail() != null ? obj.getEmail() : "")%>"
										<%=(modeView ? " disabled " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Số điện thoại</label> <input class="form-control"
										name="soDienThoai"
										value="<%=(obj != null && obj.getSoDienThoai() != null ? obj.getSoDienThoai() : "")%>"
										<%=(modeView ? " disabled " : "")%>>
								</div>
								<div class="form-group">
									<label>Địa chỉ liên hệ</label> <input class="form-control"
										name="diaChiLienHe"
										value="<%=(obj != null && obj.getDiaChiLienHe() != null ? obj.getDiaChiLienHe() : "")%>"
										<%=(modeView ? " disabled " : "")%>>
								</div>
								<div class="form-group">
									<label>Đơn vị cha</label> <select class="form-control"
										name="maDonViCha" <%=(modeView ? " disabled " : "")%>>
										<option value=""></option>
										<%
											ObjectDAO objdao = new DAO_DonVi();
											ArrayList<DonVi> listDonVi = objdao.listAll();
											for (DonVi dv : listDonVi) {

												if (obj != null && dv.compareTo(obj) != 0) {
										%>
										<option value="<%=dv.maDonVi%> "
											<%=obj != null && obj.getDonViCha() != null
							&& obj.getDonViCha().getMaDonVi().equals(dv.maDonVi) ? "selected" : ""%>>
											<%=dv.tenDonVi%>
										</option>
										<%
											} else {
										%>
										<option value="<%=dv.maDonVi%>">
											<%=dv.tenDonVi%>
										</option>
										<%
											}
											}
										%>
									</select>
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
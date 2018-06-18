<%@page import="eCore.model.SinhVien"%>
<%@page import="eCore.modelDao.DAO_SinhVien"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="eCore.modelDao.DAO_HocKy"%>
<%@page import="eCore.model.HocKy"%>
<%@page import="eCore.modelDao.DAO_HocKy"%>
<%@page import="eCore.model.HocKy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.modelDao.DAO_Lop"%>
<%@page import="eCore.model.Lop"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "SinhVien";
	String tenTrang = "Quản lý Sinh Viên";
	String trangDanhSach = "index.jsp?p=eCore/pages/sinhviens.jsp";
	String[] tk_value = {"maSinhVien", "hoVaTen", "gioiTinh", "ngaySinh", "email", "tenNganhTrungTuyen"};
	String[] tk_show = {"Mã sinh viên", "Họ và tên", "Giới tính", "Ngày sinh", "Email", "Chuyên ngành"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<SinhVien> dao = new DAO_SinhVien();

	ArrayList<SinhVien> list = new ArrayList<SinhVien>();

	String maLop = request.getParameter("maLop");
	maLop = (maLop == null || maLop.equals("null")) ? "all" : maLop;

	String chuyenNganh = request.getParameter("chuyenNganh");
	chuyenNganh = (chuyenNganh == null || chuyenNganh.equals("null")) ? "all" : chuyenNganh;

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof SinhVien) {
				list = (ArrayList<SinhVien>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<SinhVien>();
	} else {
		if (!maLop.equals("all"))
			list = dao.pagination("lop = '" + maLop + "'", (long) recordPerPage,
					(long) Long.parseLong(pid) * recordPerPage);
		else
			list = dao.pagination("1=1  ORDER BY lop ASC", (long) recordPerPage,
					(long) Long.parseLong(pid) * recordPerPage);
	}
%>


<div class="row">
	<div class="col-lg-12">
		<h4 class="page-header"><%=tenTrang%>
			<p style="color: red; display: inline;"><%=msg%></p>
		</h4>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<%@ include file="../../ePartial/panel-heading.jsp"%>
		<!-- /.panel-heading -->
		<div class="panel-body">


			<div id="danhchonguoiquanly">
				<form class="form-inline pull-left">
					<label>Chọn lớp</label> <select name="maLop" class="form-control"
						id="maLop" onchange="myFunction()">
						<%
							ObjectDAO<Lop> dao_Lop = new DAO_Lop();
							ArrayList<Lop> list_Lop = dao_Lop.listAll();
						%>
						<option value="all" <%if (maLop.equals("all")) {%>
							selected="selected" <%}%>>Tất cả</option>

						<%
							for (Lop lop : list_Lop) {
						%>
						<option value="<%=lop.getMaLop()%>"
							<%if (maLop.equals(lop.getMaLop())) {%> selected="selected" <%}%>><%=lop.getTenLop()%></option>
						<%
							}
						%>
					</select>

					<script type="text/javascript">
						function myFunction() {
							var maLop = document.getElementById("maLop").value;
							var recordPerPage = document
									.getElementById("recordPerPage").value;
							var p1 = document.getElementById("p1").value;
							window.location.href = p1 + "&maLop=" + maLop
									+ "&recordPerPage=" + recordPerPage;

						}
					</script>
				</form>

				<form class="form-inline pull-right"
					action="exportSinhVien.action">
					<input hidden=""
						value="<%=request.getParameter("maLop") != null ? request.getParameter("maLop") : ""%>"
						name="maLop">
					<button type="submit" class="form-control btn btn-success" value="">
						<img alt="" src="content/images/excel-32.png" width="16px"
							height="16px"> Xuất danh sách excel
					</button>
				</form>
			</div>


			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Mã sinh viên</th>
						<th>Họ và tên</th>
						<th>Giới tính</th>
						<th>Ngày sinh</th>
						<th>Email</th>
						<th>Chuyên ngành</th>
						<th>Mã lớp</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (SinhVien obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaSinhVien();
							String tenDoiTuong = obj.getHoDem() + " " + obj.getTen();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaSinhVien()%></td>
						<td><%=obj.getHoDem() + " " + obj.getTen()%></td>
						<td><%=obj.getGioiTinh()!=null?obj.getGioiTinh():""%></td>
						<td><%=obj.getNgaySinh()!=null?obj.getNgaySinh():""%></td>
						<td><%=obj.getEmail()!=null?obj.getEmail():""%></td>
						<td><%=obj.getTenNganhTrungTuyen()!=null?obj.getTenNganhTrungTuyen():""%>
						<td><%=obj.getLop().getMaLop()!=null?obj.getLop().getMaLop():""%>
						<td style="text-align: center;"><%@ include
								file="../../ePartial/menupullcuadoituong.jsp"%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<!-- /.table-responsive -->
			<!-- Phan trang -->
			<%@ include file="../../ePartial/phantrang.jsp"%>
			<!-- ket thuc phan trang -->
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<!-- Modal Tìm kiếm-->
<%@ include file="../../ePartial/timkiemModel.jsp"%>

<script type="text/javascript">
	document.getElementById("nutNhapLieuExcel").style.display = "none";
</script>
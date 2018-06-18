<%@page import="eCore.modelDao.DAO_NhanVien"%>
<%@page import="eCore.model.NhanVien"%>
<%@page import="eCore.modelDao.DAO_DonVi"%>
<%@page import="eCore.model.DonVi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.modelDao.DAO_Lop"%>
<%@page import="eCore.model.Lop"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "NhanVien";
	String tenTrang = "Quản lý Nhân Viên";
	String[] tk_value = {"maNhanVien", "tenNhanVien", "gioiTinh", "queQuan", "danToc", "tonGiao", "chucVu",
			"soTruongCongTac", "soCMND", "soHoChieu", "email"};
	String[] tk_show = {"Mã Nhân viên", "Tên Nhân viên", "Giới tính", "Quê quán", "Dân tộc", "Tôn giáo",
			"Chức vụ", "Sở trường công tác", "Số CMND", "Số hộ chiếu", "Email"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<NhanVien> dao = new DAO_NhanVien();

	ArrayList<NhanVien> list = new ArrayList<NhanVien>();

	String maDonVi = request.getParameter("maDonVi");
	maDonVi = (maDonVi == null || maDonVi.equals("null")) ? "all" : maDonVi;

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof NhanVien) {
				list = (ArrayList<NhanVien>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<NhanVien>();
	} else {
		if (!maDonVi.equals("all")) {
			list = dao.pagination("donVi = '" + maDonVi + "'", (long) recordPerPage,
					(long) Long.parseLong(pid) * recordPerPage);
			System.out.println("sssssssssssssssssssssssssssssss");
		} else
			list = dao.pagination("1=1  ORDER BY donVi ASC", (long) recordPerPage,
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

			<form class="form-inline pull-left">
				<label>Chọn đơn vị quản lý</label> <select name="maDonVi"
					class="form-control" id="maDonVi" onchange="myFunction()">
					<%
						ObjectDAO<DonVi> dao_DonVi = new DAO_DonVi();
						ArrayList<DonVi> list_DonVi = dao_DonVi.listAll();
					%>
					<option value="all" <%if (maDonVi.equals("all")) {%>
						selected="selected" <%}%>>Tất cả</option>

					<%
						for (DonVi donVi : list_DonVi) {
					%>
					<option value="<%=donVi.getMaDonVi()%>"
						<%if (maDonVi.equals(donVi.getMaDonVi())) {%> selected="selected"
						<%}%>><%=donVi.getTenDonVi()%></option>
					<%
						}
					%>
				</select>
				<script type="text/javascript">
					function myFunction() {
						var maDonVi = document.getElementById("maDonVi").value;
						var recordPerPage = document
								.getElementById("recordPerPage").value;
						var p1 = document.getElementById("p1").value;
						window.location.href = p1 + "&maDonVi=" + maDonVi
								+ "&recordPerPage=" + recordPerPage;

					}
				</script>
			</form>

			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Mã nhân viên</th>
						<th>Tên nhân viên</th>
						<th>Đơn vị</th>
						<th>Email</th>
						<th>Số CMND</th>
						<th>Số điện thoại</th>
						<th>Xử lý</th>

					</tr>
				</thead>
				<tbody>
					<%
						for (NhanVien obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaNhanVien();
							String tenDoiTuong = obj.getTenNhanVien();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaNhanVien()%></td>
						<td><%=obj.getTenNhanVien() != null ? obj.getTenNhanVien() : ""%></td>
						<td><%=obj.getDonVi() == null ? "" : obj.getDonVi().getTenDonVi()%></td>
						<td><%=obj.getEmail() != null ? obj.getEmail() : ""%></td>
						<td><%=obj.getSoCMND() != null ? obj.getSoCMND() : ""%></td>
						<td><%=obj.getSoDienThoaiDiDong() != null ? obj.getSoDienThoaiDiDong() : ""%></td>
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
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
	String tenLop = "DonVi";
	String tenTrang = "Quản lý đơn vị";
	String[] tk_value = {"maDonVi", "tenDonVi", "email", "soDienThoai", "diaChiLienHe"};
	String[] tk_show = {"Mã đơn vị", "Tên đơn vị", "Email", "Số điện thoại", "Địa chỉ liên hệ"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<DonVi> dao = new DAO_DonVi();

	ArrayList<DonVi> list = new ArrayList<DonVi>();

	String maDonViCha = request.getParameter("maDonViCha");
	maDonViCha = (maDonViCha == null || maDonViCha.equals("null")) ? "all" : maDonViCha;

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof DonVi) {
				list = (ArrayList<DonVi>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<DonVi>();
	} else {
		if (!maDonViCha.equals("all")) {
			list = dao.pagination("donViCha = '" + maDonViCha + "'", (long) recordPerPage,
					(long) Long.parseLong(pid) * recordPerPage);
			System.out.println("sssssssssssssssssssssssssssssss");
		} else
			list = dao.pagination("1=1  ORDER BY donViCha ASC", (long) recordPerPage,
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
				<label>Chọn đơn vị cha</label> <select name="maDonViCha"
					class="form-control" id="maDonViCha" onchange="myFunction()">
					<%
						ObjectDAO<DonVi> dao_DonVi = new DAO_DonVi();
						ArrayList<DonVi> list_DonVi = dao_DonVi.listAll();

						// lấy ra những đơn vị có đơn vị cha 
						// -> thêm vào danh sách đơn vị cha để hiển thị 
						ArrayList<DonVi> list_DonViCha = new ArrayList<DonVi>();
						for (DonVi dv : list_DonVi) {
							if (dv.getDonViCha() != null && !list_DonViCha.contains(dv.getDonViCha()))
								list_DonViCha.add(dv.getDonViCha());
						}
					%>
					<option value="all" <%if (maDonViCha.equals("all")) {%>
						selected="selected" <%}%>>Tất cả</option>

					<%
						for (DonVi donVi : list_DonViCha) {
					%>
					<option value="<%=donVi.getMaDonVi()%>"
						<%if (maDonViCha.equals(donVi.getMaDonVi())) {%>
						selected="selected" <%}%>><%=donVi.getTenDonVi()%></option>
					<%
						}
					%>
				</select>
				<script type="text/javascript">
					function myFunction() {
						var maDonViCha = document.getElementById("maDonViCha").value;
						var recordPerPage = document.getElementById("recordPerPage").value;
						var p1 = document.getElementById("p1").value;
						window.location.href = p1 + "&maDonViCha=" + maDonViCha+"&recordPerPage="+recordPerPage;

					}
				</script>
			</form>

			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Mã đơn vị</th>
						<th>Tên đơn vị</th>
						<th>Email</th>
						<th>Số điện thoại</th>
						<th>Địa chỉ liên hệ</th>
						<th>Đơn vị cha</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (DonVi obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaDonVi();
							String tenDoiTuong = obj.getTenDonVi();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaDonVi()%></td>
						<td><%=obj.getTenDonVi()%></td>
						<td><%=obj.getEmail() != null ? obj.getEmail() : ""%></td>
						<td><%=obj.getSoDienThoai() != null ? obj.getSoDienThoai() : ""%></td>
						<td><%=obj.getDiaChiLienHe() != null ? obj.getDiaChiLienHe() : ""%></td>
						<td><%=obj.getDonViCha() == null ? "" : obj.getDonViCha().getTenDonVi()%></td>
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

<!-- Modal nhập excel-->
<%@ include file="../../ePartial/nhapexcelModal.jsp"%>
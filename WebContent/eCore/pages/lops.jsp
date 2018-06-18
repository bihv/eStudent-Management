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
	String tenLop = "Lop";
	String tenTrang = "Quản lý Lớp";
	String[] tk_value = {"maLop", "tenLop", "khoa", "nienKhoa"};
	String[] tk_show = {"Mã lớp", "Tên lớp", "Khóa", "Niên khóa"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<Lop> dao = new DAO_Lop();

	ArrayList<Lop> list = new ArrayList<Lop>();

	String maDonViQuanLy = request.getParameter("maDonViQuanLy");
	maDonViQuanLy = (maDonViQuanLy == null || maDonViQuanLy.equals("null") || maDonViQuanLy.equals(""))
			? "all"
			: maDonViQuanLy;

	String khoa = request.getParameter("khoa");
	khoa = (khoa == null || khoa.equals("null") || khoa.equals("")) ? "all" : khoa;

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof Lop) {
				list = (ArrayList<Lop>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<Lop>();
	} else {
		if (!maDonViQuanLy.equals("all") && !khoa.equals("all"))
			list = dao.pagination("donVi = '" + maDonViQuanLy + "' and khoa = '" + khoa + "'",
					(long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);

		if (maDonViQuanLy.equals("all") && !khoa.equals("all"))
			list = dao.pagination("khoa = '" + khoa + "'", (long) recordPerPage,
					(long) Long.parseLong(pid) * recordPerPage);

		if (!maDonViQuanLy.equals("all") && khoa.equals("all"))
			list = dao.pagination("donVi = '" + maDonViQuanLy + "'", (long) recordPerPage,
					(long) Long.parseLong(pid) * recordPerPage);

		if (maDonViQuanLy.equals("all") && khoa.equals("all"))
			list = dao.pagination("1=1 order by khoa desc", (long) recordPerPage,
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
					<label>Chọn đơn vị quản lý</label> <select name="maDonViQuanLy"
						class="form-control" id="maDonViQuanLy" onchange="myFunction()">
						<%
							ObjectDAO<DonVi> dao_DonVi = new DAO_DonVi();
							ArrayList<DonVi> list_DonVi = dao_DonVi.listAll();
						%>
						<option value="all" <%if (maDonViQuanLy.equals("all")) {%>
							selected="selected" <%}%>>Tất cả</option>

						<%
							for (DonVi donVi : list_DonVi) {
						%>
						<option value="<%=donVi.getMaDonVi()%>"
							<%if (maDonViQuanLy.equals(donVi.getMaDonVi())) {%>
							selected="selected" <%}%>><%=donVi.getTenDonVi()%></option>
						<%
							}
						%>
					</select> <label>Chọn khóa</label> <select name="khoa" class="form-control"
						id="khoa" onchange="myFunction()">
						<%
							String s_khoa = session.getAttribute("khoa") != null ? session.getAttribute("khoa").toString() : "";
							String[] arr_khoa = {};
							String khoas = "";
							if (s_khoa.equals("")) {
								ObjectDAO<Lop> dao_Lop = new DAO_Lop();
								ArrayList<Lop> list_Lop = dao_Lop.listByQuery("FROM Lop WHERE 1=1 ORDER BY khoa ASC");

								for (Lop lop : list_Lop)
									if (!khoas.contains(lop.getKhoa()))
										khoas += lop.getKhoa() + ";";
								arr_khoa = khoas.split(";");
								session.setAttribute("khoa", khoas);
							} else {
								khoas = session.getAttribute("khoa").toString();
								arr_khoa = khoas.split(";");
							}
						%>
						<option value="all" <%if (maDonViQuanLy.equals("all")) {%>
							selected="selected" <%}%>>Tất cả</option>

						<%
							for (String k : arr_khoa) {
						%>
						<option value="<%=k%>" <%if (khoa.equals(k)) {%>
							selected="selected" <%}%>><%=k%></option>
						<%
							}
						%>
					</select>
					<script type="text/javascript">
						function myFunction() {
							var maDonViQuanLy = document
									.getElementById("maDonViQuanLy").value;
							var khoa = document.getElementById("khoa").value;
							var recordPerPage = document.getElementById("recordPerPage").value;
							var p1 = document.getElementById("p1").value;
							window.location.href = p1 + "&maDonViQuanLy="
									+ maDonViQuanLy + "&khoa=" + khoa+"&recordPerPage="+recordPerPage;

						}
					</script>
				</form>

				<form class="form-inline pull-right" action="exportLop.action">
					<input hidden=""
						value="<%=request.getParameter("maDonViQuanLy") != null ? request.getParameter("maDonViQuanLy") : ""%>"
						name="s_maDVQL"> <input hidden=""
						value="<%=request.getParameter("khoa") != null ? request.getParameter("khoa") : ""%>"
						name="s_khoa">
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
						<th>Mã lớp</th>
						<th>Tên lớp</th>
						<th>Khóa</th>
						<th>Thời gian đào tạo</th>
						<th>Đơn vị quản lý</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Lop obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaLop();
							String tenDoiTuong = obj.getTenLop();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaLop() != null ? obj.getMaLop() : ""%></td>
						<td><%=obj.getTenLop() != null ? obj.getTenLop() : ""%></td>
						<td><%=obj.getKhoa() != null ? obj.getKhoa() : ""%></td>
						<td><%=obj.getNienKhoa() != null ? obj.getNienKhoa() : ""%></td>
						<td><%=obj.getDonVi() == null ? "" : obj.getDonVi().getTenDonVi()%></td>
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






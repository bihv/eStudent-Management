<%@page import="eSm4.modelDao.DAO_DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eSm4.model.DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eCore.model.SinhVien"%>
<%@page import="eCore.modelDao.DAO_TaiKhoanSinhVien"%>
<%@page import="eCore.model.TaiKhoanSinhVien"%>
<%@page import="eSm4.modelDao.DAO_ThongTinNgoaiTru"%>
<%@page import="eSm4.model.ThongTinNgoaiTru"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "ThongTinNgoaiTru";
	String tenTrang = "Thông tin ngoại trú";
	String trangDanhSach = "index.jsp?p=eSm4/pages/thongtinngoaitrus.jsp";
	String[] tk_value = {"maThongTinNgoaiTru", "hoVaTenChuNhaTro", "diaChiNhaTro", "soDienThoaiCuaChuNhaTro",
			"ngayDangKyCuTru", "ngayKeKhaiThongTin"};
	String[] tk_show = {"Mã thông tin ngoại trú", "Họ và tên chủ trọ", "Địa chỉ nhà trọ",
			"Số điện thoại chủ nhà trọ", "Ngày đăng ký cư trú", "Ngày kê khai thông tin"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	//kiểm tra xem tài khoản đang đăng nhập là của sinh viên hay không
	String maDangNhap = session.getAttribute("maDangNhap") != null
			? session.getAttribute("maDangNhap").toString()
			: "";
	TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("taiKhoanDangNhap");
	SinhVien sinhVien = null;
	if (taiKhoan != null && taiKhoan instanceof TaiKhoanSinhVien) {
		TaiKhoanSinhVien tk1 = (TaiKhoanSinhVien) taiKhoan;
		sinhVien = tk1.getSinhVien();
	}

	ObjectDAO<ThongTinNgoaiTru> dao = new DAO_ThongTinNgoaiTru();

	ArrayList<ThongTinNgoaiTru> list = new ArrayList<ThongTinNgoaiTru>();

	String maDot = request.getParameter("maDot");
	maDot = (maDot == null || maDot.equals("null")) ? "all" : maDot;

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof ThongTinNgoaiTru) {
				list = (ArrayList<ThongTinNgoaiTru>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
				if (sinhVien != null)
					list = dao.listByColumns("sinhVien", sinhVien.getMaSinhVien());
			}
		} else
			list = new ArrayList<ThongTinNgoaiTru>();
	} else {
		if (!maDot.equals("all"))
			list = dao.pagination("dotKeKhaiThongTinNgoaiTru = '" + maDot + "'", (long) recordPerPage,
					(long) Long.parseLong(pid) * recordPerPage);
		else
			list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
		if (sinhVien != null)
			list = dao.listByColumns("sinhVien", sinhVien.getMaSinhVien());
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
					<label>Chọn đợt kê khai</label> <select
						name="maDotKeKhaiThongTinNgoaiTru" class="form-control" id="maDot"
						onchange="myFunction()">
						<%
							ObjectDAO<DotKeKhaiThongTinNgoaiTru> dao_DotKeKhaiThongTinNgoaiTru = new DAO_DotKeKhaiThongTinNgoaiTru();
							ArrayList<DotKeKhaiThongTinNgoaiTru> list_DotKeKhaiThongTinNgoaiTru = dao_DotKeKhaiThongTinNgoaiTru
									.listAll();
						%>
						<option value="all" <%if (maDot.equals("all")) {%>
							selected="selected" <%}%>>Tất cả</option>

						<%
							for (DotKeKhaiThongTinNgoaiTru dotKeKhaiThongTinNgoaiTru : list_DotKeKhaiThongTinNgoaiTru) {
						%>
						<option
							value="<%=dotKeKhaiThongTinNgoaiTru.getMaDotKeKhaiThongTinNgoaiTru()%>"
							<%if (maDot.equals(dotKeKhaiThongTinNgoaiTru.getMaDotKeKhaiThongTinNgoaiTru())) {%>
							selected="selected" <%}%>><%=dotKeKhaiThongTinNgoaiTru.getTenDotKeKhaiThongTinNgoaiTru()%></option>
						<%
							}
						%>
					</select>
					<script type="text/javascript">
						function myFunction() {
							var maDot = document.getElementById("maDot").value;
							var recordPerPage = document
									.getElementById("recordPerPage").value;
							var p1 = document.getElementById("p1").value;
							window.location.href = p1 + "&maDot=" + maDot
									+ "&recordPerPage=" + recordPerPage;

						}
					</script>
				</form>

				<form class="form-inline pull-right"
					action="exportThongTinNgoaiTru.action">
					<input hidden=""
						value="<%=request.getParameter("maDot") != null ? request.getParameter("maDot") : ""%>"
						name="maDotKeKhaiThongTinNgoaiTru">
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
						<th>Mã thông tin ngoại trú</th>
						<th>Sinh viên</th>
						<th>Đợt kê khai</th>
						<th>Họ tên chủ trọ</th>
						<th>Số điện thoại chủ trọ</th>
						<th>Ngày đăng ký cư trú</th>
						<th>Ngày kê khai</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (ThongTinNgoaiTru obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaThongTinNgoaiTru();
							String tenDoiTuong = obj.getMaThongTinNgoaiTru();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaThongTinNgoaiTru()%></td>
						<td><%=obj.getSinhVien().getHoDem() + " " + obj.getSinhVien().getTen()%></td>
						<td><%=obj.getDotKeKhaiThongTinNgoaiTru().getTenDotKeKhaiThongTinNgoaiTru()%></td>
						<td><%=obj.getHoVaTenChuNhaTro()%></td>
						<td><%=obj.getSoDienThoaiCuaChuNhaTro()%></td>
						<td><%=Util_Date.dateToString2(obj.getNgayDangKyCuTru())%></td>
						<td><%=Util_Date.dateToString2(obj.getNgayKeKhaiThongTin())%></td>
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


<%
	if (sinhVien != null) {
%>
<script>
	document.getElementById("nutNhapLieuExcel").style.display = "none";
	document.getElementById("nutThemMoi").style.display = "none";
	document.getElementById("danhchonguoiquanly").style.display = "none";
</script>
<%
	} else {
%>
<script>
	document.getElementById("nutNhapLieuExcel").style.display = "none";
	document.getElementById("nutThemMoi").style.display = "none";
</script>
<%
	}
%>

<%
	session.removeAttribute("msg");
%>
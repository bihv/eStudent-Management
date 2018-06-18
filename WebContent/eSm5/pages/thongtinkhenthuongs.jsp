<%@page import="eCore.modelDao.DAO_SinhVien"%>
<%@page import="eCore.model.SinhVien"%>
<%@page import="eCore.modelDao.DAO_TaiKhoanSinhVien"%>
<%@page import="eCore.model.TaiKhoanSinhVien"%>
<%@page import="eSm5.modelDao.DAO_ThongTinKhenThuong"%>
<%@page import="eSm5.model.ThongTinKhenThuong"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "ThongTinKhenThuong";
	String tenTrang = "Thông tin khen thưởng";
	String trangDanhSach = "index.jsp?p=eSm5/pages/thongtinkhenthuongs.jsp";
	String[] tk_value = {"maThongTinKhenThuong", "noiDungKhenThuong", "thoiGianKhenThuong"};
	String[] tk_show = {"Mã thông tin khen thưởng", "Nội dung khen thưởng",
			"Thời gian khen thưởng"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	// kiểm tra xem tài khoản đang đăng nhập là của sinh viên hay không
	String maDangNhap = session.getAttribute("maDangNhap") != null
			? session.getAttribute("maDangNhap").toString()
			: "";
	TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("taiKhoanDangNhap");
	SinhVien sinhVien = null;
	if (taiKhoan != null && taiKhoan instanceof TaiKhoanSinhVien) {
		TaiKhoanSinhVien tk1 = (TaiKhoanSinhVien) taiKhoan;
		sinhVien = tk1.getSinhVien();
	}

	ObjectDAO<ThongTinKhenThuong> dao = new DAO_ThongTinKhenThuong();

	ArrayList<ThongTinKhenThuong> list = new ArrayList<ThongTinKhenThuong>();

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof ThongTinKhenThuong) {
				list = (ArrayList<ThongTinKhenThuong>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
				if (sinhVien != null)
					list = dao.listByColumns("sinhVien", sinhVien.getMaSinhVien());
			}
		} else
			list = new ArrayList<ThongTinKhenThuong>();
	} else {
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
			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Mã thông tin khen thưởng</th>
						<th>Sinh viên</th>
						<th>Nội dung khen thưởng</th>
						<th>Thời gian khen thưởng</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (ThongTinKhenThuong obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaThongTinKhenThuong();
							String tenDoiTuong = obj.getMaThongTinKhenThuong();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaThongTinKhenThuong()%></td>
						<td><%=obj.getSinhVien().getHoDem() + " " + obj.getSinhVien().getTen()%></td>
						<td><%=obj.getNoiDungKhenThuong()%></td>
						<td><%=Util_Date.dateToString2(obj.getThoiGianKhenThuong())%></td>
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
		System.out.println("ạkdlhaskdjhaskjdgkajshdkjasdhsakj");
%>
<script>
	document.getElementById("nutThemMoi").style.display = "none";
	document.getElementById("nutNhapLieuExcel").style.display = "none";

	document.getElementById("xemChiTietVaChinhSuaDoiTuong").style.display = "none";
	document.getElementById("xoaDoiTuong").style.display = "none";
</script>
<%
	}
%>

<script>
	document.getElementById("nutNhapLieuExcel").style.display = "none";
</script>

<%session.removeAttribute("msg"); %>
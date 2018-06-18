<!-- đây là trang xem lại lịch sử đăng ký BHTN của nhân viên -->
<%@page import="eCore.model.NhanVien"%>
<%@page import="eCore.modelDao.DAO_TaiKhoanNhanVien"%>
<%@page import="eCore.model.TaiKhoanNhanVien"%>
<%@page import="eSm3.modelDao.DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien"%>
<%@page import="eSm3.model.ThongTinDangKyBaoHiemTuNguyenNhanVien"%>
<%@page import="eCore.util.Util_Number"%>
<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiem"%>
<%@page import="eSm3.model.DotDangKyBaoHiem"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "ThongTinDangKyBaoHiemTuNguyenNhanVien";
	String tenTrang = "Thông tin đăng ký bảo hiểm tự nguyện nhân viên";
	String[] tk_value = {"maThongTinDangKyBaoHiemTuNguyen", "dotDangKyBaoHiem", "thoiGianDangKy", "nhanVien"};
	String[] tk_show = {"Mã thông tin đăng ký bảo hiểm tự nguyện", "Đợt đăng ký bảo hiểm", "Thời gian đăng ký",
			"Nhân viên"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	//kiểm tra xem tài khoản đang đăng nhập là của nhân viên hay không
	String maDangNhap = session.getAttribute("maDangNhap") != null
			? session.getAttribute("maDangNhap").toString()
			: "";
	TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("taiKhoanDangNhap");
	NhanVien nhanVien = null;
	if (taiKhoan != null && taiKhoan instanceof TaiKhoanNhanVien) {
		TaiKhoanNhanVien tk1 = (TaiKhoanNhanVien) taiKhoan;
		nhanVien = tk1.getNhanVien();
	}

	ObjectDAO<ThongTinDangKyBaoHiemTuNguyenNhanVien> dao = new DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien();

	ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien> list = new ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien>();

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof ThongTinDangKyBaoHiemTuNguyenNhanVien) {
				list = (ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
				if (nhanVien != null)
					list = dao.listByColumns("nhanVien", nhanVien.getMaNhanVien());
			}
		} else
			list = new ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien>();
	} else {
		list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
		if (nhanVien != null)
			list = dao.listByColumns("nhanVien", nhanVien.getMaNhanVien());
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
						<th>Mã thông tin đăng ký bảo hiểm tự nguyện</th>
						<th>Đợt đăng ký</th>
						<th>Thời gian đăng ký</th>
						<th>Nhân viên</th>
						<th>Trạng thái</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (ThongTinDangKyBaoHiemTuNguyenNhanVien obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaThongTinDangKyBaoHiemTuNguyen();
							String tenDoiTuong = obj.getMaThongTinDangKyBaoHiemTuNguyen();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaThongTinDangKyBaoHiemTuNguyen()%></td>
						<td><%=obj.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem()%></td>
						<td><%=Util_Date.dateToString2(obj.getThoiGianDangKy())%></td>
						<td><%=obj.getNhanVien().getTenNhanVien()%></td>
						<td><%=obj.getTrangThai()%></td>
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

<script>
	document.getElementById("nutNhapLieuExcel").style.display = "none";
	document.getElementById("nutThemMoi").style.display = "none";
</script>

<%session.removeAttribute("msg"); %>
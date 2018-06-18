<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiemYTe"%>
<%@page import="eSm3.model.DotDangKyBaoHiemYTe"%>
<%@page import="eCore.model.SinhVien"%>
<%@page import="eCore.modelDao.DAO_TaiKhoanSinhVien"%>
<%@page import="eCore.model.TaiKhoanSinhVien"%>
<%@page import="eSm3.modelDao.DAO_ThongTinDangKyBaoHiemYTeSinhVien"%>
<%@page import="eSm3.model.ThongTinDangKyBaoHiemYTeSinhVien"%>
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
	String tenLop = "ThongTinDangKyBaoHiemYTeSinhVien";
	String tenTrang = "Thông tin đăng ký bảo hiểm y tế sinh viên";
	String trangDanhSach = "index.jsp?p=eSm3/pages/thongtindangkybaohiemytesinhviens.jsp";
	String[] tk_value = {"maThongTinDangKyBaoHiemYTe",  "thoiGianDangKy"};
	String[] tk_show = {"Mã thông tin đăng ký bảo hiểm y tế", "Thời gian đăng ký"};
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
	ObjectDAO<ThongTinDangKyBaoHiemYTeSinhVien> dao = new DAO_ThongTinDangKyBaoHiemYTeSinhVien();

	ArrayList<ThongTinDangKyBaoHiemYTeSinhVien> list = new ArrayList<ThongTinDangKyBaoHiemYTeSinhVien>();

	String maDot = request.getParameter("maDot");
	maDot = (maDot == null || maDot.equals("null")) ? "all" : maDot;

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof ThongTinDangKyBaoHiemYTeSinhVien) {
				list = (ArrayList<ThongTinDangKyBaoHiemYTeSinhVien>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
				if (sinhVien != null)
					list = dao.listByColumns("sinhVien", sinhVien.getMaSinhVien());
			}
		} else
			list = new ArrayList<ThongTinDangKyBaoHiemYTeSinhVien>();
	} else {
		if (!maDot.equals("all"))
			list = dao.pagination("dotDangKyBaoHiem = '" + maDot + "'", (long) recordPerPage,
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

			<div id = "danhchonguoiquanly">
				<form class="form-inline pull-left">
					<label>Chọn đợt đăng ký</label> <select name="maDotDangKyBaoHiem"
						class="form-control" id="maDot" onchange="myFunction()">
						<%
							ObjectDAO<DotDangKyBaoHiemYTe> dao_DotDangKyBaoHiemYTe = new DAO_DotDangKyBaoHiemYTe();
							ArrayList<DotDangKyBaoHiemYTe> list_DotDangKyBaoHiemYTe = dao_DotDangKyBaoHiemYTe.listByColumnLike("loaiBaoHiem", "Bảo hiểm y tế sinh viên");
						%>
						<option value="all" <%if (maDot.equals("all")) {%>
							selected="selected" <%}%>>Tất cả</option>

						<%
							for (DotDangKyBaoHiemYTe dotDangKyBaoHiemYTe : list_DotDangKyBaoHiemYTe) {
						%>
						<option value="<%=dotDangKyBaoHiemYTe.getMaDotDangKyBaoHiem()%>"
							<%if (maDot.equals(dotDangKyBaoHiemYTe.getMaDotDangKyBaoHiem())) {%>
							selected="selected" <%}%>><%=dotDangKyBaoHiemYTe.getTenDotDangKyBaoHiem()%></option>
						<%
							}
						%>
					</select>
					<script type="text/javascript">
						function myFunction() {
							var maDot = document.getElementById("maDot").value;
							var recordPerPage = document.getElementById("recordPerPage").value;
							var p1 = document.getElementById("p1").value;
							window.location.href = p1 + "&maDot=" + maDot+"&recordPerPage="+recordPerPage;

						}
					</script>
				</form>

				<form class="form-inline pull-right"
					action="exportThongTinDangKyBaoHiemYTeSinhVien.action">
					<input hidden=""
						value="<%=request.getParameter("maDot")!=null?request.getParameter("maDot"):""%>"
						name="maDotDangKyBaoHiem">
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
						<th>Mã thông tin đăng ký bảo hiểm y tế</th>
						<th>Đợt đăng ký</th>
						<th>Thời gian đăng ký</th>
						<th>Sinh viên</th>
						<th>Cơ sở khám chữa bệnh</th>
						<th>Trạng thái</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (ThongTinDangKyBaoHiemYTeSinhVien obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaThongTinDangKyBaoHiemYTe();
							String tenDoiTuong = obj.getMaThongTinDangKyBaoHiemYTe();
					%>
					<tr class="odd gradeX">
						<td><input type="checkbox"
							<%=sinhVien != null ? "style='display:none'" : ""%>
							id="<%=obj.getMaThongTinDangKyBaoHiemYTe()%>"
							value="<%=obj.getMaThongTinDangKyBaoHiemYTe()%>"
							onclick="checkedFunction(this)"> <%=obj.getMaThongTinDangKyBaoHiemYTe()%>
						</td>
						<td><%=obj.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem()%></td>
						<td><%=Util_Date.dateToString2(obj.getThoiGianDangKy())%></td>
						<td><%=obj.getSinhVien().getHoDem() + " " + obj.getSinhVien().getTen()%></td>
						<td><%=obj.getTenCoSoKhamChuaBenh()%></td>
						<td><%=obj.getTrangThai()%></td>
						<td style="text-align: center;"><%@ include
								file="../../ePartial/menupullcuadoituong.jsp"%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<script type="text/javascript">
				function checkedFunction(arg) {
					var x = document.getElementById("maThongTinDangKyBaoHiem");
					var y = document
							.getElementById("maThongTinDangKyBaoHiem_KhongDuyet");
					if (arg.checked == true) {
						x.value = x.value + ",";
						x.value = x.value + arg.id;

						y.value = y.value + ",";
						y.value = y.value + arg.id;
					}
					if (arg.checked == false) {
						x.value = x.value.replace("," + arg.id, "");
						y.value = y.value.replace("," + arg.id, "");
					}
				}
			</script>
			<form class="pull-right form-inline"
				action="duyetDangKyBaoHiemYTeSinhVien.action" method="post">
				<input name="listMaThongTinDangKyBaoHiemzzzzzzzz" hidden=""
					id="maThongTinDangKyBaoHiem"> <input type="submit"
					id="nutDuyet" value="Duyệt" class="btn btn-primary">
			</form>

			<form class="pull-right form-inline"
				action="huyDuyetDangKyBaoHiemYTeSinhVien.action" method="post">
				<input name="listMaThongTinDangKyBaoHiemzzzzzzzz" hidden=""
					id="maThongTinDangKyBaoHiem_KhongDuyet"> <input
					type="submit" id="nutHuyDuyet" value="Không duyệt"
					class="btn btn-warning">
			</form>
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
	document.getElementById("nutDuyet").style.display = "none";
	document.getElementById("nutHuyDuyet").style.display = "none";
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

<%session.removeAttribute("msg"); %>
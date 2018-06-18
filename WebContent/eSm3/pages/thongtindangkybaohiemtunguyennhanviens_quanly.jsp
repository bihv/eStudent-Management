<!-- đây là trang xem danh sách đã đăng ký BHTN của nhân viên -->
<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiemTuNguyen"%>
<%@page import="eSm3.model.DotDangKyBaoHiemTuNguyen"%>
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
	String tenLop = "ThongTinDangKyBaoHiemTuNguyenNhanVien_quanly";
	String tenTrang = "Thông tin đăng ký bảo hiểm tự nguyện nhân viên";
	String[] tk_value = {"maThongTinDangKyBaoHiemTuNguyen", "dotDangKyBaoHiem", "thoiGianDangKy", "nhanVien"};
	String[] tk_show = {"Mã thông tin đăng ký bảo hiểm tự nguyện", "Đợt đăng ký bảo hiểm", "Thời gian đăng ký",
			"Nhân viên"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<ThongTinDangKyBaoHiemTuNguyenNhanVien> dao = new DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien();

	ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien> list = new ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien>();


	String maDot = request.getParameter("maDot");
	maDot = (maDot == null || maDot.equals("null")) ? "all" : maDot;

	
	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof ThongTinDangKyBaoHiemTuNguyenNhanVien) {
				list = (ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien>();
	} else {

		if (!maDot.equals("all"))
			list = dao.pagination("dotDangKyBaoHiem = '" + maDot + "'", (long) recordPerPage,
					(long) Long.parseLong(pid) * recordPerPage);
		else
			list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
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

			<div>
				<form class="form-inline pull-left">
					<label>Chọn đợt đăng ký</label> <select name="maDotDangKyBaoHiem"
						class="form-control" id="maDot" onchange="myFunction()">
						<%
							ObjectDAO<DotDangKyBaoHiemTuNguyen> dao_DotDangKyBaoHiemTuNguyen = new DAO_DotDangKyBaoHiemTuNguyen();
							ArrayList<DotDangKyBaoHiemTuNguyen> list_DotDangKyBaoHiemTuNguyen = dao_DotDangKyBaoHiemTuNguyen.listByColumnLike("loaiBaoHiem", "Bảo hiểm tự nguyện nhân viên");
						%>
						<option value="all" <%if (maDot.equals("all")) {%>
							selected="selected" <%}%>>Tất cả</option>

						<%
							for (DotDangKyBaoHiemTuNguyen dotDangKyBaoHiemTuNguyen : list_DotDangKyBaoHiemTuNguyen) {
						%>
						<option value="<%=dotDangKyBaoHiemTuNguyen.getMaDotDangKyBaoHiem()%>"
							<%if (maDot.equals(dotDangKyBaoHiemTuNguyen.getMaDotDangKyBaoHiem())) {%>
							selected="selected" <%}%>><%=dotDangKyBaoHiemTuNguyen.getTenDotDangKyBaoHiem()%></option>
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
					action="exportThongTinDangKyBaoHiemTuNguyenNhanVien.action">
					<input hidden=""
						value="<%=request.getParameter("maDot") != null ? request.getParameter("maDot") : ""%>"
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
						<td><input type="checkbox"
							id="<%=obj.getMaThongTinDangKyBaoHiemTuNguyen()%>"
							value="<%=obj.getMaThongTinDangKyBaoHiemTuNguyen()%>"
							onclick="checkedFunction(this)"> <%=obj.getMaThongTinDangKyBaoHiemTuNguyen()%>
						</td>
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
				action="duyetDangKyBaoHiemTuNguyenNhanVien.action" method="post">
				<input name="listMaThongTinDangKyBaoHiemzzzzzzzz"
					id="maThongTinDangKyBaoHiem" hidden=""> <input
					type="submit" id="nutDuyet" value="Duyệt" class="btn btn-primary">
			</form>

			<form class="pull-right form-inline"
				action="huyDuyetDangKyBaoHiemTuNguyenNhanVien.action" method="post">
				<input name="listMaThongTinDangKyBaoHiemzzzzzzzz"
					id="maThongTinDangKyBaoHiem_KhongDuyet" hidden=""> <input
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



<script>
	document.getElementById("nutNhapLieuExcel").style.display = "none";
	document.getElementById("nutThemMoi").style.display = "none";
</script>

<%session.removeAttribute("msg"); %>
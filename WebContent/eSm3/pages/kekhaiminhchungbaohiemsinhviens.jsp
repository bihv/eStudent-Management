<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiemYTe"%>
<%@page import="eSm3.model.DotDangKyBaoHiemYTe"%>
<%@page import="eSm3.modelDao.DAO_KeKhaiMinhChungBaoHiemSinhVien"%>
<%@page import="eSm3.model.KeKhaiMinhChungBaoHiemSinhVien"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "KeKhaiMinhChungBaoHiemSinhVien";
	String tenTrang = "Quản lý kê khai minh chứng bảo hiểm sinh viên";
	String trangDanhSach = "index.jsp?p=eSm3/pages/kekhaiminhchungbaohiemsinhviens.jsp";
	String[] tk_value = { "maKeKhaiMinhChungDongBaoHiem", "dotDangKyBaoHiem", "sinhVien" };
	String[] tk_show = { "Mã kê khai minh chứng đóng bảo hiểm", "Đợt đăng ký bảo hiểm", "Sinh viên" };
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<KeKhaiMinhChungBaoHiemSinhVien> dao = new DAO_KeKhaiMinhChungBaoHiemSinhVien();

	ArrayList<KeKhaiMinhChungBaoHiemSinhVien> list = new ArrayList<KeKhaiMinhChungBaoHiemSinhVien>();

	String maDot = request.getParameter("maDot");
	maDot = (maDot == null || maDot.equals("null")) ? "all" : maDot;
	
	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
	if (listTemp.get(0) instanceof KeKhaiMinhChungBaoHiemSinhVien) {
				list = (ArrayList<KeKhaiMinhChungBaoHiemSinhVien>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<KeKhaiMinhChungBaoHiemSinhVien>();
	} else {
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
					action="exportKeKhaiMinhChungBaoHiemSinhVien.action">
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
						<th>Mã kê khai</th>
						<th>Đợt đăng ký bảo hiểm</th>
						<th>Nhân viên</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (KeKhaiMinhChungBaoHiemSinhVien obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaKeKhaiMinhChungDongBaoHiem();
							String tenDoiTuong = obj.getMaKeKhaiMinhChungDongBaoHiem();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaKeKhaiMinhChungDongBaoHiem()%></td>
						<td><%=obj.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem()%></td>
						<td><%=obj.getSinhVien().getHoDem() + " " + obj.getSinhVien().getTen()%></td>
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
</script>

<%session.removeAttribute("msg"); %>
<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiemTuNguyen"%>
<%@page import="eSm3.model.DotDangKyBaoHiemTuNguyen"%>
<%@page import="eCore.util.Util_Number"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "DotDangKyBaoHiemTuNguyen";
	String tenTrang = "Quản lý đợt đăng ký bảo hiểm tự nguyện";
	String trangDanhSach = "index.jsp?p=eSm3/pages/dotdangkybaohiemtunguyens.jsp";
	String[] tk_value = { "maDotDangKyBaoHiem", "tenDotDangKyBaoHiem", "ngayBatDau", "ngayKetThuc", "soTien" };
	String[] tk_show = { "Mã đợt đăng ký", "Tên đợt đăng ký", "Ngày bắt đầu", "Ngày kết thúc", "Số tiền" };
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<DotDangKyBaoHiemTuNguyen> dao = new DAO_DotDangKyBaoHiemTuNguyen();

	ArrayList<DotDangKyBaoHiemTuNguyen> list = new ArrayList<DotDangKyBaoHiemTuNguyen>();
	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof DotDangKyBaoHiemTuNguyen) {
				list = (ArrayList<DotDangKyBaoHiemTuNguyen>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<DotDangKyBaoHiemTuNguyen>();
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
			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Mã đợt đăng ký</th>
						<th>Tên đợt đăng ký</th>
						<th>Ngày bắt đầu</th>
						<th>Ngày kết thúc</th>
						<th>Số tiền</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (DotDangKyBaoHiemTuNguyen obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaDotDangKyBaoHiem();
							String tenDoiTuong = obj.getTenDotDangKyBaoHiem();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaDotDangKyBaoHiem()%></td>
						<td><%=obj.getTenDotDangKyBaoHiem()%></td>
						<td><%=Util_Date.dateToString2(obj.getNgayBatDau())%></td>
						<td><%=Util_Date.dateToString2(obj.getNgayKetThuc())%></td>
						<td><%=Util_Number.number2String(obj.getSoTien())%></td>
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

<%session.removeAttribute("msg"); %>
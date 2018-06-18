<%@page import="eCore.util.Util_Date"%>
<%@page import="eCore.modelDao.DAO_NamHoc"%>
<%@page import="eCore.model.NamHoc"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "NamHoc";
	String tenTrang = "Quản lý Năm Học";
	String trangDanhSach = "index.jsp?p=eCore/pages/namhocs.jsp";
	String[] tk_value = {"maNamHoc", "tenNamHoc"};
	String[] tk_show = {"Mã năm học", "Tên năm học"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<NamHoc> dao = new DAO_NamHoc();

	ArrayList<NamHoc> list = new ArrayList<NamHoc>();

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof NamHoc) {
				list = (ArrayList<NamHoc>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<NamHoc>();
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
						<th>Mã năm học</th>
						<th>Tên năm học</th>
						<th>Ngày bắt đầu</th>
						<th>Ngày kết thúc</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (NamHoc obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaNamHoc();
							String tenDoiTuong = obj.getTenNamHoc();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaNamHoc()%></td>
						<td><%=obj.getTenNamHoc()%></td>
						<td><%=Util_Date.dateToString2(obj.getNgayBatDau())%></td>
						<td><%=Util_Date.dateToString2(obj.getNgayKetThuc())%></td>
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
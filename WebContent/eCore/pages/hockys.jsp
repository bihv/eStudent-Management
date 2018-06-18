<%@page import="eCore.util.Util_Date"%>
<%@page import="eCore.modelDao.DAO_HocKy"%>
<%@page import="eCore.model.HocKy"%>
<%@page import="eCore.modelDao.DAO_HocKy"%>
<%@page import="eCore.model.HocKy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.modelDao.DAO_Lop"%>
<%@page import="eCore.model.Lop"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "HocKy";
	String tenTrang = "Quản lý Học Kỳ";
	String trangDanhSach = "index.jsp?p=eCore/pages/hockys.jsp";
	String[] tk_value = { "maHocKy", "tenHocKy"};
	String[] tk_show = { "Mã học kỳ", "Tên học kỳ"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<HocKy> dao = new DAO_HocKy();

	ArrayList<HocKy> list = new ArrayList<HocKy>();

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
	if (listTemp.get(0) instanceof HocKy) {
				list = (ArrayList<HocKy>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<HocKy>();
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
						<th>Năm học</th>
						<th>Mã học kỳ</th>
						<th>Tên học kỳ</th>
						<th>Ngày bắt đầu</th>
						<th>Ngày kết thúc</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (HocKy obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaHocKy();
							String tenDoiTuong = obj.getTenHocKy();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getNamHoc() == null ? "" : obj.getNamHoc().getTenNamHoc()%></td>
						<td><%=obj.getMaHocKy()%></td>
						<td><%=obj.getTenHocKy()%></td>
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
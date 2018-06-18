<%@page import="eSm4.modelDao.DAO_DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eSm4.model.DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "DotKeKhaiThongTinNgoaiTru";
	String tenTrang = "Quản lý đợt kê khai thông tin ngoại trú";
	String trangDanhSach = "index.jsp?p=eSm4/pages/dotkekhaithongtinngoaitrus.jsp";
	String[] tk_value = {"maDotKeKhaiThongTinNgoaiTru", "tenDotKeKhaiThongTinNgoaiTru", "ngayBatDau",
			"ngayKetThuc"};
	String[] tk_show = {"Mã đợt kê khai thông tin ngoại trú", "Tên đợt kê khai thông tin ngoại trú",
			"Ngày bắt đầu", "Ngày kết thúc"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<DotKeKhaiThongTinNgoaiTru> dao = new DAO_DotKeKhaiThongTinNgoaiTru();

	ArrayList<DotKeKhaiThongTinNgoaiTru> list = new ArrayList<DotKeKhaiThongTinNgoaiTru>();

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof DotKeKhaiThongTinNgoaiTru) {
				list = (ArrayList<DotKeKhaiThongTinNgoaiTru>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<DotKeKhaiThongTinNgoaiTru>();
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
						<th>Mã đợt kê khai</th>
						<th>Tên đợt kê khai</th>
						<th>Ngày bắt đầu</th>
						<th>Ngày kết thúc</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (DotKeKhaiThongTinNgoaiTru obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaDotKeKhaiThongTinNgoaiTru();
							String tenDoiTuong = obj.getTenDotKeKhaiThongTinNgoaiTru();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaDotKeKhaiThongTinNgoaiTru()%></td>
						<td><%=obj.getTenDotKeKhaiThongTinNgoaiTru()%></td>
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

<%session.removeAttribute("msg"); %>
<%@page import="eSm3.modelDao.DAO_CoSoKhamChuaBenh"%>
<%@page import="eSm3.model.CoSoKhamChuaBenh"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "CoSoKhamChuaBenh";
	String tenTrang = "Quản lý cơ sở khám chữa bệnh";
	String trangDanhSach = "index.jsp?p=eSm3/pages/cosokhamchuabenhs.jsp";
	String[] tk_value = {"maCoSoKhamChuaBenh", "tenCoSoKhamChuaBenh", "diaChi",
			"thongTinDangKyKhamChuaBenhBanDau"};
	String[] tk_show = {"Mã cơ sở khám chữa bệnh", "Tên cơ sở khám chữa bệnh", "Địa chỉ",
			"Thông tin đăng ký khám chữa bệnh ban đầu"};
%>

<%@ include file="../../ePartial/code-header.jsp"%>

<%
	ObjectDAO<CoSoKhamChuaBenh> dao = new DAO_CoSoKhamChuaBenh();

	ArrayList<CoSoKhamChuaBenh> list = new ArrayList<CoSoKhamChuaBenh>();

	if (session.getAttribute("checkTimKiem") != null) {
		ArrayList listTemp = (ArrayList) session.getAttribute("arr");
		if (listTemp.size() > 0) {
			if (listTemp.get(0) instanceof CoSoKhamChuaBenh) {
				list = (ArrayList<CoSoKhamChuaBenh>) listTemp;
			} else {
				session.setAttribute("checkTimKiem", null);
				list = dao.pagination((long) recordPerPage, (long) Long.parseLong(pid) * recordPerPage);
			}
		} else
			list = new ArrayList<CoSoKhamChuaBenh>();
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

			<!-- 			xóa toàn bộ thông tin cơ sở khám chữa bệnh -->
			<form action="deleteAllCoSoKhamChuaBenh.action" class="pull-right">
				<button type="submit" class="btn btn-danger">
					<img alt="" src="content/images/delete-16.png"> Xóa toàn bộ
					thông tin cơ sở khám chữa bệnh
				</button>
			</form>

			<table width="100%"
				class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr>
						<th>Mã cơ sở khám chữa bệnh</th>
						<th>Tên cơ sở khám chữa bệnh</th>
						<th>Địa chỉ</th>
						<th>Thông tin đăng ký khám chữa bệnh ban đầu</th>
						<th>Xử lý</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (CoSoKhamChuaBenh obj : list) {
							//Bat buoc co de bo vao doan code xem chi tiet, chinh sua va xoa
							String maDoiTuong = obj.getMaCoSoKhamChuaBenh();
							String tenDoiTuong = obj.getTenCoSoKhamChuaBenh();
					%>
					<tr class="odd gradeX">
						<td><%=obj.getMaCoSoKhamChuaBenh()%></td>
						<td><%=obj.getTenCoSoKhamChuaBenh()%></td>
						<td><%=obj.getDiaChi()%></td>
						<td><%=obj.getThongTinDangKyKhamChuaBenhBanDau()%></td>
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

<!-- Modal import excel-->
<%@ include file="../../ePartial/nhapexcelModal.jsp"%>

<%
	if (1 == 1) {
%>
<script>
	document.getElementById("nuttailai").style.display = "none";
</script>
<%
	}
%>

<%session.removeAttribute("msg");%>
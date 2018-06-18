<%@page import="eSm4.modelDao.DAO_DotKeKhaiThongTinNgoaiTru"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eSm4.model.DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@page import="java.util.Date"%>
<%@page import="eSm4.model.DotKeKhaiThongTinNgoaiTru"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eSm4.modelDao.DAO_DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>







<%
	// lay ra thoi gian cua dot dang ky dau tien => xac dinh nam hoc
	ObjectDAO<DotKeKhaiThongTinNgoaiTru> obj_DotKeKhaiThongTinNgoaiTru = new DAO_DotKeKhaiThongTinNgoaiTru();
	ArrayList<DotKeKhaiThongTinNgoaiTru> ls_DotDangKyNgoaiTru = obj_DotKeKhaiThongTinNgoaiTru.listAll();
	Date minDate = new Date();
	for (int i = 0; i < ls_DotDangKyNgoaiTru.size(); i++) {
		if (minDate.after(ls_DotDangKyNgoaiTru.get(i).getNgayBatDau()))
			minDate = ls_DotDangKyNgoaiTru.get(i).getNgayBatDau();
	}
	System.out.println("mindate = " + minDate.toString());
	// tu thang 9 tro ve sau, se lay nam + 1. 
	// vd: 10/9/2018 => nam hoc 2018-2019
	// vd: 10/4/2018 => nam hoc 2017-2018
	int start_year = 0;
	int end_year = 0;
	if (minDate.getMonth() + 1 >= 9)
		start_year = minDate.getYear() + 1900;
	else
		start_year = minDate.getYear() + 1900 - 1;
	end_year = start_year + 1;
%>

<%
	// lay ra nam da chon
	String namHoc = request.getParameter("namHoc"); // 2017-2018
	// truong hop mac dinh khi load trang, nguoi dung chua chon nam hoc
	if (namHoc == null || namHoc.equals("null") || namHoc.equals("")) {
		namHoc = minDate.getYear() + 1900 + "-" + minDate.getYear() + 1901;
		response.sendRedirect(
				"index.jsp?p=eSm4/pages/baocaosinhvienngoaitru.jsp&namHoc=" + start_year + "-" + end_year);
	}
	String[] arr = namHoc.split("-");
	int namBatDau = Integer.parseInt(arr[0]);
	int namKetThuc = Integer.parseInt(arr[1]);
%>
<div class="panel panel-warning">
	<div class="panel-heading">Báo cáo sinh viên ngoại trú</div>
	<div class="panel-body">
		<form class="form-group" action="">
			<div class="col-md-9">
				<label class="control-label">Chọn năm học</label> <select
					class="form-control" id="namHoc" onchange="changeFunc();">
					<%
						for (int i = start_year; i < new Date().getYear() + 1900; i++) {
							int bd = i;
							int kt = i + 1;
					%>
					<option <%if (namHoc.equals(bd + "-" + kt)) {%> selected="selected"
						<%}%>>Năm học
						<%=i%>-<%=i + 1%></option>
					<%
						}
					%>
				</select>
			</div>

			<div class="col-md-3">
				<label class="control-label">&nbsp</label> <a type="submit"
					class="form-control btn btn-warning"
					href="index.jsp?p=eSm4/pages/baocaosinhvienngoaitru.jsp&namHoc=<%=start_year%>-<%=end_year%>">
					<img alt="" src="content/images/report-32.png" width="16px"
					height="16px"> Thống kê
				</a>
			</div>
		</form>
	</div>
</div>

<%session.removeAttribute("msg"); %>
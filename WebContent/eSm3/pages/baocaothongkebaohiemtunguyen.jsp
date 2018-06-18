<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiemTuNguyen"%>
<%@page import="eSm3.model.DotDangKyBaoHiemTuNguyen"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiemYTe"%>
<%@page import="eSm3.model.DotDangKyBaoHiemYTe"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="panel panel-primary">
	<div class="panel-heading">Báo cáo thống kê thông tin đăng ký bảo
		hiểm tự nguyện</div>
	<div class="panel-body">
		<form class="form-group"
			action="exportThongTinDangKyBaoHiemTuNguyenSinhVien.action">
			<div class="col-md-9">
				<label class="control-label">Chọn đợt đăng ký</label> <select
					class="form-control" name="maDotDangKyBaoHiem">
					<%
						ObjectDAO<DotDangKyBaoHiemTuNguyen> dao_DotDangKyBHTN = new DAO_DotDangKyBaoHiemTuNguyen();
						ArrayList<DotDangKyBaoHiemTuNguyen> list_DotDangKyBHTN = dao_DotDangKyBHTN.listAll();
						for (DotDangKyBaoHiemTuNguyen dotDangKyBaoHiemTuNguyen : list_DotDangKyBHTN) {
					%>
					<option value="<%=dotDangKyBaoHiemTuNguyen.getMaDotDangKyBaoHiem()%>"><%=dotDangKyBaoHiemTuNguyen.getTenDotDangKyBaoHiem()%></option>
					<%
						}
					%>
				</select>
			</div>
			<div class="col-md-3">
			<label class="control-label">&nbsp</label>
				<button type="submit" class="form-control btn btn-success" value="">
					<img alt="" src="content/images/excel-32.png" width="16px"
						height="16px"> Xuất danh sách excel
				</button>
			</div>
		</form>
	</div>
</div>


<%session.removeAttribute("msg"); %>
<%@page import="java.util.Date"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eSm3.modelDao.DAO_DotDangKyBaoHiemYTe"%>
<%@page import="eSm3.model.DotDangKyBaoHiemYTe"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="panel panel-primary">
	<div class="panel-heading">Báo cáo thống kê thông tin khen thưởng</div>
	<div class="panel-body">
		<form class="form-group" action="exportThongTinKhenThuong.action">
			<div class="col-md-4">
				<label class="control-label">Chọn ngày bắt đầu</label> <input
					type="date" name="s_ngayBatDau" class="form-control"
					value="<%=Util_Date.dateToString(new Date())%>">
			</div>

			<div class="col-md-4">
				<label class="control-label">Chọn ngày kết thúc</label> <input
					type="date" name="s_ngayKetThuc" class="form-control"
					value="<%=Util_Date.dateToString(new Date())%>">
			</div>

			<div class="col-md-3">
				<label class="control-label"> &nbsp</label>
				<button type="submit" class="form-control btn btn-success" value="">
					<img alt="" src="content/images/excel-32.png" width="16px"
						height="16px"> Xuất danh sách excel
				</button>
			</div>
		</form>
	</div>
</div>

<div class="panel panel-primary">
	<div class="panel-heading">Báo cáo thống kê thông tin kỷ luật</div>
	<div class="panel-body">
		<form class="form-group" action="exportThongTinKyLuat.action">
			<div class="col-md-4">
				<label class="control-label">Chọn ngày bắt đầu</label> <input
					type="date" name="s_ngayBatDau" class="form-control"
					value="<%=Util_Date.dateToString(new Date())%>">
			</div>

			<div class="col-md-4">
				<label class="control-label">Chọn ngày kết thúc</label> <input
					type="date" name="s_ngayKetThuc" class="form-control"
					value="<%=Util_Date.dateToString(new Date())%>">
			</div>

			<div class="col-md-3">
				<label class="control-label"> &nbsp</label>
				<button type="submit" class="form-control btn btn-success" value="">
					<img alt="" src="content/images/excel-32.png" width="16px"
						height="16px"> Xuất danh sách excel
				</button>
			</div>
		</form>
	</div>
</div>


<%session.removeAttribute("msg"); %>
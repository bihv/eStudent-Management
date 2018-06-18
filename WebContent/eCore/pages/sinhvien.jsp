<%@page import="eCore.model.Lop"%>
<%@page import="eCore.modelDao.DAO_Lop"%>
<%@page import="eCore.modelDanhMuc.TonGiao"%>
<%@page import="eCore.modelDaoDanhMuc.DAO_TonGiao"%>
<%@page import="eCore.modelDaoDanhMuc.DAO_DanToc"%>
<%@page import="eCore.modelDanhMuc.DanToc"%>
<%@page import="eCore.model.SinhVien"%>
<%@page import="eCore.modelDao.DAO_NamHoc"%>
<%@page import="eCore.model.HocKy"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="eCore.model.NamHoc"%>
<%@page import="eCore.model.DonVi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "SinhVien";
	String tenTrang = "Quản lý Sinh Viên";
	String trangDanhSach = "index.jsp?p=eCore/pages/sinhviens.jsp";
	String[] tk_value = { "maSinhVien", "tenHocKy", "ngayBatDau", "ngayKetThuc", "namHoc" };
	String[] tk_show = { "Mã sinh viên", "Họ và tên", "Giới tính", "Ngày sinh", "Email", "Chuyên ngành" };
%>
<%@ include file="../../ePartial/code-header.jsp"%>

<%
	String mode = session.getAttribute("mode") + "";
	String tenTrangChiTiet = "";
	tenTrangChiTiet = mode.equals("addNew") ? "Thêm mới" : tenTrangChiTiet;
	tenTrangChiTiet = mode.equals("viewDetail") ? "Xem thông tin chi tiết" : tenTrangChiTiet;
	tenTrangChiTiet = mode.equals("viewDetailAndEdit") ? "Chỉnh sửa thông tin" : tenTrangChiTiet;
	tenTrangChiTiet = mode.equals("null") ? "" : tenTrangChiTiet;

	boolean modeView = mode.equals("viewDetail");
	boolean modeEdit = mode.equals("viewDetailAndEdit");

	SinhVien obj = session.getAttribute("obj") != null ? (SinhVien) session.getAttribute("obj") : null;
%>
<div class="row">
	<div class="col-lg-12">
		<h4 class="page-header"><%=tenTrang%>
			-
			<%=tenTrangChiTiet%>
		</h4>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<form action="luuDuLieu<%=tenLop%>.action" method="post">
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading" style="text-align: left;">
					<div class="row">
						<div class="col-md-5">
							<p style="color: red; display: inline;"><%=msg%></p>
						</div>
						<div class="col-md-7">
							<%@ include file="../../ePartial/processform.jsp"%>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="row" style="padding: 10px">
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Mã sinh viên</label> <input class="form-control"
										name="maSinhVien" r
										value="<%=(obj != null ? obj.getMaSinhVien() : "")%>"
										<%=(modeView || modeEdit ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Họ và tên</label> <input class="form-control"
										name="hoVaTen"
										value="<%=(obj != null && obj.getHoVaTen() != null? obj.getHoVaTen() : "")%>"
										<%=(modeView || modeEdit ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Lớp</label><select class="form-control"
										name="maLop" <%=(modeView ? " disabled " : "")%>>
										<option value=""></option>
										<%
											ObjectDAO dao_lop = new DAO_Lop();
											ArrayList<Lop> listLop = dao_lop.listAll();
											for (Lop lop : listLop) {
										%>
										<option value="<%=lop.getMaLop()%>"
											<%=obj != null && obj.getLop() != null && obj.getLop().getMaLop().equals(lop.maLop)
						? "selected"
						: ""%>>
											<%=lop.tenLop%>
										</option>
										<%
											}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Tên</label> <input class="form-control" name="ten"
										value="<%=(obj != null ? obj.getTen() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Họ đệm</label> <input class="form-control" name="hoDem"
										value="<%=(obj != null ? obj.getHoDem() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Giới tính</label> <select class="form-control" <%=(modeView ? " disabled " : "")%>
										name="gioiTinh">
										<option></option>
										<option value="Nam"
											<%=obj != null && obj.getGioiTinh() != null && obj.gioiTinh.equals("Nam") ? "selected" : ""%>>Nam</option>
										<option value="Nữ"
											<%=obj != null && obj.getGioiTinh() != null && obj.gioiTinh.equals("Nữ") ? "selected" : ""%>>Nữ</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>CMND</label> <input class="form-control" name="soCMND"
										value="<%=(obj != null ? obj.getSoCMND() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Ngày Cấp</label> <input class="form-control"
										name="ngayCap"
										value="<%=(obj != null ? obj.getNgayCap() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Nơi cấp</label> <input class="form-control"
										name="noiCap"
										value="<%=(obj != null ? obj.getNoiCap() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Ngày sinh</label> <input class="form-control"
										name="ngaySinh"
										value="<%=(obj != null ? obj.getNgaySinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Nơi sinh</label> <input class="form-control"
										name="noiSinh"
										value="<%=(obj != null ? obj.getNoiSinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Đối tượng</label> <input class="form-control"
										name="doiTuong"
										value="<%=(obj != null ? obj.getDoiTuong() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Khu vực</label> <input class="form-control"
										name="khuVuc"
										value="<%=(obj != null ? obj.getKhuVuc() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Năm tốt nghiệp THPT</label> <input class="form-control"
										name="namTotNghiepTHPT"
										value="<%=(obj != null ? obj.getNamTotNghiepTHPT() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Tốt nghiệp tại trường THPT</label> <input
										class="form-control" name="totNghiepTaiTruongTHPT"
										value="<%=(obj != null ? obj.getTotNghiepTaiTruongTHPT() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Xếp loại văn hóa</label> <input class="form-control"
										name="xepLoaiVanHoa"
										value="<%=(obj != null ? obj.getXepLoaiVanHoa() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Xếp loại giáo dục</label> <input class="form-control"
										name="xepLoaiGiaoDuc"
										value="<%=(obj != null ? obj.getXepLoaiGiaoDuc() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Quê quán</label> <input class="form-control"
										name="queQuan"
										value="<%=(obj != null ? obj.getQueQuan() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Hộ khẩu thường trú</label> <input class="form-control"
										value="<%=(obj != null ? obj.getHoKhauThuongTru() : "")%>"
										name="hoKhauThuongTru" <%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Mã tỉnh</label> <input class="form-control"
										name="maTinh"
										value="<%=(obj != null ? obj.getMaTinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Mã quận huyện</label> <input class="form-control"
										name="maQuanHuyen"
										value="<%=(obj != null ? obj.getMaQuanHuyen() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Mã phường xã</label> <input class="form-control"
										name="maPhuongXa"
										value="<%=(obj != null ? obj.getMaPhuongXa() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Dân tộc</label> <select class="form-control"
										name="maDanToc" <%=(modeView ? " disabled " : "")%>>
										<option value=""></option>
										<%
											ObjectDAO dao_danToc = new DAO_DanToc();
											ArrayList<DanToc> listDanToc = dao_danToc.listAll();
											for (DanToc dt : listDanToc) {
										%>
										<option value="<%=dt.maDanToc%>"
											<%=obj != null && obj.getMaDanToc() != null && obj.getMaDanToc().equals(dt.maDanToc) ? "selected"
						: ""%>>
											<%=dt.tenDanToc%>
										</option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Tôn giáo</label> <select class="form-control"
										name="maTonGiao" <%=(modeView ? " disabled " : "")%>>
										<option value=""></option>
										<%
											ObjectDAO dao_tonGiao = new DAO_TonGiao();
											ArrayList<TonGiao> listTonGiao = dao_tonGiao.listAll();
											for (TonGiao tg : listTonGiao) {
										%>
										<option value="<%=tg.maTonGiao%>"
											<%=obj != null && obj.getMaTonGiao() != null && obj.getMaTonGiao().equals(tg.maTonGiao)
						? "selected"
						: ""%>>
											<%=tg.tenTonGiao%>
										</option>
										<%
											}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Quốc tịch</label> <input class="form-control"
										name="maQuocTich"
										value="<%=(obj != null ? obj.getMaQuocTich() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Thành phần gia đình</label> <input class="form-control"
										name="maThanhPhanGiaDinh"
										value="<%=(obj != null ? obj.getMaThanhPhanGiaDinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Điện thoại di động</label> <input class="form-control"
										name="dienThoaiDiDong"
										value="<%=(obj != null ? obj.getDienThoaiDiDong() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Điện thoại cố định</label> <input class="form-control"
										name="dienThoaiCoDinh"
										value="<%=(obj != null ? obj.getDienThoaiCoDinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Điện thoại gia đình</label> <input class="form-control"
										name="dienThoaiGiaDinh"
										value="<%=(obj != null ? obj.getDienThoaiGiaDinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Email</label> <input class="form-control" name="email"
										value="<%=(obj != null ? obj.getEmail() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Thông tin báo tin</label> <input class="form-control"
										name="thongTinBaoTin"
										value="<%=(obj != null ? obj.getThongTinBaoTin() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Ngày vào đảng</label> <input class="form-control"
										name="ngayVaoDang"
										value="<%=(obj != null ? obj.getNgayVaoDang() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Ngày vào đoàn </label> <input class="form-control"
										name="ngayVaoDoan"
										value="<%=(obj != null ? obj.getNgayVaoDoan() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Mã số hình ảnh</label> <input class="form-control"
										name="maSoHinhAnh"
										value="<%=(obj != null ? obj.getMaSoHinhAnh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Khi cần báo tin cho ai</label> <input
										class="form-control" name="khiCanBaoTinChoAi"
										value="<%=(obj != null ? obj.getKhiCanBaoTinChoAi() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-8">
								<div class="form-group">
									<label>Địa chỉ khi cần báo tin cho ai</label> <input
										class="form-control" name="diaChiKhiCanBaoTinChoAi"
										value="<%=(obj != null ? obj.getDiaChiKhiCanBaoTinChoAi() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Tỉnh đăng ký bảo hiểm y tế</label> <input
										class="form-control" name="bhyt_maTinh"
										value="<%=(obj != null ? obj.getBhyt_maTinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Mã bệnh viện đăng ký bảo hiểm y tế</label> <input
										class="form-control" name="bhyt_maBenhVien"
										value="<%=(obj != null ? obj.getBhyt_maBenhVien() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Tên bệnh viện đăng ký bảo hiểu y tế</label> <input
										class="form-control" name="bhyt_tenBenhVien"
										value="<%=(obj != null ? obj.getBhyt_maBenhVien() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Bảo hiểm tự nguyện tham gia</label> <input
										class="form-control" name="bhtn_thamgia"
										value="<%=(obj != null ? obj.getBhtn_thamgia() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Thời hạn bảo hiểm tự nguyện</label> <input
										class="form-control" name="bthn_sothang"
										value="<%=(obj != null ? obj.getBthn_sothang() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group">
									<label>Số báo danh</label> <input class="form-control"
										name="soBaoDanh"
										value="<%=(obj != null ? obj.getSoBaoDanh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-4">
								<div class="form-group">
									<label>Điểm môn 1</label> <input class="form-control"
										name="diemMon1"
										value="<%=(obj != null ? obj.getDiemMon1() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Điểm môn 2</label> <input class="form-control"
										name="diemMon2"
										value="<%=(obj != null ? obj.getDiemMon2() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="form-group">
									<label>Điểm môn 3</label> <input class="form-control"
										name="diemMon3"
										value="<%=(obj != null ? obj.getDiemMon3() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Điểm ưu tiên</label> <input class="form-control"
										name="diemUuTien"
										value="<%=(obj != null ? obj.getDiemUuTien() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Tổng điểm</label> <input class="form-control"
										name="tongDiem"
										value="<%=(obj != null ? obj.getTongDiem() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Nghề nghiệp trước khi vào trường</label> <input
										class="form-control" name="ngheNghiepTruocKhiVaoTruong"
										value="<%=(obj != null ? obj.getNgheNghiepTruocKhiVaoTruong() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Thành phần gia đình</label> <input class="form-control"
										name="thanhPhanGiaDinh"
										value="<%=(obj != null ? obj.getThanhPhanGiaDinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Ngày thi THPT</label> <input class="form-control"
										name="thiTHPTNgay"
										value="<%=(obj != null ? obj.getThiTHPTNgay() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Địa chỉ nhận thư</label> <input class="form-control"
										name="diaChiNhanThu"
										value="<%=(obj != null ? obj.getDiaChiNhanThu() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Email phụ huynh</label> <input class="form-control"
										name="emailPhuHuynh"
										value="<%=(obj != null ? obj.getEmailPhuHuynh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Tên ngành trúng tuyển</label> <input
										class="form-control" name="tenNganhTrungTuyen"
										value="<%=(obj != null ? obj.getTenNganhTrungTuyen() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Đã khai phiếu quản lý sinh viên</label> <input
										class="form-control" name="daKhaiPhieuQuanLySinhVien"
										value="<%=(obj != null ? obj.getDaKhaiPhieuQuanLySinhVien() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Đã nhập học</label> <input class="form-control"
										name="daNhapHoc"
										value="<%=(obj != null ? obj.getDaNhapHoc() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6">
								<div class="form-group">
									<label>Mã nguyên ngành 1</label> <input class="form-control"
										name="maChuyenNganh1"
										value="<%=(obj != null ? obj.getMaChuyenNganh1() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Mã nguyên ngành 2</label> <input class="form-control"
										name="maChuyenNganh2"
										value="<%=(obj != null ? obj.getMaChuyenNganh2() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
							</div>
						</div>

					<div class="panel-footer" style="text-align: left;">
						<div class="col-md-5"></div>
						<div class="col-md-7">
							<%@ include file="../../ePartial/processform.jsp"%>
						</div>
					</div>
					<!-- /.col-lg-6 (nested) -->
					<!-- /.col-lg-6 (nested) -->
				</div>
				<!-- /.row (nested) -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</form>
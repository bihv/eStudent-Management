<%@page import="eCore.modelDanhMuc.TonGiao"%>
<%@page import="eCore.modelDaoDanhMuc.DAO_TonGiao"%>
<%@page import="eCore.modelDanhMuc.DanToc"%>
<%@page import="eCore.modelDaoDanhMuc.DAO_DanToc"%>
<%@page import="eCore.util.Util_Date"%>
<%@page import="eCore.model.NhanVien"%>
<%@page import="eCore.model.Lop"%>
<%@page import="eCore.model.DonVi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.modelDao.DAO_DonVi"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String tenLop = "NhanVien";
	String tenTrang = "Quản lý Nhân Viên";
	String trangDanhSach = "index.jsp?p=eCore/pages/nhanviens.jsp";
	String[] tk_value = {"maNhanVien", "tenNhanVien", "gioiTinh", "queQuan", "danToc", "tonGiao", "chucVu",
			"soTruongCongTac", "soCMND", "soHoChieu", "email", "donVi"};
	String[] tk_show = {"Mã Nhân viên", "Tên Nhân viên", "Giới tính", "Quê quán", "Dân tộc", "Tôn giáo",
			"Chức vụ", "Sở trường công tác", "Số CMND", "Số hộ chiếu", "Email", "Đơn vị"};
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

	NhanVien obj = session.getAttribute("obj") != null ? (NhanVien) session.getAttribute("obj") : null;
%>

<script>
	function thayDoiMyFileFileName() {
		var x = document.getElementById("maNhanVien");
		x.value = x.value.toUpperCase();

		var b = document.getElementById("myFileName");
		b.value = x.value;

	}
</script>

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
<form action="luuDuLieu<%=tenLop%>.action" method="post"
	enctype="multipart/form-data">
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
							<div class="col-lg-6">
								<div class="form-group">
									<label>Mã nhân viên</label> <input class="form-control"
										id="maNhanVien" name="maNhanVien"
										onblur="thayDoiMyFileFileName()"
										value="<%=(obj != null && obj.getMaNhanVien() != null ? obj.getMaNhanVien() : "")%>"
										<%=(modeView || modeEdit ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Tên nhân viên</label> <input class="form-control"
										name="tenNhanVien"
										value="<%=(obj != null && obj.getTenNhanVien() != null ? obj.getTenNhanVien() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Hình ảnh</label> <input class="form-control"
										name="myFile"
										value="<%=(obj != null && obj.getHinhAnh() != null ? obj.getHinhAnh() : "")%>"
										type="<%=(modeView ? "hidden" : "file")%>"><img
										src="<%=obj != null && obj.getHinhAnh() != null && modeView ? "eCore/images/nhanviens/" + obj.getHinhAnh()
					: ""%>"
										height="<%=modeView ? 135 : 1%>"
										width="<%=modeView ? 135 : 1%>">
								</div>
								<div class="form-group">
									<label>Ngày sinh</label> <input class="form-control"
										name="s_ngaySinh" type="date"
										value="<%=(obj != null && obj.getNgaySinh() != null ? Util_Date.dateToString(obj.getNgaySinh()) : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>

								<div class="form-group">
									<label>Hộ khẩu thường trú</label> <input class="form-control"
										name="hoKhauThuongTru"
										value="<%=(obj != null && obj.getHoKhauThuongTru() != null ? obj.getHoKhauThuongTru() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Nơi ở hiện tại</label> <input class="form-control"
										name="noiOHienTai"
										value="<%=(obj != null && obj.getNoiOHienTai() != null ? obj.getNoiOHienTai() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Nghề nghiệp trước khi tuyển dụng</label> <input
										class="form-control" name="ngheNghiepTruocKhiTuyenDung"
										value="<%=(obj != null && obj.getNgheNghiepTruocKhiTuyenDung() != null ? obj.getNgheNghiepTruocKhiTuyenDung()
							: "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngày tuyển dụng</label> <input class="form-control"
										name="s_ngayTuyenDung" type="date"
										value="<%=(obj != null && obj.getNgayTuyenDung() != null ? Util_Date.dateToString(obj.getNgayTuyenDung())
					: "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Chức vụ</label> <input class="form-control"
										name="chucVu"
										value="<%=(obj != null && obj.getChucVu() != null ? obj.getChucVu() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Công việc chính được giao</label> <input
										class="form-control" name="congViecChinhDuocGiao"
										value="<%=(obj != null && obj.getCongViecChinhDuocGiao() != null ? obj.getCongViecChinhDuocGiao() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngạch công chức</label> <input class="form-control"
										name="hoKhauThuongTru"
										value="<%=(obj != null && obj.getNgachCongChuc() != null ? obj.getNgachCongChuc() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Mã ngạch</label> <input class="form-control"
										name="maNgach"
										value="<%=(obj != null && obj.getMaNgach() != null ? obj.getMaNgach() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Bậc lương</label> <input class="form-control"
										name="bacLuong"
										value="<%=(obj != null && obj.getBacLuong() != null ? obj.getBacLuong() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Hệ số</label> <input class="form-control" name="heSo"
										value="<%=(obj != null && obj.getHeSo() != null ? obj.getHeSo() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngày hưởng</label> <input class="form-control"
										name="s_ngayHuong" type="date"
										value="<%=(obj != null && obj.getNgayHuong() != null ? Util_Date.dateToString(obj.getNgayHuong()) : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Trình độ giáo dục phổ thông</label> <input
										class="form-control" name="trinhDoGiaoDucPhoThong"
										value="<%=(obj != null && obj.getTrinhDoGiaoDucPhoThong() != null ? obj.getTrinhDoGiaoDucPhoThong() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Trình độ chuyên môn cao nhất</label> <input
										class="form-control" name="trinhDoChuyenMonCaoNhat"
										value="<%=(obj != null && obj.getTrinhDoChuyenMonCaoNhat() != null ? obj.getTrinhDoChuyenMonCaoNhat() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Lý luận chính trị</label> <input class="form-control"
										name="lyLuanChinhTri"
										value="<%=(obj != null && obj.getLyLuanChinhTri() != null ? obj.getLyLuanChinhTri() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Quản lý nhà nước</label> <input class="form-control"
										name="quanLyNhaNuoc"
										value="<%=(obj != null && obj.getQuanLyNhaNuoc() != null ? obj.getQuanLyNhaNuoc() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngoại ngữ</label> <input class="form-control"
										name="ngoaiNgu"
										value="<%=(obj != null && obj.getNgoaiNgu() != null ? obj.getNgoaiNgu() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Tin học</label> <input class="form-control"
										name="tinHoc"
										value="<%=(obj != null && obj.getTinHoc() != null ? obj.getTinHoc() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngày vào đảng dự bị</label> <input class="form-control"
										name="s_ngayVaoDangDuBi" type="date"
										value="<%=(obj != null && obj.getNgayVaoDangDuBi() != null ? Util_Date.dateToString(obj.getNgayVaoDangDuBi())
							: "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngày vào đảng chính thức</label> <input
										class="form-control" name="s_ngayVaoDangChinhThuc" type="date"
										value="<%=(obj != null && obj.getNgayVaoDangChinhThuc() != null
					? Util_Date.dateToString(obj.getNgayVaoDangChinhThuc())
					: "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Tham gia tổ chức chính trị xã hội</label> <input
										class="form-control" name="thamGiaToChucChinhTriXaHoi"
										value="<%=(obj != null && obj.getThamGiaToChucChinhTriXaHoi() != null ? obj.getThamGiaToChucChinhTriXaHoi()
					: "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngày nhập ngũ</label> <input class="form-control"
										name="s_ngayNhapNgu" type="date"
										value="<%=(obj != null && obj.getNgayNhapNgu() != null ? Util_Date.dateToString(obj.getNgayNhapNgu()) : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngày xuất ngũ</label> <input class="form-control"
										name="s_ngayXuatNgu"
										value="<%=(obj != null && obj.getNgayXuatNgu() != null ? Util_Date.dateToString(obj.getNgayXuatNgu()) : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Quân hàm cao nhất</label> <input class="form-control"
										name="heSo"
										value="<%=(obj != null && obj.getQuanHamCaoNhat() != null ? obj.getQuanHamCaoNhat() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Danh hiệu được phong tặng cao nhất</label> <input
										class="form-control" name="danhHieuDuocPhongTangCaoNhat"
										value="<%=(obj != null && obj.getDanhHieuDuocPhongTangCaoNhat() != null
					? obj.getDanhHieuDuocPhongTangCaoNhat()
					: "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Sở trường công tác</label> <input class="form-control"
										name="soTruongCongTac"
										value="<%=(obj != null && obj.getSoTruongCongTac() != null ? obj.getSoTruongCongTac() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Khen thưởng</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="khenThuong" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getKhenThuong() != null ? obj.getKhenThuong() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Kỷ luật</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="kyLuat" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getKyLuat() != null ? obj.getKyLuat() : "")%></textarea>
								</div>


							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Giới tính</label> <select class="form-control"
										name="gioiTinh" <%=(modeView ? " disabled " : "")%>>
										<option></option>
										<option value="Nam"
											<%=obj != null && obj.getGioiTinh() != null && obj.gioiTinh.equals("Nam") ? "selected" : ""%>>Nam</option>
										<option value="Nữ"
											<%=obj != null && obj.getGioiTinh() != null && obj.gioiTinh.equals("Nữ") ? "selected" : ""%>>Nữ</option>
									</select>
								</div>
								<div class="form-group">
									<label>Nơi sinh</label> <input class="form-control"
										name="noiSinh"
										value="<%=(obj != null && obj.getNoiSinh() != null ? obj.getNoiSinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Quê quán</label> <input class="form-control"
										name="queQuan"
										value="<%=(obj != null && obj.getQueQuan() != null ? obj.getQueQuan() : "")%>"
										<%=(modeView ? " disabled " : "")%>>
								</div>
								<div class="form-group">
									<label>Dân tộc</label> <select class="form-control"
										name="danToc" <%=(modeView ? " disabled " : "")%>>
										<option value=""></option>
										<%
											ObjectDAO dao_danToc = new DAO_DanToc();
											ArrayList<DanToc> listDanToc = dao_danToc.listAll();
											for (DanToc dt : listDanToc) {
										%>
										<option value="<%=dt.maDanToc%> "
											<%=obj != null && obj.getDanToc() != null && obj.getDanToc().equals(dt.maDanToc) ? "selected"
						: ""%>>
											<%=dt.tenDanToc%>
										</option>
										<%
											}
										%>
									</select>
								</div>
								<div class="form-group">
									<label>Tôn giáo</label> <select class="form-control"
										name="tonGiao" <%=(modeView ? " disabled " : "")%>>
										<option value=""></option>
										<%
											ObjectDAO dao_tonGiao = new DAO_TonGiao();
											ArrayList<TonGiao> listTonGiao = dao_tonGiao.listAll();
											for (TonGiao tg : listTonGiao) {
										%>
										<option value="<%=tg.maTonGiao%> "
											<%=obj != null && obj.getTonGiao() != null && obj.getTonGiao().equals(tg.maTonGiao) ? "selected"
						: ""%>>
											<%=tg.tenTonGiao%>
										</option>
										<%
											}
										%>
									</select>
								</div>







								<div class="form-group">
									<label>Tình trạng sức khỏe</label> <input class="form-control"
										name="tinhTrangSucKhoe"
										value="<%=(obj != null && obj.getTinhTrangSucKhoe() != null ? obj.getTinhTrangSucKhoe() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Là con thương binh</label> <input class="form-control"
										name="laConThuongBinh"
										value="<%=(obj != null && obj.getLaConThuongBinh() != null ? obj.getLaConThuongBinh() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Là con gia đình chính sách</label> <input
										class="form-control" name="laConGiaDinhChinhSach"
										value="<%=(obj != null && obj.getLaConGiaDinhChinhSach() != null ? obj.getLaConGiaDinhChinhSach() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Số CMND</label> <input class="form-control"
										name="soCMND"
										value="<%=(obj != null && obj.getSoCMND() != null ? obj.getSoCMND() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngày cấp CMND</label> <input class="form-control"
										name="s_ngayCapCMND" type="date"
										value="<%=(obj != null && obj.getNgayCapCMND() != null ? Util_Date.dateToString(obj.getNgayCapCMND()) : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Nơi cấp CMND</label> <input class="form-control"
										name="noiCapCMND"
										value="<%=(obj != null && obj.getNoiCapCMND() != null ? obj.getNoiCapCMND() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Số hộ chiếu</label> <input class="form-control"
										name="soHoChieu"
										value="<%=(obj != null && obj.getSoHoChieu() != null ? obj.getSoHoChieu() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Ngày cấp hộ chiếu</label> <input class="form-control"
										name="s_ngayCapHoChieu"
										value="<%=(obj != null && obj.getNgayCapHoChieu() != null ? Util_Date.dateToString(obj.getNgayCapHoChieu())
					: "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Nơi cấp hộ chiếu</label> <input class="form-control"
										name="noiCapHoChieu"
										value="<%=(obj != null && obj.getNoiCapHoChieu() != null ? obj.getNoiCapHoChieu() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Số sổ bảo hiểm xã hội</label> <input
										class="form-control" name="soSoBaoHiemXaHoi"
										value="<%=(obj != null && obj.getSoSoBaoHiemXaHoi() != null ? obj.getSoSoBaoHiemXaHoi() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Quá trình đào tạo</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="quaTrinhDaoTao" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getQuaTrinhDaoTao() != null ? obj.getQuaTrinhDaoTao() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Quá trình công tác</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="quaTrinhCongTac" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getQuaTrinhCongTac() != null ? obj.getQuaTrinhCongTac() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Đặc điểm lịch sử bản thân</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="dacDiemLichSuBanThan"
										<%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getDacDiemLichSuBanThan() != null ? obj.getDacDiemLichSuBanThan() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Quan hệ với gia đình</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="quanHeVoiGiaDinh" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getQuanHeVoiGiaDinh() != null ? obj.getQuanHeVoiGiaDinh() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Hoàn cảnh kinh tế gia đình</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="hoanCanhKinhTeGiaDinh"
										<%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getHoanCanhKinhTeGiaDinh() != null ? obj.getHoanCanhKinhTeGiaDinh() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Nhận xét đánh giá của cơ quan</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="nhanXetDanhGiaCuaCoQuan"
										<%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getNhanXetDanhGiaCuaCoQuan() != null ? obj.getNhanXetDanhGiaCuaCoQuan() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Email</label> <input class="form-control" name="email"
										value="<%=(obj != null && obj.getEmail() != null ? obj.getEmail() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Số điện thoại di động</label> <input
										class="form-control" name="soDienThoaiDiDong"
										value="<%=(obj != null && obj.getSoDienThoaiDiDong() != null ? obj.getSoDienThoaiDiDong() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Số điện thoại cơ quan</label> <input
										class="form-control" name="soDienThoaiCoQuan"
										value="<%=(obj != null && obj.getSoDienThoaiCoQuan() != null ? obj.getSoDienThoaiCoQuan() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Địa chỉ liên hệ</label> <input class="form-control"
										name="diaChiLienHe"
										value="<%=(obj != null && obj.getDiaChiLienHe() != null ? obj.getDiaChiLienHe() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Địa chỉ báo tin</label> <input class="form-control"
										name="diaChiBaoTin"
										value="<%=(obj != null && obj.getDiaChiBaoTin() != null ? obj.getDiaChiBaoTin() : "")%>"
										<%=(modeView ? " readonly " : "")%>>
								</div>
								<div class="form-group">
									<label>Đơn vị quản lý</label> <select class="form-control"
										name="maDonVi" <%=(modeView ? " disabled " : "")%>>
										<option value=""></option>
										<%
											ObjectDAO objdao = new DAO_DonVi();
											ArrayList<DonVi> listDonVi = objdao.listAll();
											for (DonVi dv : listDonVi) {
										%>
										<option value="<%=dv.maDonVi%> "
											<%=obj != null && obj.getDonVi() != null && obj.getDonVi().maDonVi.equals(dv.maDonVi) ? "selected"
								: ""%>>
											<%=dv.tenDonVi%>
										</option>
										<%
											}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<div class="form-group">
									<label>Mô tả</label>
									<textarea class="form-control" cols="80" id="editor1" rows="5"
										name="moTa" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getMoTa() != null ? obj.getMoTa() : "")%></textarea>
								</div>
								<div class="form-group">
									<label>Ghi chú</label>
									<textarea class="form-control" cols="80" id="editor2" rows="5"
										name="ghiChu" <%=(modeView ? " disabled " : "")%>><%=(obj != null && obj.getGhiChu() != null ? obj.getGhiChu() : "")%></textarea>
								</div>
							</div>
						</div>
						<input type="hidden" name="s_hinhAnh"
							value="<%=obj != null && obj.getHinhAnh() != null ? obj.getHinhAnh() : ""%>">
						<input type="hidden" id="myFileName" name="myFileName"></input> <input
							type="hidden" name="myFolder"
							value="<%=request.getRealPath("eCore/images/nhanviens")%>" />
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
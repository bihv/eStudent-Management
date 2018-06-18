package eCore.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderExtent;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import eCore.dao.ObjectDAO;
import eCore.model.Lop;
import eCore.model.SinhVien;
import eCore.modelDao.DAO_Lop;
import eCore.modelDao.DAO_SinhVien;
import eCore.util.Util_Date;
import eCore.util.Util_Excel;
import eCore.util.Util_Number;
import eSm3.model.ThongTinDangKyBaoHiemYTeNhanVien;
import eSm3.modelDao.DAO_ThongTinDangKyBaoHiemYTeNhanVien;
import servlet.DownloadServlet;

public class Controller_SinhVien extends SinhVien
		implements ZEController<SinhVien>, ServletRequestAware, ServletResponseAware {
	ObjectDAO<SinhVien> dao = new DAO_SinhVien();
	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eCore/pages/sinhviens.jsp";
	String duongDanTrangView = "eCore/pages/sinhvien.jsp";
	String tenCotTimDoiTuong = "maSinhVien";
	String maObj;
	String maLop;
	String s_thoiGianCapNhat;

	public String getTimKiemTheo() {
		return timKiemTheo;
	}

	public void setTimKiemTheo(String timKiemTheo) {
		this.timKiemTheo = timKiemTheo;
	}

	public String getTuKhoa() {
		return tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}

	public String getDuongDanTrang() {
		return duongDanTrang;
	}

	public void setDuongDanTrang(String duongDanTrang) {
		this.duongDanTrang = duongDanTrang;
	}

	public String getDuongDanTrangView() {
		return duongDanTrangView;
	}

	public void setDuongDanTrangView(String duongDanTrangView) {
		this.duongDanTrangView = duongDanTrangView;
	}

	public String getTenCotTimDoiTuong() {
		return tenCotTimDoiTuong;
	}

	public void setTenCotTimDoiTuong(String tenCotTimDoiTuong) {
		this.tenCotTimDoiTuong = tenCotTimDoiTuong;
	}

	public String getMaObj() {
		return maObj;
	}

	public void setMaObj(String maObj) {
		this.maObj = maObj;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getS_thoiGianCapNhat() {
		return s_thoiGianCapNhat;
	}

	public void setS_thoiGianCapNhat(String s_thoiGianCapNhat) {
		this.s_thoiGianCapNhat = s_thoiGianCapNhat;
	}

	public Lop getLop() {
		ObjectDAO<Lop> dao_Lop = new DAO_Lop();
		ArrayList<Lop> list_Lop = dao_Lop.listByColumns("maLop", getMaLop());
		if (list_Lop.size() > 0) {
			return list_Lop.get(0);
		} else {
			return null;
		}
	}

	public Date getThoiGianCapNhat() {
		return Util_Date.stringToDate(getS_thoiGianCapNhat());
	}

	@Override
	public String addNew() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("mode", "addNew");
		session.setAttribute("p", duongDanTrangView);
		session.setAttribute("msg", null);
		session.setAttribute("obj", null);
		return "SUCCESS";
	}

	@Override
	public String viewDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String maobj = request.getParameter("maobj");

		session.setAttribute("mode", "viewDetail");

		ArrayList<SinhVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
		if (arr.size() > 0) {
			session.setAttribute("obj", arr.get(0));
			session.setAttribute("p", duongDanTrangView);
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@Override
	public String viewDetailAndEdit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("msg", null);

		String maobj = request.getParameter("maobj");
		session.setAttribute("mode", "viewDetailAndEdit");
		ArrayList<SinhVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
		if (arr.size() > 0) {
			session.setAttribute("obj", arr.get(0));
			session.setAttribute("p", duongDanTrangView);
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@Override
	public String saveOrUpdate() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		SinhVien obj = new SinhVien();
		obj.maSinhVien = getMaSinhVien();
		obj.ten = getTen();
		obj.hoDem = getHoDem();
		obj.hoVaTen = getHoDem() + " " + getTen();
		obj.gioiTinh = getGioiTinh();
		obj.soCMND = getSoCMND();
		obj.ngayCap = getNgayCap();
		obj.noiCap = getNoiCap();
		obj.ngaySinh = getNgaySinh();
		obj.noiSinh = getNoiSinh();
		obj.doiTuong = getDoiTuong();
		obj.khuVuc = getKhuVuc();
		obj.namTotNghiepTHPT = getNamTotNghiepTHPT();
		obj.totNghiepTaiTruongTHPT = getTotNghiepTaiTruongTHPT();
		obj.xepLoaiVanHoa = getXepLoaiVanHoa();
		obj.xepLoaiGiaoDuc = getXepLoaiGiaoDuc();
		obj.queQuan = getQueQuan();
		obj.hoKhauThuongTru = getHoKhauThuongTru();
		obj.maTinh = getMaTinh();
		obj.maQuanHuyen = getMaQuanHuyen();
		obj.maPhuongXa = getMaPhuongXa();
		obj.maDanToc = getMaDanToc();
		obj.maTonGiao = getMaTonGiao();
		obj.maQuocTich = getMaQuocTich();
		obj.maThanhPhanGiaDinh = getMaThanhPhanGiaDinh();
		obj.dienThoaiDiDong = getDienThoaiDiDong();
		obj.dienThoaiCoDinh = getDienThoaiCoDinh();
		obj.dienThoaiGiaDinh = getDienThoaiGiaDinh();
		obj.email = getEmail();
		obj.thongTinBaoTin = getThongTinBaoTin();
		obj.ngayVaoDoan = getNgayVaoDoan();
		obj.ngayVaoDang = getNgayVaoDang();
		obj.maSoHinhAnh = getMaSoHinhAnh();
		obj.khiCanBaoTinChoAi = getKhiCanBaoTinChoAi();
		obj.diaChiKhiCanBaoTinChoAi = getDiaChiKhiCanBaoTinChoAi();
		obj.bhyt_maTinh = getBhyt_maTinh();
		obj.bhyt_maBenhVien = getBhyt_maBenhVien();
		obj.bhyt_tenBenhVien = getBhyt_tenBenhVien();
		obj.bhtn_thamgia = getBhtn_thamgia();
		obj.bthn_sothang = getBthn_sothang();
		obj.soBaoDanh = getSoBaoDanh();
		obj.diemMon1 = getDiemMon1();
		obj.diemMon2 = getDiemMon2();
		obj.diemMon3 = getDiemMon3();
		obj.diemUuTien = getDiemUuTien();
		obj.tongDiem = getTongDiem();
		obj.ngheNghiepTruocKhiVaoTruong = getNgheNghiepTruocKhiVaoTruong();
		obj.thanhPhanGiaDinh = getThanhPhanGiaDinh();
		obj.thiTHPTNgay = getThiTHPTNgay();
		obj.diaChiNhanThu = getDiaChiNhanThu();
		obj.emailPhuHuynh = getEmailPhuHuynh();
		obj.tenNganhTrungTuyen = getTenNganhTrungTuyen();
		obj.daKhaiPhieuQuanLySinhVien = getDaKhaiPhieuQuanLySinhVien();
		obj.daNhapHoc = getDaNhapHoc();
		obj.maChuyenNganh1 = getMaChuyenNganh1();
		obj.maChuyenNganh2 = getMaChuyenNganh2();
		obj.lop = getLop();
		obj.moTa = getMoTa();
		obj.ghiChu = getGhiChu();
		obj.thoiGianCapNhat = new Date();
		if (dao.saveOrUpdate(obj)) {
			session.setAttribute("msg", "Cập nhật dữ liệu thành công");
			session.setAttribute("obj", obj);
			session.setAttribute("mode", "viewDetailAndEdit");
			session.setAttribute("p", duongDanTrangView);
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@Override
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String maobj = request.getParameter("maobj");
		SinhVien obj = new SinhVien();
		obj.setMaSinhVien(maobj);
		if (dao.delete(obj)) {
			session.setAttribute("msg", "Xóa dữ liệu thành công");
			session.setAttribute("p", duongDanTrang);
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	@Override
	public String search() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String column = getTimKiemTheo();
		String key = getTuKhoa();
		ArrayList<SinhVien> arr = dao.listByColumnLike(column, key);
		session.setAttribute("arr", arr);
		session.setAttribute("checkTimKiem", "true");
		session.setAttribute("p", duongDanTrang);
		return "SUCCESS";
	}

	@Override
	public String refresh() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("arr", null);
		session.setAttribute("msg", null);
		session.setAttribute("checkTimKiem", null);
		session.setAttribute("p", duongDanTrang);
		return "SUCCESS";
	}

	@Override
	public String importData() {
		// TODO Auto-generated method stub
		return null;
	}

	private HttpServletRequest servletRequest;
	private HttpServletResponse servletResponse;

	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
		HSSFFont font = workbook.createFont();
		font.setBold(true);
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		return style;
	}

	@Override
	public String exportData() throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Danh sách sinh viên");
		//
		HSSFCellStyle style = createStyleForTitle(workbook);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 54));

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("DANH SÁCH SINH VIÊN");
		cell.setCellStyle(style);

		rownum = rownum + 1;
		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Mã sinh viên");
		cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Họ đệm");
		cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Tên");
		cell.setCellStyle(style);

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Giới tính");
		cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Số CMND");
		cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Ngày cấp");
		cell.setCellStyle(style);

		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Nơi cấp");
		cell.setCellStyle(style);

		cell = row.createCell(7, CellType.STRING);
		cell.setCellValue("Ngày sinh");
		cell.setCellStyle(style);

		cell = row.createCell(8, CellType.STRING);
		cell.setCellValue("Nơi sinh");
		cell.setCellStyle(style);

		cell = row.createCell(9, CellType.STRING);
		cell.setCellValue("Đối tượng");
		cell.setCellStyle(style);

		cell = row.createCell(10, CellType.STRING);
		cell.setCellValue("Khu vực");
		cell.setCellStyle(style);

		cell = row.createCell(11, CellType.STRING);
		cell.setCellValue("Năm tốt nghiệp THPT");
		cell.setCellStyle(style);

		cell = row.createCell(12, CellType.STRING);
		cell.setCellValue("Tốt nghiệp trường THPT");
		cell.setCellStyle(style);

		cell = row.createCell(13, CellType.STRING);
		cell.setCellValue("Xếp loại văn hóa");
		cell.setCellStyle(style);

		cell = row.createCell(14, CellType.STRING);
		cell.setCellValue("Xếp loại giáo dục");
		cell.setCellStyle(style);

		cell = row.createCell(15, CellType.STRING);
		cell.setCellValue("Quê quán");
		cell.setCellStyle(style);

		cell = row.createCell(16, CellType.STRING);
		cell.setCellValue("Hộ khẩu thường trú");
		cell.setCellStyle(style);

		cell = row.createCell(17, CellType.STRING);
		cell.setCellValue("Mã tỉnh");
		cell.setCellStyle(style);

		cell = row.createCell(18, CellType.STRING);
		cell.setCellValue("Mã quận huyện");
		cell.setCellStyle(style);

		cell = row.createCell(19, CellType.STRING);
		cell.setCellValue("Mã phường xã");
		cell.setCellStyle(style);

		cell = row.createCell(20, CellType.STRING);
		cell.setCellValue("Mã dân tộc");
		cell.setCellStyle(style);

		cell = row.createCell(21, CellType.STRING);
		cell.setCellValue("Mã tôn giáo");
		cell.setCellStyle(style);

		cell = row.createCell(22, CellType.STRING);
		cell.setCellValue("Mã quốc tịch");
		cell.setCellStyle(style);

		cell = row.createCell(23, CellType.STRING);
		cell.setCellValue("Mã thành phần gia đình");
		cell.setCellStyle(style);

		cell = row.createCell(24, CellType.STRING);
		cell.setCellValue("Điện thoại di động");
		cell.setCellStyle(style);

		cell = row.createCell(25, CellType.STRING);
		cell.setCellValue("Điện thoại cố định");
		cell.setCellStyle(style);

		cell = row.createCell(26, CellType.STRING);
		cell.setCellValue("Điện thoại gia đình");
		cell.setCellStyle(style);

		cell = row.createCell(27, CellType.STRING);
		cell.setCellValue("Email");
		cell.setCellStyle(style);

		cell = row.createCell(28, CellType.STRING);
		cell.setCellValue("Thông tin báo tin");
		cell.setCellStyle(style);

		cell = row.createCell(29, CellType.STRING);
		cell.setCellValue("Ngày vào đoàn");
		cell.setCellStyle(style);

		cell = row.createCell(30, CellType.STRING);
		cell.setCellValue("Ngày vào đảng");
		cell.setCellStyle(style);

		cell = row.createCell(31, CellType.STRING);
		cell.setCellValue("Mã số hình ảnh");
		cell.setCellStyle(style);

		cell = row.createCell(32, CellType.STRING);
		cell.setCellValue("Người báo tin");
		cell.setCellStyle(style);

		cell = row.createCell(33, CellType.STRING);
		cell.setCellValue("BHYT mã tỉnh");
		cell.setCellStyle(style);

		cell = row.createCell(34, CellType.STRING);
		cell.setCellValue("BHYT mã BV");
		cell.setCellStyle(style);

		cell = row.createCell(35, CellType.STRING);
		cell.setCellValue("BHYT tên BV");
		cell.setCellStyle(style);

		cell = row.createCell(36, CellType.STRING);
		cell.setCellValue("BHTN tham gia");
		cell.setCellStyle(style);

		cell = row.createCell(37, CellType.STRING);
		cell.setCellValue("BHTN số tháng");
		cell.setCellStyle(style);

		cell = row.createCell(38, CellType.STRING);
		cell.setCellValue("Số báo danh");
		cell.setCellStyle(style);

		cell = row.createCell(39, CellType.STRING);
		cell.setCellValue("Điểm môn 1");
		cell.setCellStyle(style);

		cell = row.createCell(40, CellType.STRING);
		cell.setCellValue("Điểm môn 2");
		cell.setCellStyle(style);

		cell = row.createCell(41, CellType.STRING);
		cell.setCellValue("Điểm môn 3");
		cell.setCellStyle(style);

		cell = row.createCell(42, CellType.STRING);
		cell.setCellValue("Điểm ưu tiên");
		cell.setCellStyle(style);

		cell = row.createCell(43, CellType.STRING);
		cell.setCellValue("Tổng điểm");
		cell.setCellStyle(style);

		cell = row.createCell(44, CellType.STRING);
		cell.setCellValue("Nghề nghiệp trước khi vào trường");
		cell.setCellStyle(style);

		cell = row.createCell(45, CellType.STRING);
		cell.setCellValue("Thành phần gia đình");
		cell.setCellStyle(style);

		cell = row.createCell(46, CellType.STRING);
		cell.setCellValue("Ngày thi THPT");
		cell.setCellStyle(style);

		cell = row.createCell(47, CellType.STRING);
		cell.setCellValue("Địa chỉ nhận thư");
		cell.setCellStyle(style);

		cell = row.createCell(48, CellType.STRING);
		cell.setCellValue("Email phụ huynh");
		cell.setCellStyle(style);

		cell = row.createCell(49, CellType.STRING);
		cell.setCellValue("Tên ngành trúng tuyển");
		cell.setCellStyle(style);

		cell = row.createCell(50, CellType.STRING);
		cell.setCellValue("Đã khai phiếu quản lý sinh viên");
		cell.setCellStyle(style);

		cell = row.createCell(51);
		cell.setCellValue("Đã nhập học");
		cell.setCellStyle(style);

		cell = row.createCell(52, CellType.STRING);
		cell.setCellValue("Mã chuyên ngành 1");
		cell.setCellStyle(style);

		cell = row.createCell(53, CellType.STRING);
		cell.setCellValue("Mã chuyên ngành 2");
		cell.setCellStyle(style);

		cell = row.createCell(54, CellType.STRING);
		cell.setCellValue("Mã lớp");
		cell.setCellStyle(style);
		//
		// rownum = rownum + 1;
		// row = sheet.createRow(rownum);

		// Data
		// bắt đầu xuất dữ liệu thông tin sinh viên

		ObjectDAO<SinhVien> dao_SinhVien = new DAO_SinhVien();
		ArrayList<SinhVien> list_SinhVien = new ArrayList<SinhVien>();
		if (!getMaLop().isEmpty() && getMaLop() != null
				&& !getMaLop().equals("all"))
			list_SinhVien = dao_SinhVien.listByColumns("lop", getMaLop());
		else
			list_SinhVien = dao_SinhVien.listAll();

		System.out.println("list_SinhVien.size() = " + list_SinhVien.size());
		for (SinhVien sinhVien : list_SinhVien) {
			rownum++;
			row = sheet.createRow(rownum);

			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(sinhVien.getMaSinhVien());

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(sinhVien.getHoDem());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(sinhVien.getTen());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(sinhVien.getGioiTinh());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(sinhVien.getSoCMND());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(sinhVien.getNgayCap());

			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(sinhVien.getNoiCap());

			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue(sinhVien.getNgaySinh());

			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue(sinhVien.getNoiSinh());

			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue(sinhVien.getDoiTuong());

			cell = row.createCell(10, CellType.STRING);
			cell.setCellValue(sinhVien.getKhuVuc());

			cell = row.createCell(11, CellType.STRING);
			cell.setCellValue(sinhVien.getNamTotNghiepTHPT());

			cell = row.createCell(12, CellType.STRING);
			cell.setCellValue(sinhVien.getTotNghiepTaiTruongTHPT());

			cell = row.createCell(13, CellType.STRING);
			cell.setCellValue(sinhVien.getXepLoaiVanHoa());

			cell = row.createCell(14, CellType.STRING);
			cell.setCellValue(sinhVien.getXepLoaiGiaoDuc());

			cell = row.createCell(15, CellType.STRING);
			cell.setCellValue(sinhVien.getQueQuan());

			cell = row.createCell(16, CellType.STRING);
			cell.setCellValue(sinhVien.getHoKhauThuongTru());

			cell = row.createCell(17, CellType.STRING);
			cell.setCellValue(sinhVien.getMaTinh());

			cell = row.createCell(18, CellType.STRING);
			cell.setCellValue(sinhVien.getMaQuanHuyen());

			cell = row.createCell(19, CellType.STRING);
			cell.setCellValue(sinhVien.getMaPhuongXa());

			cell = row.createCell(20, CellType.STRING);
			cell.setCellValue(sinhVien.getMaDanToc());

			cell = row.createCell(21, CellType.STRING);
			cell.setCellValue(sinhVien.getMaTonGiao());

			cell = row.createCell(22, CellType.STRING);
			cell.setCellValue(sinhVien.getMaQuocTich());

			cell = row.createCell(23, CellType.STRING);
			cell.setCellValue(sinhVien.getMaThanhPhanGiaDinh());

			cell = row.createCell(24, CellType.STRING);
			cell.setCellValue(sinhVien.getDienThoaiDiDong());

			cell = row.createCell(25, CellType.STRING);
			cell.setCellValue(sinhVien.getDienThoaiCoDinh());

			cell = row.createCell(26, CellType.STRING);
			cell.setCellValue(sinhVien.getDienThoaiGiaDinh());

			cell = row.createCell(27, CellType.STRING);
			cell.setCellValue(sinhVien.getEmail());

			cell = row.createCell(28, CellType.STRING);
			cell.setCellValue(sinhVien.getThongTinBaoTin());

			cell = row.createCell(29, CellType.STRING);
			cell.setCellValue(sinhVien.getNgayVaoDoan());

			cell = row.createCell(30, CellType.STRING);
			cell.setCellValue(sinhVien.getNgayVaoDang());

			cell = row.createCell(31, CellType.STRING);
			cell.setCellValue(sinhVien.getMaSoHinhAnh());

			cell = row.createCell(32, CellType.STRING);
			cell.setCellValue(sinhVien.getKhiCanBaoTinChoAi());

			cell = row.createCell(33, CellType.STRING);
			cell.setCellValue(sinhVien.getBhyt_maTinh());

			cell = row.createCell(34, CellType.STRING);
			cell.setCellValue(sinhVien.getBhyt_maBenhVien());

			cell = row.createCell(35, CellType.STRING);
			cell.setCellValue(sinhVien.getBhyt_tenBenhVien());

			cell = row.createCell(36, CellType.STRING);
			cell.setCellValue(sinhVien.getBhtn_thamgia());

			cell = row.createCell(37, CellType.STRING);
			cell.setCellValue(sinhVien.getBthn_sothang());

			cell = row.createCell(38, CellType.STRING);
			cell.setCellValue(sinhVien.getSoBaoDanh());

			cell = row.createCell(39, CellType.STRING);
			cell.setCellValue(sinhVien.getDiemMon1());

			cell = row.createCell(40, CellType.STRING);
			cell.setCellValue(sinhVien.getDiemMon2());

			cell = row.createCell(41, CellType.STRING);
			cell.setCellValue(sinhVien.getDiemMon3());

			cell = row.createCell(42, CellType.STRING);
			cell.setCellValue(sinhVien.getDiemUuTien());

			cell = row.createCell(43, CellType.STRING);
			cell.setCellValue(sinhVien.getTongDiem());

			cell = row.createCell(44, CellType.STRING);
			cell.setCellValue(sinhVien.getNgheNghiepTruocKhiVaoTruong());

			cell = row.createCell(45, CellType.STRING);
			cell.setCellValue(sinhVien.getThanhPhanGiaDinh());

			cell = row.createCell(46, CellType.STRING);
			cell.setCellValue(sinhVien.getThiTHPTNgay());

			cell = row.createCell(47, CellType.STRING);
			cell.setCellValue(sinhVien.getDiaChiNhanThu());

			cell = row.createCell(48, CellType.STRING);
			cell.setCellValue(sinhVien.getEmailPhuHuynh());

			cell = row.createCell(49, CellType.STRING);
			cell.setCellValue(sinhVien.getTenNganhTrungTuyen());

			cell = row.createCell(50, CellType.STRING);
			cell.setCellValue(sinhVien.getDaKhaiPhieuQuanLySinhVien());

			cell = row.createCell(51, CellType.STRING);
			cell.setCellValue(sinhVien.getDaNhapHoc());

			cell = row.createCell(52, CellType.STRING);
			cell.setCellValue(sinhVien.getMaChuyenNganh1());

			cell = row.createCell(53, CellType.STRING);
			cell.setCellValue(sinhVien.getMaChuyenNganh2());

			cell = row.createCell(54, CellType.STRING);
			cell.setCellValue(sinhVien.getLop().getMaLop());

		}
		// kết thúc xuất danh sách sinh viên

		PropertyTemplate pt = new PropertyTemplate();
		pt.drawBorders(new CellRangeAddress(1, 1, 0, 54), BorderStyle.THIN, BorderExtent.ALL);

		pt.drawBorders(new CellRangeAddress(1, rownum, 0, 54), BorderStyle.THIN, BorderExtent.RIGHT);

		pt.drawBorders(new CellRangeAddress(1, rownum, 0, 54), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(rownum, rownum, 0, 54), BorderStyle.THIN, BorderExtent.BOTTOM);

		pt.applyBorders(sheet);

		// auto width all column
		for (int i = 0; i < Util_Excel.getColumnsCount(sheet); i++)
			sheet.autoSizeColumn(i);

		String fileName = "Danh sach sinh vien.xls";
		String filePath = servletRequest.getSession().getServletContext().getRealPath("/").concat("report") + "/"
				+ fileName;
		System.out.println("filePath = " + filePath);
		File file = new File(filePath);
		file.getParentFile().mkdirs();

		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);
		System.out.println("Created file: " + file.getAbsolutePath());

		////////////////////////////////////////////////////
		// DOWNLOAD FILE
		////////////////////////////////////////////////////
		DownloadServlet dl = new DownloadServlet();
		try {
			dl.doGet(servletRequest, servletResponse, filePath, fileName);

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "SUCCESS";
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

}

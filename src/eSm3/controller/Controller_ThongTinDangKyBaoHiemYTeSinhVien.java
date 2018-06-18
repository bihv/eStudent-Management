package eSm3.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.internet.InternetAddress;
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
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import eCore.controller.ZEController;
import eCore.dao.ObjectDAO;
import eCore.model.SinhVien;
import eCore.modelDao.DAO_SinhVien;
import eCore.util.Util_Date;
import eCore.util.Util_Excel;
import eCore.util.Util_Mail;
import eCore.util.Util_Number;
import eSm3.model.CoSoKhamChuaBenh;
import eSm3.model.DotDangKyBaoHiem;
import eSm3.model.ThongTinDangKyBaoHiemYTeNhanVien;
import eSm3.model.ThongTinDangKyBaoHiemYTeSinhVien;
import eSm3.modelDao.DAO_CoSoKhamChuaBenh;
import eSm3.modelDao.DAO_DotDangKyBaoHiem;
import eSm3.modelDao.DAO_ThongTinDangKyBaoHiemYTeNhanVien;
import eSm3.modelDao.DAO_ThongTinDangKyBaoHiemYTeSinhVien;
import servlet.DownloadServlet;

public class Controller_ThongTinDangKyBaoHiemYTeSinhVien extends ThongTinDangKyBaoHiemYTeSinhVien
		implements ZEController, ServletRequestAware, ServletResponseAware {
	ObjectDAO dao = new DAO_ThongTinDangKyBaoHiemYTeSinhVien();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eSm3/pages/thongtindangkybaohiemytesinhviens.jsp";
	String duongDanTrangView = "eSm3/pages/thongtindangkybaohiemytesinhvien.jsp";
	String tenCotTimDoiTuong = "maThongTinDangKyBaoHiemYTe";
	String maObj;
	String maDotDangKyBaoHiem;
	String maSinhVien;
	String coSoKhamChuaBenh;
	String listMaThongTinDangKyBaoHiemzzzzzzzz;

	public String getListMaThongTinDangKyBaoHiemzzzzzzzz() {
		return listMaThongTinDangKyBaoHiemzzzzzzzz;
	}

	public void setListMaThongTinDangKyBaoHiemzzzzzzzz(String listMaThongTinDangKyBaoHiemzzzzzzzz) {
		this.listMaThongTinDangKyBaoHiemzzzzzzzz = listMaThongTinDangKyBaoHiemzzzzzzzz;
	}

	public String getCoSoKhamChuaBenh() {
		return coSoKhamChuaBenh;
	}

	public void setCoSoKhamChuaBenh(String coSoKhamChuaBenh) {
		this.coSoKhamChuaBenh = coSoKhamChuaBenh;
	}

	String s_thoiGianDangKy;

	public Date getThoiGianDangKy() {
		return Util_Date.stringToDate(getS_thoiGianDangKy());
	}

	public SinhVien getSinhVien() {
		ObjectDAO<SinhVien> obj_SinhVien = new DAO_SinhVien();
		ArrayList<SinhVien> ls_SinhVien = obj_SinhVien.listByColumns("maSinhVien", getMaSinhVien());
		if (ls_SinhVien.size() > 0)
			return ls_SinhVien.get(0);
		else
			return null;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getS_thoiGianDangKy() {
		return s_thoiGianDangKy;
	}

	public void setS_thoiGianDangKy(String s_thoiGianDangKy) {
		this.s_thoiGianDangKy = s_thoiGianDangKy;
	}

	public String getMaDotDangKyBaoHiem() {
		return maDotDangKyBaoHiem;
	}

	public void setMaDotDangKyBaoHiem(String maDotDangKyBaoHiem) {
		this.maDotDangKyBaoHiem = maDotDangKyBaoHiem;
	}

	public DotDangKyBaoHiem getDotDangKyBaoHiem() {
		ObjectDAO<DotDangKyBaoHiem> obj_DotDangKyBaoHiem = new DAO_DotDangKyBaoHiem();
		ArrayList<DotDangKyBaoHiem> ls_DotDangKyBaoHiem = obj_DotDangKyBaoHiem.listByColumns("maDotDangKyBaoHiem",
				getMaDotDangKyBaoHiem());
		if (ls_DotDangKyBaoHiem.size() > 0)
			return ls_DotDangKyBaoHiem.get(0);
		else
			return null;
	}

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

		ArrayList<ThongTinDangKyBaoHiemYTeSinhVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<ThongTinDangKyBaoHiemYTeSinhVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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

		ThongTinDangKyBaoHiemYTeSinhVien obj = new ThongTinDangKyBaoHiemYTeSinhVien();
		obj.maThongTinDangKyBaoHiemYTe = getMaThongTinDangKyBaoHiemYTe();
		String maCoSoKhamChuaBenh = getCoSoKhamChuaBenh().substring(0, getCoSoKhamChuaBenh().indexOf("-"));
		String tenCoSoKhamChuaBenh = getCoSoKhamChuaBenh().substring(getCoSoKhamChuaBenh().indexOf("-") + 1,
				getCoSoKhamChuaBenh().length());
		obj.maCoSoKhamChuaBenh = maCoSoKhamChuaBenh;
		obj.tenCoSoKhamChuaBenh = tenCoSoKhamChuaBenh;
		obj.dotDangKyBaoHiem = getDotDangKyBaoHiem();
		obj.thoiGianDangKy = getThoiGianDangKy();
		obj.sinhVien = getSinhVien();
		obj.xa = getXa();
		obj.huyen = getHuyen();
		obj.tinh = getTinh();
		obj.diaChi = getDiaChi();
		obj.trangThai = "Đang chờ duyệt";
		obj.moTa = getMoTa();
		obj.ghiChu = getGhiChu();
		obj.thoiGianCapNhat = new Date();
		if (dao.saveOrUpdate(obj)) {
			session.setAttribute("msg", "Cập nhật dữ liệu thành công");
			session.setAttribute("obj", obj);
			session.setAttribute("mode", "viewDetailAndEdit");
			session.setAttribute("p", duongDanTrangView);

			// gửi mail thông báo đã đăng ký
			String content = "<p>\r\n"
					+ "	<span class='im' style='font-family: arial, sans-serif; font-size: 12.8px;'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Xin ch&agrave;o&nbsp;<span style='color:#ff0000;'>"
					+ obj.getSinhVien().getHoDem() + " " + obj.getSinhVien().getTen()
					+ "</span>,</span></span></span></p>\r\n" + "<p>\r\n"
					+ "	<span class='im' style='font-family: arial, sans-serif; font-size: 12.8px;'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Ch&uacute;c mừng bạn đ&atilde; đăng k&yacute; th&agrave;nh c&ocirc;ng bảo hiểm y tế trong đợt đăng k&yacute;&nbsp;<span style='color:#ff0000;'>&quot;"
					+ obj.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem() + "&quot;</span>.</span></span></span></p>\r\n"
					+ "<p>\r\n"
					+ "	<span class='im' style='font-family: arial, sans-serif; font-size: 12.8px;'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Th&ocirc;ng tin bảo hiểm y tế đ&atilde; đăng k&yacute;:</span></span></span></p>\r\n"
					+ "<ul style='font-family: arial, sans-serif; font-size: 12.8px;'>\r\n"
					+ "	<li style='margin-left: 15px;'>\r\n"
					+ "		<span class='im'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>T&ecirc;n nh&acirc;n vi&ecirc;n:&nbsp;&quot;"
					+ obj.getSinhVien().getHoDem() + " " + obj.getSinhVien().getTen()
					+ "&quot;</span></span></span></li>\r\n" + "	<li style='margin-left: 15px;'>\r\n"
					+ "		<span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Thời gian đăng k&yacute;:&nbsp;&quot;"
					+ Util_Date.dateToString2(obj.getThoiGianDangKy()) + "&quot;</span></span></li>\r\n"
					+ "	<li style='margin-left: 15px;'>\r\n"
					+ "		<span class='im'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Đợt đăng k&yacute;:&nbsp;&quot;"
					+ obj.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem() + "&quot;</span></span></span></li>\r\n"
					+ "	<li style='margin-left: 15px;'>\r\n"
					+ "		<span class='im'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Trạng th&aacute;i:&nbsp;&quot;"
					+ obj.getTrangThai() + "&quot;</span></span></span></li>\r\n" + "</ul>\r\n" + "";
			Util_Mail u = new Util_Mail("smtp.gmail.com", "587", "true", "true", "hovanbi2018", "giaothongvantai");

			// lấy email tài khoản đã đăng ký.
			String re = obj.getSinhVien().getEmail();

			try {
				InternetAddress[] arr = InternetAddress.parse(re);
				for (InternetAddress internetAddress : arr) {
					System.out.println(internetAddress.toString());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			u.sendEmails(null, null, re, "[UTC2] Thông báo kết quả đăng ký bảo hiểm", content);

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
		ThongTinDangKyBaoHiemYTeSinhVien obj = new ThongTinDangKyBaoHiemYTeSinhVien();
		obj.setMaThongTinDangKyBaoHiemYTe(maobj);
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
		ArrayList<ThongTinDangKyBaoHiemYTeSinhVien> arr = dao.listByColumnLike(column, key);
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
		HSSFSheet sheet = workbook.createSheet("Danh sách đăng ký BHYT");
		//
		HSSFCellStyle style = createStyleForTitle(workbook);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 13));

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("DANH SÁCH THAM GIA BẢO HIỂM Y TẾ");
		cell.setCellStyle(style);

		rownum = rownum + 1;
		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("STT");
		cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Họ đệm");
		cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Tên");
		cell.setCellStyle(style);

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Ngày tháng năm sinh");
		cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Nữ (x)");
		cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Số CMND");
		cell.setCellStyle(style);

		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Xã");
		cell.setCellStyle(style);

		cell = row.createCell(7, CellType.STRING);
		cell.setCellValue("Huyện");
		cell.setCellStyle(style);

		cell = row.createCell(8, CellType.STRING);
		cell.setCellValue("Tỉnh");
		cell.setCellStyle(style);

		cell = row.createCell(9, CellType.STRING);
		cell.setCellValue("Địa chỉ");
		cell.setCellStyle(style);

		cell = row.createCell(10, CellType.STRING);
		cell.setCellValue("Mã BV (Nơi đăng ký KCB ban đầu)");
		cell.setCellStyle(style);

		cell = row.createCell(11, CellType.STRING);
		cell.setCellValue("Tên bệnh viện");
		cell.setCellStyle(style);

		cell = row.createCell(12, CellType.STRING);
		cell.setCellValue("MSSV");
		cell.setCellStyle(style);

		cell = row.createCell(13, CellType.STRING);
		cell.setCellValue("Số tiền BHYT");
		cell.setCellStyle(style);

		rownum = rownum + 1;
		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("(1)");
		cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("(2)");
		cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("(3)");
		cell.setCellStyle(style);

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("(4)");
		cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("(5)");
		cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("(#)");
		cell.setCellStyle(style);

		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("");

		cell = row.createCell(7, CellType.STRING);
		cell.setCellValue("");

		cell = row.createCell(8, CellType.STRING);
		cell.setCellValue("");

		cell = row.createCell(9, CellType.STRING);
		cell.setCellValue("#");
		cell.setCellStyle(style);

		cell = row.createCell(10, CellType.STRING);
		cell.setCellValue("(6)");
		cell.setCellStyle(style);

		cell = row.createCell(11, CellType.STRING);
		cell.setCellValue("");

		cell = row.createCell(12, CellType.STRING);
		cell.setCellValue("");

		cell = row.createCell(13, CellType.STRING);
		cell.setCellValue("");

		// Data
		// bắt đầu xuất dữ liệu thông tin đăng ký bảo hiểm y tế sinh viên
		ObjectDAO<ThongTinDangKyBaoHiemYTeSinhVien> dao_ThongTinDangKyBHYTSinhVien = new DAO_ThongTinDangKyBaoHiemYTeSinhVien();
		ArrayList<ThongTinDangKyBaoHiemYTeSinhVien> list_ThongTinDangKyBHYTSinhVien = new ArrayList<ThongTinDangKyBaoHiemYTeSinhVien>();

		if (!getMaDotDangKyBaoHiem().isEmpty() && getMaDotDangKyBaoHiem() != null
				&& !getMaDotDangKyBaoHiem().equals("all"))
			list_ThongTinDangKyBHYTSinhVien = dao_ThongTinDangKyBHYTSinhVien.listByColumns("dotDangKyBaoHiem",
					getMaDotDangKyBaoHiem());
		else
			list_ThongTinDangKyBHYTSinhVien = dao_ThongTinDangKyBHYTSinhVien.listAll();

		int stt = 0;
		double tongTien = 0;
		for (ThongTinDangKyBaoHiemYTeSinhVien thongTinDangKyBaoHiemYTeSinhVien : list_ThongTinDangKyBHYTSinhVien) {
			if (thongTinDangKyBaoHiemYTeSinhVien.getTrangThai().equals("Đã duyệt")) {
				rownum++;
				stt++;
				row = sheet.createRow(rownum);

				cell = row.createCell(0, CellType.STRING);
				cell.setCellValue(stt);

				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getSinhVien().getHoDem());

				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getSinhVien().getTen());

				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getSinhVien().getNgaySinh());

				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue(
						thongTinDangKyBaoHiemYTeSinhVien.getSinhVien().getGioiTinh().equalsIgnoreCase("Nữ") ? "x" : "");

				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getSinhVien().getSoCMND());

				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getXa());

				cell = row.createCell(7, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getHuyen());

				cell = row.createCell(8, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getTinh());

				cell = row.createCell(9, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getDiaChi());

				cell = row.createCell(10, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getMaCoSoKhamChuaBenh());

				cell = row.createCell(11, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getTenCoSoKhamChuaBenh());

				cell = row.createCell(12, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getSinhVien().getMaSinhVien());

				cell = row.createCell(13, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemYTeSinhVien.getDotDangKyBaoHiem().getSoTien());

				tongTien += thongTinDangKyBaoHiemYTeSinhVien.getDotDangKyBaoHiem().getSoTien();
			}

		}
		// kết thúc xuất dữ liệu thông tin đăng ký bảo hiểm y tế sinh viên

		rownum++;
		row = sheet.createRow(rownum);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 13));
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Tổng tiền (BHYT + BHTT) bằng số: " + Util_Number.number2String(tongTien));

		rownum++;
		row = sheet.createRow(rownum);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 13));
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Tổng tiền (BHYT + BHTT) bằng chữ: " + Util_Number.numberToString(tongTien));

		PropertyTemplate pt = new PropertyTemplate();
		pt.drawBorders(new CellRangeAddress(1, 2, 0, 13), BorderStyle.THIN, BorderExtent.ALL);

		pt.drawBorders(new CellRangeAddress(1, rownum - 2, 0, 14), BorderStyle.THIN, BorderExtent.LEFT);

		pt.drawBorders(new CellRangeAddress(1, rownum - 2, 0, 14), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(rownum - 1, rownum, 0, 13), BorderStyle.THIN, BorderExtent.TOP);

		pt.applyBorders(sheet);

		// auto width all column
		for (int i = 0; i < Util_Excel.getColumnsCount(sheet); i++)
			sheet.autoSizeColumn(i);

		String fileName = "Danh sach dang ky BHYT sinh vien.xls";
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

	public String duyetDangKyBHYT() {
		System.out.println(getListMaThongTinDangKyBaoHiemzzzzzzzz());
		String[] list_Duyet = getListMaThongTinDangKyBaoHiemzzzzzzzz().split(",");
		String re = "";
		for (int i = 0; i < list_Duyet.length; i++) {
			System.out.println(list_Duyet[i]);
			ObjectDAO<ThongTinDangKyBaoHiemYTeSinhVien> dao_ThongTinDangKyBHYTSinhVien = new DAO_ThongTinDangKyBaoHiemYTeSinhVien();
			ArrayList<ThongTinDangKyBaoHiemYTeSinhVien> list_ThongTinDangKyBaoHiemYTeSinhVien = dao_ThongTinDangKyBHYTSinhVien
					.listByColumns("maThongTinDangKyBaoHiemYTe", list_Duyet[i]);
			if (list_ThongTinDangKyBaoHiemYTeSinhVien.size() > 0) {
				ThongTinDangKyBaoHiemYTeSinhVien thongTinDangKyBaoHiemYTeSinhVien = list_ThongTinDangKyBaoHiemYTeSinhVien
						.get(0);
				thongTinDangKyBaoHiemYTeSinhVien.setTrangThai("Đã duyệt");
				if (dao.saveOrUpdate(thongTinDangKyBaoHiemYTeSinhVien))
					re += thongTinDangKyBaoHiemYTeSinhVien.getSinhVien().getEmail() + ",";
			}
		}

		// gửi mail thông báo đã được duyệt
		String content = "<div style=''>\r\n" + "	<span style='font-size:16px;'>Ch&agrave;o bạn,</span></div>\r\n"
				+ "<div style=''>\r\n" + "	&nbsp;</div>\r\n" + "<div style=''>\r\n"
				+ "	<span style='font-size:16px;'>Th&ocirc;ng tin đăng k&yacute; bảo hiểm y tế của bạn đ&atilde; <span style='color:#ff0000;'><strong>ĐƯỢC DUYỆT</strong></span>.</span></div>";
		Util_Mail u = new Util_Mail("smtp.gmail.com", "587", "true", "true", "hovanbi2018", "giaothongvantai");
		System.out.println("re=" + re);
		try {
			InternetAddress[] arr = InternetAddress.parse(re);
			for (InternetAddress internetAddress : arr) {
				System.out.println(internetAddress.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		u.sendEmails(null, null, re, "[UTC2] Thông báo kết quả đăng ký bảo hiểm", content);

		return "SUCCESS";
	}

	public String huyDuyetDangKyBHYT() {
		System.out.println(getListMaThongTinDangKyBaoHiemzzzzzzzz());
		String[] list_Duyet = getListMaThongTinDangKyBaoHiemzzzzzzzz().split(",");
		String re = "";
		for (int i = 0; i < list_Duyet.length; i++) {
			System.out.println(list_Duyet[i]);
			ObjectDAO<ThongTinDangKyBaoHiemYTeSinhVien> dao_ThongTinDangKyBHYTSinhVien = new DAO_ThongTinDangKyBaoHiemYTeSinhVien();
			ArrayList<ThongTinDangKyBaoHiemYTeSinhVien> list_ThongTinDangKyBaoHiemYTeSinhVien = dao_ThongTinDangKyBHYTSinhVien
					.listByColumns("maThongTinDangKyBaoHiemYTe", list_Duyet[i]);
			if (list_ThongTinDangKyBaoHiemYTeSinhVien.size() > 0) {
				ThongTinDangKyBaoHiemYTeSinhVien thongTinDangKyBaoHiemYTeSinhVien = list_ThongTinDangKyBaoHiemYTeSinhVien
						.get(0);
				thongTinDangKyBaoHiemYTeSinhVien.setTrangThai("Không duyệt");
				if (dao.saveOrUpdate(thongTinDangKyBaoHiemYTeSinhVien))
					re += thongTinDangKyBaoHiemYTeSinhVien.getSinhVien().getEmail() + ",";
			}
		}

		// gửi mail thông báo đã được duyệt
		String content = "<div style=''>\r\n" + "	<span style='font-size:16px;'>Ch&agrave;o bạn,</span></div>\r\n"
				+ "<div style=''>\r\n" + "	&nbsp;</div>\r\n" + "<div style=''>\r\n"
				+ "	<span style='font-size:16px;'>Th&ocirc;ng tin đăng k&yacute; bảo hiểm y tế của bạn đ&atilde; <span style='color:#ff0000;'><strong>KHÔNG ĐƯỢC DUYỆT</strong></span>.</span></div>";
		Util_Mail u = new Util_Mail("smtp.gmail.com", "587", "true", "true", "hovanbi2018", "giaothongvantai");
		System.out.println("re=" + re);
		try {
			InternetAddress[] arr = InternetAddress.parse(re);
			for (InternetAddress internetAddress : arr) {
				System.out.println(internetAddress.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		u.sendEmails(null, null, re, "[UTC2] Thông báo kết quả đăng ký bảo hiểm", content);

		return "SUCCESS";
	}
}

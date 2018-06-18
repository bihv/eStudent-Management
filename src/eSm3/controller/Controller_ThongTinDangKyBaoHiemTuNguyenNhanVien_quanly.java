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
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import eCore.controller.ZEController;
import eCore.dao.ObjectDAO;
import eCore.model.NhanVien;
import eCore.modelDao.DAO_NhanVien;
import eCore.util.Util_Date;
import eCore.util.Util_Excel;
import eCore.util.Util_Mail;
import eCore.util.Util_Number;
import eSm3.model.DotDangKyBaoHiem;
import eSm3.model.ThongTinDangKyBaoHiemTuNguyenNhanVien;
import eSm3.model.ThongTinDangKyBaoHiemTuNguyenSinhVien;
import eSm3.modelDao.DAO_DotDangKyBaoHiem;
import eSm3.modelDao.DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien;
import eSm3.modelDao.DAO_ThongTinDangKyBaoHiemTuNguyenSinhVien;
import servlet.DownloadServlet;

public class Controller_ThongTinDangKyBaoHiemTuNguyenNhanVien_quanly extends ThongTinDangKyBaoHiemTuNguyenNhanVien
		implements ZEController, ServletRequestAware, ServletResponseAware {
	ObjectDAO dao = new DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eSm3/pages/thongtindangkybaohiemtunguyennhanviens_quanly.jsp";
	String duongDanTrangView = "eSm3/pages/thongtindangkybaohiemtunguyennhanvien_quanly.jsp";
	String tenCotTimDoiTuong = "maThongTinDangKyBaoHiemTuNguyen";
	String maObj;
	String maDotDangKyBaoHiem;
	String maNhanVien;

	String s_thoiGianDangKy;

	String listMaThongTinDangKyBaoHiemzzzzzzzz;

	public String getListMaThongTinDangKyBaoHiemzzzzzzzz() {
		return listMaThongTinDangKyBaoHiemzzzzzzzz;
	}

	public void setListMaThongTinDangKyBaoHiemzzzzzzzz(String listMaThongTinDangKyBaoHiemzzzzzzzz) {
		this.listMaThongTinDangKyBaoHiemzzzzzzzz = listMaThongTinDangKyBaoHiemzzzzzzzz;
	}

	public Date getThoiGianDangKy() {
		return Util_Date.stringToDate(getS_thoiGianDangKy());
	}

	public NhanVien getNhanVien() {
		ObjectDAO<NhanVien> obj_NhanVien = new DAO_NhanVien();
		ArrayList<NhanVien> ls_NhanVien = obj_NhanVien.listByColumns("maNhanVien", getMaNhanVien());
		if (ls_NhanVien.size() > 0)
			return ls_NhanVien.get(0);
		else
			return null;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
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

		ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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

		ThongTinDangKyBaoHiemTuNguyenNhanVien obj = new ThongTinDangKyBaoHiemTuNguyenNhanVien();
		obj.maThongTinDangKyBaoHiemTuNguyen = getMaThongTinDangKyBaoHiemTuNguyen();
		obj.dotDangKyBaoHiem = getDotDangKyBaoHiem();
		obj.thoiGianDangKy = getThoiGianDangKy();
		obj.nhanVien = getNhanVien();
		obj.trangThai = "Đang chờ duyệt";
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
		ThongTinDangKyBaoHiemTuNguyenNhanVien obj = new ThongTinDangKyBaoHiemTuNguyenNhanVien();
		obj.setMaThongTinDangKyBaoHiemTuNguyen(maobj);
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
		System.out.println(key);
		ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien> arr = dao.listByColumnLike(column, key);
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
		HSSFSheet sheet = workbook.createSheet("Danh sách đăng ký BHTN");
		//
		HSSFCellStyle style = createStyleForTitle(workbook);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("DANH SÁCH THAM GIA BẢO HIỂM TỰ NGUYỆN");
		cell.setCellStyle(style);

		rownum = rownum + 1;
		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("STT");
		cell.setCellStyle(style);

		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 2));
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
		cell.setCellValue("Số CMND");
		cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("MSSV");
		cell.setCellStyle(style);

		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Phí bảo hiểm");
		cell.setCellStyle(style);

		cell = row.createCell(7, CellType.STRING);
		cell.setCellValue("Ngày nộp");
		cell.setCellStyle(style);

		cell = row.createCell(8, CellType.STRING);
		cell.setCellValue("Người nộp ký tên");
		cell.setCellStyle(style);

		cell = row.createCell(9, CellType.STRING);
		cell.setCellValue("Ghi chú");
		cell.setCellStyle(style);

		// Data
		// bắt đầu xuất dữ liệu thông tin đăng ký bảo hiểm y tế nhân viên
		ObjectDAO<ThongTinDangKyBaoHiemTuNguyenNhanVien> dao_ThongTinDangKyBaoHiemTuNguyenNhanVien = new DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien();
		ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien> list_ThongTinDangKyBaoHiemTuNguyenNhanVien = new ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien>();
		if (!getMaDotDangKyBaoHiem().isEmpty() && getMaDotDangKyBaoHiem() != null
				&& !getMaDotDangKyBaoHiem().equals("all"))
			list_ThongTinDangKyBaoHiemTuNguyenNhanVien = dao_ThongTinDangKyBaoHiemTuNguyenNhanVien
					.listByColumns("dotDangKyBaoHiem", getMaDotDangKyBaoHiem());
		else
			list_ThongTinDangKyBaoHiemTuNguyenNhanVien = dao_ThongTinDangKyBaoHiemTuNguyenNhanVien.listAll();

		System.out.println("getMaDotDangKyBaoHiem() = " + getMaDotDangKyBaoHiem());
		int stt = 0;
		double tongTien = 0;

		for (ThongTinDangKyBaoHiemTuNguyenNhanVien thongTinDangKyBaoHiemTuNguyenNhanVien : list_ThongTinDangKyBaoHiemTuNguyenNhanVien) {
			if (thongTinDangKyBaoHiemTuNguyenNhanVien.getTrangThai().equals("Đã duyệt")) {
				rownum++;
				stt++;
				row = sheet.createRow(rownum);

				cell = row.createCell(0, CellType.STRING);
				cell.setCellValue(stt);

				String hoVaTen = thongTinDangKyBaoHiemTuNguyenNhanVien.getNhanVien().getTenNhanVien().trim();
				String hoDem = hoVaTen.substring(0, hoVaTen.lastIndexOf(" "));
				String ten = hoVaTen.substring(hoVaTen.lastIndexOf(" "), hoVaTen.length());
				System.out.println(hoDem);
				System.out.println(ten);
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(hoDem);

				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(ten);

				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue(
						Util_Date.dateToString2(thongTinDangKyBaoHiemTuNguyenNhanVien.getNhanVien().getNgaySinh()));

				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemTuNguyenNhanVien.getNhanVien().getSoCMND());

				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemTuNguyenNhanVien.getNhanVien().getMaNhanVien());

				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue(thongTinDangKyBaoHiemTuNguyenNhanVien.getDotDangKyBaoHiem().getSoTien());

				tongTien += thongTinDangKyBaoHiemTuNguyenNhanVien.getDotDangKyBaoHiem().getSoTien();
			}
		}
		// kết thúc xuất danh sách đăng ký bảo hiểm y tế nhân viên

		rownum++;
		row = sheet.createRow(rownum);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 10));
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Tổng tiền bằng số: " + Util_Number.number2String(tongTien));

		rownum++;
		row = sheet.createRow(rownum);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 10));
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("Tổng tiền bằng chữ: " + Util_Number.numberToString(tongTien));

		PropertyTemplate pt = new PropertyTemplate();
		pt.drawBorders(new CellRangeAddress(1, 1, 0, 9), BorderStyle.THIN, BorderExtent.ALL);

		pt.drawBorders(new CellRangeAddress(1, rownum - 2, 0, 1), BorderStyle.THIN, BorderExtent.LEFT);

		pt.drawBorders(new CellRangeAddress(1, rownum - 2, 0, 1), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(1, rownum - 2, 2, 10), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(rownum - 1, rownum, 0, 9), BorderStyle.THIN, BorderExtent.TOP);

		pt.applyBorders(sheet);

		// auto width all column
		for (int i = 0; i < Util_Excel.getColumnsCount(sheet); i++)
			sheet.autoSizeColumn(i);

		String fileName = "Danh sach dang ky BHTN nhan vien.xls";
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

	public String duyetDangKyBHTN() {
		System.out.println(getListMaThongTinDangKyBaoHiemzzzzzzzz());
		String[] list_Duyet = getListMaThongTinDangKyBaoHiemzzzzzzzz().split(",");
		String re = "";
		for (int i = 0; i < list_Duyet.length; i++) {
			System.out.println(list_Duyet[i]);
			ObjectDAO<ThongTinDangKyBaoHiemTuNguyenNhanVien> dao_ThongTinDangKyBHTNNhanVien = new DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien();
			ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien> list_ThongTinDangKyBaoHiemTuNguyenNhanVien = dao_ThongTinDangKyBHTNNhanVien
					.listByColumns("maThongTinDangKyBaoHiemTuNguyen", list_Duyet[i]);
			if (list_ThongTinDangKyBaoHiemTuNguyenNhanVien.size() > 0) {
				ThongTinDangKyBaoHiemTuNguyenNhanVien thongTinDangKyBaoHiemTuNguyenNhanVien = list_ThongTinDangKyBaoHiemTuNguyenNhanVien
						.get(0);
				thongTinDangKyBaoHiemTuNguyenNhanVien.setTrangThai("Đã duyệt");
				if (dao.saveOrUpdate(thongTinDangKyBaoHiemTuNguyenNhanVien)) {
					// lấy email tài khoản đã đăng ký.
					re += thongTinDangKyBaoHiemTuNguyenNhanVien.getNhanVien().getEmail() + ",";
				}
			}
		}

		// gửi mail thông báo đã được duyệt
		String content = "<div style=''>\r\n" + "	<span style='font-size:16px;'>Ch&agrave;o bạn,</span></div>\r\n"
				+ "<div style=''>\r\n" + "	&nbsp;</div>\r\n" + "<div style=''>\r\n"
				+ "	<span style='font-size:16px;'>Th&ocirc;ng tin đăng k&yacute; bảo hiểm tự nguyện của bạn đ&atilde; <span style='color:#ff0000;'><strong>ĐƯỢC DUYỆT</strong></span>.</span></div>";
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

	public String huyDuyetDangKyBHTN() {
		System.out.println(getListMaThongTinDangKyBaoHiemzzzzzzzz());
		String[] list_Duyet = getListMaThongTinDangKyBaoHiemzzzzzzzz().split(",");
		String re = "";
		for (int i = 0; i < list_Duyet.length; i++) {
			System.out.println(list_Duyet[i]);
			ObjectDAO<ThongTinDangKyBaoHiemTuNguyenNhanVien> dao_ThongTinDangKyBHTNNhanVien = new DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien();
			ArrayList<ThongTinDangKyBaoHiemTuNguyenNhanVien> list_ThongTinDangKyBaoHiemTuNguyenNhanVien = dao_ThongTinDangKyBHTNNhanVien
					.listByColumns("maThongTinDangKyBaoHiemTuNguyen", list_Duyet[i]);
			if (list_ThongTinDangKyBaoHiemTuNguyenNhanVien.size() > 0) {
				ThongTinDangKyBaoHiemTuNguyenNhanVien thongTinDangKyBaoHiemTuNguyenNhanVien = list_ThongTinDangKyBaoHiemTuNguyenNhanVien
						.get(0);
				thongTinDangKyBaoHiemTuNguyenNhanVien.setTrangThai("Không duyệt");
				if (dao.saveOrUpdate(thongTinDangKyBaoHiemTuNguyenNhanVien)) {
					// lấy email tài khoản đã đăng ký.
					re += thongTinDangKyBaoHiemTuNguyenNhanVien.getNhanVien().getEmail() + ",";
				}
			}
		}
		// gửi mail thông báo không được duyệt
		String content = "<div style=''>\r\n" + "	<span style='font-size:16px;'>Ch&agrave;o bạn,</span></div>\r\n"
				+ "<div style=''>\r\n" + "	&nbsp;</div>\r\n" + "<div style=''>\r\n"
				+ "	<span style='font-size:16px;'>Th&ocirc;ng tin đăng k&yacute; bảo hiểm tự nguyện của bạn đ&atilde; <strong><span style='color:#ff0000;'>KH&Ocirc;NG&nbsp;ĐƯỢC DUYỆT</span></strong>.</span></div>";
		Util_Mail u = new Util_Mail("smtp.gmail.com", "587", "true", "true", "hovanbi2018", "giaothongvantai");

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

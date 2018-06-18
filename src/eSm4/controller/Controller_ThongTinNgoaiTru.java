package eSm4.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.IntStream;

import javax.mail.internet.InternetAddress;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
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
import eCore.model.SinhVien;
import eCore.modelDao.DAO_SinhVien;
import eCore.util.Util_Date;
import eCore.util.Util_Excel;
import eCore.util.Util_Mail;
import eCore.util.Util_Number;
import eSm3.model.ThongTinDangKyBaoHiemYTeSinhVien;
import eSm4.model.DotKeKhaiThongTinNgoaiTru;
import eSm4.model.ThongTinNgoaiTru;
import eSm4.modelDao.DAO_DotKeKhaiThongTinNgoaiTru;
import eSm4.modelDao.DAO_ThongTinNgoaiTru;
import servlet.DownloadServlet;

public class Controller_ThongTinNgoaiTru extends ThongTinNgoaiTru
		implements ZEController, ServletRequestAware, ServletResponseAware {
	ObjectDAO dao = new DAO_ThongTinNgoaiTru();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eSm4/pages/thongtinngoaitrus.jsp";
	String duongDanTrangView = "eSm4/pages/thongtinngoaitru.jsp";
	String tenCotTimDoiTuong = "maThongTinNgoaiTru";
	String maObj;
	String s_thoiGianCapNhat;
	String maSinhVien;
	String maDotKeKhaiThongTinNgoaiTru;
	String s_ngayDangKyCuTru;

	public SinhVien getSinhVien() {
		ObjectDAO<SinhVien> obj_SinhVien = new DAO_SinhVien();
		ArrayList<SinhVien> ls_SinhVien = obj_SinhVien.listByColumns("maSinhVien", getMaSinhVien());
		if (ls_SinhVien.size() > 0)
			return ls_SinhVien.get(0);
		else
			return null;
	}

	public DotKeKhaiThongTinNgoaiTru getDotKeKhaiThongTinNgoaiTru() {
		ObjectDAO<DotKeKhaiThongTinNgoaiTru> obj_DotKeKhaiThongTinNgoaiTru = new DAO_DotKeKhaiThongTinNgoaiTru();
		ArrayList<DotKeKhaiThongTinNgoaiTru> ls_DotKeKhaiThongTinNgoaiTru = obj_DotKeKhaiThongTinNgoaiTru
				.listByColumns("maDotKeKhaiThongTinNgoaiTru", getMaDotKeKhaiThongTinNgoaiTru());
		if (ls_DotKeKhaiThongTinNgoaiTru.size() > 0)
			return ls_DotKeKhaiThongTinNgoaiTru.get(0);
		else
			return null;
	}

	public Date getNgayDangKyCuTru() {
		return Util_Date.stringToDate(getS_ngayDangKyCuTru());
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getMaDotKeKhaiThongTinNgoaiTru() {
		return maDotKeKhaiThongTinNgoaiTru;
	}

	public void setMaDotKeKhaiThongTinNgoaiTru(String maDotKeKhaiThongTinNgoaiTru) {
		this.maDotKeKhaiThongTinNgoaiTru = maDotKeKhaiThongTinNgoaiTru;
	}

	public String getS_ngayDangKyCuTru() {
		return s_ngayDangKyCuTru;
	}

	public void setS_ngayDangKyCuTru(String s_ngayDangKyCuTru) {
		this.s_ngayDangKyCuTru = s_ngayDangKyCuTru;
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

	public String getS_thoiGianCapNhat() {
		return s_thoiGianCapNhat;
	}

	public void setS_thoiGianCapNhat(String s_thoiGianCapNhat) {
		this.s_thoiGianCapNhat = s_thoiGianCapNhat;
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

		ArrayList<ThongTinNgoaiTru> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<ThongTinNgoaiTru> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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

		ThongTinNgoaiTru obj = new ThongTinNgoaiTru();
		obj.maThongTinNgoaiTru = getMaThongTinNgoaiTru();
		obj.sinhVien = getSinhVien();
		obj.dotKeKhaiThongTinNgoaiTru = getDotKeKhaiThongTinNgoaiTru();
		obj.hoVaTenChuNhaTro = getHoVaTenChuNhaTro();
		obj.diaChiNhaTro = getDiaChiNhaTro();
		obj.soDienThoaiCuaChuNhaTro = getSoDienThoaiCuaChuNhaTro();
		obj.ngayDangKyCuTru = getNgayDangKyCuTru();
		obj.ngayKeKhaiThongTin = new Date();
		obj.thueNhaTro = isThueNhaTro();
		obj.moTa = getMoTa();
		obj.ghiChu = getGhiChu();
		obj.thoiGianCapNhat = new Date();
		if (dao.saveOrUpdate(obj)) {
			session.setAttribute("msg", "Cập nhật dữ liệu thành công");
			session.setAttribute("obj", obj);
			session.setAttribute("mode", "viewDetailAndEdit");
			session.setAttribute("p", duongDanTrangView);

			// gửi mail thông báo đã đăng ký
			String content = "<p>\r\n" + "	<span style='font-size:16px;'>Xin chào " + obj.getSinhVien().getHoDem()
					+ " " + obj.getSinhVien().getTen() + ",</span></p>\r\n" + "<p>\r\n"
					+ "	<span style='font-size:16px;'>Thông tin ngoại trú; của bạn:</span></p>\r\n" + "<ul>\r\n"
					+ "	<li>\r\n" + "		<span style='font-size:16px;'>Mã thông tin ngoại trú: "
					+ obj.getMaThongTinNgoaiTru() + "</span></li>\r\n" + "	<li>\r\n"
					+ "		<span style='font-size:16px;'>Sinh viên: " + obj.getSinhVien().getHoDem() + " "
					+ obj.getSinhVien().getTen() + "</span></li>\r\n" + "	<li>\r\n"
					+ "		<span style='font-size:16px;'>Đợt kê khai: "
					+ obj.getDotKeKhaiThongTinNgoaiTru().getTenDotKeKhaiThongTinNgoaiTru() + "</span></li>\r\n"
					+ "	<li>\r\n" + "		<span style='font-size:16px;'>Họ tên chủ trọ:" + obj.getHoVaTenChuNhaTro()
					+ "</span></li>\r\n" + "	<li>\r\n"
					+ "		<span style='font-size:16px;'>Số điện thoại chủ trọ: " + obj.getSoDienThoaiCuaChuNhaTro()
					+ "</span></li>\r\n" + "	<li>\r\n" + "		<span style='font-size:16px;'>Ngày đăng ký cư trú: "
					+ Util_Date.dateToString2(obj.getNgayDangKyCuTru()) + "</span></li>\r\n" + "	<li>\r\n"
					+ "		<span style='font-size:16px;'>Ngày kê khai: "
					+ Util_Date.dateToString2(obj.getNgayKeKhaiThongTin()) + "</span></li>\r\n" + "</ul>\r\n" + "";
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
			u.sendEmails(null, null, re, "[UTC2] Thông báo kết quả kê khai thông tin ngoại trú", content);

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
		ThongTinNgoaiTru obj = new ThongTinNgoaiTru();
		obj.setMaThongTinNgoaiTru(maobj);
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
		ArrayList<ThongTinNgoaiTru> arr = dao.listByColumnLike(column, key);
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
		HSSFSheet sheet = workbook.createSheet("Danh sách sinh viên kê khai ngoại trú");
		//
		HSSFCellStyle style = createStyleForTitle(workbook);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 9));

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("TRƯỜNG ĐẠI HỌC GIAO THÔNG VẬN TẢI");
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellStyle(style);

		rownum = rownum + 1;
		row = sheet.createRow(rownum);

		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 9));
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("PHÂN HIỆU TẠI TP. HỒ CHÍ  MINH");
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellStyle(style);

		rownum = rownum + 2;
		row = sheet.createRow(rownum);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 9));
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("DANH SÁCH SINH VIÊN NGOẠI TRÚ");
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellStyle(style);

		rownum = rownum + 1;
		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("STT");
		cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("MSSV");
		cell.setCellStyle(style);

		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 2, 3));
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Họ và tên");
		cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Địa chỉ nơi cư trú");
		cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("SĐT");
		cell.setCellStyle(style);

		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Chủ nhà trọ");
		cell.setCellStyle(style);

		cell = row.createCell(7, CellType.STRING);
		cell.setCellValue("SĐT chủ nhà trọ");
		cell.setCellStyle(style);

		cell = row.createCell(8, CellType.STRING);
		cell.setCellValue("Ngày đăng ký cư trú");
		cell.setCellStyle(style);

		cell = row.createCell(9, CellType.STRING);
		cell.setCellValue("Ghi chú");
		cell.setCellStyle(style);

		// Data
		ObjectDAO<ThongTinNgoaiTru> dao_ThongTinNgoaiTru = new DAO_ThongTinNgoaiTru();
		ArrayList<ThongTinNgoaiTru> list_ThongTinNgoaiTru = new ArrayList<ThongTinNgoaiTru>();

		
		
		if (!getMaDotKeKhaiThongTinNgoaiTru().isEmpty() && getMaDotKeKhaiThongTinNgoaiTru() != null
				&& !getMaDotKeKhaiThongTinNgoaiTru().equals("all"))
			list_ThongTinNgoaiTru = dao_ThongTinNgoaiTru.listByColumns("dotKeKhaiThongTinNgoaiTru",
					getMaDotKeKhaiThongTinNgoaiTru());
		else
			list_ThongTinNgoaiTru = dao_ThongTinNgoaiTru.listAll();


		int stt = 0;
		for (ThongTinNgoaiTru thongTinNgoaiTru : list_ThongTinNgoaiTru) {
			rownum++;
			stt++;
			row = sheet.createRow(rownum);

			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(stt);

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(thongTinNgoaiTru.getSinhVien().getMaSinhVien());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(thongTinNgoaiTru.getSinhVien().getHoDem());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(thongTinNgoaiTru.getSinhVien().getTen());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(thongTinNgoaiTru.getDiaChiNhaTro());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(thongTinNgoaiTru.getSinhVien().getDienThoaiDiDong());

			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(thongTinNgoaiTru.getHoVaTenChuNhaTro());

			cell = row.createCell(7, CellType.STRING);
			cell.setCellValue(thongTinNgoaiTru.getSoDienThoaiCuaChuNhaTro());

			cell = row.createCell(8, CellType.STRING);
			cell.setCellValue(Util_Date.dateToString2(thongTinNgoaiTru.getNgayDangKyCuTru()));

			cell = row.createCell(9, CellType.STRING);
			cell.setCellValue(thongTinNgoaiTru.getGhiChu());

		}
		System.out.println("rownum = " + rownum);
		PropertyTemplate pt = new PropertyTemplate();
		pt.drawBorders(new CellRangeAddress(4, 4, 0, 9), BorderStyle.THIN, BorderExtent.ALL);

		pt.drawBorders(new CellRangeAddress(4, rownum, 0, 1), BorderStyle.THIN, BorderExtent.LEFT);

		pt.drawBorders(new CellRangeAddress(4, rownum, 0, 2), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(4, rownum, 3, 9), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(4, rownum, 10, 10), BorderStyle.THIN, BorderExtent.LEFT);

		pt.drawBorders(new CellRangeAddress(rownum + 1, rownum + 1, 0, 9), BorderStyle.THIN, BorderExtent.TOP);

		pt.applyBorders(sheet);

		// auto width all column
		for (int i = 0; i < Util_Excel.getColumnsCount(sheet); i++)
			sheet.autoSizeColumn(i);

		String fileName = "Danh sach ke khai thong tin ngoai tru " + getMaDotKeKhaiThongTinNgoaiTru() + ".xls";
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

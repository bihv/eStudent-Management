package eSm5.controller;

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
import eCore.model.SinhVien;
import eCore.modelDao.DAO_SinhVien;
import eCore.util.Util_Date;
import eCore.util.Util_Excel;
import eCore.util.Util_Mail;
import eSm4.model.ThongTinNgoaiTru;
import eSm4.modelDao.DAO_ThongTinNgoaiTru;
import eSm5.model.ThongTinKhenThuong;
import eSm5.modelDao.DAO_ThongTinKhenThuong;
import servlet.DownloadServlet;

public class Controller_ThongTinKhenThuong extends ThongTinKhenThuong
		implements ZEController, ServletRequestAware, ServletResponseAware {
	ObjectDAO dao = new DAO_ThongTinKhenThuong();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eSm5/pages/thongtinkhenthuongs.jsp";
	String duongDanTrangView = "eSm5/pages/thongtinkhenthuong.jsp";
	String tenCotTimDoiTuong = "maThongTinKhenThuong";
	String maObj;
	String maSinhVien;
	String s_thoiGianKhenThuong;
	String s_ngayBatDau;
	String s_ngayKetThuc;

	public Date getNgayBatDau() {
		return Util_Date.stringToDate(getS_ngayBatDau());
	}

	public Date getNgayKetThuc() {
		return Util_Date.stringToDate(getS_ngayKetThuc());
	}

	public String getS_ngayBatDau() {
		return s_ngayBatDau;
	}

	public void setS_ngayBatDau(String s_ngayBatDau) {
		this.s_ngayBatDau = s_ngayBatDau;
	}

	public String getS_ngayKetThuc() {
		return s_ngayKetThuc;
	}

	public void setS_ngayKetThuc(String s_ngayKetThuc) {
		this.s_ngayKetThuc = s_ngayKetThuc;
	}

	public Date getThoiGianKhenThuong() {
		return Util_Date.stringToDate(getS_thoiGianKhenThuong());
	}

	public String getS_thoiGianKhenThuong() {
		return s_thoiGianKhenThuong;
	}

	public void setS_thoiGianKhenThuong(String s_thoiGianKhenThuong) {
		this.s_thoiGianKhenThuong = s_thoiGianKhenThuong;
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

		ArrayList<ThongTinKhenThuong> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<ThongTinKhenThuong> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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

		ThongTinKhenThuong obj = new ThongTinKhenThuong();
		obj.maThongTinKhenThuong = getMaThongTinKhenThuong();
		obj.sinhVien = getSinhVien();
		obj.noiDungKhenThuong = getNoiDungKhenThuong();
		obj.thoiGianKhenThuong = getThoiGianKhenThuong();
		obj.moTa = getMoTa();
		obj.ghiChu = getGhiChu();
		obj.thoiGianCapNhat = new Date();
		if (dao.saveOrUpdate(obj)) {
			session.setAttribute("msg", "Cập nhật dữ liệu thành công");
			session.setAttribute("obj", obj);
			session.setAttribute("mode", "viewDetailAndEdit");
			session.setAttribute("p", duongDanTrangView);
			

			// gửi mail thông báo đã đăng ký
			String content = "<p>\r\n" + 
					"	<span style='font-size:16px;'>Xin chào "+obj.getSinhVien().getHoDem() +" " + obj.getSinhVien().getTen()+",</span></p>\r\n" + 
					"<p>\r\n" + 
					"	<span style='font-size:16px;'>Thông tin khen thưởng của bạn:</span></p>\r\n" + 
					"<ul>\r\n" + 
					"	<li>\r\n" + 
					"		<span style='font-size:16px;'>Mã thông tin khen thưởng: "+obj.getMaThongTinKhenThuong()+"</span></li>\r\n" + 
					"	<li>\r\n" + 
					"		<span style='font-size:16px;'>Sinh viên: "+obj.getSinhVien().getHoDem() +" " + obj.getSinhVien().getTen()+"</span></li>\r\n" + 
					"	<li>\r\n" + 
					"		<span style='font-size:16px;'>Nội dung khen thưởng: "+obj.getNoiDungKhenThuong()+"</span></li>\r\n" + 
					"	<li>\r\n" + 
					"		<span style='font-size:16px;'>Thời gian khen thưởng: "+Util_Date.dateToString2(obj.getThoiGianKhenThuong())+"</span></li>\r\n" + 
					"</ul>";
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
			u.sendEmails(null, null, re, "[UTC2] Thông báo kết quả khen thưởng", content);
			
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
		ThongTinKhenThuong obj = new ThongTinKhenThuong();
		obj.setMaThongTinKhenThuong(maobj);
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
		ArrayList<ThongTinKhenThuong> arr = dao.listByColumnLike(column, key);
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
		HSSFSheet sheet = workbook.createSheet("Danh sách khen thưởng");
		//
		HSSFCellStyle style = createStyleForTitle(workbook);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("DANH SÁCH KHEN THƯỞNG SINH VIÊN TỪ " + Util_Date.dateToString2(getNgayBatDau()) + " ĐẾN "
				+ Util_Date.dateToString2(getNgayKetThuc()));
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
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 2, 3));
		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Họ và tên");
		cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Lớp");
		cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Nội dung khen thưởng");
		cell.setCellStyle(style);

		cell = row.createCell(6, CellType.STRING);
		cell.setCellValue("Ghi chú");
		cell.setCellStyle(style);

		// Data
		ObjectDAO<ThongTinKhenThuong> dao_ThongTinKhenThuong = new DAO_ThongTinKhenThuong();
		ArrayList<ThongTinKhenThuong> list_ThongTinKhenThuong = dao_ThongTinKhenThuong.listByQuery(
				"FROM ThongTinKhenThuong WHERE thoiGianKhenThuong>='" + Util_Date.dateToString(getNgayBatDau())
						+ "' AND thoiGianKhenThuong<='" + Util_Date.dateToString(getNgayKetThuc()) + "'");
		System.out.println("list_ThongTinKhenThuong.size() = " + list_ThongTinKhenThuong.size());
		int stt = 0;
		for (ThongTinKhenThuong thongTinKhenThuong : list_ThongTinKhenThuong) {
			rownum++;
			stt++;
			row = sheet.createRow(rownum);

			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(stt);

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(thongTinKhenThuong.getSinhVien().getMaSinhVien());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(thongTinKhenThuong.getSinhVien().getHoDem());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(thongTinKhenThuong.getSinhVien().getTen());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(thongTinKhenThuong.getSinhVien().getLop().getMaLop());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(thongTinKhenThuong.getNoiDungKhenThuong());

			cell = row.createCell(6, CellType.STRING);
			cell.setCellValue(thongTinKhenThuong.getGhiChu());
		}
		System.out.println("rownum = " + rownum);
		PropertyTemplate pt = new PropertyTemplate();
		pt.drawBorders(new CellRangeAddress(1, 1, 0, 6), BorderStyle.THIN, BorderExtent.ALL);

		pt.drawBorders(new CellRangeAddress(1, rownum, 0, 1), BorderStyle.THIN, BorderExtent.LEFT);

		pt.drawBorders(new CellRangeAddress(1, rownum, 0, 2), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(1, rownum, 3, 7), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(rownum + 1, rownum + 1, 0, 6), BorderStyle.THIN, BorderExtent.TOP);

		pt.applyBorders(sheet);

		// auto width all column
		for (int i = 0; i < Util_Excel.getColumnsCount(sheet); i++)
			sheet.autoSizeColumn(i);

		String fileName = "DANH SACH KHEN THUONG SINH VIEN TU " + Util_Date.dateToString2(getNgayBatDau()) + " DEN "
				+ Util_Date.dateToString2(getNgayKetThuc()) + ".xls";
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

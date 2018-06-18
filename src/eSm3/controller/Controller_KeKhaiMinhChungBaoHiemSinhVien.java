package eSm3.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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
import eCore.util.Util_Excel;
import eSm3.model.DotDangKyBaoHiem;
import eSm3.model.KeKhaiMinhChungBaoHiemSinhVien;
import eSm3.modelDao.DAO_DotDangKyBaoHiem;
import eSm3.modelDao.DAO_KeKhaiMinhChungBaoHiemSinhVien;
import servlet.DownloadServlet;

public class Controller_KeKhaiMinhChungBaoHiemSinhVien extends KeKhaiMinhChungBaoHiemSinhVien
		implements ZEController, ServletRequestAware, ServletResponseAware {
	ObjectDAO dao = new DAO_KeKhaiMinhChungBaoHiemSinhVien();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eSm3/pages/kekhaiminhchungbaohiemsinhviens.jsp";
	String duongDanTrangView = "eSm3/pages/kekhaiminhchungbaohiemsinhvien.jsp";
	String tenCotTimDoiTuong = "maKeKhaiMinhChungDongBaoHiem";
	String maObj;
	String maDotDangKyBaoHiem;
	String maSinhVien;

	String s_hinhAnh;
	File myFile;
	String myFileContentType;
	String myFileFileName;
	String myFileName;
	String myFolder;

	public String getS_hinhAnh() {
		return s_hinhAnh;
	}

	public void setS_hinhAnh(String s_hinhAnh) {
		this.s_hinhAnh = s_hinhAnh;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getMyFileName() {
		return myFileName;
	}

	public void setMyFileName(String myFileName) {
		this.myFileName = myFileName;
	}

	public String getMyFolder() {
		return myFolder;
	}

	public void setMyFolder(String myFolder) {
		this.myFolder = myFolder;
	}

	public String getMaDotDangKyBaoHiem() {
		return maDotDangKyBaoHiem;
	}

	public void setMaDotDangKyBaoHiem(String maDotDangKyBaoHiem) {
		this.maDotDangKyBaoHiem = maDotDangKyBaoHiem;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
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

	public SinhVien getSinhVien() {
		ObjectDAO<SinhVien> obj_SinhVien = new DAO_SinhVien();
		ArrayList<SinhVien> ls_SinhVien = obj_SinhVien.listByColumns("maSinhVien", getMaSinhVien());
		if (ls_SinhVien.size() > 0)
			return ls_SinhVien.get(0);
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

		ArrayList<KeKhaiMinhChungBaoHiemSinhVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<KeKhaiMinhChungBaoHiemSinhVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		try {
			String s = "";
			if (myFile != null || !myFileName.equals("")) {
				myFileName = getMaSinhVien() + "-" + getDotDangKyBaoHiem().getMaDotDangKyBaoHiem()
						+ myFileFileName.substring(myFileFileName.lastIndexOf("."));
				File destFile = new File(myFolder, myFileName);
				s = destFile + "";
				FileUtils.copyFile(myFile, destFile);
				System.out.println(destFile.toString());
			} else
				s = getS_hinhAnh();

			KeKhaiMinhChungBaoHiemSinhVien obj = new KeKhaiMinhChungBaoHiemSinhVien();
			obj.maKeKhaiMinhChungDongBaoHiem = getMaKeKhaiMinhChungDongBaoHiem();
			obj.dotDangKyBaoHiem = getDotDangKyBaoHiem();
			obj.hinhAnhMinhChung = s.substring(s.lastIndexOf("\\") + 1, s.length());
			obj.sinhVien = getSinhVien();
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
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
	}

	@Override
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String maobj = request.getParameter("maobj");
		KeKhaiMinhChungBaoHiemSinhVien obj = new KeKhaiMinhChungBaoHiemSinhVien();
		obj.setMaKeKhaiMinhChungDongBaoHiem(maobj);
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
		ArrayList<KeKhaiMinhChungBaoHiemSinhVien> arr = dao.listByColumnLike(column, key);
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
		HSSFSheet sheet = workbook.createSheet("Danh sách kê khai minh chứng BHYT");
		//
		HSSFCellStyle style = createStyleForTitle(workbook);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));

		int rownum = 0;
		Cell cell;
		Row row;

		row = sheet.createRow(rownum);
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("DANH SÁCH KÊ KHAI MINH CHỨNG BẢO HIỂM Y TẾ");
		cell.setCellStyle(style);

		rownum = rownum + 1;
		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("STT");
		cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Mã kê khai");
		cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Họ đệm");
		cell.setCellStyle(style);

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Tên");
		cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Đợt đăng ký BHYT");
		cell.setCellStyle(style);

		// Data
		// bắt đầu xuất dữ liệu thông tin kê khai minh chứng đóng bảo hiểm y tế nhân
		// viên
		ObjectDAO<KeKhaiMinhChungBaoHiemSinhVien> dao_KeKhaiMinhChungBaoHiemSinhVien = new DAO_KeKhaiMinhChungBaoHiemSinhVien();
		ArrayList<KeKhaiMinhChungBaoHiemSinhVien> list_KeKhaiMinhChungBaoHiemSinhVien = new ArrayList<KeKhaiMinhChungBaoHiemSinhVien>();

		if (!getMaDotDangKyBaoHiem().isEmpty() && getMaDotDangKyBaoHiem() != null
				&& !getMaDotDangKyBaoHiem().equals("all"))
			list_KeKhaiMinhChungBaoHiemSinhVien = dao_KeKhaiMinhChungBaoHiemSinhVien.listByColumns("dotDangKyBaoHiem",
					getMaDotDangKyBaoHiem());
		else
			list_KeKhaiMinhChungBaoHiemSinhVien = dao_KeKhaiMinhChungBaoHiemSinhVien.listAll();

		int stt = 0;
		for (KeKhaiMinhChungBaoHiemSinhVien keKhaiMinhChungBaoHiemSinhVien : list_KeKhaiMinhChungBaoHiemSinhVien) {
			rownum++;
			stt++;
			row = sheet.createRow(rownum);

			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(stt);

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(keKhaiMinhChungBaoHiemSinhVien.getMaKeKhaiMinhChungDongBaoHiem());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(keKhaiMinhChungBaoHiemSinhVien.getSinhVien().getHoDem());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(keKhaiMinhChungBaoHiemSinhVien.getSinhVien().getTen());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(keKhaiMinhChungBaoHiemSinhVien.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem());

		}
		// kết thúc xuất dữ liệu thông tin kê khai minh chứng đóng bảo hiểm y tế nhân
		// viên

		PropertyTemplate pt = new PropertyTemplate();
		pt.drawBorders(new CellRangeAddress(1, 1, 0, 4), BorderStyle.THIN, BorderExtent.ALL);

		pt.drawBorders(new CellRangeAddress(1, rownum, 0, 5), BorderStyle.THIN, BorderExtent.LEFT);

		pt.drawBorders(new CellRangeAddress(1, rownum, 0, 5), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(rownum + 1, rownum + 1, 0, 4), BorderStyle.THIN, BorderExtent.TOP);

		pt.applyBorders(sheet);

		// auto width all column
		for (int i = 0; i < Util_Excel.getColumnsCount(sheet); i++)
			sheet.autoSizeColumn(i);

		String fileName = "Danh sach ke khai minh chung BHYT sinh vien.xls";
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

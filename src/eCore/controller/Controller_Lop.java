package eCore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import eCore.dao.ObjectDAO;
import eCore.model.DonVi;
import eCore.model.Lop;
import eCore.modelDao.DAO_DonVi;
import eCore.modelDao.DAO_Lop;
import eCore.util.Util_Date;
import eCore.util.Util_Excel;
import eSm4.model.ThongTinNgoaiTru;
import eSm4.modelDao.DAO_ThongTinNgoaiTru;
import servlet.DownloadServlet;

public class Controller_Lop extends Lop implements ZEController, ServletRequestAware, ServletResponseAware {
	ObjectDAO dao = new DAO_Lop();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eCore/pages/lops.jsp";
	String duongDanTrangView = "eCore/pages/lop.jsp";
	String tenCotTimDoiTuong = "maLop";
	String maObj;
	String maDonVi;
	String s_maDVQL;
	String s_khoa;
	
	File excel_myFile;
	String excel_myFileContentType;
	String excel_myFileFileName;
	String excel_myFileName;
	String myFolder_eCore;

	String tenLop;

	public File getExcel_myFile() {
		return excel_myFile;
	}

	public void setExcel_myFile(File excel_myFile) {
		this.excel_myFile = excel_myFile;
	}

	public String getExcel_myFileContentType() {
		return excel_myFileContentType;
	}

	public void setExcel_myFileContentType(String excel_myFileContentType) {
		this.excel_myFileContentType = excel_myFileContentType;
	}

	public String getExcel_myFileFileName() {
		return excel_myFileFileName;
	}

	public void setExcel_myFileFileName(String excel_myFileFileName) {
		this.excel_myFileFileName = excel_myFileFileName;
	}

	public String getExcel_myFileName() {
		return excel_myFileName;
	}

	public void setExcel_myFileName(String excel_myFileName) {
		this.excel_myFileName = excel_myFileName;
	}

	public String getMyFolder_eCore() {
		return myFolder_eCore;
	}

	public void setMyFolder_eCore(String myFolder_eCore) {
		this.myFolder_eCore = myFolder_eCore;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getS_khoa() {
		return s_khoa;
	}

	public void setS_khoa(String s_khoa) {
		this.s_khoa = s_khoa;
	}

	public String getS_maDVQL() {
		return s_maDVQL;
	}

	public void setS_maDVQL(String s_maDVQL) {
		this.s_maDVQL = s_maDVQL;
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

	public String getMaObj() {
		return maObj;
	}

	public void setMaObj(String maObj) {
		this.maObj = maObj;
	}

	public String getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}

	public DonVi getDonVi() {
		ObjectDAO objdao = new DAO_DonVi();
		ArrayList<DonVi> list = objdao.listByColumns("maDonVi", getMaDonVi());
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
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

		ArrayList<Lop> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<Lop> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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

		Lop obj = new Lop();
		obj.maLop = getMaLop();
		obj.tenLop = getTenLop();
		obj.khoa = getKhoa();
		obj.nienKhoa = getNienKhoa();
		obj.moTa = getMoTa();
		obj.ghiChu = getGhiChu();
		obj.donVi = getDonVi();
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
		Lop obj = new Lop();
		obj.setMaLop(maobj);
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
		ArrayList<Lop> arr = dao.listByColumnLike(column, key);
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
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		try {
			String s = "";
			if (!excel_myFileName.equals("")) {
				if (excel_myFile != null) {
					excel_myFileName = getTenLop() + excel_myFileFileName.substring(excel_myFileFileName.lastIndexOf("."));
					System.out.println("123 "+excel_myFileName);
					File destFile = new File(myFolder_eCore, excel_myFileName);
					s = destFile.toString();
					FileUtils.copyFile(excel_myFile, destFile);
					System.out.println(destFile.toString());

				}
				FileInputStream inputStream = new FileInputStream(new File(s));
				// Ä�á»‘i tÆ°á»£ng workbook cho file XSL.
				HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
				// Láº¥y ra sheet Ä‘áº§u tiÃªn tá»« workbook
				HSSFSheet sheet = workbook.getSheetAt(0);
				DAO_Lop objDAO = new DAO_Lop();
				Lop obj = new Lop();

				String msg = "";
				String kq = "";

				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					Row r = sheet.getRow(i);

					Cell cell_maLop = r.getCell(0);
					String maLop = cell_maLop.toString();
					
					Cell cell_ghiChu = r.getCell(1);
					String ghiChu = "";
					if (cell_ghiChu != null)
						ghiChu = cell_ghiChu.toString();

					Cell cell_khoa = r.getCell(2);
					String khoa = "";
					if (cell_khoa != null)
						khoa = cell_khoa.toString();

					Cell cell_moTa = r.getCell(3);
					String moTa = "";
					if (cell_moTa != null)
						moTa = cell_moTa.toString();

					Cell cell_nienKhoa = r.getCell(4);
					String nienKhoa = "";
					if (cell_nienKhoa != null)
						nienKhoa = cell_nienKhoa.toString();

					Cell cell_tenLop = r.getCell(5);
					String tenLop = "";
					if (cell_tenLop != null)
						tenLop = cell_tenLop.toString();

					Cell cell_maDonViCha = r.getCell(8);
					String maDonViCha = "";
					if (cell_maDonViCha != null)
						maDonViCha = cell_maDonViCha.toString();
					ObjectDAO<DonVi> dao_donViCha = new DAO_DonVi();
					ArrayList<DonVi> list_dv = dao_donViCha.listByColumns("maDonVi", maDonViCha);
					DonVi donViCha = new DonVi();
					if (list_dv.size() > 0)
						donViCha = list_dv.get(0);
					else
						donViCha = null;

					obj.setMaLop(maLop);
					obj.setKhoa(nienKhoa);
					obj.setNienKhoa(nienKhoa);
					obj.setGhiChu(ghiChu);
					obj.setMoTa(moTa);
					obj.setTenLop(tenLop);
					obj.setDonVi(donViCha);

					if (objDAO.saveOrUpdate(obj)) {
						kq += "";
					} else {
						kq += "fail ";
					}
				}
				if (kq.equals(""))
					return "SUCCESS";
				else
					return "FAIL";
			} else
				System.out.println("ssssssssssssss");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "ssssdsadasdasdas");
		}
		return "SUCCESS";
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
		HSSFSheet sheet = workbook.createSheet("Danh sách lớp");
		//
		HSSFCellStyle style = createStyleForTitle(workbook);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));

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
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 5));
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("PHÂN HIỆU TẠI TP. HỒ CHÍ  MINH");
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellStyle(style);

		rownum = rownum + 2;
		row = sheet.createRow(rownum);
		// merged cell
		sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, 0, 5));
		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("DANH SÁCH LỚP");
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellStyle(style);

		rownum = rownum + 1;
		row = sheet.createRow(rownum);

		cell = row.createCell(0, CellType.STRING);
		cell.setCellValue("STT");
		cell.setCellStyle(style);

		cell = row.createCell(1, CellType.STRING);
		cell.setCellValue("Mã lớp");
		cell.setCellStyle(style);

		cell = row.createCell(2, CellType.STRING);
		cell.setCellValue("Tên lớp");
		cell.setCellStyle(style);

		cell = row.createCell(3, CellType.STRING);
		cell.setCellValue("Khóa");
		cell.setCellStyle(style);

		cell = row.createCell(4, CellType.STRING);
		cell.setCellValue("Thời gian đào tạo");
		cell.setCellStyle(style);

		cell = row.createCell(5, CellType.STRING);
		cell.setCellValue("Đơn vị quản lý");
		cell.setCellStyle(style);

		// Data
		ObjectDAO<Lop> dao_Lop = new DAO_Lop();
		ArrayList<Lop> list_Lop = new ArrayList<Lop>();
		ArrayList<Lop> list_Remove = new ArrayList<Lop>();
		String maDonViQuanLy = getS_maDVQL();
		String khoa = getS_khoa();
		int flag = 0;
		if (!(khoa.isEmpty() || khoa == null || khoa.equals("all"))) {
			flag = 1;
		}

		if (maDonViQuanLy.isEmpty() || maDonViQuanLy == null || maDonViQuanLy.equals("all")) {
			System.out.println("case all or empty");
			list_Lop = dao_Lop.listAll();
			if (flag == 1) {
				for (Lop s : list_Lop) {
					if (!(s.getKhoa().equals(khoa))) {
						list_Remove.add(s);
						System.out.println("remove" + s.getTenLop());
					}
				}
			}
		} else {
			System.out.println("have data");
			list_Lop = dao_Lop.listByColumns("donVi", maDonViQuanLy);
			if (flag == 1) {
				for (Lop s : list_Lop) {
					if (!(s.getKhoa().equals(khoa))) {
						list_Remove.add(s);
						System.out.println("remove" + s.getTenLop());
					}
				}
			}
		}
		list_Lop.removeAll(list_Remove);

		int stt = 0;
		for (Lop lop : list_Lop) {
			rownum++;
			stt++;
			row = sheet.createRow(rownum);

			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue(stt);

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue(lop.getMaLop());

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue(lop.getTenLop());

			cell = row.createCell(3, CellType.STRING);
			cell.setCellValue(lop.getKhoa());

			cell = row.createCell(4, CellType.STRING);
			cell.setCellValue(lop.getNienKhoa());

			cell = row.createCell(5, CellType.STRING);
			cell.setCellValue(lop.getDonVi().getTenDonVi());

		}
		System.out.println("rownum = " + rownum);
		PropertyTemplate pt = new PropertyTemplate();
		pt.drawBorders(new CellRangeAddress(4, 4, 0, 5), BorderStyle.THIN, BorderExtent.ALL);

		pt.drawBorders(new CellRangeAddress(4, rownum, 0, 1), BorderStyle.THIN, BorderExtent.LEFT);

		pt.drawBorders(new CellRangeAddress(4, rownum, 0, 6), BorderStyle.THIN, BorderExtent.INSIDE_VERTICAL);

		pt.drawBorders(new CellRangeAddress(rownum + 1, rownum + 1, 0, 5), BorderStyle.THIN, BorderExtent.TOP);

		pt.applyBorders(sheet);

		// auto width all column
		for (int i = 0; i < Util_Excel.getColumnsCount(sheet); i++)
			sheet.autoSizeColumn(i);

		String fileName = "Danh sach lop.xls";
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

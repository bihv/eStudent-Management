package eCore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import eCore.dao.ObjectDAO;
import eCore.model.DonVi;
import eCore.model.Lop;
import eCore.modelDao.DAO_DonVi;
import eCore.modelDao.DAO_Lop;

public class Controller_DonVi extends DonVi implements ZEController {
	ObjectDAO dao = new DAO_DonVi();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eCore/pages/donvis.jsp";
	String duongDanTrangView = "eCore/pages/donvi.jsp";
	String tenCotTimDoiTuong = "maDonVi";
	String maObj;
	String maDonViCha;

	File myFile;
	String myFileContentType;
	String myFileFileName;
	String myFileName;
	String myFolder_eCore;

	String tenLop;

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
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

	public String getMyFolder_eCore() {
		return myFolder_eCore;
	}

	public void setMyFolder_eCore(String myFolder_eCore) {
		this.myFolder_eCore = myFolder_eCore;
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

	public String getMaDonViCha() {
		return maDonViCha;
	}

	public void setMaDonViCha(String maDonViCha) {
		this.maDonViCha = maDonViCha;
	}

	public DonVi getDonViCha() {
		ArrayList<DonVi> list = dao.listByColumns("maDonVi", getMaDonViCha());
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

		ArrayList<DonVi> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<DonVi> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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

		DonVi obj = new DonVi();
		obj.maDonVi = getMaDonVi();
		obj.tenDonVi = getTenDonVi();
		obj.email = getEmail();
		obj.soDienThoai = getSoDienThoai();
		obj.diaChiLienHe = getDiaChiLienHe();
		obj.moTa = getMoTa();
		obj.ghiChu = getGhiChu();
		obj.donViCha = getDonViCha();
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
		DonVi obj = new DonVi();
		obj.setMaDonVi(maobj);
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
		ArrayList<DonVi> arr = dao.listByColumnLike(column, key);
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
			if (!myFileName.equals("")) {
				if (myFile != null) {
					myFileName = getTenLop() + myFileFileName.substring(myFileFileName.lastIndexOf("."));
					File destFile = new File(myFolder_eCore, myFileName);
					s = destFile.toString();
					FileUtils.copyFile(myFile, destFile);
					System.out.println(destFile.toString());

				}
				FileInputStream inputStream = new FileInputStream(new File(s));
				// Ä�á»‘i tÆ°á»£ng workbook cho file XSL.
				HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
				// Láº¥y ra sheet Ä‘áº§u tiÃªn tá»« workbook
				HSSFSheet sheet = workbook.getSheetAt(0);
				DAO_DonVi objDAO = new DAO_DonVi();
				DonVi donvi = new DonVi();

				String msg = "";
				String kq = "";

				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					Row r = sheet.getRow(i);

					Cell cell_maDonVi = r.getCell(0);
					String maDonVi = cell_maDonVi.toString();
					Cell cell_diaChiLienHe = r.getCell(1);
					String diaChiLienHe = "";
					if (cell_diaChiLienHe != null)
						diaChiLienHe = cell_diaChiLienHe.toString();

					Cell cell_email = r.getCell(2);
					String email = "";
					if (cell_email != null)
						email = cell_email.toString();

					Cell cell_ghiChu = r.getCell(3);
					String ghiChu = "";
					if (cell_ghiChu != null)
						ghiChu = cell_ghiChu.toString();

					Cell cell_moTa = r.getCell(4);
					String moTa = "";
					if (cell_moTa != null)
						moTa = cell_moTa.toString();

					Cell cell_soDienThoai = r.getCell(5);
					String soDienThoai = "";
					if (cell_soDienThoai != null)
						soDienThoai = cell_soDienThoai.toString();

					Cell cell_tenDonVi = r.getCell(6);
					String tenDonVi = cell_tenDonVi.toString();

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

					donvi.setMaDonVi(maDonVi);
					donvi.setDiaChiLienHe(diaChiLienHe);
					donvi.setEmail(email);
					donvi.setGhiChu(ghiChu);
					donvi.setMoTa(moTa);
					donvi.setSoDienThoai(soDienThoai);
					donvi.setTenDonVi(tenDonVi);
					donvi.setDonViCha(donViCha);

					if (objDAO.saveOrUpdate(donvi)) {
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

	@Override
	public String exportData() {
		// TODO Auto-generated method stub
		return null;
	}

}

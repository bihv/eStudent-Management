package eSm3.controller;

import java.io.File;
import java.io.FileInputStream;
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

import eCore.controller.ZEController;
import eCore.dao.ObjectDAO;
import eCore.model.DonVi;
import eCore.modelDao.DAO_DonVi;
import eCore.util.Util_Date;
import eSm3.model.CoSoKhamChuaBenh;
import eSm3.modelDao.DAO_CoSoKhamChuaBenh;

public class Controller_CoSoKhamChuaBenh extends CoSoKhamChuaBenh implements ZEController {
	ObjectDAO dao = new DAO_CoSoKhamChuaBenh();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eSm3/pages/cosokhamchuabenhs.jsp";
	String duongDanTrangView = "eSm3/pages/cosokhamchuabenh.jsp";
	String tenCotTimDoiTuong = "maCoSoKhamChuaBenh";
	String maObj;
	String s_thoiGianCapNhat;

	File myFile;
	String myFileContentType;
	String myFileFileName;
	String myFileName;
	String myFolder_eSm3;

	String tenLop;

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

	public String getMyFolder_eSm3() {
		return myFolder_eSm3;
	}

	public void setMyFolder_eSm3(String myFolder_eSm3) {
		this.myFolder_eSm3 = myFolder_eSm3;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
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

		ArrayList<CoSoKhamChuaBenh> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<CoSoKhamChuaBenh> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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

		CoSoKhamChuaBenh obj = new CoSoKhamChuaBenh();
		obj.maCoSoKhamChuaBenh = getMaCoSoKhamChuaBenh();
		obj.tenCoSoKhamChuaBenh = getTenCoSoKhamChuaBenh();
		obj.diaChi = getDiaChi();
		obj.thongTinDangKyKhamChuaBenhBanDau = getThongTinDangKyKhamChuaBenhBanDau();
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
		CoSoKhamChuaBenh obj = new CoSoKhamChuaBenh();
		obj.setMaCoSoKhamChuaBenh(maobj);
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
		ArrayList<CoSoKhamChuaBenh> arr = dao.listByColumnLike(column, key);
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
					File destFile = new File(myFolder_eSm3, myFileName);
					s = destFile.toString();
					FileUtils.copyFile(myFile, destFile);
					System.out.println(destFile.toString());

				}
				FileInputStream inputStream = new FileInputStream(new File(s));
				// Ä�á»‘i tÆ°á»£ng workbook cho file XSL.
				HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
				// Láº¥y ra sheet Ä‘áº§u tiÃªn tá»« workbook
				HSSFSheet sheet = workbook.getSheetAt(0);
				DAO_CoSoKhamChuaBenh objDAO = new DAO_CoSoKhamChuaBenh();
				CoSoKhamChuaBenh coSoKhamChuaBenh = new CoSoKhamChuaBenh();

				String msg = "";
				String kq = "";

				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					Row r = sheet.getRow(i);

					Cell cell_maCoSoKhamChuaBenh = r.getCell(0);
					String maCoSoKhamChuaBenh = "";
					if (cell_maCoSoKhamChuaBenh != null)
						maCoSoKhamChuaBenh = cell_maCoSoKhamChuaBenh.toString();

					Cell cell_diaChi = r.getCell(1);
					String diaChi = "";
					if (cell_diaChi != null)
						diaChi = cell_diaChi.toString();

					Cell cell_ghiChu = r.getCell(2);
					String ghiChu = "";
					if (cell_ghiChu != null)
						ghiChu = cell_ghiChu.toString();

					Cell cell_moTa = r.getCell(3);
					String moTa = "";
					if (cell_moTa != null)
						moTa = cell_moTa.toString();

					Cell cell_tenCoSoKhamChuaBenh = r.getCell(4);
					String tenCoSoKhamChuaBenh = "";
					if (cell_tenCoSoKhamChuaBenh != null)
						tenCoSoKhamChuaBenh = cell_tenCoSoKhamChuaBenh.toString();

					Cell cell_thongTinDangKyKhamChuaBenhBanDau = r.getCell(6);
					String thongTinDangKyKhamChuaBenhBanDau = "";
					if (cell_thongTinDangKyKhamChuaBenhBanDau != null)
						thongTinDangKyKhamChuaBenhBanDau = cell_thongTinDangKyKhamChuaBenhBanDau.toString();

					coSoKhamChuaBenh.setMaCoSoKhamChuaBenh(maCoSoKhamChuaBenh);
					coSoKhamChuaBenh.setDiaChi(diaChi);
					coSoKhamChuaBenh.setGhiChu(ghiChu);
					coSoKhamChuaBenh.setMoTa(moTa);
					coSoKhamChuaBenh.setTenCoSoKhamChuaBenh(tenCoSoKhamChuaBenh);
					coSoKhamChuaBenh.setThongTinDangKyKhamChuaBenhBanDau(thongTinDangKyKhamChuaBenhBanDau);

					if (objDAO.saveOrUpdate(coSoKhamChuaBenh)) {
						kq += "";
					} else {
						kq += "fail ";
					}
				}
				if (kq.equals(""))
					return "SUCCESS";
				else
					return "FAIL";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "SUCCESS";
	}

	public String deleteAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ObjectDAO<CoSoKhamChuaBenh> dao_CoSoKhamChuaBenh = new DAO_CoSoKhamChuaBenh();
		ArrayList<CoSoKhamChuaBenh> list_CoSoKhamChuaBenh = dao_CoSoKhamChuaBenh.listAll();
		String kq = "";
		for (CoSoKhamChuaBenh coSoKhamChuaBenh : list_CoSoKhamChuaBenh)
			if (dao_CoSoKhamChuaBenh.delete(coSoKhamChuaBenh))
				kq += "";
			else
				kq += " fail";
		if (kq.isEmpty()) {
			session.setAttribute("msg", "Xóa dữ liệu thành công");
			return "SUCCESS";
		}
		else {
			session.setAttribute("msg", "Xóa dữ liệu không thành công");
			return "FAIL";
		}
	}

	@Override
	public String exportData() {
		// TODO Auto-generated method stub
		return null;
	}

}

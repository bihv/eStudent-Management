package eCore.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import eCore.dao.ObjectDAO;
import eCore.model.DonVi;
import eCore.model.NhanVien;
import eCore.modelDao.DAO_DonVi;
import eCore.modelDao.DAO_NhanVien;
import eCore.util.Util_Date;

public class Controller_NhanVien extends NhanVien implements ZEController {
	ObjectDAO dao = new DAO_NhanVien();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eCore/pages/nhanviens.jsp";
	String duongDanTrangView = "eCore/pages/nhanvien.jsp";
	String tenCotTimDoiTuong = "maNhanVien";
	String maObj;
	String s_ngaySinh;
	String s_ngayTuyenDung;
	String s_ngayHuong;
	String s_ngayVaoDangDuBi;
	String s_ngayVaoDangChinhThuc;
	String s_ngayNhapNgu;
	String s_ngayXuatNgu;
	String s_ngayCapCMND;
	String s_ngayCapHoChieu;
	String s_hinhAnh;
	String maDonVi;

	File myFile;
	String myFileContentType;
	String myFileFileName;
	String myFileName;
	String myFolder;

	public String getS_ngaySinh() {
		return s_ngaySinh;
	}

	public void setS_ngaySinh(String s_ngaySinh) {
		this.s_ngaySinh = s_ngaySinh;
	}

	public Date getNgaySinh() {
		return Util_Date.stringToDate(getS_ngaySinh());
	}

	public String getS_ngayTuyenDung() {
		return s_ngayTuyenDung;
	}

	public void setS_ngayTuyenDung(String s_ngayTuyenDung) {
		this.s_ngayTuyenDung = s_ngayTuyenDung;
	}

	public Date getNgayTuyenDung() {
		return Util_Date.stringToDate(getS_ngayTuyenDung());
	}

	public String getS_ngayHuong() {
		return s_ngayHuong;
	}

	public void setS_ngayHuong(String s_ngayHuong) {
		this.s_ngayHuong = s_ngayHuong;
	}

	public Date getNgayHuong() {
		return Util_Date.stringToDate(getS_ngayHuong());
	}

	public String getS_ngayVaoDangDuBi() {
		return s_ngayVaoDangDuBi;
	}

	public void setS_ngayVaoDangDuBi(String s_ngayVaoDangDuBi) {
		this.s_ngayVaoDangDuBi = s_ngayVaoDangDuBi;
	}

	public Date getNgayVaoDangDuBi() {
		return Util_Date.stringToDate(getS_ngayVaoDangDuBi());
	}

	public String getS_ngayVaoDangChinhThuc() {
		return s_ngayVaoDangChinhThuc;
	}

	public void setS_ngayVaoDangChinhThuc(String s_ngayVaoDangChinhThuc) {
		this.s_ngayVaoDangChinhThuc = s_ngayVaoDangChinhThuc;
	}

	public Date getNgayVaoDangChinhThuc() {
		return Util_Date.stringToDate(getS_ngayVaoDangChinhThuc());
	}

	public String getS_ngayNhapNgu() {
		return s_ngayNhapNgu;
	}

	public void setS_ngayNhapNgu(String s_ngayNhapNgu) {
		this.s_ngayNhapNgu = s_ngayNhapNgu;
	}

	public Date getNgayNhapNgu() {
		return Util_Date.stringToDate(getS_ngayNhapNgu());
	}

	public String getS_ngayXuatNgu() {
		return s_ngayXuatNgu;
	}

	public void setS_ngayXuatNgu(String s_ngayXuatNgu) {
		this.s_ngayXuatNgu = s_ngayXuatNgu;
	}

	public Date getNgayXuatNgu() {
		return Util_Date.stringToDate(getS_ngayXuatNgu());
	}

	public String getS_ngayCapCMND() {
		return s_ngayCapCMND;
	}

	public void setS_ngayCapCMND(String s_ngayCapCMND) {
		this.s_ngayCapCMND = s_ngayCapCMND;
	}

	public Date getNgayCapCMND() {
		return Util_Date.stringToDate(getS_ngayCapCMND());
	}

	public String getS_ngayCapHoChieu() {
		return s_ngayCapHoChieu;
	}

	public void setS_ngayCapHoChieu(String s_ngayCapHoChieu) {
		this.s_ngayCapHoChieu = s_ngayCapHoChieu;
	}

	public Date getNgayCapHoChieu() {
		return Util_Date.stringToDate(getS_ngayCapHoChieu());
	}

	public String getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public DonVi getDonVi() {
		ObjectDAO dao_donVi = new DAO_DonVi();
		ArrayList<DonVi> list_donVi = dao_donVi.listByColumns("maDonVi", getMaDonVi());
		if (list_donVi.size() > 0)
			return list_donVi.get(0);
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

	public String getMaObj() {
		return maObj;
	}

	public void setMaObj(String maObj) {
		this.maObj = maObj;
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

	public String getS_hinhAnh() {
		return s_hinhAnh;
	}

	public void setS_hinhAnh(String s_hinhAnh) {
		this.s_hinhAnh = s_hinhAnh;
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

		ArrayList<NhanVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
		ArrayList<NhanVien> arr = dao.listByColumnLike(tenCotTimDoiTuong, maobj);
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
			String s ="";
			if (!myFileName.equals("")) {
				if (myFile != null) {
					myFileName = getMaNhanVien() + myFileFileName.substring(myFileFileName.lastIndexOf("."));
					File destFile = new File(myFolder, myFileName);
					s = destFile + "";
					FileUtils.copyFile(myFile, destFile);
					System.out.println(destFile.toString());
				} else {
					s = getS_hinhAnh();
				}
			} else
				s = getS_hinhAnh();
			NhanVien obj = new NhanVien();
			obj.maNhanVien = getMaNhanVien();
			obj.tenNhanVien = getTenNhanVien();
			obj.hinhAnh = s.substring(s.lastIndexOf("\\")+1, s.length());
			obj.ngaySinh = getNgaySinh();
			obj.gioiTinh = getGioiTinh();
			obj.noiSinh = getNoiSinh();
			obj.queQuan = getQueQuan();
			obj.danToc = getDanToc();
			obj.tonGiao = getTonGiao();
			obj.hoKhauThuongTru = getHoKhauThuongTru();
			obj.noiOHienTai = getNoiOHienTai();
			obj.ngheNghiepTruocKhiTuyenDung = getNgheNghiepTruocKhiTuyenDung();
			obj.ngayTuyenDung = getNgayTuyenDung();
			obj.chucVu = getChucVu();
			obj.congViecChinhDuocGiao = getCongViecChinhDuocGiao();
			obj.ngachCongChuc = getNgachCongChuc();
			obj.maNgach = getMaNgach();
			obj.bacLuong = getBacLuong();
			obj.heSo = getHeSo();
			obj.ngayHuong = getNgayHuong();
			obj.trinhDoGiaoDucPhoThong = getTrinhDoGiaoDucPhoThong();
			obj.trinhDoChuyenMonCaoNhat = getTrinhDoChuyenMonCaoNhat();
			obj.lyLuanChinhTri = getLyLuanChinhTri();
			obj.quanLyNhaNuoc = getQuanLyNhaNuoc();
			obj.ngoaiNgu = getNgoaiNgu();
			obj.tinHoc = getTinHoc();
			obj.ngayVaoDangDuBi = getNgayVaoDangDuBi();
			obj.ngayVaoDangChinhThuc = getNgayVaoDangChinhThuc();
			obj.thamGiaToChucChinhTriXaHoi = getThamGiaToChucChinhTriXaHoi();
			obj.ngayNhapNgu = getNgayNhapNgu();
			obj.ngayXuatNgu = getNgayXuatNgu();
			obj.quanHamCaoNhat = getQuanHamCaoNhat();
			obj.danhHieuDuocPhongTangCaoNhat = getDanhHieuDuocPhongTangCaoNhat();
			obj.soTruongCongTac = getSoTruongCongTac();
			obj.khenThuong = getKhenThuong();
			obj.kyLuat = getKyLuat();
			obj.tinhTrangSucKhoe = getTinhTrangSucKhoe();
			obj.laConThuongBinh = getLaConThuongBinh();
			obj.laConGiaDinhChinhSach = getLaConGiaDinhChinhSach();
			obj.soCMND = getSoCMND();
			obj.ngayCapCMND = getNgayCapCMND();
			obj.noiCapCMND = getNoiCapCMND();
			obj.soHoChieu = getSoHoChieu();
			obj.ngayCapHoChieu = getNgayCapHoChieu();
			obj.noiCapHoChieu = getNoiCapHoChieu();
			obj.soSoBaoHiemXaHoi = getSoSoBaoHiemXaHoi();
			obj.quaTrinhDaoTao = getQuaTrinhDaoTao();
			obj.quaTrinhCongTac = getQuaTrinhCongTac();
			obj.dacDiemLichSuBanThan = getDacDiemLichSuBanThan();
			obj.quanHeVoiGiaDinh = getQuanHeVoiGiaDinh();
			obj.hoanCanhKinhTeGiaDinh = getHoanCanhKinhTeGiaDinh();
			obj.nhanXetDanhGiaCuaCoQuan = getNhanXetDanhGiaCuaCoQuan();
			obj.email = getEmail();
			obj.soDienThoaiDiDong = getSoDienThoaiDiDong();
			obj.soDienThoaiCoQuan = getSoDienThoaiCoQuan();
			obj.diaChiLienHe = getDiaChiLienHe();
			obj.diaChiBaoTin = getDiaChiBaoTin();
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
		NhanVien obj = (NhanVien) dao.listByColumns("maNhanVien", maobj).get(0);
//		obj.setMaNhanVien(maobj);
		if(obj.getHinhAnh()!=null) {
			myFileName = request.getRealPath("eCore/images/nhanviens")+"/"+obj.getHinhAnh();
			System.out.println(myFileName);
			File destFile = new File(myFolder, myFileName);
			if(destFile.exists()) {
				destFile.delete();
			}
		}
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
		ArrayList<NhanVien> arr = dao.listByColumnLike(column, key);
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

	@Override
	public String exportData() {
		// TODO Auto-generated method stub
		return null;
	}

}

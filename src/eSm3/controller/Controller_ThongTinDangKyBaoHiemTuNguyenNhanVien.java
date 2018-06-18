package eSm3.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import eCore.controller.ZEController;
import eCore.dao.ObjectDAO;
import eCore.model.NhanVien;
import eCore.modelDao.DAO_NhanVien;
import eCore.util.Util_Date;
import eCore.util.Util_Mail;
import eSm3.model.DotDangKyBaoHiem;
import eSm3.model.ThongTinDangKyBaoHiemTuNguyenNhanVien;
import eSm3.modelDao.DAO_DotDangKyBaoHiem;
import eSm3.modelDao.DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien;

public class Controller_ThongTinDangKyBaoHiemTuNguyenNhanVien extends ThongTinDangKyBaoHiemTuNguyenNhanVien
		implements ZEController {
	ObjectDAO dao = new DAO_ThongTinDangKyBaoHiemTuNguyenNhanVien();

	String timKiemTheo;
	String tuKhoa;
	String duongDanTrang = "eSm3/pages/thongtindangkybaohiemtunguyennhanviens.jsp";
	String duongDanTrangView = "eSm3/pages/thongtindangkybaohiemtunguyennhanvien.jsp";
	String tenCotTimDoiTuong = "maThongTinDangKyBaoHiemTuNguyen";
	String maObj;
	String maDotDangKyBaoHiem;
	String maNhanVien;

	String s_thoiGianDangKy;

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
				
				// gửi mail thông báo đã đăng ký
				String content =  "<p>\r\n" + 
					"	<span class='im' style='font-family: arial, sans-serif; font-size: 12.8px;'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Xin ch&agrave;o&nbsp;<span style='color:#ff0000;'>"+obj.getNhanVien().getTenNhanVien()+"</span>,</span></span></span></p>\r\n" + 
					"<p>\r\n" + 
					"	<span class='im' style='font-family: arial, sans-serif; font-size: 12.8px;'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Ch&uacute;c mừng bạn đ&atilde; đăng k&yacute; th&agrave;nh c&ocirc;ng bảo hiểm tự nguyện trong đợt đăng k&yacute;&nbsp;<span style='color:#ff0000;'>&quot;"+obj.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem()+"&quot;</span>.</span></span></span></p>\r\n" + 
					"<p>\r\n" + 
					"	<span class='im' style='font-family: arial, sans-serif; font-size: 12.8px;'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Th&ocirc;ng tin bảo hiểm tự nguyện đ&atilde; đăng k&yacute;:</span></span></span></p>\r\n" + 
					"<ul style='font-family: arial, sans-serif; font-size: 12.8px;'>\r\n" + 
					"	<li style='margin-left: 15px;'>\r\n" + 
					"		<span class='im'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>T&ecirc;n nh&acirc;n vi&ecirc;n:&nbsp;&quot;"+obj.getNhanVien().getTenNhanVien()+"&quot;</span></span></span></li>\r\n" + 
					"	<li style='margin-left: 15px;'>\r\n" + 
					"		<span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Thời gian đăng k&yacute;:&nbsp;&quot;"+Util_Date.dateToString2(obj.getThoiGianDangKy())+"&quot;</span></span></li>\r\n" + 
					"	<li style='margin-left: 15px;'>\r\n" + 
					"		<span class='im'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Đợt đăng k&yacute;:&nbsp;&quot;"+obj.getDotDangKyBaoHiem().getTenDotDangKyBaoHiem()+"&quot;</span></span></span></li>\r\n" + 
					"	<li style='margin-left: 15px;'>\r\n" + 
					"		<span class='im'><span style='font-size: 14px;'><span style='font-family: arial, helvetica, sans-serif;'>Trạng th&aacute;i:&nbsp;&quot;"+obj.getTrangThai()+"&quot;</span></span></span></li>\r\n" + 
					"</ul>\r\n" + 
					"";
				Util_Mail u = new Util_Mail("smtp.gmail.com", "587", "true", "true", "hovanbi2018", "giaothongvantai");

				// lấy email tài khoản đã đăng ký.
				String re = obj.getNhanVien().getEmail();
				
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

	@Override
	public String exportData() {
		// TODO Auto-generated method stub
		return null;
	}

}

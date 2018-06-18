<%@page import="eCore.model.TaiKhoanSinhVien"%>
<%@page import="eCore.modelDao.DAO_SinhVien"%>
<%@page import="eCore.model.SinhVien"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="eCore.modelDao.DAO_ChucNang"%>
<%@page import="eCore.model.ChucNang"%>
<%@page import="eCore.modelDao.DAO_NhomPhanQuyen"%>
<%@page import="eCore.model.NhomPhanQuyen"%>
<%@page import="eCore.util.Util_MD5"%>
<%@page import="eCore.modelDao.DAO_TaiKhoan"%>
<%@page import="eCore.model.TaiKhoanNhanVien"%>
<%@page import="eCore.model.TaiKhoan"%>
<%@page import="eCore.modelDao.DAO_NhanVien"%>
<%@page import="eCore.modelDao.DAO_DonVi"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@page import="eCore.model.DonVi"%>
<%@page import="eCore.model.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 		DonVi dv = new DonVi();
		// 		dv.setMaDonVi("DV01");
		// 		dv.setTenDonVi("Bo mon CNTT");
		// 		dv.setDonViCha(null);
		// 		ObjectDAO dao1 = new DAO_DonVi();
		// 		dao1.saveOrUpdate(dv);

		// 		NhanVien admin = new NhanVien();
		// 		admin.setMaNhanVien("001");
		// 		admin.setTenNhanVien("Lê Nhật Tùng");
		// 		admin.setEmail("tungit07@gmail.com");
		// 		admin.setDonVi(dv);
		// 		ObjectDAO dao2 = new DAO_NhanVien();
		// 		dao2.saveOrUpdate(admin);

		// 		NhanVien giangVien = new NhanVien();
		// 		giangVien.setMaNhanVien("002");
		// 		giangVien.setTenNhanVien("Nguyễn Xuân Thiện");
		// 		giangVien.setEmail("xuanthien@gmail.com");
		// 		giangVien.setDonVi(dv);
		// 		dao2.saveOrUpdate(giangVien);

		// 		SinhVien sinhVien = new SinhVien();
		// 		sinhVien.setMaSinhVien("5551074004");
		// 		sinhVien.setHoDem("Hồ Văn");
		// 		sinhVien.setTen("Bi");
		// 		sinhVien.setEmail("hobi2908@gmail.com");
		// 		ObjectDAO dao_sinhVien = new DAO_SinhVien();
		// 		dao_sinhVien.saveOrUpdate(sinhVien);

		ObjectDAO daochucnang = new DAO_ChucNang();

		ChucNang CN_QuanLyThongTinCoBan = new ChucNang();
		CN_QuanLyThongTinCoBan.setMaChucNang("eCore_0_0_CN_QuanLyThongTinCoBan");
		CN_QuanLyThongTinCoBan.setDuongDan("");
		CN_QuanLyThongTinCoBan.setHinhAnh("fa fa-wrench");
		CN_QuanLyThongTinCoBan.setTenHienThi("Thông tin cơ bản");
		CN_QuanLyThongTinCoBan.setChucNangCha(null);
		daochucnang.saveOrUpdate(CN_QuanLyThongTinCoBan);

		ChucNang CN_QuanLyDonVi = new ChucNang();
		CN_QuanLyDonVi.setMaChucNang("eCore_0_1_CN_QuanLyDonVi");
		CN_QuanLyDonVi.setDuongDan("eCore/pages/donvis.jsp");
		CN_QuanLyDonVi.setHinhAnh("fa fa-sitemap");
		CN_QuanLyDonVi.setTenHienThi("Quản lý đơn vị");
		CN_QuanLyDonVi.setChucNangCha(CN_QuanLyThongTinCoBan);
		daochucnang.saveOrUpdate(CN_QuanLyDonVi);

		ChucNang CN_QuanLyLop = new ChucNang();
		CN_QuanLyLop.setMaChucNang("eCore_0_2_CN_QuanLyLop");
		CN_QuanLyLop.setDuongDan("eCore/pages/lops.jsp");
		CN_QuanLyLop.setHinhAnh("fa fa-book");
		CN_QuanLyLop.setTenHienThi("Quản lý lớp");
		CN_QuanLyLop.setChucNangCha(CN_QuanLyThongTinCoBan);
		daochucnang.saveOrUpdate(CN_QuanLyLop);

		ChucNang CN_QuanLyNamHoc = new ChucNang();
		CN_QuanLyNamHoc.setMaChucNang("eCore_0_3_CN_QuanLyNamHoc");
		CN_QuanLyNamHoc.setDuongDan("eCore/pages/namhocs.jsp");
		CN_QuanLyNamHoc.setHinhAnh("fa fa-calendar-o");
		CN_QuanLyNamHoc.setTenHienThi("Quản lý năm học");
		CN_QuanLyNamHoc.setChucNangCha(CN_QuanLyThongTinCoBan);
		daochucnang.saveOrUpdate(CN_QuanLyNamHoc);

		ChucNang CN_QuanLyHocKy = new ChucNang();
		CN_QuanLyHocKy.setMaChucNang("eCore_0_4_CN_QuanLyHocKy");
		CN_QuanLyHocKy.setDuongDan("eCore/pages/hockys.jsp");
		CN_QuanLyHocKy.setHinhAnh("fa fa-calendar");
		CN_QuanLyHocKy.setTenHienThi("Quản lý học kỳ");
		CN_QuanLyHocKy.setChucNangCha(CN_QuanLyThongTinCoBan);
		daochucnang.saveOrUpdate(CN_QuanLyThongTinCoBan);

		ChucNang CN_QuanLyNhanVien = new ChucNang();
		CN_QuanLyNhanVien.setMaChucNang("eCore_0_5_CN_QuanLyNhanVien");
		CN_QuanLyNhanVien.setDuongDan("eCore/pages/nhanviens.jsp");
		CN_QuanLyNhanVien.setHinhAnh("fa fa-user");
		CN_QuanLyNhanVien.setTenHienThi("Quản lý nhân viên");
		CN_QuanLyNhanVien.setChucNangCha(CN_QuanLyThongTinCoBan);
		daochucnang.saveOrUpdate(CN_QuanLyNhanVien);

		ChucNang CN_QuanLySinhVien = new ChucNang();
		CN_QuanLySinhVien.setMaChucNang("eCore_0_6_CN_QuanLySinhVien");
		CN_QuanLySinhVien.setDuongDan("eCore/pages/sinhviens.jsp");
		CN_QuanLySinhVien.setHinhAnh("fa fa-users");
		CN_QuanLySinhVien.setTenHienThi("Quản lý sinh viên");
		CN_QuanLySinhVien.setChucNangCha(CN_QuanLyThongTinCoBan);
		daochucnang.saveOrUpdate(CN_QuanLySinhVien);

		ChucNang CN_QuanLyChucNangVaTaiKhoan = new ChucNang();
		CN_QuanLyChucNangVaTaiKhoan.setMaChucNang("eCore_1_0_CN_QuanLyChucNangVaTaiKhoan");
		CN_QuanLyChucNangVaTaiKhoan.setDuongDan("null");
		CN_QuanLyChucNangVaTaiKhoan.setHinhAnh("fa fa-filter");
		CN_QuanLyChucNangVaTaiKhoan.setTenHienThi("Chức năng và tài khoản");
		CN_QuanLyChucNangVaTaiKhoan.setChucNangCha(null);
		daochucnang.saveOrUpdate(CN_QuanLyChucNangVaTaiKhoan);

		ChucNang CN_QuanLyTaiKhoanNhanVien = new ChucNang();
		CN_QuanLyTaiKhoanNhanVien.setMaChucNang("eCore_1_1_CN_QuanLyTaiKhoanNhanVien");
		CN_QuanLyTaiKhoanNhanVien.setDuongDan("eCore/pages/taikhoannhanviens.jsp");
		CN_QuanLyTaiKhoanNhanVien.setHinhAnh("fa fa-users");
		CN_QuanLyTaiKhoanNhanVien.setTenHienThi("Quản lý tài khoản nhân viên");
		CN_QuanLyTaiKhoanNhanVien.setChucNangCha(CN_QuanLyChucNangVaTaiKhoan);
		daochucnang.saveOrUpdate(CN_QuanLyTaiKhoanNhanVien);

		ChucNang CN_QuanLyTaiKhoanSinhVien = new ChucNang();
		CN_QuanLyTaiKhoanSinhVien.setMaChucNang("eCore_1_1_CN_QuanLyTaiKhoanSinhVien");
		CN_QuanLyTaiKhoanSinhVien.setDuongDan("eCore/pages/taikhoansinhviens.jsp");
		CN_QuanLyTaiKhoanSinhVien.setHinhAnh("fa fa-users");
		CN_QuanLyTaiKhoanSinhVien.setTenHienThi("Quản lý tài khoản sinh viên");
		CN_QuanLyTaiKhoanSinhVien.setChucNangCha(CN_QuanLyChucNangVaTaiKhoan);
		daochucnang.saveOrUpdate(CN_QuanLyTaiKhoanSinhVien);

		ChucNang CN_QuanLyChucNang = new ChucNang();
		CN_QuanLyChucNang.setMaChucNang("eCore_1_2_CN_QuanLyChucNang");
		CN_QuanLyChucNang.setDuongDan("eCore/pages/chucnangs.jsp");
		CN_QuanLyChucNang.setHinhAnh("fa fa-share-alt");
		CN_QuanLyChucNang.setTenHienThi("Quản lý chức năng");
		CN_QuanLyChucNang.setChucNangCha(CN_QuanLyChucNangVaTaiKhoan);
		daochucnang.saveOrUpdate(CN_QuanLyChucNang);

		ChucNang CN_QuanLyPhanQuyen = new ChucNang();
		CN_QuanLyPhanQuyen.setMaChucNang("eCore_1_3_CN_QuanLyPhanQuyen");
		CN_QuanLyPhanQuyen.setDuongDan("eCore/pages/nhomphanquyens.jsp");
		CN_QuanLyPhanQuyen.setHinhAnh("fa fa-shield");
		CN_QuanLyPhanQuyen.setTenHienThi("Quản lý phân quyền");
		CN_QuanLyPhanQuyen.setChucNangCha(CN_QuanLyChucNangVaTaiKhoan);
		daochucnang.saveOrUpdate(CN_QuanLyPhanQuyen);

		ChucNang CN_QuanLyBaoHiemYTe = new ChucNang();
		CN_QuanLyBaoHiemYTe.setMaChucNang("eSm3_0_0_CN_QuanLyBaoHiemYTe");
		CN_QuanLyBaoHiemYTe.setDuongDan("");
		CN_QuanLyBaoHiemYTe.setHinhAnh("fa fa-heartbeat");
		CN_QuanLyBaoHiemYTe.setTenHienThi("Bảo hiểm y tế");
		CN_QuanLyBaoHiemYTe.setChucNangCha(null);
		daochucnang.saveOrUpdate(CN_QuanLyBaoHiemYTe);

		ChucNang CN_DangKyBHYTNhanVien = new ChucNang();
		CN_DangKyBHYTNhanVien.setMaChucNang("eSm3_0_1_CN_DangKyBHYTNhanVien");
		CN_DangKyBHYTNhanVien.setDuongDan("eSm3/pages/thongtindangkybaohiemytenhanvien.jsp");
		CN_DangKyBHYTNhanVien.setHinhAnh("fa fa-user-md");
		CN_DangKyBHYTNhanVien.setTenHienThi("Đăng ký BHYT nhân viên");
		CN_DangKyBHYTNhanVien.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_DangKyBHYTNhanVien);

		ChucNang CN_QuanLyKetQuaDangKyBHYTNhanVien = new ChucNang();
		CN_QuanLyKetQuaDangKyBHYTNhanVien.setMaChucNang("eSm3_0_2_CN_QuanLyDanhSachDangKyBHYTNhanVien");
		CN_QuanLyKetQuaDangKyBHYTNhanVien.setDuongDan("eSm3/pages/thongtindangkybaohiemytenhanviens.jsp");
		CN_QuanLyKetQuaDangKyBHYTNhanVien.setHinhAnh("fa fa-user-md");
		CN_QuanLyKetQuaDangKyBHYTNhanVien.setTenHienThi("Lịch sử đăng ký BHYT nhân viên");
		CN_QuanLyKetQuaDangKyBHYTNhanVien.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_QuanLyKetQuaDangKyBHYTNhanVien);

		ChucNang CN_QuanLyCoSoKhamChuaBenh = new ChucNang();
		CN_QuanLyCoSoKhamChuaBenh.setMaChucNang("eSm3_0_3_CN_QuanLyCoSoKhamChuaBenh");
		CN_QuanLyCoSoKhamChuaBenh.setDuongDan("eSm3/pages/cosokhamchuabenhs.jsp");
		CN_QuanLyCoSoKhamChuaBenh.setHinhAnh("fa fa-hospital-o");
		CN_QuanLyCoSoKhamChuaBenh.setTenHienThi("Quản lý cơ sở khám chữa bệnh");
		CN_QuanLyCoSoKhamChuaBenh.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_QuanLyCoSoKhamChuaBenh);

		ChucNang CN_QuanLyDotDangKyBHYT = new ChucNang();
		CN_QuanLyDotDangKyBHYT.setMaChucNang("eSm3_0_4_CN_QuanLyDotDangKyBHYT");
		CN_QuanLyDotDangKyBHYT.setDuongDan("eSm3/pages/dotdangkybaohiemytes.jsp");
		CN_QuanLyDotDangKyBHYT.setHinhAnh("fa fa-list-ol");
		CN_QuanLyDotDangKyBHYT.setTenHienThi("Quản lý đợt đăng ký BHYT");
		CN_QuanLyDotDangKyBHYT.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_QuanLyDotDangKyBHYT);

		ChucNang CN_QuanLyDanhSachDangKyBHYTNhanVien = new ChucNang();
		CN_QuanLyDanhSachDangKyBHYTNhanVien.setMaChucNang("eSm3_0_5_CN_QuanLyDanhSachDangKyBHYTNhanVien");
		CN_QuanLyDanhSachDangKyBHYTNhanVien.setDuongDan("eSm3/pages/thongtindangkybaohiemytenhanviens_quanly.jsp");
		CN_QuanLyDanhSachDangKyBHYTNhanVien.setHinhAnh("fa fa-user-md");
		CN_QuanLyDanhSachDangKyBHYTNhanVien.setTenHienThi("Thông tin đăng ký BHYT nhân viên");
		CN_QuanLyDanhSachDangKyBHYTNhanVien.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_QuanLyDanhSachDangKyBHYTNhanVien);

		ChucNang CN_QuanLyDanhSachDangKyBHYTSinhVien = new ChucNang();
		CN_QuanLyDanhSachDangKyBHYTSinhVien.setMaChucNang("eSm3_0_6_CN_QuanLyDanhSachDangKyBHYTSinhVien");
		CN_QuanLyDanhSachDangKyBHYTSinhVien.setDuongDan("eSm3/pages/thongtindangkybaohiemytesinhviens.jsp");
		CN_QuanLyDanhSachDangKyBHYTSinhVien.setHinhAnh("fa fa-user-md");
		CN_QuanLyDanhSachDangKyBHYTSinhVien.setTenHienThi("Thông tin đăng ký BHYT sinh viên");
		CN_QuanLyDanhSachDangKyBHYTSinhVien.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_QuanLyDanhSachDangKyBHYTSinhVien);

		ChucNang CN_DangKyBHYTSinhVien = new ChucNang();
		CN_DangKyBHYTSinhVien.setMaChucNang("eSm3_0_7_CN_DangKyBHYTSinhVien");
		CN_DangKyBHYTSinhVien.setDuongDan("eSm3/pages/thongtindangkybaohiemytesinhvien.jsp");
		CN_DangKyBHYTSinhVien.setHinhAnh("fa fa-user-md");
		CN_DangKyBHYTSinhVien.setTenHienThi("Đăng ký BHYT sinh viên");
		CN_DangKyBHYTSinhVien.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_DangKyBHYTSinhVien);

		ChucNang CN_KeKhaiMinhChungBaoHiemNhanVien = new ChucNang();
		CN_KeKhaiMinhChungBaoHiemNhanVien.setMaChucNang("eSm3_0_8_CN_KeKhaiMinhChungBaoHiemNhanVien");
		CN_KeKhaiMinhChungBaoHiemNhanVien.setDuongDan("eSm3/pages/kekhaiminhchungbaohiemnhanvien.jsp");
		CN_KeKhaiMinhChungBaoHiemNhanVien.setHinhAnh("fa fa-paperclip");
		CN_KeKhaiMinhChungBaoHiemNhanVien.setTenHienThi("Kê khai minh chứng bảo hiểm nhân viên");
		CN_KeKhaiMinhChungBaoHiemNhanVien.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_KeKhaiMinhChungBaoHiemNhanVien);

		ChucNang CN_KeKhaiMinhChungBaoHiemSinhVien = new ChucNang();
		CN_KeKhaiMinhChungBaoHiemSinhVien.setMaChucNang("eSm3_0_8_CN_KeKhaiMinhChungBaoHiemSinhVien");
		CN_KeKhaiMinhChungBaoHiemSinhVien.setDuongDan("eSm3/pages/kekhaiminhchungbaohiemsinhvien.jsp");
		CN_KeKhaiMinhChungBaoHiemSinhVien.setHinhAnh("fa fa-paperclip");
		CN_KeKhaiMinhChungBaoHiemSinhVien.setTenHienThi("Kê khai minh chứng bảo hiểm sinh viên");
		CN_KeKhaiMinhChungBaoHiemSinhVien.setChucNangCha(CN_QuanLyBaoHiemYTe);
		daochucnang.saveOrUpdate(CN_KeKhaiMinhChungBaoHiemSinhVien);

// 		ChucNang CN_BaoCaoThongKeBHYT = new ChucNang();
// 		CN_BaoCaoThongKeBHYT.setMaChucNang("eSm3_0_9_CN_BaoCaoThongKeBHYT");
// 		CN_BaoCaoThongKeBHYT.setDuongDan("eSm3/pages/baocaothongkebaohiemyte.jsp");
// 		CN_BaoCaoThongKeBHYT.setHinhAnh("fa fa-spinner");
// 		CN_BaoCaoThongKeBHYT.setTenHienThi("Báo cáo thống kê");
// 		CN_BaoCaoThongKeBHYT.setChucNangCha(CN_QuanLyBaoHiemYTe);
// 		daochucnang.saveOrUpdate(CN_BaoCaoThongKeBHYT);

		ChucNang CN_QuanLyBHTN = new ChucNang();
		CN_QuanLyBHTN.setMaChucNang("eSm3_1_0_CN_QuanLyBHTN");
		CN_QuanLyBHTN.setDuongDan("null");
		CN_QuanLyBHTN.setHinhAnh("fa fa-child");
		CN_QuanLyBHTN.setTenHienThi("Bảo hiểm tự nguyện");
		CN_QuanLyBHTN.setChucNangCha(null);
		daochucnang.saveOrUpdate(CN_QuanLyBHTN);
		
		ChucNang CN_DangKyBHTNNhanVien = new ChucNang();
		CN_DangKyBHTNNhanVien.setMaChucNang("eSm3_1_1_CN_DangKyBHTNNhanVien");
		CN_DangKyBHTNNhanVien.setDuongDan("eSm3/pages/thongtindangkybaohiemtunguyennhanvien.jsp");
		CN_DangKyBHTNNhanVien.setHinhAnh("fa fa-user-md");
		CN_DangKyBHTNNhanVien.setTenHienThi("Đăng ký BHTN nhân viên");
		CN_DangKyBHTNNhanVien.setChucNangCha(CN_QuanLyBHTN);
		daochucnang.saveOrUpdate(CN_DangKyBHTNNhanVien);

		ChucNang CN_QuanLyKetQuaDangKyBHTNNhanVien = new ChucNang();
		CN_QuanLyKetQuaDangKyBHTNNhanVien.setMaChucNang("eSm3_1_2_CN_QuanLyKetQuaDangKyBHTNNhanVien");
		CN_QuanLyKetQuaDangKyBHTNNhanVien.setDuongDan("eSm3/pages/thongtindangkybaohiemtunguyennhanviens.jsp");
		CN_QuanLyKetQuaDangKyBHTNNhanVien.setHinhAnh("fa fa-list-ol");
		CN_QuanLyKetQuaDangKyBHTNNhanVien.setTenHienThi("Lịch sử đăng ký BHTN nhân viên");
		CN_QuanLyKetQuaDangKyBHTNNhanVien.setChucNangCha(CN_QuanLyBHTN);
		daochucnang.saveOrUpdate(CN_QuanLyKetQuaDangKyBHTNNhanVien);

		ChucNang CN_QuanLyDotDangKyBHTN = new ChucNang();
		CN_QuanLyDotDangKyBHTN.setMaChucNang("eSm3_1_3_CN_QuanLyDotDangKyBHTN");
		CN_QuanLyDotDangKyBHTN.setDuongDan("eSm3/pages/dotdangkybaohiemtunguyens.jsp");
		CN_QuanLyDotDangKyBHTN.setHinhAnh("fa fa-list-ol");
		CN_QuanLyDotDangKyBHTN.setTenHienThi("Quản lý đợt đăng ký BHTN");
		CN_QuanLyDotDangKyBHTN.setChucNangCha(CN_QuanLyBHTN);
		daochucnang.saveOrUpdate(CN_QuanLyDotDangKyBHTN);

		ChucNang CN_QuanLyDanhSachDangKyBHTNNhanVien = new ChucNang();
		CN_QuanLyDanhSachDangKyBHTNNhanVien.setMaChucNang("eSm3_1_4_CN_QuanLyDanhSachDangKyBHTNNhanVien");
		CN_QuanLyDanhSachDangKyBHTNNhanVien
				.setDuongDan("eSm3/pages/thongtindangkybaohiemtunguyennhanviens_quanly.jsp");
		CN_QuanLyDanhSachDangKyBHTNNhanVien.setHinhAnh("fa fa-list-ol");
		CN_QuanLyDanhSachDangKyBHTNNhanVien.setTenHienThi("Thông tin đăng ký BHTN nhân viên");
		CN_QuanLyDanhSachDangKyBHTNNhanVien.setChucNangCha(CN_QuanLyBHTN);
		daochucnang.saveOrUpdate(CN_QuanLyDanhSachDangKyBHTNNhanVien);

		

		ChucNang CN_QuanLyDanhSachDangKyBHTNSinhVien = new ChucNang();
		CN_QuanLyDanhSachDangKyBHTNSinhVien.setMaChucNang("eSm3_1_5_CN_QuanLyDanhSachDangKyBHTNSinhVien");
		CN_QuanLyDanhSachDangKyBHTNSinhVien.setDuongDan("eSm3/pages/thongtindangkybaohiemtunguyensinhviens.jsp");
		CN_QuanLyDanhSachDangKyBHTNSinhVien.setHinhAnh("fa fa-list-ol");
		CN_QuanLyDanhSachDangKyBHTNSinhVien.setTenHienThi("Thông tin đăng ký BHTN sinh viên");
		CN_QuanLyDanhSachDangKyBHTNSinhVien.setChucNangCha(CN_QuanLyBHTN);
		daochucnang.saveOrUpdate(CN_QuanLyDanhSachDangKyBHTNSinhVien);

		ChucNang CN_DangKyBHTNSinhVien = new ChucNang();
		CN_DangKyBHTNSinhVien.setMaChucNang("eSm3_1_6_CN_DangKyBHTNSinhVien");
		CN_DangKyBHTNSinhVien.setDuongDan("eSm3/pages/thongtindangkybaohiemtunguyensinhvien.jsp");
		CN_DangKyBHTNSinhVien.setHinhAnh("fa fa-user-md");
		CN_DangKyBHTNSinhVien.setTenHienThi("Đăng ký BHTN sinh viên");
		CN_DangKyBHTNSinhVien.setChucNangCha(CN_QuanLyBHTN);
		daochucnang.saveOrUpdate(CN_DangKyBHTNSinhVien);

// 		ChucNang CN_BaoCaoThongKeBHTN = new ChucNang();
// 		CN_BaoCaoThongKeBHTN.setMaChucNang("eSm3_1_7_CN_BaoCaoThongKeBHTN");
// 		CN_BaoCaoThongKeBHTN.setDuongDan("eSm3/pages/baocaothongkebaohiemtunguyen.jsp");
// 		CN_BaoCaoThongKeBHTN.setHinhAnh("fa fa-spinner");
// 		CN_BaoCaoThongKeBHTN.setTenHienThi("Báo cáo thống kê");
// 		CN_BaoCaoThongKeBHTN.setChucNangCha(CN_QuanLyBHTN);
// 		daochucnang.saveOrUpdate(CN_BaoCaoThongKeBHTN);

		ChucNang CN_QuanLyNgoaiTru = new ChucNang();
		CN_QuanLyNgoaiTru.setMaChucNang("eSm4_0_0_CN_QuanLyNgoaiTru");
		CN_QuanLyNgoaiTru.setDuongDan("null");
		CN_QuanLyNgoaiTru.setHinhAnh("fa fa-university");
		CN_QuanLyNgoaiTru.setTenHienThi("Ngoại trú");
		CN_QuanLyNgoaiTru.setChucNangCha(null);
		daochucnang.saveOrUpdate(CN_QuanLyNgoaiTru);

		ChucNang CN_QuanLyDotKeKhaiThongTinNgoaiTru = new ChucNang();
		CN_QuanLyDotKeKhaiThongTinNgoaiTru.setMaChucNang("eSm4_0_1_CN_QuanLyDotKeKhaiThongTinNgoaiTru");
		CN_QuanLyDotKeKhaiThongTinNgoaiTru.setDuongDan("eSm4/pages/dotkekhaithongtinngoaitrus.jsp");
		CN_QuanLyDotKeKhaiThongTinNgoaiTru.setHinhAnh("fa fa-list-ol");
		CN_QuanLyDotKeKhaiThongTinNgoaiTru.setTenHienThi("Quản lý đợt kê khai thông tin ngoại trú");
		CN_QuanLyDotKeKhaiThongTinNgoaiTru.setChucNangCha(CN_QuanLyNgoaiTru);
		daochucnang.saveOrUpdate(CN_QuanLyDotKeKhaiThongTinNgoaiTru);

		ChucNang CN_QuanLyThongTinNgoaiTru = new ChucNang();
		CN_QuanLyThongTinNgoaiTru.setMaChucNang("eSm4_0_2_CN_QuanLyThongTinNgoaiTru");
		CN_QuanLyThongTinNgoaiTru.setDuongDan("eSm4/pages/thongtinngoaitrus.jsp");
		CN_QuanLyThongTinNgoaiTru.setHinhAnh("fa fa-institution");
		CN_QuanLyThongTinNgoaiTru.setTenHienThi("Thông tin ngoại trú");
		CN_QuanLyThongTinNgoaiTru.setChucNangCha(CN_QuanLyNgoaiTru);
		daochucnang.saveOrUpdate(CN_QuanLyThongTinNgoaiTru);

		ChucNang CN_KeKhaiThongTinNgoaiTru = new ChucNang();
		CN_KeKhaiThongTinNgoaiTru.setMaChucNang("eSm4_0_3_CN_KeKhaiThongTinNgoaiTru");
		CN_KeKhaiThongTinNgoaiTru.setDuongDan("eSm4/pages/thongtinngoaitru.jsp");
		CN_KeKhaiThongTinNgoaiTru.setHinhAnh("fa fa-paperclip");
		CN_KeKhaiThongTinNgoaiTru.setTenHienThi("Kê khai thông tin ngoại trú");
		CN_KeKhaiThongTinNgoaiTru.setChucNangCha(CN_QuanLyNgoaiTru);
		daochucnang.saveOrUpdate(CN_KeKhaiThongTinNgoaiTru);

		ChucNang CN_BaoCaoThongKeNgoaiTru = new ChucNang();
		CN_BaoCaoThongKeNgoaiTru.setMaChucNang("eSm4_0_4_CN_BaoCaoThongKeNgoaiTru");
		CN_BaoCaoThongKeNgoaiTru.setDuongDan("eSm4/pages/baocaothongke.jsp");
		CN_BaoCaoThongKeNgoaiTru.setHinhAnh("fa fa-spinner");
		CN_BaoCaoThongKeNgoaiTru.setTenHienThi("Báo cáo thống kê");
		CN_BaoCaoThongKeNgoaiTru.setChucNangCha(CN_QuanLyNgoaiTru);
		daochucnang.saveOrUpdate(CN_BaoCaoThongKeNgoaiTru);

		ChucNang CN_QuanLyKhenThuongKyLuat = new ChucNang();
		CN_QuanLyKhenThuongKyLuat.setMaChucNang("eSm5_0_0_CN_QuanLyKhenThuongKyLuat");
		CN_QuanLyKhenThuongKyLuat.setDuongDan("null");
		CN_QuanLyKhenThuongKyLuat.setHinhAnh("fa fa-american-sign-language-interpreting");
		CN_QuanLyKhenThuongKyLuat.setTenHienThi("Khen thưởng và kỷ luật");
		CN_QuanLyKhenThuongKyLuat.setChucNangCha(null);
		daochucnang.saveOrUpdate(CN_QuanLyKhenThuongKyLuat);

		ChucNang CN_QuanLyKhenThuong = new ChucNang();
		CN_QuanLyKhenThuong.setMaChucNang("eSm5_0_1_CN_QuanLyKhenThuong");
		CN_QuanLyKhenThuong.setDuongDan("eSm5/pages/thongtinkhenthuongs.jsp");
		CN_QuanLyKhenThuong.setHinhAnh("fa fa-thumbs-up");
		CN_QuanLyKhenThuong.setTenHienThi("Quản lý khen thưởng");
		CN_QuanLyKhenThuong.setChucNangCha(CN_QuanLyKhenThuongKyLuat);
		daochucnang.saveOrUpdate(CN_QuanLyKhenThuong);

		ChucNang CN_QuanLyKyLuat = new ChucNang();
		CN_QuanLyKyLuat.setMaChucNang("eSm5_0_2_CN_QuanLyKyLuat");
		CN_QuanLyKyLuat.setDuongDan("eSm5/pages/thongtinkyluats.jsp");
		CN_QuanLyKyLuat.setHinhAnh("fa fa-thumbs-down");
		CN_QuanLyKyLuat.setTenHienThi("Quản lý kỷ luật");
		CN_QuanLyKyLuat.setChucNangCha(CN_QuanLyKhenThuongKyLuat);
		daochucnang.saveOrUpdate(CN_QuanLyKyLuat);

		ChucNang CN_BaoCaoThongKeKhenThuongKyLuat = new ChucNang();
		CN_BaoCaoThongKeKhenThuongKyLuat.setMaChucNang("eSm5_0_3_CN_BaoCaoThongKeKhenThuongKyLuat");
		CN_BaoCaoThongKeKhenThuongKyLuat.setDuongDan("eSm5/pages/baocaothongke.jsp");
		CN_BaoCaoThongKeKhenThuongKyLuat.setHinhAnh("fa fa-spinner");
		CN_BaoCaoThongKeKhenThuongKyLuat.setTenHienThi("Báo cáo thống kê");
		CN_BaoCaoThongKeKhenThuongKyLuat.setChucNangCha(CN_QuanLyKhenThuongKyLuat);
		daochucnang.saveOrUpdate(CN_BaoCaoThongKeKhenThuongKyLuat);

		ChucNang CN_ThongTinKhenThuong = new ChucNang();
		CN_ThongTinKhenThuong.setMaChucNang("eSm5_0_4_CN_ThongTinKhenThuong");
		CN_ThongTinKhenThuong.setDuongDan("eSm5/pages/thongtinkhenthuongs.jsp");
		CN_ThongTinKhenThuong.setHinhAnh("fa fa-thumbs-up");
		CN_ThongTinKhenThuong.setTenHienThi("Thông tin khen thưởng");
		CN_ThongTinKhenThuong.setChucNangCha(CN_QuanLyKhenThuongKyLuat);
		daochucnang.saveOrUpdate(CN_ThongTinKhenThuong);

		ChucNang CN_ThongTinKyLuat = new ChucNang();
		CN_ThongTinKyLuat.setMaChucNang("eSm5_0_5_CN_ThongTinKyLuat");
		CN_ThongTinKyLuat.setDuongDan("eSm5/pages/thongtinkyluats.jsp");
		CN_ThongTinKyLuat.setHinhAnh("fa fa-thumbs-down");
		CN_ThongTinKyLuat.setTenHienThi("Thông tin kỷ luật");
		CN_ThongTinKyLuat.setChucNangCha(CN_QuanLyKhenThuongKyLuat);
		daochucnang.saveOrUpdate(CN_ThongTinKyLuat);

		/////////////////////////////////////////////////////////////////////////
		// admin
		/////////////////////////////////////////////////////////////////////////
		NhomPhanQuyen nhomPhanQuyenAdmin = new NhomPhanQuyen();
		nhomPhanQuyenAdmin.setMaNhomPhanQuyen("admin");
		nhomPhanQuyenAdmin.setTenNhomPhanQuyen("Admin");
		Set<ChucNang> chs1 = new HashSet<ChucNang>();

		chs1.add(CN_QuanLyThongTinCoBan);
		chs1.add(CN_QuanLyDonVi);
		chs1.add(CN_QuanLyLop);
		chs1.add(CN_QuanLyNamHoc);
		chs1.add(CN_QuanLyHocKy);
		chs1.add(CN_QuanLyNhanVien);
		chs1.add(CN_QuanLySinhVien);

		chs1.add(CN_QuanLyChucNangVaTaiKhoan);
		chs1.add(CN_QuanLyTaiKhoanNhanVien);
		chs1.add(CN_QuanLyTaiKhoanSinhVien);
		chs1.add(CN_QuanLyChucNang);
		chs1.add(CN_QuanLyPhanQuyen);

		chs1.add(CN_QuanLyBaoHiemYTe);
		chs1.add(CN_QuanLyCoSoKhamChuaBenh);
		chs1.add(CN_QuanLyDotDangKyBHYT);
		chs1.add(CN_QuanLyDanhSachDangKyBHYTNhanVien);
		chs1.add(CN_QuanLyDanhSachDangKyBHYTSinhVien);
		chs1.add(CN_DangKyBHYTNhanVien);
		chs1.add(CN_QuanLyKetQuaDangKyBHYTNhanVien);
		chs1.add(CN_KeKhaiMinhChungBaoHiemNhanVien);
		chs1.add(CN_KeKhaiMinhChungBaoHiemSinhVien);
// 		chs1.add(CN_BaoCaoThongKeBHYT);

		chs1.add(CN_QuanLyBHTN);
		chs1.add(CN_QuanLyDanhSachDangKyBHTNNhanVien);
		chs1.add(CN_QuanLyDanhSachDangKyBHTNSinhVien);
		chs1.add(CN_QuanLyDotDangKyBHTN);
		chs1.add(CN_DangKyBHTNNhanVien);
		chs1.add(CN_QuanLyKetQuaDangKyBHTNNhanVien);
// 		chs1.add(CN_BaoCaoThongKeBHTN);

		chs1.add(CN_QuanLyNgoaiTru);
		chs1.add(CN_QuanLyDotKeKhaiThongTinNgoaiTru);
		chs1.add(CN_QuanLyThongTinNgoaiTru);
		chs1.add(CN_BaoCaoThongKeNgoaiTru);

		chs1.add(CN_QuanLyKhenThuongKyLuat);
		chs1.add(CN_QuanLyKhenThuong);
		chs1.add(CN_QuanLyKyLuat);
		chs1.add(CN_BaoCaoThongKeKhenThuongKyLuat);

		nhomPhanQuyenAdmin.setChucNangs(chs1);
		ObjectDAO daonpq = new DAO_NhomPhanQuyen();
		daonpq.saveOrUpdate(nhomPhanQuyenAdmin);

		//////////////////////////////////////////////////////
		// giang vien binh thuong, khong duoc phan cong thuc hien cac nhiem vu quan ly
		/////////////////////////////////////////////////////
		NhomPhanQuyen nhomPhanQuyenGiangVien = new NhomPhanQuyen();
		nhomPhanQuyenGiangVien.setMaNhomPhanQuyen("giangvien");
		nhomPhanQuyenGiangVien.setTenNhomPhanQuyen("Giảng viên");
		Set<ChucNang> chs2 = new HashSet<ChucNang>();

		chs2.add(CN_QuanLyBaoHiemYTe);
		chs2.add(CN_DangKyBHYTNhanVien);
		chs2.add(CN_QuanLyKetQuaDangKyBHYTNhanVien);

		chs2.add(CN_QuanLyBHTN);
		chs2.add(CN_DangKyBHTNNhanVien);
		chs2.add(CN_QuanLyKetQuaDangKyBHTNNhanVien);

		nhomPhanQuyenGiangVien.setChucNangs(chs2);
		ObjectDAO daonpq1 = new DAO_NhomPhanQuyen();
		daonpq1.saveOrUpdate(nhomPhanQuyenGiangVien);
		//////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////
		// giang vien duoc phan cong quan ly thong tin bao hiem
		/////////////////////////////////////////////////////
		NhomPhanQuyen nhomPhanQuyenGiangVienQuanLyBaoHiem = new NhomPhanQuyen();
		nhomPhanQuyenGiangVienQuanLyBaoHiem.setMaNhomPhanQuyen("giangvienquanlybaohiem");
		nhomPhanQuyenGiangVienQuanLyBaoHiem.setTenNhomPhanQuyen("Giảng viên quản lý bảo hiểm");
		Set<ChucNang> chs3 = new HashSet<ChucNang>();

		chs3.add(CN_QuanLyBaoHiemYTe);
		chs3.add(CN_QuanLyCoSoKhamChuaBenh);
		chs3.add(CN_QuanLyDotDangKyBHYT);
		chs3.add(CN_DangKyBHYTNhanVien);
		chs3.add(CN_QuanLyKetQuaDangKyBHYTNhanVien);
		chs3.add(CN_QuanLyDanhSachDangKyBHYTNhanVien);
		chs3.add(CN_QuanLyDanhSachDangKyBHYTSinhVien);
// 		chs3.add(CN_BaoCaoThongKeBHYT);

		chs3.add(CN_QuanLyBHTN);
		chs3.add(CN_QuanLyDotDangKyBHTN);
		chs3.add(CN_DangKyBHTNNhanVien);
		chs3.add(CN_QuanLyKetQuaDangKyBHTNNhanVien);
		chs3.add(CN_QuanLyDanhSachDangKyBHTNNhanVien);
		chs3.add(CN_QuanLyDanhSachDangKyBHTNSinhVien);
// 		chs3.add(CN_BaoCaoThongKeBHTN);

		nhomPhanQuyenGiangVienQuanLyBaoHiem.setChucNangs(chs3);
		ObjectDAO daonpq2 = new DAO_NhomPhanQuyen();
		daonpq2.saveOrUpdate(nhomPhanQuyenGiangVienQuanLyBaoHiem);
		//////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////
		// giang vien duoc phan cong quan ly thong tin ngoai tru
		/////////////////////////////////////////////////////
		NhomPhanQuyen nhomPhanQuyenGiangVienQuanLyNgoaiTru = new NhomPhanQuyen();
		nhomPhanQuyenGiangVienQuanLyNgoaiTru.setMaNhomPhanQuyen("giangvienquanlyngoaitru");
		nhomPhanQuyenGiangVienQuanLyNgoaiTru.setTenNhomPhanQuyen("Giảng viên quản lý ngoại trú");
		Set<ChucNang> chs4 = new HashSet<ChucNang>();

		chs4.add(CN_QuanLyBaoHiemYTe);
		chs4.add(CN_DangKyBHYTNhanVien);
		chs4.add(CN_QuanLyKetQuaDangKyBHYTNhanVien);

		chs4.add(CN_QuanLyBHTN);
		chs4.add(CN_DangKyBHTNNhanVien);
		chs4.add(CN_QuanLyKetQuaDangKyBHTNNhanVien);

		chs4.add(CN_QuanLyNgoaiTru);
		chs4.add(CN_QuanLyDotKeKhaiThongTinNgoaiTru);
		chs4.add(CN_QuanLyThongTinNgoaiTru);

		nhomPhanQuyenGiangVienQuanLyNgoaiTru.setChucNangs(chs4);
		ObjectDAO daonpq3 = new DAO_NhomPhanQuyen();
		daonpq3.saveOrUpdate(nhomPhanQuyenGiangVienQuanLyNgoaiTru);
		//////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////
		// giang vien duoc phan cong quan ly thong tin khen thuong ky luat
		/////////////////////////////////////////////////////
		NhomPhanQuyen nhomPhanQuyenGiangVienQuanLyKhenThuongKyLuat = new NhomPhanQuyen();
		nhomPhanQuyenGiangVienQuanLyKhenThuongKyLuat.setMaNhomPhanQuyen("giangvienquanlykhenthuongkyluat");
		nhomPhanQuyenGiangVienQuanLyKhenThuongKyLuat
				.setTenNhomPhanQuyen("Giảng viên quản lý khen thưởng và kỷ luật");
		Set<ChucNang> chs5 = new HashSet<ChucNang>();

		chs5.add(CN_QuanLyBaoHiemYTe);
		chs5.add(CN_DangKyBHYTNhanVien);
		chs5.add(CN_QuanLyKetQuaDangKyBHYTNhanVien);

		chs5.add(CN_QuanLyBHTN);
		chs5.add(CN_DangKyBHTNNhanVien);
		chs5.add(CN_QuanLyKetQuaDangKyBHTNNhanVien);

		chs5.add(CN_QuanLyKhenThuongKyLuat);
		chs5.add(CN_QuanLyKhenThuong);
		chs5.add(CN_QuanLyKyLuat);
		chs5.add(CN_BaoCaoThongKeKhenThuongKyLuat);

		nhomPhanQuyenGiangVienQuanLyKhenThuongKyLuat.setChucNangs(chs5);
		ObjectDAO daonpq4 = new DAO_NhomPhanQuyen();
		daonpq4.saveOrUpdate(nhomPhanQuyenGiangVienQuanLyKhenThuongKyLuat);
		//////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////
		// sinh vien
		/////////////////////////////////////////////////////
		NhomPhanQuyen nhomPhanQuyenSinhVien = new NhomPhanQuyen();
		nhomPhanQuyenSinhVien.setMaNhomPhanQuyen("sinhvien");
		nhomPhanQuyenSinhVien.setTenNhomPhanQuyen("Sinh viên");
		Set<ChucNang> chs6 = new HashSet<ChucNang>();

		chs6.add(CN_QuanLyBaoHiemYTe);
		chs6.add(CN_DangKyBHYTSinhVien);
		chs6.add(CN_QuanLyDanhSachDangKyBHYTSinhVien);

		chs6.add(CN_QuanLyBHTN);
		chs6.add(CN_DangKyBHTNSinhVien);
		chs6.add(CN_QuanLyDanhSachDangKyBHTNSinhVien);

		chs6.add(CN_QuanLyNgoaiTru);
		chs6.add(CN_KeKhaiThongTinNgoaiTru);
		chs6.add(CN_QuanLyThongTinNgoaiTru);

		chs6.add(CN_QuanLyKhenThuongKyLuat);
		chs6.add(CN_ThongTinKhenThuong);
		chs6.add(CN_ThongTinKyLuat);

		nhomPhanQuyenSinhVien.setChucNangs(chs6);
		ObjectDAO daonpq5 = new DAO_NhomPhanQuyen();
		daonpq5.saveOrUpdate(nhomPhanQuyenSinhVien);
		//////////////////////////////////////////////////////////

		// 		TaiKhoanNhanVien tk = new TaiKhoanNhanVien();
		// 		tk.setMaDangNhap(admin.getEmail());
		// 		tk.setEmail(admin.getEmail());
		// 		tk.setMatKhau(Util_MD5.md5("123456"));
		// 		tk.setNhanVien(admin);
		// 		tk.setNhomPhanQuyen(nhomPhanQuyenAdmin);
		// 		ObjectDAO dao3 = new DAO_TaiKhoan();
		// 		dao3.saveOrUpdate(tk);

		// 		TaiKhoanNhanVien tkGiangVien = new TaiKhoanNhanVien();
		// 		tkGiangVien.setMaDangNhap(giangVien.getEmail());
		// 		tkGiangVien.setEmail(giangVien.getEmail());
		// 		tkGiangVien.setMatKhau(Util_MD5.md5("123456"));
		// 		tkGiangVien.setNhanVien(giangVien);
		// 		tkGiangVien.setNhomPhanQuyen(nhomPhanQuyenGiangVien);
		// 		dao3.saveOrUpdate(tkGiangVien);

		// 		TaiKhoanSinhVien tkSinhVien = new TaiKhoanSinhVien();
		// 		tkSinhVien.setMaDangNhap(sinhVien.getEmail());
		// 		tkSinhVien.setEmail(sinhVien.getEmail());
		// 		tkSinhVien.setMatKhau(Util_MD5.md5("123456"));
		// 		tkSinhVien.setSinhVien(sinhVien);
		// 		tkSinhVien.setNhomPhanQuyen(nhomPhanQuyenSinhVien);
		// 		ObjectDAO dao4 = new DAO_TaiKhoan();
		// 		dao3.saveOrUpdate(tkSinhVien);
	%>

</body>
</html>
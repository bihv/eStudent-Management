package eCore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class SinhVien implements Comparable<SinhVien> {
	@Id
	public String maSinhVien;
	public String ten;
	public String hoDem;
	public String hoVaTen;
	public String gioiTinh;
	public String soCMND;
	public String ngayCap;
	public String noiCap;
	public String ngaySinh;
	public String noiSinh;
	public String doiTuong;
	public String khuVuc;
	public String namTotNghiepTHPT;
	public String totNghiepTaiTruongTHPT;
	public String xepLoaiVanHoa;
	public String xepLoaiGiaoDuc;
	public String queQuan;
	public String hoKhauThuongTru;
	public String maTinh;
	public String maQuanHuyen;
	public String maPhuongXa;
	public String maDanToc;
	public String maTonGiao;
	public String maQuocTich;
	public String maThanhPhanGiaDinh;
	public String dienThoaiDiDong;
	public String dienThoaiCoDinh;
	public String dienThoaiGiaDinh;
	public String email;
	public String thongTinBaoTin;
	public String ngayVaoDoan;
	public String ngayVaoDang;
	public String maSoHinhAnh;
	public String khiCanBaoTinChoAi;
	public String diaChiKhiCanBaoTinChoAi;
	public String bhyt_maTinh;
	public String bhyt_maBenhVien;
	public String bhyt_tenBenhVien;
	public String bhtn_thamgia;
	public String bthn_sothang;
	public String soBaoDanh;
	public String diemMon1;
	public String diemMon2;
	public String diemMon3;
	public String diemUuTien;
	public String tongDiem;
	public String ngheNghiepTruocKhiVaoTruong;
	public String thanhPhanGiaDinh;
	public String thiTHPTNgay;
	public String diaChiNhanThu;
	public String emailPhuHuynh;
	public String tenNganhTrungTuyen;
	public String daKhaiPhieuQuanLySinhVien;
	public String daNhapHoc;
	public String maChuyenNganh1;
	public String maChuyenNganh2;

	@ManyToOne(fetch = FetchType.EAGER)
	public Lop lop;
	@Type(type = "text")
	public String ghiChu;
	@Type(type = "text")
	public String moTa;
	public Date thoiGianCapNhat;

	public SinhVien() {
	}

	public SinhVien(String maSinhVien, String ten, String hoDem, String hoVaTen, String gioiTinh, String soCMND,
			String ngayCap, String noiCap, String ngaySinh, String noiSinh, String doiTuong, String khuVuc,
			String namTotNghiepTHPT, String totNghiepTaiTruongTHPT, String xepLoaiVanHoa, String xepLoaiGiaoDuc,
			String queQuan, String hoKhauThuongTru, String maTinh, String maQuanHuyen, String maPhuongXa,
			String maDanToc, String maTonGiao, String maQuocTich, String maThanhPhanGiaDinh, String dienThoaiDiDong,
			String dienThoaiCoDinh, String dienThoaiGiaDinh, String email, String thongTinBaoTin, String ngayVaoDoan,
			String ngayVaoDang, String maSoHinhAnh, String khiCanBaoTinChoAi, String diaChiKhiCanBaoTinChoAi,
			String bhyt_maTinh, String bhyt_maBenhVien, String bhyt_tenBenhVien, String bhtn_thamgia,
			String bthn_sothang, String soBaoDanh, String diemMon1, String diemMon2, String diemMon3, String diemUuTien,
			String tongDiem, String ngheNghiepTruocKhiVaoTruong, String thanhPhanGiaDinh, String thiTHPTNgay,
			String diaChiNhanThu, String emailPhuHuynh, String tenNganhTrungTuyen, String daKhaiPhieuQuanLySinhVien,
			String daNhapHoc, String maChuyenNganh1, String maChuyenNganh2, Lop lop, String ghiChu, String moTa,
			Date thoiGianCapNhat) {
		super();
		this.maSinhVien = maSinhVien;
		this.ten = ten;
		this.hoDem = hoDem;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.soCMND = soCMND;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.ngaySinh = ngaySinh;
		this.noiSinh = noiSinh;
		this.doiTuong = doiTuong;
		this.khuVuc = khuVuc;
		this.namTotNghiepTHPT = namTotNghiepTHPT;
		this.totNghiepTaiTruongTHPT = totNghiepTaiTruongTHPT;
		this.xepLoaiVanHoa = xepLoaiVanHoa;
		this.xepLoaiGiaoDuc = xepLoaiGiaoDuc;
		this.queQuan = queQuan;
		this.hoKhauThuongTru = hoKhauThuongTru;
		this.maTinh = maTinh;
		this.maQuanHuyen = maQuanHuyen;
		this.maPhuongXa = maPhuongXa;
		this.maDanToc = maDanToc;
		this.maTonGiao = maTonGiao;
		this.maQuocTich = maQuocTich;
		this.maThanhPhanGiaDinh = maThanhPhanGiaDinh;
		this.dienThoaiDiDong = dienThoaiDiDong;
		this.dienThoaiCoDinh = dienThoaiCoDinh;
		this.dienThoaiGiaDinh = dienThoaiGiaDinh;
		this.email = email;
		this.thongTinBaoTin = thongTinBaoTin;
		this.ngayVaoDoan = ngayVaoDoan;
		this.ngayVaoDang = ngayVaoDang;
		this.maSoHinhAnh = maSoHinhAnh;
		this.khiCanBaoTinChoAi = khiCanBaoTinChoAi;
		this.diaChiKhiCanBaoTinChoAi = diaChiKhiCanBaoTinChoAi;
		this.bhyt_maTinh = bhyt_maTinh;
		this.bhyt_maBenhVien = bhyt_maBenhVien;
		this.bhyt_tenBenhVien = bhyt_tenBenhVien;
		this.bhtn_thamgia = bhtn_thamgia;
		this.bthn_sothang = bthn_sothang;
		this.soBaoDanh = soBaoDanh;
		this.diemMon1 = diemMon1;
		this.diemMon2 = diemMon2;
		this.diemMon3 = diemMon3;
		this.diemUuTien = diemUuTien;
		this.tongDiem = tongDiem;
		this.ngheNghiepTruocKhiVaoTruong = ngheNghiepTruocKhiVaoTruong;
		this.thanhPhanGiaDinh = thanhPhanGiaDinh;
		this.thiTHPTNgay = thiTHPTNgay;
		this.diaChiNhanThu = diaChiNhanThu;
		this.emailPhuHuynh = emailPhuHuynh;
		this.tenNganhTrungTuyen = tenNganhTrungTuyen;
		this.daKhaiPhieuQuanLySinhVien = daKhaiPhieuQuanLySinhVien;
		this.daNhapHoc = daNhapHoc;
		this.maChuyenNganh1 = maChuyenNganh1;
		this.maChuyenNganh2 = maChuyenNganh2;
		this.lop = lop;
		this.ghiChu = ghiChu;
		this.moTa = moTa;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bhtn_thamgia == null) ? 0 : bhtn_thamgia.hashCode());
		result = prime * result + ((bhyt_maBenhVien == null) ? 0 : bhyt_maBenhVien.hashCode());
		result = prime * result + ((bhyt_maTinh == null) ? 0 : bhyt_maTinh.hashCode());
		result = prime * result + ((bhyt_tenBenhVien == null) ? 0 : bhyt_tenBenhVien.hashCode());
		result = prime * result + ((bthn_sothang == null) ? 0 : bthn_sothang.hashCode());
		result = prime * result + ((daKhaiPhieuQuanLySinhVien == null) ? 0 : daKhaiPhieuQuanLySinhVien.hashCode());
		result = prime * result + ((daNhapHoc == null) ? 0 : daNhapHoc.hashCode());
		result = prime * result + ((diaChiKhiCanBaoTinChoAi == null) ? 0 : diaChiKhiCanBaoTinChoAi.hashCode());
		result = prime * result + ((diaChiNhanThu == null) ? 0 : diaChiNhanThu.hashCode());
		result = prime * result + ((diemMon1 == null) ? 0 : diemMon1.hashCode());
		result = prime * result + ((diemMon2 == null) ? 0 : diemMon2.hashCode());
		result = prime * result + ((diemMon3 == null) ? 0 : diemMon3.hashCode());
		result = prime * result + ((diemUuTien == null) ? 0 : diemUuTien.hashCode());
		result = prime * result + ((dienThoaiCoDinh == null) ? 0 : dienThoaiCoDinh.hashCode());
		result = prime * result + ((dienThoaiDiDong == null) ? 0 : dienThoaiDiDong.hashCode());
		result = prime * result + ((dienThoaiGiaDinh == null) ? 0 : dienThoaiGiaDinh.hashCode());
		result = prime * result + ((doiTuong == null) ? 0 : doiTuong.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((emailPhuHuynh == null) ? 0 : emailPhuHuynh.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((gioiTinh == null) ? 0 : gioiTinh.hashCode());
		result = prime * result + ((hoDem == null) ? 0 : hoDem.hashCode());
		result = prime * result + ((hoKhauThuongTru == null) ? 0 : hoKhauThuongTru.hashCode());
		result = prime * result + ((hoVaTen == null) ? 0 : hoVaTen.hashCode());
		result = prime * result + ((khiCanBaoTinChoAi == null) ? 0 : khiCanBaoTinChoAi.hashCode());
		result = prime * result + ((khuVuc == null) ? 0 : khuVuc.hashCode());
		result = prime * result + ((lop == null) ? 0 : lop.hashCode());
		result = prime * result + ((maChuyenNganh1 == null) ? 0 : maChuyenNganh1.hashCode());
		result = prime * result + ((maChuyenNganh2 == null) ? 0 : maChuyenNganh2.hashCode());
		result = prime * result + ((maDanToc == null) ? 0 : maDanToc.hashCode());
		result = prime * result + ((maPhuongXa == null) ? 0 : maPhuongXa.hashCode());
		result = prime * result + ((maQuanHuyen == null) ? 0 : maQuanHuyen.hashCode());
		result = prime * result + ((maQuocTich == null) ? 0 : maQuocTich.hashCode());
		result = prime * result + ((maSinhVien == null) ? 0 : maSinhVien.hashCode());
		result = prime * result + ((maSoHinhAnh == null) ? 0 : maSoHinhAnh.hashCode());
		result = prime * result + ((maThanhPhanGiaDinh == null) ? 0 : maThanhPhanGiaDinh.hashCode());
		result = prime * result + ((maTinh == null) ? 0 : maTinh.hashCode());
		result = prime * result + ((maTonGiao == null) ? 0 : maTonGiao.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((namTotNghiepTHPT == null) ? 0 : namTotNghiepTHPT.hashCode());
		result = prime * result + ((ngayCap == null) ? 0 : ngayCap.hashCode());
		result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
		result = prime * result + ((ngayVaoDang == null) ? 0 : ngayVaoDang.hashCode());
		result = prime * result + ((ngayVaoDoan == null) ? 0 : ngayVaoDoan.hashCode());
		result = prime * result + ((ngheNghiepTruocKhiVaoTruong == null) ? 0 : ngheNghiepTruocKhiVaoTruong.hashCode());
		result = prime * result + ((noiCap == null) ? 0 : noiCap.hashCode());
		result = prime * result + ((noiSinh == null) ? 0 : noiSinh.hashCode());
		result = prime * result + ((queQuan == null) ? 0 : queQuan.hashCode());
		result = prime * result + ((soBaoDanh == null) ? 0 : soBaoDanh.hashCode());
		result = prime * result + ((soCMND == null) ? 0 : soCMND.hashCode());
		result = prime * result + ((ten == null) ? 0 : ten.hashCode());
		result = prime * result + ((tenNganhTrungTuyen == null) ? 0 : tenNganhTrungTuyen.hashCode());
		result = prime * result + ((thanhPhanGiaDinh == null) ? 0 : thanhPhanGiaDinh.hashCode());
		result = prime * result + ((thiTHPTNgay == null) ? 0 : thiTHPTNgay.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + ((thongTinBaoTin == null) ? 0 : thongTinBaoTin.hashCode());
		result = prime * result + ((tongDiem == null) ? 0 : tongDiem.hashCode());
		result = prime * result + ((totNghiepTaiTruongTHPT == null) ? 0 : totNghiepTaiTruongTHPT.hashCode());
		result = prime * result + ((xepLoaiGiaoDuc == null) ? 0 : xepLoaiGiaoDuc.hashCode());
		result = prime * result + ((xepLoaiVanHoa == null) ? 0 : xepLoaiVanHoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		if (bhtn_thamgia == null) {
			if (other.bhtn_thamgia != null)
				return false;
		} else if (!bhtn_thamgia.equals(other.bhtn_thamgia))
			return false;
		if (bhyt_maBenhVien == null) {
			if (other.bhyt_maBenhVien != null)
				return false;
		} else if (!bhyt_maBenhVien.equals(other.bhyt_maBenhVien))
			return false;
		if (bhyt_maTinh == null) {
			if (other.bhyt_maTinh != null)
				return false;
		} else if (!bhyt_maTinh.equals(other.bhyt_maTinh))
			return false;
		if (bhyt_tenBenhVien == null) {
			if (other.bhyt_tenBenhVien != null)
				return false;
		} else if (!bhyt_tenBenhVien.equals(other.bhyt_tenBenhVien))
			return false;
		if (bthn_sothang == null) {
			if (other.bthn_sothang != null)
				return false;
		} else if (!bthn_sothang.equals(other.bthn_sothang))
			return false;
		if (daKhaiPhieuQuanLySinhVien == null) {
			if (other.daKhaiPhieuQuanLySinhVien != null)
				return false;
		} else if (!daKhaiPhieuQuanLySinhVien.equals(other.daKhaiPhieuQuanLySinhVien))
			return false;
		if (daNhapHoc == null) {
			if (other.daNhapHoc != null)
				return false;
		} else if (!daNhapHoc.equals(other.daNhapHoc))
			return false;
		if (diaChiKhiCanBaoTinChoAi == null) {
			if (other.diaChiKhiCanBaoTinChoAi != null)
				return false;
		} else if (!diaChiKhiCanBaoTinChoAi.equals(other.diaChiKhiCanBaoTinChoAi))
			return false;
		if (diaChiNhanThu == null) {
			if (other.diaChiNhanThu != null)
				return false;
		} else if (!diaChiNhanThu.equals(other.diaChiNhanThu))
			return false;
		if (diemMon1 == null) {
			if (other.diemMon1 != null)
				return false;
		} else if (!diemMon1.equals(other.diemMon1))
			return false;
		if (diemMon2 == null) {
			if (other.diemMon2 != null)
				return false;
		} else if (!diemMon2.equals(other.diemMon2))
			return false;
		if (diemMon3 == null) {
			if (other.diemMon3 != null)
				return false;
		} else if (!diemMon3.equals(other.diemMon3))
			return false;
		if (diemUuTien == null) {
			if (other.diemUuTien != null)
				return false;
		} else if (!diemUuTien.equals(other.diemUuTien))
			return false;
		if (dienThoaiCoDinh == null) {
			if (other.dienThoaiCoDinh != null)
				return false;
		} else if (!dienThoaiCoDinh.equals(other.dienThoaiCoDinh))
			return false;
		if (dienThoaiDiDong == null) {
			if (other.dienThoaiDiDong != null)
				return false;
		} else if (!dienThoaiDiDong.equals(other.dienThoaiDiDong))
			return false;
		if (dienThoaiGiaDinh == null) {
			if (other.dienThoaiGiaDinh != null)
				return false;
		} else if (!dienThoaiGiaDinh.equals(other.dienThoaiGiaDinh))
			return false;
		if (doiTuong == null) {
			if (other.doiTuong != null)
				return false;
		} else if (!doiTuong.equals(other.doiTuong))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailPhuHuynh == null) {
			if (other.emailPhuHuynh != null)
				return false;
		} else if (!emailPhuHuynh.equals(other.emailPhuHuynh))
			return false;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (gioiTinh == null) {
			if (other.gioiTinh != null)
				return false;
		} else if (!gioiTinh.equals(other.gioiTinh))
			return false;
		if (hoDem == null) {
			if (other.hoDem != null)
				return false;
		} else if (!hoDem.equals(other.hoDem))
			return false;
		if (hoKhauThuongTru == null) {
			if (other.hoKhauThuongTru != null)
				return false;
		} else if (!hoKhauThuongTru.equals(other.hoKhauThuongTru))
			return false;
		if (hoVaTen == null) {
			if (other.hoVaTen != null)
				return false;
		} else if (!hoVaTen.equals(other.hoVaTen))
			return false;
		if (khiCanBaoTinChoAi == null) {
			if (other.khiCanBaoTinChoAi != null)
				return false;
		} else if (!khiCanBaoTinChoAi.equals(other.khiCanBaoTinChoAi))
			return false;
		if (khuVuc == null) {
			if (other.khuVuc != null)
				return false;
		} else if (!khuVuc.equals(other.khuVuc))
			return false;
		if (lop == null) {
			if (other.lop != null)
				return false;
		} else if (!lop.equals(other.lop))
			return false;
		if (maChuyenNganh1 == null) {
			if (other.maChuyenNganh1 != null)
				return false;
		} else if (!maChuyenNganh1.equals(other.maChuyenNganh1))
			return false;
		if (maChuyenNganh2 == null) {
			if (other.maChuyenNganh2 != null)
				return false;
		} else if (!maChuyenNganh2.equals(other.maChuyenNganh2))
			return false;
		if (maDanToc == null) {
			if (other.maDanToc != null)
				return false;
		} else if (!maDanToc.equals(other.maDanToc))
			return false;
		if (maPhuongXa == null) {
			if (other.maPhuongXa != null)
				return false;
		} else if (!maPhuongXa.equals(other.maPhuongXa))
			return false;
		if (maQuanHuyen == null) {
			if (other.maQuanHuyen != null)
				return false;
		} else if (!maQuanHuyen.equals(other.maQuanHuyen))
			return false;
		if (maQuocTich == null) {
			if (other.maQuocTich != null)
				return false;
		} else if (!maQuocTich.equals(other.maQuocTich))
			return false;
		if (maSinhVien == null) {
			if (other.maSinhVien != null)
				return false;
		} else if (!maSinhVien.equals(other.maSinhVien))
			return false;
		if (maSoHinhAnh == null) {
			if (other.maSoHinhAnh != null)
				return false;
		} else if (!maSoHinhAnh.equals(other.maSoHinhAnh))
			return false;
		if (maThanhPhanGiaDinh == null) {
			if (other.maThanhPhanGiaDinh != null)
				return false;
		} else if (!maThanhPhanGiaDinh.equals(other.maThanhPhanGiaDinh))
			return false;
		if (maTinh == null) {
			if (other.maTinh != null)
				return false;
		} else if (!maTinh.equals(other.maTinh))
			return false;
		if (maTonGiao == null) {
			if (other.maTonGiao != null)
				return false;
		} else if (!maTonGiao.equals(other.maTonGiao))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (namTotNghiepTHPT == null) {
			if (other.namTotNghiepTHPT != null)
				return false;
		} else if (!namTotNghiepTHPT.equals(other.namTotNghiepTHPT))
			return false;
		if (ngayCap == null) {
			if (other.ngayCap != null)
				return false;
		} else if (!ngayCap.equals(other.ngayCap))
			return false;
		if (ngaySinh == null) {
			if (other.ngaySinh != null)
				return false;
		} else if (!ngaySinh.equals(other.ngaySinh))
			return false;
		if (ngayVaoDang == null) {
			if (other.ngayVaoDang != null)
				return false;
		} else if (!ngayVaoDang.equals(other.ngayVaoDang))
			return false;
		if (ngayVaoDoan == null) {
			if (other.ngayVaoDoan != null)
				return false;
		} else if (!ngayVaoDoan.equals(other.ngayVaoDoan))
			return false;
		if (ngheNghiepTruocKhiVaoTruong == null) {
			if (other.ngheNghiepTruocKhiVaoTruong != null)
				return false;
		} else if (!ngheNghiepTruocKhiVaoTruong.equals(other.ngheNghiepTruocKhiVaoTruong))
			return false;
		if (noiCap == null) {
			if (other.noiCap != null)
				return false;
		} else if (!noiCap.equals(other.noiCap))
			return false;
		if (noiSinh == null) {
			if (other.noiSinh != null)
				return false;
		} else if (!noiSinh.equals(other.noiSinh))
			return false;
		if (queQuan == null) {
			if (other.queQuan != null)
				return false;
		} else if (!queQuan.equals(other.queQuan))
			return false;
		if (soBaoDanh == null) {
			if (other.soBaoDanh != null)
				return false;
		} else if (!soBaoDanh.equals(other.soBaoDanh))
			return false;
		if (soCMND == null) {
			if (other.soCMND != null)
				return false;
		} else if (!soCMND.equals(other.soCMND))
			return false;
		if (ten == null) {
			if (other.ten != null)
				return false;
		} else if (!ten.equals(other.ten))
			return false;
		if (tenNganhTrungTuyen == null) {
			if (other.tenNganhTrungTuyen != null)
				return false;
		} else if (!tenNganhTrungTuyen.equals(other.tenNganhTrungTuyen))
			return false;
		if (thanhPhanGiaDinh == null) {
			if (other.thanhPhanGiaDinh != null)
				return false;
		} else if (!thanhPhanGiaDinh.equals(other.thanhPhanGiaDinh))
			return false;
		if (thiTHPTNgay == null) {
			if (other.thiTHPTNgay != null)
				return false;
		} else if (!thiTHPTNgay.equals(other.thiTHPTNgay))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		if (thongTinBaoTin == null) {
			if (other.thongTinBaoTin != null)
				return false;
		} else if (!thongTinBaoTin.equals(other.thongTinBaoTin))
			return false;
		if (tongDiem == null) {
			if (other.tongDiem != null)
				return false;
		} else if (!tongDiem.equals(other.tongDiem))
			return false;
		if (totNghiepTaiTruongTHPT == null) {
			if (other.totNghiepTaiTruongTHPT != null)
				return false;
		} else if (!totNghiepTaiTruongTHPT.equals(other.totNghiepTaiTruongTHPT))
			return false;
		if (xepLoaiGiaoDuc == null) {
			if (other.xepLoaiGiaoDuc != null)
				return false;
		} else if (!xepLoaiGiaoDuc.equals(other.xepLoaiGiaoDuc))
			return false;
		if (xepLoaiVanHoa == null) {
			if (other.xepLoaiVanHoa != null)
				return false;
		} else if (!xepLoaiVanHoa.equals(other.xepLoaiVanHoa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SinhVien [maSinhVien=" + maSinhVien + ", ten=" + ten + ", hoDem=" + hoDem + ", hoVaTen=" + hoVaTen
				+ ", gioiTinh=" + gioiTinh + ", soCMND=" + soCMND + ", ngayCap=" + ngayCap + ", noiCap=" + noiCap
				+ ", ngaySinh=" + ngaySinh + ", noiSinh=" + noiSinh + ", doiTuong=" + doiTuong + ", khuVuc=" + khuVuc
				+ ", namTotNghiepTHPT=" + namTotNghiepTHPT + ", totNghiepTaiTruongTHPT=" + totNghiepTaiTruongTHPT
				+ ", xepLoaiVanHoa=" + xepLoaiVanHoa + ", xepLoaiGiaoDuc=" + xepLoaiGiaoDuc + ", queQuan=" + queQuan
				+ ", hoKhauThuongTru=" + hoKhauThuongTru + ", maTinh=" + maTinh + ", maQuanHuyen=" + maQuanHuyen
				+ ", maPhuongXa=" + maPhuongXa + ", maDanToc=" + maDanToc + ", maTonGiao=" + maTonGiao + ", maQuocTich="
				+ maQuocTich + ", maThanhPhanGiaDinh=" + maThanhPhanGiaDinh + ", dienThoaiDiDong=" + dienThoaiDiDong
				+ ", dienThoaiCoDinh=" + dienThoaiCoDinh + ", dienThoaiGiaDinh=" + dienThoaiGiaDinh + ", email=" + email
				+ ", thongTinBaoTin=" + thongTinBaoTin + ", ngayVaoDoan=" + ngayVaoDoan + ", ngayVaoDang=" + ngayVaoDang
				+ ", maSoHinhAnh=" + maSoHinhAnh + ", khiCanBaoTinChoAi=" + khiCanBaoTinChoAi
				+ ", diaChiKhiCanBaoTinChoAi=" + diaChiKhiCanBaoTinChoAi + ", bhyt_maTinh=" + bhyt_maTinh
				+ ", bhyt_maBenhVien=" + bhyt_maBenhVien + ", bhyt_tenBenhVien=" + bhyt_tenBenhVien + ", bhtn_thamgia="
				+ bhtn_thamgia + ", bthn_sothang=" + bthn_sothang + ", soBaoDanh=" + soBaoDanh + ", diemMon1="
				+ diemMon1 + ", diemMon2=" + diemMon2 + ", diemMon3=" + diemMon3 + ", diemUuTien=" + diemUuTien
				+ ", tongDiem=" + tongDiem + ", ngheNghiepTruocKhiVaoTruong=" + ngheNghiepTruocKhiVaoTruong
				+ ", thanhPhanGiaDinh=" + thanhPhanGiaDinh + ", thiTHPTNgay=" + thiTHPTNgay + ", diaChiNhanThu="
				+ diaChiNhanThu + ", emailPhuHuynh=" + emailPhuHuynh + ", tenNganhTrungTuyen=" + tenNganhTrungTuyen
				+ ", daKhaiPhieuQuanLySinhVien=" + daKhaiPhieuQuanLySinhVien + ", daNhapHoc=" + daNhapHoc
				+ ", maChuyenNganh1=" + maChuyenNganh1 + ", maChuyenNganh2=" + maChuyenNganh2 + ", lop=" + lop
				+ ", ghiChu=" + ghiChu + ", moTa=" + moTa + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	@Override
	public int compareTo(SinhVien o) {
		return this.maSinhVien.compareTo(o.maSinhVien);
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(String ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getDoiTuong() {
		return doiTuong;
	}

	public void setDoiTuong(String doiTuong) {
		this.doiTuong = doiTuong;
	}

	public String getKhuVuc() {
		return khuVuc;
	}

	public void setKhuVuc(String khuVuc) {
		this.khuVuc = khuVuc;
	}

	public String getNamTotNghiepTHPT() {
		return namTotNghiepTHPT;
	}

	public void setNamTotNghiepTHPT(String namTotNghiepTHPT) {
		this.namTotNghiepTHPT = namTotNghiepTHPT;
	}

	public String getTotNghiepTaiTruongTHPT() {
		return totNghiepTaiTruongTHPT;
	}

	public void setTotNghiepTaiTruongTHPT(String totNghiepTaiTruongTHPT) {
		this.totNghiepTaiTruongTHPT = totNghiepTaiTruongTHPT;
	}

	public String getXepLoaiVanHoa() {
		return xepLoaiVanHoa;
	}

	public void setXepLoaiVanHoa(String xepLoaiVanHoa) {
		this.xepLoaiVanHoa = xepLoaiVanHoa;
	}

	public String getXepLoaiGiaoDuc() {
		return xepLoaiGiaoDuc;
	}

	public void setXepLoaiGiaoDuc(String xepLoaiGiaoDuc) {
		this.xepLoaiGiaoDuc = xepLoaiGiaoDuc;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getHoKhauThuongTru() {
		return hoKhauThuongTru;
	}

	public void setHoKhauThuongTru(String hoKhauThuongTru) {
		this.hoKhauThuongTru = hoKhauThuongTru;
	}

	public String getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(String maTinh) {
		this.maTinh = maTinh;
	}

	public String getMaQuanHuyen() {
		return maQuanHuyen;
	}

	public void setMaQuanHuyen(String maQuanHuyen) {
		this.maQuanHuyen = maQuanHuyen;
	}

	public String getMaPhuongXa() {
		return maPhuongXa;
	}

	public void setMaPhuongXa(String maPhuongXa) {
		this.maPhuongXa = maPhuongXa;
	}

	public String getMaDanToc() {
		return maDanToc;
	}

	public void setMaDanToc(String maDanToc) {
		this.maDanToc = maDanToc;
	}

	public String getMaTonGiao() {
		return maTonGiao;
	}

	public void setMaTonGiao(String maTonGiao) {
		this.maTonGiao = maTonGiao;
	}

	public String getMaQuocTich() {
		return maQuocTich;
	}

	public void setMaQuocTich(String maQuocTich) {
		this.maQuocTich = maQuocTich;
	}

	public String getMaThanhPhanGiaDinh() {
		return maThanhPhanGiaDinh;
	}

	public void setMaThanhPhanGiaDinh(String maThanhPhanGiaDinh) {
		this.maThanhPhanGiaDinh = maThanhPhanGiaDinh;
	}

	public String getDienThoaiDiDong() {
		return dienThoaiDiDong;
	}

	public void setDienThoaiDiDong(String dienThoaiDiDong) {
		this.dienThoaiDiDong = dienThoaiDiDong;
	}

	public String getDienThoaiCoDinh() {
		return dienThoaiCoDinh;
	}

	public void setDienThoaiCoDinh(String dienThoaiCoDinh) {
		this.dienThoaiCoDinh = dienThoaiCoDinh;
	}

	public String getDienThoaiGiaDinh() {
		return dienThoaiGiaDinh;
	}

	public void setDienThoaiGiaDinh(String dienThoaiGiaDinh) {
		this.dienThoaiGiaDinh = dienThoaiGiaDinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getThongTinBaoTin() {
		return thongTinBaoTin;
	}

	public void setThongTinBaoTin(String thongTinBaoTin) {
		this.thongTinBaoTin = thongTinBaoTin;
	}

	public String getNgayVaoDoan() {
		return ngayVaoDoan;
	}

	public void setNgayVaoDoan(String ngayVaoDoan) {
		this.ngayVaoDoan = ngayVaoDoan;
	}

	public String getNgayVaoDang() {
		return ngayVaoDang;
	}

	public void setNgayVaoDang(String ngayVaoDang) {
		this.ngayVaoDang = ngayVaoDang;
	}

	public String getMaSoHinhAnh() {
		return maSoHinhAnh;
	}

	public void setMaSoHinhAnh(String maSoHinhAnh) {
		this.maSoHinhAnh = maSoHinhAnh;
	}

	public String getKhiCanBaoTinChoAi() {
		return khiCanBaoTinChoAi;
	}

	public void setKhiCanBaoTinChoAi(String khiCanBaoTinChoAi) {
		this.khiCanBaoTinChoAi = khiCanBaoTinChoAi;
	}

	public String getDiaChiKhiCanBaoTinChoAi() {
		return diaChiKhiCanBaoTinChoAi;
	}

	public void setDiaChiKhiCanBaoTinChoAi(String diaChiKhiCanBaoTinChoAi) {
		this.diaChiKhiCanBaoTinChoAi = diaChiKhiCanBaoTinChoAi;
	}

	public String getBhyt_maTinh() {
		return bhyt_maTinh;
	}

	public void setBhyt_maTinh(String bhyt_maTinh) {
		this.bhyt_maTinh = bhyt_maTinh;
	}

	public String getBhyt_maBenhVien() {
		return bhyt_maBenhVien;
	}

	public void setBhyt_maBenhVien(String bhyt_maBenhVien) {
		this.bhyt_maBenhVien = bhyt_maBenhVien;
	}

	public String getBhyt_tenBenhVien() {
		return bhyt_tenBenhVien;
	}

	public void setBhyt_tenBenhVien(String bhyt_tenBenhVien) {
		this.bhyt_tenBenhVien = bhyt_tenBenhVien;
	}

	public String getBhtn_thamgia() {
		return bhtn_thamgia;
	}

	public void setBhtn_thamgia(String bhtn_thamgia) {
		this.bhtn_thamgia = bhtn_thamgia;
	}

	public String getBthn_sothang() {
		return bthn_sothang;
	}

	public void setBthn_sothang(String bthn_sothang) {
		this.bthn_sothang = bthn_sothang;
	}

	public String getSoBaoDanh() {
		return soBaoDanh;
	}

	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}

	public String getDiemMon1() {
		return diemMon1;
	}

	public void setDiemMon1(String diemMon1) {
		this.diemMon1 = diemMon1;
	}

	public String getDiemMon2() {
		return diemMon2;
	}

	public void setDiemMon2(String diemMon2) {
		this.diemMon2 = diemMon2;
	}

	public String getDiemMon3() {
		return diemMon3;
	}

	public void setDiemMon3(String diemMon3) {
		this.diemMon3 = diemMon3;
	}

	public String getDiemUuTien() {
		return diemUuTien;
	}

	public void setDiemUuTien(String diemUuTien) {
		this.diemUuTien = diemUuTien;
	}

	public String getTongDiem() {
		return tongDiem;
	}

	public void setTongDiem(String tongDiem) {
		this.tongDiem = tongDiem;
	}

	public String getNgheNghiepTruocKhiVaoTruong() {
		return ngheNghiepTruocKhiVaoTruong;
	}

	public void setNgheNghiepTruocKhiVaoTruong(String ngheNghiepTruocKhiVaoTruong) {
		this.ngheNghiepTruocKhiVaoTruong = ngheNghiepTruocKhiVaoTruong;
	}

	public String getThanhPhanGiaDinh() {
		return thanhPhanGiaDinh;
	}

	public void setThanhPhanGiaDinh(String thanhPhanGiaDinh) {
		this.thanhPhanGiaDinh = thanhPhanGiaDinh;
	}

	public String getThiTHPTNgay() {
		return thiTHPTNgay;
	}

	public void setThiTHPTNgay(String thiTHPTNgay) {
		this.thiTHPTNgay = thiTHPTNgay;
	}

	public String getDiaChiNhanThu() {
		return diaChiNhanThu;
	}

	public void setDiaChiNhanThu(String diaChiNhanThu) {
		this.diaChiNhanThu = diaChiNhanThu;
	}

	public String getEmailPhuHuynh() {
		return emailPhuHuynh;
	}

	public void setEmailPhuHuynh(String emailPhuHuynh) {
		this.emailPhuHuynh = emailPhuHuynh;
	}

	public String getTenNganhTrungTuyen() {
		return tenNganhTrungTuyen;
	}

	public void setTenNganhTrungTuyen(String tenNganhTrungTuyen) {
		this.tenNganhTrungTuyen = tenNganhTrungTuyen;
	}

	public String getDaKhaiPhieuQuanLySinhVien() {
		return daKhaiPhieuQuanLySinhVien;
	}

	public void setDaKhaiPhieuQuanLySinhVien(String daKhaiPhieuQuanLySinhVien) {
		this.daKhaiPhieuQuanLySinhVien = daKhaiPhieuQuanLySinhVien;
	}

	public String getDaNhapHoc() {
		return daNhapHoc;
	}

	public void setDaNhapHoc(String daNhapHoc) {
		this.daNhapHoc = daNhapHoc;
	}

	public String getMaChuyenNganh1() {
		return maChuyenNganh1;
	}

	public void setMaChuyenNganh1(String maChuyenNganh1) {
		this.maChuyenNganh1 = maChuyenNganh1;
	}

	public String getMaChuyenNganh2() {
		return maChuyenNganh2;
	}

	public void setMaChuyenNganh2(String maChuyenNganh2) {
		this.maChuyenNganh2 = maChuyenNganh2;
	}

	public Lop getLop() {
		return lop;
	}

	public void setLop(Lop lop) {
		this.lop = lop;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public Date getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}

	public void setThoiGianCapNhat(Date thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

}

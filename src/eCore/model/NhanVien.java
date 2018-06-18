package eCore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class NhanVien implements Comparable<NhanVien> {
	@Id
	public String maNhanVien; // CMND, SDT, TKEMail
	public String tenNhanVien;
	public String hinhAnh;
	public Date ngaySinh;
	public String gioiTinh;
	public String noiSinh;
	public String queQuan;
	public String danToc;
	public String tonGiao;
	public String hoKhauThuongTru;
	public String noiOHienTai;
	public String ngheNghiepTruocKhiTuyenDung;
	public Date ngayTuyenDung;
	public String chucVu;
	public String congViecChinhDuocGiao;
	public String ngachCongChuc;
	public String maNgach;
	public String bacLuong;
	public String heSo;
	public Date ngayHuong;
	public String trinhDoGiaoDucPhoThong;
	public String trinhDoChuyenMonCaoNhat;
	public String lyLuanChinhTri;
	public String quanLyNhaNuoc;
	public String ngoaiNgu;
	public String tinHoc;
	public Date ngayVaoDangDuBi;
	public Date ngayVaoDangChinhThuc;
	public String thamGiaToChucChinhTriXaHoi;
	public Date ngayNhapNgu;
	public Date ngayXuatNgu;
	public String quanHamCaoNhat;
	public String danhHieuDuocPhongTangCaoNhat;
	public String soTruongCongTac;
	@Type(type = "text")
	public String khenThuong;
	@Type(type = "text")
	public String kyLuat;
	public String tinhTrangSucKhoe;
	public String laConThuongBinh;
	public String laConGiaDinhChinhSach;
	public String soCMND;
	public Date ngayCapCMND;
	public String noiCapCMND;
	public String soHoChieu;
	public Date ngayCapHoChieu;
	public String noiCapHoChieu;
	public String soSoBaoHiemXaHoi;
	@Type(type = "text")
	public String quaTrinhDaoTao;
	@Type(type = "text")
	public String quaTrinhCongTac;
	@Type(type = "text")
	public String dacDiemLichSuBanThan;
	@Type(type = "text")
	public String quanHeVoiGiaDinh;
	@Type(type = "text")
	public String hoanCanhKinhTeGiaDinh;
	@Type(type = "text")
	public String nhanXetDanhGiaCuaCoQuan;
	public String email;
	public String soDienThoaiDiDong;
	public String soDienThoaiCoQuan;
	public String diaChiLienHe;
	public String diaChiBaoTin;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	@ManyToOne(fetch = FetchType.EAGER)
	public DonVi donVi;
	public Date thoiGianCapNhat;

	public NhanVien() {
	}

	public NhanVien(String maNhanVien, String tenNhanVien, String hinhAnh, Date ngaySinh, String gioiTinh,
			String noiSinh, String queQuan, String danToc, String tonGiao, String hoKhauThuongTru, String noiOHienTai,
			String ngheNghiepTruocKhiTuyenDung, Date ngayTuyenDung, String chucVu, String congViecChinhDuocGiao,
			String ngachCongChuc, String maNgach, String bacLuong, String heSo, Date ngayHuong,
			String trinhDoGiaoDucPhoThong, String trinhDoChuyenMonCaoNhat, String lyLuanChinhTri, String quanLyNhaNuoc,
			String ngoaiNgu, String tinHoc, Date ngayVaoDangDuBi, Date ngayVaoDangChinhThuc,
			String thamGiaToChucChinhTriXaHoi, Date ngayNhapNgu, Date ngayXuatNgu, String quanHamCaoNhat,
			String danhHieuDuocPhongTangCaoNhat, String soTruongCongTac, String khenThuong, String kyLuat,
			String tinhTrangSucKhoe, String laConThuongBinh, String laConGiaDinhChinhSach, String soCMND,
			Date ngayCapCMND, String noiCapCMND, String soHoChieu, Date ngayCapHoChieu, String noiCapHoChieu,
			String soSoBaoHiemXaHoi, String quaTrinhDaoTao, String quaTrinhCongTac, String dacDiemLichSuBanThan,
			String quanHeVoiGiaDinh, String hoanCanhKinhTeGiaDinh, String nhanXetDanhGiaCuaCoQuan, String email,
			String soDienThoaiDiDong, String soDienThoaiCoQuan, String diaChiLienHe, String diaChiBaoTin, String moTa,
			String ghiChu, DonVi donVi, Date thoiGianCapNhat) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.hinhAnh = hinhAnh;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.noiSinh = noiSinh;
		this.queQuan = queQuan;
		this.danToc = danToc;
		this.tonGiao = tonGiao;
		this.hoKhauThuongTru = hoKhauThuongTru;
		this.noiOHienTai = noiOHienTai;
		this.ngheNghiepTruocKhiTuyenDung = ngheNghiepTruocKhiTuyenDung;
		this.ngayTuyenDung = ngayTuyenDung;
		this.chucVu = chucVu;
		this.congViecChinhDuocGiao = congViecChinhDuocGiao;
		this.ngachCongChuc = ngachCongChuc;
		this.maNgach = maNgach;
		this.bacLuong = bacLuong;
		this.heSo = heSo;
		this.ngayHuong = ngayHuong;
		this.trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThong;
		this.trinhDoChuyenMonCaoNhat = trinhDoChuyenMonCaoNhat;
		this.lyLuanChinhTri = lyLuanChinhTri;
		this.quanLyNhaNuoc = quanLyNhaNuoc;
		this.ngoaiNgu = ngoaiNgu;
		this.tinHoc = tinHoc;
		this.ngayVaoDangDuBi = ngayVaoDangDuBi;
		this.ngayVaoDangChinhThuc = ngayVaoDangChinhThuc;
		this.thamGiaToChucChinhTriXaHoi = thamGiaToChucChinhTriXaHoi;
		this.ngayNhapNgu = ngayNhapNgu;
		this.ngayXuatNgu = ngayXuatNgu;
		this.quanHamCaoNhat = quanHamCaoNhat;
		this.danhHieuDuocPhongTangCaoNhat = danhHieuDuocPhongTangCaoNhat;
		this.soTruongCongTac = soTruongCongTac;
		this.khenThuong = khenThuong;
		this.kyLuat = kyLuat;
		this.tinhTrangSucKhoe = tinhTrangSucKhoe;
		this.laConThuongBinh = laConThuongBinh;
		this.laConGiaDinhChinhSach = laConGiaDinhChinhSach;
		this.soCMND = soCMND;
		this.ngayCapCMND = ngayCapCMND;
		this.noiCapCMND = noiCapCMND;
		this.soHoChieu = soHoChieu;
		this.ngayCapHoChieu = ngayCapHoChieu;
		this.noiCapHoChieu = noiCapHoChieu;
		this.soSoBaoHiemXaHoi = soSoBaoHiemXaHoi;
		this.quaTrinhDaoTao = quaTrinhDaoTao;
		this.quaTrinhCongTac = quaTrinhCongTac;
		this.dacDiemLichSuBanThan = dacDiemLichSuBanThan;
		this.quanHeVoiGiaDinh = quanHeVoiGiaDinh;
		this.hoanCanhKinhTeGiaDinh = hoanCanhKinhTeGiaDinh;
		this.nhanXetDanhGiaCuaCoQuan = nhanXetDanhGiaCuaCoQuan;
		this.email = email;
		this.soDienThoaiDiDong = soDienThoaiDiDong;
		this.soDienThoaiCoQuan = soDienThoaiCoQuan;
		this.diaChiLienHe = diaChiLienHe;
		this.diaChiBaoTin = diaChiBaoTin;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.donVi = donVi;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getDanToc() {
		return danToc;
	}

	public void setDanToc(String danToc) {
		this.danToc = danToc;
	}

	public String getTonGiao() {
		return tonGiao;
	}

	public void setTonGiao(String tonGiao) {
		this.tonGiao = tonGiao;
	}

	public String getHoKhauThuongTru() {
		return hoKhauThuongTru;
	}

	public void setHoKhauThuongTru(String hoKhauThuongTru) {
		this.hoKhauThuongTru = hoKhauThuongTru;
	}

	public String getNoiOHienTai() {
		return noiOHienTai;
	}

	public void setNoiOHienTai(String noiOHienTai) {
		this.noiOHienTai = noiOHienTai;
	}

	public String getNgheNghiepTruocKhiTuyenDung() {
		return ngheNghiepTruocKhiTuyenDung;
	}

	public void setNgheNghiepTruocKhiTuyenDung(String ngheNghiepTruocKhiTuyenDung) {
		this.ngheNghiepTruocKhiTuyenDung = ngheNghiepTruocKhiTuyenDung;
	}

	public Date getNgayTuyenDung() {
		return ngayTuyenDung;
	}

	public void setNgayTuyenDung(Date ngayTuyenDung) {
		this.ngayTuyenDung = ngayTuyenDung;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getCongViecChinhDuocGiao() {
		return congViecChinhDuocGiao;
	}

	public void setCongViecChinhDuocGiao(String congViecChinhDuocGiao) {
		this.congViecChinhDuocGiao = congViecChinhDuocGiao;
	}

	public String getNgachCongChuc() {
		return ngachCongChuc;
	}

	public void setNgachCongChuc(String ngachCongChuc) {
		this.ngachCongChuc = ngachCongChuc;
	}

	public String getMaNgach() {
		return maNgach;
	}

	public void setMaNgach(String maNgach) {
		this.maNgach = maNgach;
	}

	public String getBacLuong() {
		return bacLuong;
	}

	public void setBacLuong(String bacLuong) {
		this.bacLuong = bacLuong;
	}

	public String getHeSo() {
		return heSo;
	}

	public void setHeSo(String heSo) {
		this.heSo = heSo;
	}

	public Date getNgayHuong() {
		return ngayHuong;
	}

	public void setNgayHuong(Date ngayHuong) {
		this.ngayHuong = ngayHuong;
	}

	public String getTrinhDoGiaoDucPhoThong() {
		return trinhDoGiaoDucPhoThong;
	}

	public void setTrinhDoGiaoDucPhoThong(String trinhDoGiaoDucPhoThong) {
		this.trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThong;
	}

	public String getTrinhDoChuyenMonCaoNhat() {
		return trinhDoChuyenMonCaoNhat;
	}

	public void setTrinhDoChuyenMonCaoNhat(String trinhDoChuyenMonCaoNhat) {
		this.trinhDoChuyenMonCaoNhat = trinhDoChuyenMonCaoNhat;
	}

	public String getLyLuanChinhTri() {
		return lyLuanChinhTri;
	}

	public void setLyLuanChinhTri(String lyLuanChinhTri) {
		this.lyLuanChinhTri = lyLuanChinhTri;
	}

	public String getQuanLyNhaNuoc() {
		return quanLyNhaNuoc;
	}

	public void setQuanLyNhaNuoc(String quanLyNhaNuoc) {
		this.quanLyNhaNuoc = quanLyNhaNuoc;
	}

	public String getNgoaiNgu() {
		return ngoaiNgu;
	}

	public void setNgoaiNgu(String ngoaiNgu) {
		this.ngoaiNgu = ngoaiNgu;
	}

	public String getTinHoc() {
		return tinHoc;
	}

	public void setTinHoc(String tinHoc) {
		this.tinHoc = tinHoc;
	}

	public Date getNgayVaoDangDuBi() {
		return ngayVaoDangDuBi;
	}

	public void setNgayVaoDangDuBi(Date ngayVaoDangDuBi) {
		this.ngayVaoDangDuBi = ngayVaoDangDuBi;
	}

	public Date getNgayVaoDangChinhThuc() {
		return ngayVaoDangChinhThuc;
	}

	public void setNgayVaoDangChinhThuc(Date ngayVaoDangChinhThuc) {
		this.ngayVaoDangChinhThuc = ngayVaoDangChinhThuc;
	}

	public String getThamGiaToChucChinhTriXaHoi() {
		return thamGiaToChucChinhTriXaHoi;
	}

	public void setThamGiaToChucChinhTriXaHoi(String thamGiaToChucChinhTriXaHoi) {
		this.thamGiaToChucChinhTriXaHoi = thamGiaToChucChinhTriXaHoi;
	}

	public Date getNgayNhapNgu() {
		return ngayNhapNgu;
	}

	public void setNgayNhapNgu(Date ngayNhapNgu) {
		this.ngayNhapNgu = ngayNhapNgu;
	}

	public Date getNgayXuatNgu() {
		return ngayXuatNgu;
	}

	public void setNgayXuatNgu(Date ngayXuatNgu) {
		this.ngayXuatNgu = ngayXuatNgu;
	}

	public String getQuanHamCaoNhat() {
		return quanHamCaoNhat;
	}

	public void setQuanHamCaoNhat(String quanHamCaoNhat) {
		this.quanHamCaoNhat = quanHamCaoNhat;
	}

	public String getDanhHieuDuocPhongTangCaoNhat() {
		return danhHieuDuocPhongTangCaoNhat;
	}

	public void setDanhHieuDuocPhongTangCaoNhat(String danhHieuDuocPhongTangCaoNhat) {
		this.danhHieuDuocPhongTangCaoNhat = danhHieuDuocPhongTangCaoNhat;
	}

	public String getSoTruongCongTac() {
		return soTruongCongTac;
	}

	public void setSoTruongCongTac(String soTruongCongTac) {
		this.soTruongCongTac = soTruongCongTac;
	}

	public String getKhenThuong() {
		return khenThuong;
	}

	public void setKhenThuong(String khenThuong) {
		this.khenThuong = khenThuong;
	}

	public String getKyLuat() {
		return kyLuat;
	}

	public void setKyLuat(String kyLuat) {
		this.kyLuat = kyLuat;
	}

	public String getTinhTrangSucKhoe() {
		return tinhTrangSucKhoe;
	}

	public void setTinhTrangSucKhoe(String tinhTrangSucKhoe) {
		this.tinhTrangSucKhoe = tinhTrangSucKhoe;
	}

	public String getLaConThuongBinh() {
		return laConThuongBinh;
	}

	public void setLaConThuongBinh(String laConThuongBinh) {
		this.laConThuongBinh = laConThuongBinh;
	}

	public String getLaConGiaDinhChinhSach() {
		return laConGiaDinhChinhSach;
	}

	public void setLaConGiaDinhChinhSach(String laConGiaDinhChinhSach) {
		this.laConGiaDinhChinhSach = laConGiaDinhChinhSach;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public Date getNgayCapCMND() {
		return ngayCapCMND;
	}

	public void setNgayCapCMND(Date ngayCapCMND) {
		this.ngayCapCMND = ngayCapCMND;
	}

	public String getNoiCapCMND() {
		return noiCapCMND;
	}

	public void setNoiCapCMND(String noiCapCMND) {
		this.noiCapCMND = noiCapCMND;
	}

	public String getSoHoChieu() {
		return soHoChieu;
	}

	public void setSoHoChieu(String soHoChieu) {
		this.soHoChieu = soHoChieu;
	}

	public Date getNgayCapHoChieu() {
		return ngayCapHoChieu;
	}

	public void setNgayCapHoChieu(Date ngayCapHoChieu) {
		this.ngayCapHoChieu = ngayCapHoChieu;
	}

	public String getNoiCapHoChieu() {
		return noiCapHoChieu;
	}

	public void setNoiCapHoChieu(String noiCapHoChieu) {
		this.noiCapHoChieu = noiCapHoChieu;
	}

	public String getSoSoBaoHiemXaHoi() {
		return soSoBaoHiemXaHoi;
	}

	public void setSoSoBaoHiemXaHoi(String soSoBaoHiemXaHoi) {
		this.soSoBaoHiemXaHoi = soSoBaoHiemXaHoi;
	}

	public String getQuaTrinhDaoTao() {
		return quaTrinhDaoTao;
	}

	public void setQuaTrinhDaoTao(String quaTrinhDaoTao) {
		this.quaTrinhDaoTao = quaTrinhDaoTao;
	}

	public String getQuaTrinhCongTac() {
		return quaTrinhCongTac;
	}

	public void setQuaTrinhCongTac(String quaTrinhCongTac) {
		this.quaTrinhCongTac = quaTrinhCongTac;
	}

	public String getDacDiemLichSuBanThan() {
		return dacDiemLichSuBanThan;
	}

	public void setDacDiemLichSuBanThan(String dacDiemLichSuBanThan) {
		this.dacDiemLichSuBanThan = dacDiemLichSuBanThan;
	}

	public String getQuanHeVoiGiaDinh() {
		return quanHeVoiGiaDinh;
	}

	public void setQuanHeVoiGiaDinh(String quanHeVoiGiaDinh) {
		this.quanHeVoiGiaDinh = quanHeVoiGiaDinh;
	}

	public String getHoanCanhKinhTeGiaDinh() {
		return hoanCanhKinhTeGiaDinh;
	}

	public void setHoanCanhKinhTeGiaDinh(String hoanCanhKinhTeGiaDinh) {
		this.hoanCanhKinhTeGiaDinh = hoanCanhKinhTeGiaDinh;
	}

	public String getNhanXetDanhGiaCuaCoQuan() {
		return nhanXetDanhGiaCuaCoQuan;
	}

	public void setNhanXetDanhGiaCuaCoQuan(String nhanXetDanhGiaCuaCoQuan) {
		this.nhanXetDanhGiaCuaCoQuan = nhanXetDanhGiaCuaCoQuan;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoaiDiDong() {
		return soDienThoaiDiDong;
	}

	public void setSoDienThoaiDiDong(String soDienThoaiDiDong) {
		this.soDienThoaiDiDong = soDienThoaiDiDong;
	}

	public String getSoDienThoaiCoQuan() {
		return soDienThoaiCoQuan;
	}

	public void setSoDienThoaiCoQuan(String soDienThoaiCoQuan) {
		this.soDienThoaiCoQuan = soDienThoaiCoQuan;
	}

	public String getDiaChiLienHe() {
		return diaChiLienHe;
	}

	public void setDiaChiLienHe(String diaChiLienHe) {
		this.diaChiLienHe = diaChiLienHe;
	}

	public String getDiaChiBaoTin() {
		return diaChiBaoTin;
	}

	public void setDiaChiBaoTin(String diaChiBaoTin) {
		this.diaChiBaoTin = diaChiBaoTin;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public DonVi getDonVi() {
		return donVi;
	}

	public void setDonVi(DonVi donVi) {
		this.donVi = donVi;
	}

	public Date getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}

	public void setThoiGianCapNhat(Date thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bacLuong == null) ? 0 : bacLuong.hashCode());
		result = prime * result + ((chucVu == null) ? 0 : chucVu.hashCode());
		result = prime * result + ((congViecChinhDuocGiao == null) ? 0 : congViecChinhDuocGiao.hashCode());
		result = prime * result + ((dacDiemLichSuBanThan == null) ? 0 : dacDiemLichSuBanThan.hashCode());
		result = prime * result + ((danToc == null) ? 0 : danToc.hashCode());
		result = prime * result
				+ ((danhHieuDuocPhongTangCaoNhat == null) ? 0 : danhHieuDuocPhongTangCaoNhat.hashCode());
		result = prime * result + ((diaChiBaoTin == null) ? 0 : diaChiBaoTin.hashCode());
		result = prime * result + ((diaChiLienHe == null) ? 0 : diaChiLienHe.hashCode());
		result = prime * result + ((donVi == null) ? 0 : donVi.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((gioiTinh == null) ? 0 : gioiTinh.hashCode());
		result = prime * result + ((heSo == null) ? 0 : heSo.hashCode());
		result = prime * result + ((hinhAnh == null) ? 0 : hinhAnh.hashCode());
		result = prime * result + ((hoKhauThuongTru == null) ? 0 : hoKhauThuongTru.hashCode());
		result = prime * result + ((hoanCanhKinhTeGiaDinh == null) ? 0 : hoanCanhKinhTeGiaDinh.hashCode());
		result = prime * result + ((khenThuong == null) ? 0 : khenThuong.hashCode());
		result = prime * result + ((kyLuat == null) ? 0 : kyLuat.hashCode());
		result = prime * result + ((laConGiaDinhChinhSach == null) ? 0 : laConGiaDinhChinhSach.hashCode());
		result = prime * result + ((laConThuongBinh == null) ? 0 : laConThuongBinh.hashCode());
		result = prime * result + ((lyLuanChinhTri == null) ? 0 : lyLuanChinhTri.hashCode());
		result = prime * result + ((maNgach == null) ? 0 : maNgach.hashCode());
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((ngachCongChuc == null) ? 0 : ngachCongChuc.hashCode());
		result = prime * result + ((ngayCapCMND == null) ? 0 : ngayCapCMND.hashCode());
		result = prime * result + ((ngayCapHoChieu == null) ? 0 : ngayCapHoChieu.hashCode());
		result = prime * result + ((ngayHuong == null) ? 0 : ngayHuong.hashCode());
		result = prime * result + ((ngayNhapNgu == null) ? 0 : ngayNhapNgu.hashCode());
		result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
		result = prime * result + ((ngayTuyenDung == null) ? 0 : ngayTuyenDung.hashCode());
		result = prime * result + ((ngayVaoDangChinhThuc == null) ? 0 : ngayVaoDangChinhThuc.hashCode());
		result = prime * result + ((ngayVaoDangDuBi == null) ? 0 : ngayVaoDangDuBi.hashCode());
		result = prime * result + ((ngayXuatNgu == null) ? 0 : ngayXuatNgu.hashCode());
		result = prime * result + ((ngheNghiepTruocKhiTuyenDung == null) ? 0 : ngheNghiepTruocKhiTuyenDung.hashCode());
		result = prime * result + ((ngoaiNgu == null) ? 0 : ngoaiNgu.hashCode());
		result = prime * result + ((nhanXetDanhGiaCuaCoQuan == null) ? 0 : nhanXetDanhGiaCuaCoQuan.hashCode());
		result = prime * result + ((noiCapCMND == null) ? 0 : noiCapCMND.hashCode());
		result = prime * result + ((noiCapHoChieu == null) ? 0 : noiCapHoChieu.hashCode());
		result = prime * result + ((noiOHienTai == null) ? 0 : noiOHienTai.hashCode());
		result = prime * result + ((noiSinh == null) ? 0 : noiSinh.hashCode());
		result = prime * result + ((quaTrinhCongTac == null) ? 0 : quaTrinhCongTac.hashCode());
		result = prime * result + ((quaTrinhDaoTao == null) ? 0 : quaTrinhDaoTao.hashCode());
		result = prime * result + ((quanHamCaoNhat == null) ? 0 : quanHamCaoNhat.hashCode());
		result = prime * result + ((quanHeVoiGiaDinh == null) ? 0 : quanHeVoiGiaDinh.hashCode());
		result = prime * result + ((quanLyNhaNuoc == null) ? 0 : quanLyNhaNuoc.hashCode());
		result = prime * result + ((queQuan == null) ? 0 : queQuan.hashCode());
		result = prime * result + ((soCMND == null) ? 0 : soCMND.hashCode());
		result = prime * result + ((soDienThoaiCoQuan == null) ? 0 : soDienThoaiCoQuan.hashCode());
		result = prime * result + ((soDienThoaiDiDong == null) ? 0 : soDienThoaiDiDong.hashCode());
		result = prime * result + ((soHoChieu == null) ? 0 : soHoChieu.hashCode());
		result = prime * result + ((soSoBaoHiemXaHoi == null) ? 0 : soSoBaoHiemXaHoi.hashCode());
		result = prime * result + ((soTruongCongTac == null) ? 0 : soTruongCongTac.hashCode());
		result = prime * result + ((tenNhanVien == null) ? 0 : tenNhanVien.hashCode());
		result = prime * result + ((thamGiaToChucChinhTriXaHoi == null) ? 0 : thamGiaToChucChinhTriXaHoi.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + ((tinHoc == null) ? 0 : tinHoc.hashCode());
		result = prime * result + ((tinhTrangSucKhoe == null) ? 0 : tinhTrangSucKhoe.hashCode());
		result = prime * result + ((tonGiao == null) ? 0 : tonGiao.hashCode());
		result = prime * result + ((trinhDoChuyenMonCaoNhat == null) ? 0 : trinhDoChuyenMonCaoNhat.hashCode());
		result = prime * result + ((trinhDoGiaoDucPhoThong == null) ? 0 : trinhDoGiaoDucPhoThong.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (bacLuong == null) {
			if (other.bacLuong != null)
				return false;
		} else if (!bacLuong.equals(other.bacLuong))
			return false;
		if (chucVu == null) {
			if (other.chucVu != null)
				return false;
		} else if (!chucVu.equals(other.chucVu))
			return false;
		if (congViecChinhDuocGiao == null) {
			if (other.congViecChinhDuocGiao != null)
				return false;
		} else if (!congViecChinhDuocGiao.equals(other.congViecChinhDuocGiao))
			return false;
		if (dacDiemLichSuBanThan == null) {
			if (other.dacDiemLichSuBanThan != null)
				return false;
		} else if (!dacDiemLichSuBanThan.equals(other.dacDiemLichSuBanThan))
			return false;
		if (danToc == null) {
			if (other.danToc != null)
				return false;
		} else if (!danToc.equals(other.danToc))
			return false;
		if (danhHieuDuocPhongTangCaoNhat == null) {
			if (other.danhHieuDuocPhongTangCaoNhat != null)
				return false;
		} else if (!danhHieuDuocPhongTangCaoNhat.equals(other.danhHieuDuocPhongTangCaoNhat))
			return false;
		if (diaChiBaoTin == null) {
			if (other.diaChiBaoTin != null)
				return false;
		} else if (!diaChiBaoTin.equals(other.diaChiBaoTin))
			return false;
		if (diaChiLienHe == null) {
			if (other.diaChiLienHe != null)
				return false;
		} else if (!diaChiLienHe.equals(other.diaChiLienHe))
			return false;
		if (donVi == null) {
			if (other.donVi != null)
				return false;
		} else if (!donVi.equals(other.donVi))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		if (heSo == null) {
			if (other.heSo != null)
				return false;
		} else if (!heSo.equals(other.heSo))
			return false;
		if (hinhAnh == null) {
			if (other.hinhAnh != null)
				return false;
		} else if (!hinhAnh.equals(other.hinhAnh))
			return false;
		if (hoKhauThuongTru == null) {
			if (other.hoKhauThuongTru != null)
				return false;
		} else if (!hoKhauThuongTru.equals(other.hoKhauThuongTru))
			return false;
		if (hoanCanhKinhTeGiaDinh == null) {
			if (other.hoanCanhKinhTeGiaDinh != null)
				return false;
		} else if (!hoanCanhKinhTeGiaDinh.equals(other.hoanCanhKinhTeGiaDinh))
			return false;
		if (khenThuong == null) {
			if (other.khenThuong != null)
				return false;
		} else if (!khenThuong.equals(other.khenThuong))
			return false;
		if (kyLuat == null) {
			if (other.kyLuat != null)
				return false;
		} else if (!kyLuat.equals(other.kyLuat))
			return false;
		if (laConGiaDinhChinhSach == null) {
			if (other.laConGiaDinhChinhSach != null)
				return false;
		} else if (!laConGiaDinhChinhSach.equals(other.laConGiaDinhChinhSach))
			return false;
		if (laConThuongBinh == null) {
			if (other.laConThuongBinh != null)
				return false;
		} else if (!laConThuongBinh.equals(other.laConThuongBinh))
			return false;
		if (lyLuanChinhTri == null) {
			if (other.lyLuanChinhTri != null)
				return false;
		} else if (!lyLuanChinhTri.equals(other.lyLuanChinhTri))
			return false;
		if (maNgach == null) {
			if (other.maNgach != null)
				return false;
		} else if (!maNgach.equals(other.maNgach))
			return false;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (ngachCongChuc == null) {
			if (other.ngachCongChuc != null)
				return false;
		} else if (!ngachCongChuc.equals(other.ngachCongChuc))
			return false;
		if (ngayCapCMND == null) {
			if (other.ngayCapCMND != null)
				return false;
		} else if (!ngayCapCMND.equals(other.ngayCapCMND))
			return false;
		if (ngayCapHoChieu == null) {
			if (other.ngayCapHoChieu != null)
				return false;
		} else if (!ngayCapHoChieu.equals(other.ngayCapHoChieu))
			return false;
		if (ngayHuong == null) {
			if (other.ngayHuong != null)
				return false;
		} else if (!ngayHuong.equals(other.ngayHuong))
			return false;
		if (ngayNhapNgu == null) {
			if (other.ngayNhapNgu != null)
				return false;
		} else if (!ngayNhapNgu.equals(other.ngayNhapNgu))
			return false;
		if (ngaySinh == null) {
			if (other.ngaySinh != null)
				return false;
		} else if (!ngaySinh.equals(other.ngaySinh))
			return false;
		if (ngayTuyenDung == null) {
			if (other.ngayTuyenDung != null)
				return false;
		} else if (!ngayTuyenDung.equals(other.ngayTuyenDung))
			return false;
		if (ngayVaoDangChinhThuc == null) {
			if (other.ngayVaoDangChinhThuc != null)
				return false;
		} else if (!ngayVaoDangChinhThuc.equals(other.ngayVaoDangChinhThuc))
			return false;
		if (ngayVaoDangDuBi == null) {
			if (other.ngayVaoDangDuBi != null)
				return false;
		} else if (!ngayVaoDangDuBi.equals(other.ngayVaoDangDuBi))
			return false;
		if (ngayXuatNgu == null) {
			if (other.ngayXuatNgu != null)
				return false;
		} else if (!ngayXuatNgu.equals(other.ngayXuatNgu))
			return false;
		if (ngheNghiepTruocKhiTuyenDung == null) {
			if (other.ngheNghiepTruocKhiTuyenDung != null)
				return false;
		} else if (!ngheNghiepTruocKhiTuyenDung.equals(other.ngheNghiepTruocKhiTuyenDung))
			return false;
		if (ngoaiNgu == null) {
			if (other.ngoaiNgu != null)
				return false;
		} else if (!ngoaiNgu.equals(other.ngoaiNgu))
			return false;
		if (nhanXetDanhGiaCuaCoQuan == null) {
			if (other.nhanXetDanhGiaCuaCoQuan != null)
				return false;
		} else if (!nhanXetDanhGiaCuaCoQuan.equals(other.nhanXetDanhGiaCuaCoQuan))
			return false;
		if (noiCapCMND == null) {
			if (other.noiCapCMND != null)
				return false;
		} else if (!noiCapCMND.equals(other.noiCapCMND))
			return false;
		if (noiCapHoChieu == null) {
			if (other.noiCapHoChieu != null)
				return false;
		} else if (!noiCapHoChieu.equals(other.noiCapHoChieu))
			return false;
		if (noiOHienTai == null) {
			if (other.noiOHienTai != null)
				return false;
		} else if (!noiOHienTai.equals(other.noiOHienTai))
			return false;
		if (noiSinh == null) {
			if (other.noiSinh != null)
				return false;
		} else if (!noiSinh.equals(other.noiSinh))
			return false;
		if (quaTrinhCongTac == null) {
			if (other.quaTrinhCongTac != null)
				return false;
		} else if (!quaTrinhCongTac.equals(other.quaTrinhCongTac))
			return false;
		if (quaTrinhDaoTao == null) {
			if (other.quaTrinhDaoTao != null)
				return false;
		} else if (!quaTrinhDaoTao.equals(other.quaTrinhDaoTao))
			return false;
		if (quanHamCaoNhat == null) {
			if (other.quanHamCaoNhat != null)
				return false;
		} else if (!quanHamCaoNhat.equals(other.quanHamCaoNhat))
			return false;
		if (quanHeVoiGiaDinh == null) {
			if (other.quanHeVoiGiaDinh != null)
				return false;
		} else if (!quanHeVoiGiaDinh.equals(other.quanHeVoiGiaDinh))
			return false;
		if (quanLyNhaNuoc == null) {
			if (other.quanLyNhaNuoc != null)
				return false;
		} else if (!quanLyNhaNuoc.equals(other.quanLyNhaNuoc))
			return false;
		if (queQuan == null) {
			if (other.queQuan != null)
				return false;
		} else if (!queQuan.equals(other.queQuan))
			return false;
		if (soCMND == null) {
			if (other.soCMND != null)
				return false;
		} else if (!soCMND.equals(other.soCMND))
			return false;
		if (soDienThoaiCoQuan == null) {
			if (other.soDienThoaiCoQuan != null)
				return false;
		} else if (!soDienThoaiCoQuan.equals(other.soDienThoaiCoQuan))
			return false;
		if (soDienThoaiDiDong == null) {
			if (other.soDienThoaiDiDong != null)
				return false;
		} else if (!soDienThoaiDiDong.equals(other.soDienThoaiDiDong))
			return false;
		if (soHoChieu == null) {
			if (other.soHoChieu != null)
				return false;
		} else if (!soHoChieu.equals(other.soHoChieu))
			return false;
		if (soSoBaoHiemXaHoi == null) {
			if (other.soSoBaoHiemXaHoi != null)
				return false;
		} else if (!soSoBaoHiemXaHoi.equals(other.soSoBaoHiemXaHoi))
			return false;
		if (soTruongCongTac == null) {
			if (other.soTruongCongTac != null)
				return false;
		} else if (!soTruongCongTac.equals(other.soTruongCongTac))
			return false;
		if (tenNhanVien == null) {
			if (other.tenNhanVien != null)
				return false;
		} else if (!tenNhanVien.equals(other.tenNhanVien))
			return false;
		if (thamGiaToChucChinhTriXaHoi == null) {
			if (other.thamGiaToChucChinhTriXaHoi != null)
				return false;
		} else if (!thamGiaToChucChinhTriXaHoi.equals(other.thamGiaToChucChinhTriXaHoi))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		if (tinHoc == null) {
			if (other.tinHoc != null)
				return false;
		} else if (!tinHoc.equals(other.tinHoc))
			return false;
		if (tinhTrangSucKhoe == null) {
			if (other.tinhTrangSucKhoe != null)
				return false;
		} else if (!tinhTrangSucKhoe.equals(other.tinhTrangSucKhoe))
			return false;
		if (tonGiao == null) {
			if (other.tonGiao != null)
				return false;
		} else if (!tonGiao.equals(other.tonGiao))
			return false;
		if (trinhDoChuyenMonCaoNhat == null) {
			if (other.trinhDoChuyenMonCaoNhat != null)
				return false;
		} else if (!trinhDoChuyenMonCaoNhat.equals(other.trinhDoChuyenMonCaoNhat))
			return false;
		if (trinhDoGiaoDucPhoThong == null) {
			if (other.trinhDoGiaoDucPhoThong != null)
				return false;
		} else if (!trinhDoGiaoDucPhoThong.equals(other.trinhDoGiaoDucPhoThong))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", hinhAnh=" + hinhAnh
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", noiSinh=" + noiSinh + ", queQuan=" + queQuan
				+ ", danToc=" + danToc + ", tonGiao=" + tonGiao + ", hoKhauThuongTru=" + hoKhauThuongTru
				+ ", noiOHienTai=" + noiOHienTai + ", ngheNghiepTruocKhiTuyenDung=" + ngheNghiepTruocKhiTuyenDung
				+ ", ngayTuyenDung=" + ngayTuyenDung + ", chucVu=" + chucVu + ", congViecChinhDuocGiao="
				+ congViecChinhDuocGiao + ", ngachCongChuc=" + ngachCongChuc + ", maNgach=" + maNgach + ", bacLuong="
				+ bacLuong + ", heSo=" + heSo + ", ngayHuong=" + ngayHuong + ", trinhDoGiaoDucPhoThong="
				+ trinhDoGiaoDucPhoThong + ", trinhDoChuyenMonCaoNhat=" + trinhDoChuyenMonCaoNhat + ", lyLuanChinhTri="
				+ lyLuanChinhTri + ", quanLyNhaNuoc=" + quanLyNhaNuoc + ", ngoaiNgu=" + ngoaiNgu + ", tinHoc=" + tinHoc
				+ ", ngayVaoDangDuBi=" + ngayVaoDangDuBi + ", ngayVaoDangChinhThuc=" + ngayVaoDangChinhThuc
				+ ", thamGiaToChucChinhTriXaHoi=" + thamGiaToChucChinhTriXaHoi + ", ngayNhapNgu=" + ngayNhapNgu
				+ ", ngayXuatNgu=" + ngayXuatNgu + ", quanHamCaoNhat=" + quanHamCaoNhat
				+ ", danhHieuDuocPhongTangCaoNhat=" + danhHieuDuocPhongTangCaoNhat + ", soTruongCongTac="
				+ soTruongCongTac + ", khenThuong=" + khenThuong + ", kyLuat=" + kyLuat + ", tinhTrangSucKhoe="
				+ tinhTrangSucKhoe + ", laConThuongBinh=" + laConThuongBinh + ", laConGiaDinhChinhSach="
				+ laConGiaDinhChinhSach + ", soCMND=" + soCMND + ", ngayCapCMND=" + ngayCapCMND + ", noiCapCMND="
				+ noiCapCMND + ", soHoChieu=" + soHoChieu + ", ngayCapHoChieu=" + ngayCapHoChieu + ", noiCapHoChieu="
				+ noiCapHoChieu + ", soSoBaoHiemXaHoi=" + soSoBaoHiemXaHoi + ", quaTrinhDaoTao=" + quaTrinhDaoTao
				+ ", quaTrinhCongTac=" + quaTrinhCongTac + ", dacDiemLichSuBanThan=" + dacDiemLichSuBanThan
				+ ", quanHeVoiGiaDinh=" + quanHeVoiGiaDinh + ", hoanCanhKinhTeGiaDinh=" + hoanCanhKinhTeGiaDinh
				+ ", nhanXetDanhGiaCuaCoQuan=" + nhanXetDanhGiaCuaCoQuan + ", email=" + email + ", soDienThoaiDiDong="
				+ soDienThoaiDiDong + ", soDienThoaiCoQuan=" + soDienThoaiCoQuan + ", diaChiLienHe=" + diaChiLienHe
				+ ", diaChiBaoTin=" + diaChiBaoTin + ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", donVi=" + donVi
				+ ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	@Override
	public int compareTo(NhanVien o) {
		return this.maNhanVien.compareTo(o.maNhanVien);
	}

}

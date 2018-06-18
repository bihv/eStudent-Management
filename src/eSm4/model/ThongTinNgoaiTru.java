package eSm4.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import eCore.model.SinhVien;

@Entity
public class ThongTinNgoaiTru implements Comparable<ThongTinNgoaiTru> {
	@Id
	public String maThongTinNgoaiTru;
	@ManyToOne
	public SinhVien sinhVien;
	@ManyToOne
	public DotKeKhaiThongTinNgoaiTru dotKeKhaiThongTinNgoaiTru;
	public String hoVaTenChuNhaTro;
	public String diaChiNhaTro;
	public String soDienThoaiCuaChuNhaTro;
	public Date ngayDangKyCuTru;
	public Date ngayKeKhaiThongTin;
	public boolean thueNhaTro;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	public Date thoiGianCapNhat;

	public ThongTinNgoaiTru() {
		super();
	}

	public ThongTinNgoaiTru(String maThongTinNgoaiTru, SinhVien sinhVien,
			DotKeKhaiThongTinNgoaiTru dotKeKhaiThongTinNgoaiTru, String hoVaTenChuNhaTro, String diaChiNhaTro,
			String soDienThoaiCuaChuNhaTro, Date ngayDangKyCuTru, Date ngayKeKhaiThongTin, boolean thueNhaTro,
			String moTa, String ghiChu, Date thoiGianCapNhat) {
		super();
		this.maThongTinNgoaiTru = maThongTinNgoaiTru;
		this.sinhVien = sinhVien;
		this.dotKeKhaiThongTinNgoaiTru = dotKeKhaiThongTinNgoaiTru;
		this.hoVaTenChuNhaTro = hoVaTenChuNhaTro;
		this.diaChiNhaTro = diaChiNhaTro;
		this.soDienThoaiCuaChuNhaTro = soDienThoaiCuaChuNhaTro;
		this.ngayDangKyCuTru = ngayDangKyCuTru;
		this.ngayKeKhaiThongTin = ngayKeKhaiThongTin;
		this.thueNhaTro = thueNhaTro;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public String toString() {
		return "ThongTinNgoaiTru [maThongTinNgoaiTru=" + maThongTinNgoaiTru + ", sinhVien=" + sinhVien
				+ ", dotKeKhaiThongTinNgoaiTru=" + dotKeKhaiThongTinNgoaiTru + ", hoVaTenChuNhaTro=" + hoVaTenChuNhaTro
				+ ", diaChiNhaTro=" + diaChiNhaTro + ", soDienThoaiCuaChuNhaTro=" + soDienThoaiCuaChuNhaTro
				+ ", ngayDangKyCuTru=" + ngayDangKyCuTru + ", ngayKeKhaiThongTin=" + ngayKeKhaiThongTin
				+ ", thueNhaTro=" + thueNhaTro + ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", thoiGianCapNhat="
				+ thoiGianCapNhat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaChiNhaTro == null) ? 0 : diaChiNhaTro.hashCode());
		result = prime * result + ((dotKeKhaiThongTinNgoaiTru == null) ? 0 : dotKeKhaiThongTinNgoaiTru.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((hoVaTenChuNhaTro == null) ? 0 : hoVaTenChuNhaTro.hashCode());
		result = prime * result + ((maThongTinNgoaiTru == null) ? 0 : maThongTinNgoaiTru.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((ngayDangKyCuTru == null) ? 0 : ngayDangKyCuTru.hashCode());
		result = prime * result + ((ngayKeKhaiThongTin == null) ? 0 : ngayKeKhaiThongTin.hashCode());
		result = prime * result + ((sinhVien == null) ? 0 : sinhVien.hashCode());
		result = prime * result + ((soDienThoaiCuaChuNhaTro == null) ? 0 : soDienThoaiCuaChuNhaTro.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + (thueNhaTro ? 1231 : 1237);
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
		ThongTinNgoaiTru other = (ThongTinNgoaiTru) obj;
		if (diaChiNhaTro == null) {
			if (other.diaChiNhaTro != null)
				return false;
		} else if (!diaChiNhaTro.equals(other.diaChiNhaTro))
			return false;
		if (dotKeKhaiThongTinNgoaiTru == null) {
			if (other.dotKeKhaiThongTinNgoaiTru != null)
				return false;
		} else if (!dotKeKhaiThongTinNgoaiTru.equals(other.dotKeKhaiThongTinNgoaiTru))
			return false;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (hoVaTenChuNhaTro == null) {
			if (other.hoVaTenChuNhaTro != null)
				return false;
		} else if (!hoVaTenChuNhaTro.equals(other.hoVaTenChuNhaTro))
			return false;
		if (maThongTinNgoaiTru == null) {
			if (other.maThongTinNgoaiTru != null)
				return false;
		} else if (!maThongTinNgoaiTru.equals(other.maThongTinNgoaiTru))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (ngayDangKyCuTru == null) {
			if (other.ngayDangKyCuTru != null)
				return false;
		} else if (!ngayDangKyCuTru.equals(other.ngayDangKyCuTru))
			return false;
		if (ngayKeKhaiThongTin == null) {
			if (other.ngayKeKhaiThongTin != null)
				return false;
		} else if (!ngayKeKhaiThongTin.equals(other.ngayKeKhaiThongTin))
			return false;
		if (sinhVien == null) {
			if (other.sinhVien != null)
				return false;
		} else if (!sinhVien.equals(other.sinhVien))
			return false;
		if (soDienThoaiCuaChuNhaTro == null) {
			if (other.soDienThoaiCuaChuNhaTro != null)
				return false;
		} else if (!soDienThoaiCuaChuNhaTro.equals(other.soDienThoaiCuaChuNhaTro))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		if (thueNhaTro != other.thueNhaTro)
			return false;
		return true;
	}

	public String getMaThongTinNgoaiTru() {
		return maThongTinNgoaiTru;
	}

	public void setMaThongTinNgoaiTru(String maThongTinNgoaiTru) {
		this.maThongTinNgoaiTru = maThongTinNgoaiTru;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public DotKeKhaiThongTinNgoaiTru getDotKeKhaiThongTinNgoaiTru() {
		return dotKeKhaiThongTinNgoaiTru;
	}

	public void setDotKeKhaiThongTinNgoaiTru(DotKeKhaiThongTinNgoaiTru dotKeKhaiThongTinNgoaiTru) {
		this.dotKeKhaiThongTinNgoaiTru = dotKeKhaiThongTinNgoaiTru;
	}

	public String getHoVaTenChuNhaTro() {
		return hoVaTenChuNhaTro;
	}

	public void setHoVaTenChuNhaTro(String hoVaTenChuNhaTro) {
		this.hoVaTenChuNhaTro = hoVaTenChuNhaTro;
	}

	public String getDiaChiNhaTro() {
		return diaChiNhaTro;
	}

	public void setDiaChiNhaTro(String diaChiNhaTro) {
		this.diaChiNhaTro = diaChiNhaTro;
	}

	public String getSoDienThoaiCuaChuNhaTro() {
		return soDienThoaiCuaChuNhaTro;
	}

	public void setSoDienThoaiCuaChuNhaTro(String soDienThoaiCuaChuNhaTro) {
		this.soDienThoaiCuaChuNhaTro = soDienThoaiCuaChuNhaTro;
	}

	public Date getNgayDangKyCuTru() {
		return ngayDangKyCuTru;
	}

	public void setNgayDangKyCuTru(Date ngayDangKyCuTru) {
		this.ngayDangKyCuTru = ngayDangKyCuTru;
	}

	public Date getNgayKeKhaiThongTin() {
		return ngayKeKhaiThongTin;
	}

	public void setNgayKeKhaiThongTin(Date ngayKeKhaiThongTin) {
		this.ngayKeKhaiThongTin = ngayKeKhaiThongTin;
	}

	public boolean isThueNhaTro() {
		return thueNhaTro;
	}

	public void setThueNhaTro(boolean thueNhaTro) {
		this.thueNhaTro = thueNhaTro;
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

	public Date getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}

	public void setThoiGianCapNhat(Date thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public int compareTo(ThongTinNgoaiTru o) {
		return this.maThongTinNgoaiTru.compareTo(o.maThongTinNgoaiTru);
	}

}

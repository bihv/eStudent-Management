package eSm4.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class DotKeKhaiThongTinNgoaiTru {
	@Id
	public String maDotKeKhaiThongTinNgoaiTru;
	public String tenDotKeKhaiThongTinNgoaiTru;
	public Date ngayBatDau;
	public Date ngayKetThuc;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	public Date thoiGianCapNhat;

	public String getMaDotKeKhaiThongTinNgoaiTru() {
		return maDotKeKhaiThongTinNgoaiTru;
	}

	public void setMaDotKeKhaiThongTinNgoaiTru(String maDotKeKhaiThongTinNgoaiTru) {
		this.maDotKeKhaiThongTinNgoaiTru = maDotKeKhaiThongTinNgoaiTru;
	}

	public String getTenDotKeKhaiThongTinNgoaiTru() {
		return tenDotKeKhaiThongTinNgoaiTru;
	}

	public void setTenDotKeKhaiThongTinNgoaiTru(String tenDotKeKhaiThongTinNgoaiTru) {
		this.tenDotKeKhaiThongTinNgoaiTru = tenDotKeKhaiThongTinNgoaiTru;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
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

	public Date getNgayCapNhat() {
		return thoiGianCapNhat;
	}

	public void setNgayCapNhat(Date thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public DotKeKhaiThongTinNgoaiTru(String maDotKeKhaiThongTinNgoaiTru, String tenDotKeKhaiThongTinNgoaiTru,
			Date ngayBatDau, Date ngayKetThuc, String moTa, String ghiChu, Date thoiGianCapNhat) {
		super();
		this.maDotKeKhaiThongTinNgoaiTru = maDotKeKhaiThongTinNgoaiTru;
		this.tenDotKeKhaiThongTinNgoaiTru = tenDotKeKhaiThongTinNgoaiTru;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public DotKeKhaiThongTinNgoaiTru() {
		super();
	}

	@Override
	public String toString() {
		return "DotKeKhaiThongTinNgoaiTru [maDotKeKhaiThongTinNgoaiTru=" + maDotKeKhaiThongTinNgoaiTru
				+ ", tenDotKeKhaiThongTinNgoaiTru=" + tenDotKeKhaiThongTinNgoaiTru + ", ngayBatDau=" + ngayBatDau
				+ ", ngayKetThuc=" + ngayKetThuc + ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", thoiGianCapNhat="
				+ thoiGianCapNhat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((maDotKeKhaiThongTinNgoaiTru == null) ? 0 : maDotKeKhaiThongTinNgoaiTru.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((ngayBatDau == null) ? 0 : ngayBatDau.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + ((ngayKetThuc == null) ? 0 : ngayKetThuc.hashCode());
		result = prime * result
				+ ((tenDotKeKhaiThongTinNgoaiTru == null) ? 0 : tenDotKeKhaiThongTinNgoaiTru.hashCode());
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
		DotKeKhaiThongTinNgoaiTru other = (DotKeKhaiThongTinNgoaiTru) obj;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (maDotKeKhaiThongTinNgoaiTru == null) {
			if (other.maDotKeKhaiThongTinNgoaiTru != null)
				return false;
		} else if (!maDotKeKhaiThongTinNgoaiTru.equals(other.maDotKeKhaiThongTinNgoaiTru))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (ngayBatDau == null) {
			if (other.ngayBatDau != null)
				return false;
		} else if (!ngayBatDau.equals(other.ngayBatDau))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		if (ngayKetThuc == null) {
			if (other.ngayKetThuc != null)
				return false;
		} else if (!ngayKetThuc.equals(other.ngayKetThuc))
			return false;
		if (tenDotKeKhaiThongTinNgoaiTru == null) {
			if (other.tenDotKeKhaiThongTinNgoaiTru != null)
				return false;
		} else if (!tenDotKeKhaiThongTinNgoaiTru.equals(other.tenDotKeKhaiThongTinNgoaiTru))
			return false;
		return true;
	}

}

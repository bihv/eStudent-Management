package eCore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class NamHoc implements Comparable<NamHoc> {
	@Id
	public String maNamHoc;
	public String tenNamHoc;
	public Date ngayBatDau;
	public Date ngayKetThuc;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	public Date thoiGianCapNhat;

	public NamHoc() {
	}

	public NamHoc(String maNamHoc, String tenNamHoc, Date ngayBatDau, Date ngayKetThuc, String moTa, String ghiChu,
			Date thoiGianCapNhat) {
		super();
		this.maNamHoc = maNamHoc;
		this.tenNamHoc = tenNamHoc;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public String getMaNamHoc() {
		return maNamHoc;
	}

	public void setMaNamHoc(String maNamHoc) {
		this.maNamHoc = maNamHoc;
	}

	public String getTenNamHoc() {
		return tenNamHoc;
	}

	public void setTenNamHoc(String tenNamHoc) {
		this.tenNamHoc = tenNamHoc;
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
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((maNamHoc == null) ? 0 : maNamHoc.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((ngayBatDau == null) ? 0 : ngayBatDau.hashCode());
		result = prime * result + ((ngayKetThuc == null) ? 0 : ngayKetThuc.hashCode());
		result = prime * result + ((tenNamHoc == null) ? 0 : tenNamHoc.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
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
		NamHoc other = (NamHoc) obj;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (maNamHoc == null) {
			if (other.maNamHoc != null)
				return false;
		} else if (!maNamHoc.equals(other.maNamHoc))
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
		if (ngayKetThuc == null) {
			if (other.ngayKetThuc != null)
				return false;
		} else if (!ngayKetThuc.equals(other.ngayKetThuc))
			return false;
		if (tenNamHoc == null) {
			if (other.tenNamHoc != null)
				return false;
		} else if (!tenNamHoc.equals(other.tenNamHoc))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NamHoc [maNamHoc=" + maNamHoc + ", tenNamHoc=" + tenNamHoc + ", ngayBatDau=" + ngayBatDau
				+ ", ngayKetThuc=" + ngayKetThuc + ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", thoiGianCapNhat="
				+ thoiGianCapNhat + "]";
	}

	@Override
	public int compareTo(NamHoc o) {
		return this.maNamHoc.compareTo(o.maNamHoc);
	}

}

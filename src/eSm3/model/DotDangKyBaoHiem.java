package eSm3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DotDangKyBaoHiem implements Comparable<DotDangKyBaoHiem> {
	@Id
	public String maDotDangKyBaoHiem;
	public String tenDotDangKyBaoHiem;
	public String loaiBaoHiem;
	public Date ngayBatDau;
	public Date ngayKetThuc;
	public double soTien;
	@Type(type="text")
	public String moTa;
	@Type(type="text")
	public String ghiChu;
	public Date thoiGianCapNhat;
	
	public DotDangKyBaoHiem() {
	}
	
	public DotDangKyBaoHiem(String maDotDangKyBaoHiem, String tenDotDangKyBaoHiem, String loaiBaoHiem, Date ngayBatDau,
			Date ngayKetThuc, double soTien, String moTa, String ghiChu, Date ngayCapNhat) {
		super();
		this.maDotDangKyBaoHiem = maDotDangKyBaoHiem;
		this.tenDotDangKyBaoHiem = tenDotDangKyBaoHiem;
		this.loaiBaoHiem = loaiBaoHiem;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.soTien = soTien;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = ngayCapNhat;
	}

	public String getMaDotDangKyBaoHiem() {
		return maDotDangKyBaoHiem;
	}

	public void setMaDotDangKyBaoHiem(String maDotDangKyBaoHiem) {
		this.maDotDangKyBaoHiem = maDotDangKyBaoHiem;
	}

	public String getTenDotDangKyBaoHiem() {
		return tenDotDangKyBaoHiem;
	}

	public void setTenDotDangKyBaoHiem(String tenDotDangKyBaoHiem) {
		this.tenDotDangKyBaoHiem = tenDotDangKyBaoHiem;
	}

	public String getLoaiBaoHiem() {
		return loaiBaoHiem;
	}

	public void setLoaiBaoHiem(String loaiBaoHiem) {
		this.loaiBaoHiem = loaiBaoHiem;
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

	public double getSoTien() {
		return soTien;
	}

	public void setSoTien(double soTien) {
		this.soTien = soTien;
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

	public void setNgayCapNhat(Date ngayCapNhat) {
		this.thoiGianCapNhat = ngayCapNhat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((loaiBaoHiem == null) ? 0 : loaiBaoHiem.hashCode());
		result = prime * result + ((maDotDangKyBaoHiem == null) ? 0 : maDotDangKyBaoHiem.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((ngayBatDau == null) ? 0 : ngayBatDau.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + ((ngayKetThuc == null) ? 0 : ngayKetThuc.hashCode());
		long temp;
		temp = Double.doubleToLongBits(soTien);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tenDotDangKyBaoHiem == null) ? 0 : tenDotDangKyBaoHiem.hashCode());
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
		DotDangKyBaoHiem other = (DotDangKyBaoHiem) obj;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (loaiBaoHiem == null) {
			if (other.loaiBaoHiem != null)
				return false;
		} else if (!loaiBaoHiem.equals(other.loaiBaoHiem))
			return false;
		if (maDotDangKyBaoHiem == null) {
			if (other.maDotDangKyBaoHiem != null)
				return false;
		} else if (!maDotDangKyBaoHiem.equals(other.maDotDangKyBaoHiem))
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
		if (Double.doubleToLongBits(soTien) != Double.doubleToLongBits(other.soTien))
			return false;
		if (tenDotDangKyBaoHiem == null) {
			if (other.tenDotDangKyBaoHiem != null)
				return false;
		} else if (!tenDotDangKyBaoHiem.equals(other.tenDotDangKyBaoHiem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DotDangKyBaoHiem [maDotDangKyBaoHiem=" + maDotDangKyBaoHiem + ", tenDotDangKyBaoHiem="
				+ tenDotDangKyBaoHiem + ", loaiBaoHiem=" + loaiBaoHiem + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc="
				+ ngayKetThuc + ", soTien=" + soTien + ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", ngayCapNhat="
				+ thoiGianCapNhat + "]";
	}

	@Override
	public int compareTo(DotDangKyBaoHiem o) {
		return this.maDotDangKyBaoHiem.compareTo(o.maDotDangKyBaoHiem);
	}
}

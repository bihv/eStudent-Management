package eCore.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class HocKy implements Comparable<HocKy> {
	@Id
	public String maHocKy;
	public String tenHocKy;
	public Date ngayBatDau;
	public Date ngayKetThuc;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;

	@ManyToOne(fetch = FetchType.EAGER)
	public NamHoc namHoc;
	public Date thoiGianCapNhat;

	public HocKy() {
	}

	public HocKy(String maHocKy, String tenHocKy, Date ngayBatDau, Date ngayKetThuc, String moTa, String ghiChu,
			NamHoc namHoc, Date thoiGianCapNhat) {
		super();
		this.maHocKy = maHocKy;
		this.tenHocKy = tenHocKy;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.namHoc = namHoc;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public String getMaHocKy() {
		return maHocKy;
	}

	public void setMaHocKy(String maHocKy) {
		this.maHocKy = maHocKy;
	}

	public String getTenHocKy() {
		return tenHocKy;
	}

	public void setTenHocKy(String tenHocKy) {
		this.tenHocKy = tenHocKy;
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

	public NamHoc getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(NamHoc namHoc) {
		this.namHoc = namHoc;
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
		result = prime * result + ((maHocKy == null) ? 0 : maHocKy.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((namHoc == null) ? 0 : namHoc.hashCode());
		result = prime * result + ((ngayBatDau == null) ? 0 : ngayBatDau.hashCode());
		result = prime * result + ((ngayKetThuc == null) ? 0 : ngayKetThuc.hashCode());
		result = prime * result + ((tenHocKy == null) ? 0 : tenHocKy.hashCode());
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
		HocKy other = (HocKy) obj;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (maHocKy == null) {
			if (other.maHocKy != null)
				return false;
		} else if (!maHocKy.equals(other.maHocKy))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (namHoc == null) {
			if (other.namHoc != null)
				return false;
		} else if (!namHoc.equals(other.namHoc))
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
		if (tenHocKy == null) {
			if (other.tenHocKy != null)
				return false;
		} else if (!tenHocKy.equals(other.tenHocKy))
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
		return "HocKy [maHocKy=" + maHocKy + ", tenHocKy=" + tenHocKy + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc="
				+ ngayKetThuc + ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", namHoc=" + namHoc + ", thoiGianCapNhat="
				+ thoiGianCapNhat + "]";
	}

	@Override
	public int compareTo(HocKy o) {
		return this.maHocKy.compareTo(o.maHocKy);
	}

}

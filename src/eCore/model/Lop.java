package eCore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class Lop implements Comparable<Lop> {
	@Id
	public String maLop;
	public String tenLop;
	public String khoa;
	public String nienKhoa;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;

	@ManyToOne(fetch = FetchType.EAGER)
	public DonVi donVi;
	public Date thoiGianCapNhat;

	public Lop() {
	}

	public Lop(String maLop, String tenLop, String khoa, String nienKhoa, String moTa, String ghiChu, DonVi donVi,
			Date thoiGianCapNhat) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.khoa = khoa;
		this.nienKhoa = nienKhoa;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.donVi = donVi;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
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
		result = prime * result + ((donVi == null) ? 0 : donVi.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((khoa == null) ? 0 : khoa.hashCode());
		result = prime * result + ((maLop == null) ? 0 : maLop.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((nienKhoa == null) ? 0 : nienKhoa.hashCode());
		result = prime * result + ((tenLop == null) ? 0 : tenLop.hashCode());
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
		Lop other = (Lop) obj;
		if (donVi == null) {
			if (other.donVi != null)
				return false;
		} else if (!donVi.equals(other.donVi))
			return false;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (khoa == null) {
			if (other.khoa != null)
				return false;
		} else if (!khoa.equals(other.khoa))
			return false;
		if (maLop == null) {
			if (other.maLop != null)
				return false;
		} else if (!maLop.equals(other.maLop))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (nienKhoa == null) {
			if (other.nienKhoa != null)
				return false;
		} else if (!nienKhoa.equals(other.nienKhoa))
			return false;
		if (tenLop == null) {
			if (other.tenLop != null)
				return false;
		} else if (!tenLop.equals(other.tenLop))
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
		return "Lop [maLop=" + maLop + ", tenLop=" + tenLop + ", khoa=" + khoa + ", nienKhoa=" + nienKhoa + ", moTa="
				+ moTa + ", ghiChu=" + ghiChu + ", donVi=" + donVi + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	@Override
	public int compareTo(Lop o) {
		return this.maLop.compareTo(o.maLop);
	}

}

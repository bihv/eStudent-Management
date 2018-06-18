package eSm3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ThongTinDangKyBaoHiemTuNguyen implements Comparable<ThongTinDangKyBaoHiemTuNguyen> {
	@Id
	public String maThongTinDangKyBaoHiemTuNguyen;
	@ManyToOne
	public DotDangKyBaoHiem dotDangKyBaoHiem;
	public Date thoiGianDangKy;
	public String trangThai;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	public Date thoiGianCapNhat;

	public ThongTinDangKyBaoHiemTuNguyen() {
	}

	public ThongTinDangKyBaoHiemTuNguyen(String maThongTinDangKyBaoHiemTuNguyen, DotDangKyBaoHiem dotDangKyBaoHiem,
			Date thoiGianDangKy, String trangThai, String moTa, String ghiChu, Date thoiGianCapNhat) {
		super();
		this.maThongTinDangKyBaoHiemTuNguyen = maThongTinDangKyBaoHiemTuNguyen;
		this.dotDangKyBaoHiem = dotDangKyBaoHiem;
		this.thoiGianDangKy = thoiGianDangKy;
		this.trangThai = trangThai;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public String toString() {
		return "ThongTinDangKyBaoHiemTuNguyen [maThongTinDangKyBaoHiemTuNguyen=" + maThongTinDangKyBaoHiemTuNguyen
				+ ", dotDangKyBaoHiem=" + dotDangKyBaoHiem + ", thoiGianDangKy=" + thoiGianDangKy + ", trangThai="
				+ trangThai + ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dotDangKyBaoHiem == null) ? 0 : dotDangKyBaoHiem.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result
				+ ((maThongTinDangKyBaoHiemTuNguyen == null) ? 0 : maThongTinDangKyBaoHiemTuNguyen.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + ((thoiGianDangKy == null) ? 0 : thoiGianDangKy.hashCode());
		result = prime * result + ((trangThai == null) ? 0 : trangThai.hashCode());
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
		ThongTinDangKyBaoHiemTuNguyen other = (ThongTinDangKyBaoHiemTuNguyen) obj;
		if (dotDangKyBaoHiem == null) {
			if (other.dotDangKyBaoHiem != null)
				return false;
		} else if (!dotDangKyBaoHiem.equals(other.dotDangKyBaoHiem))
			return false;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (maThongTinDangKyBaoHiemTuNguyen == null) {
			if (other.maThongTinDangKyBaoHiemTuNguyen != null)
				return false;
		} else if (!maThongTinDangKyBaoHiemTuNguyen.equals(other.maThongTinDangKyBaoHiemTuNguyen))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		if (thoiGianDangKy == null) {
			if (other.thoiGianDangKy != null)
				return false;
		} else if (!thoiGianDangKy.equals(other.thoiGianDangKy))
			return false;
		if (trangThai == null) {
			if (other.trangThai != null)
				return false;
		} else if (!trangThai.equals(other.trangThai))
			return false;
		return true;
	}

	public String getMaThongTinDangKyBaoHiemTuNguyen() {
		return maThongTinDangKyBaoHiemTuNguyen;
	}

	public void setMaThongTinDangKyBaoHiemTuNguyen(String maThongTinDangKyBaoHiemTuNguyen) {
		this.maThongTinDangKyBaoHiemTuNguyen = maThongTinDangKyBaoHiemTuNguyen;
	}

	public DotDangKyBaoHiem getDotDangKyBaoHiem() {
		return dotDangKyBaoHiem;
	}

	public void setDotDangKyBaoHiem(DotDangKyBaoHiem dotDangKyBaoHiem) {
		this.dotDangKyBaoHiem = dotDangKyBaoHiem;
	}

	public Date getThoiGianDangKy() {
		return thoiGianDangKy;
	}

	public void setThoiGianDangKy(Date thoiGianDangKy) {
		this.thoiGianDangKy = thoiGianDangKy;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
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

}

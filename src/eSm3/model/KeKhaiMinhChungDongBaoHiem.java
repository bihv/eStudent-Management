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
public abstract class KeKhaiMinhChungDongBaoHiem implements Comparable<KeKhaiMinhChungDongBaoHiem> {
	@Id
	public String maKeKhaiMinhChungDongBaoHiem;
	@ManyToOne
	public DotDangKyBaoHiem dotDangKyBaoHiem;
	public String hinhAnhMinhChung;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	public Date thoiGianCapNhat;

	public KeKhaiMinhChungDongBaoHiem() {
	}

	public KeKhaiMinhChungDongBaoHiem(String maKeKhaiMinhChungDongBaoHiem, DotDangKyBaoHiem dotDangKyBaoHiem,
			String hinhAnhMinhChung, String moTa, String ghiChu, Date thoiGianCapNhat) {
		this.maKeKhaiMinhChungDongBaoHiem = maKeKhaiMinhChungDongBaoHiem;
		this.dotDangKyBaoHiem = dotDangKyBaoHiem;
		this.hinhAnhMinhChung = hinhAnhMinhChung;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public String getMaKeKhaiMinhChungDongBaoHiem() {
		return maKeKhaiMinhChungDongBaoHiem;
	}

	public void setMaKeKhaiMinhChungDongBaoHiem(String maKeKhaiMinhChungDongBaoHiem) {
		this.maKeKhaiMinhChungDongBaoHiem = maKeKhaiMinhChungDongBaoHiem;
	}

	public DotDangKyBaoHiem getDotDangKyBaoHiem() {
		return dotDangKyBaoHiem;
	}

	public void setDotDangKyBaoHiem(DotDangKyBaoHiem dotDangKyBaoHiem) {
		this.dotDangKyBaoHiem = dotDangKyBaoHiem;
	}

	public String getHinhAnhMinhChung() {
		return hinhAnhMinhChung;
	}

	public void setHinhAnhMinhChung(String hinhAnhMinhChung) {
		this.hinhAnhMinhChung = hinhAnhMinhChung;
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
		result = prime * result + ((dotDangKyBaoHiem == null) ? 0 : dotDangKyBaoHiem.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((hinhAnhMinhChung == null) ? 0 : hinhAnhMinhChung.hashCode());
		result = prime * result
				+ ((maKeKhaiMinhChungDongBaoHiem == null) ? 0 : maKeKhaiMinhChungDongBaoHiem.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
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
		KeKhaiMinhChungDongBaoHiem other = (KeKhaiMinhChungDongBaoHiem) obj;
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
		if (hinhAnhMinhChung == null) {
			if (other.hinhAnhMinhChung != null)
				return false;
		} else if (!hinhAnhMinhChung.equals(other.hinhAnhMinhChung))
			return false;
		if (maKeKhaiMinhChungDongBaoHiem == null) {
			if (other.maKeKhaiMinhChungDongBaoHiem != null)
				return false;
		} else if (!maKeKhaiMinhChungDongBaoHiem.equals(other.maKeKhaiMinhChungDongBaoHiem))
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
		return true;
	}

	@Override
	public String toString() {
		return "KeKhaiMinhChungDongBaoHiem [maKeKhaiMinhChungDongBaoHiem=" + maKeKhaiMinhChungDongBaoHiem
				+ ", dotDangKyBaoHiem=" + dotDangKyBaoHiem + ", hinhAnhMinhChung=" + hinhAnhMinhChung + ", moTa=" + moTa
				+ ", ghiChu=" + ghiChu + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	@Override
	public int compareTo(KeKhaiMinhChungDongBaoHiem o) {
		return this.maKeKhaiMinhChungDongBaoHiem.compareTo(o.maKeKhaiMinhChungDongBaoHiem);
	}

}

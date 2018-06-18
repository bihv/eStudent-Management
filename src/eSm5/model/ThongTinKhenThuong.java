package eSm5.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import eCore.model.SinhVien;

@Entity
public class ThongTinKhenThuong implements Comparable<ThongTinKhenThuong> {
	@Id
	public String maThongTinKhenThuong;
	@ManyToOne
	public SinhVien sinhVien;
	@Type(type = "text")
	public String noiDungKhenThuong;
	public Date thoiGianKhenThuong;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	public Date thoiGianCapNhat;

	public ThongTinKhenThuong(String maThongTinKhenThuong, SinhVien sinhVien, String noiDungKhenThuong,
			Date thoiGianKhenThuong, String moTa, String ghiChu, Date thoiGianCapNhat) {
		super();
		this.maThongTinKhenThuong = maThongTinKhenThuong;
		this.sinhVien = sinhVien;
		this.noiDungKhenThuong = noiDungKhenThuong;
		this.thoiGianKhenThuong = thoiGianKhenThuong;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public ThongTinKhenThuong() {
		super();
	}

	@Override
	public String toString() {
		return "ThongTinKhenThuong [maThongTinKhenThuong=" + maThongTinKhenThuong + ", sinhVien=" + sinhVien
				+ ", noiDungKhenThuong=" + noiDungKhenThuong + ", thoiGianKhenThuong=" + thoiGianKhenThuong + ", moTa="
				+ moTa + ", ghiChu=" + ghiChu + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((maThongTinKhenThuong == null) ? 0 : maThongTinKhenThuong.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((noiDungKhenThuong == null) ? 0 : noiDungKhenThuong.hashCode());
		result = prime * result + ((sinhVien == null) ? 0 : sinhVien.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + ((thoiGianKhenThuong == null) ? 0 : thoiGianKhenThuong.hashCode());
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
		ThongTinKhenThuong other = (ThongTinKhenThuong) obj;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (maThongTinKhenThuong == null) {
			if (other.maThongTinKhenThuong != null)
				return false;
		} else if (!maThongTinKhenThuong.equals(other.maThongTinKhenThuong))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (noiDungKhenThuong == null) {
			if (other.noiDungKhenThuong != null)
				return false;
		} else if (!noiDungKhenThuong.equals(other.noiDungKhenThuong))
			return false;
		if (sinhVien == null) {
			if (other.sinhVien != null)
				return false;
		} else if (!sinhVien.equals(other.sinhVien))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		if (thoiGianKhenThuong == null) {
			if (other.thoiGianKhenThuong != null)
				return false;
		} else if (!thoiGianKhenThuong.equals(other.thoiGianKhenThuong))
			return false;
		return true;
	}

	public String getMaThongTinKhenThuong() {
		return maThongTinKhenThuong;
	}

	public void setMaThongTinKhenThuong(String maThongTinKhenThuong) {
		this.maThongTinKhenThuong = maThongTinKhenThuong;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public String getNoiDungKhenThuong() {
		return noiDungKhenThuong;
	}

	public void setNoiDungKhenThuong(String noiDungKhenThuong) {
		this.noiDungKhenThuong = noiDungKhenThuong;
	}

	public Date getThoiGianKhenThuong() {
		return thoiGianKhenThuong;
	}

	public void setThoiGianKhenThuong(Date thoiGianKhenThuong) {
		this.thoiGianKhenThuong = thoiGianKhenThuong;
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
	public int compareTo(ThongTinKhenThuong o) {
		return this.maThongTinKhenThuong.compareTo(o.maThongTinKhenThuong);
	}

}

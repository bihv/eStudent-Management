package eSm5.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import eCore.model.SinhVien;

@Entity
public class ThongTinKyLuat implements Comparable<ThongTinKyLuat> {
	@Id
	public String maThongTinKyLuat;
	@ManyToOne
	public SinhVien sinhVien;
	@Type(type = "text")
	public String noiDungKyLuat;
	@ManyToOne
	public HinhThucKyLuat hinhThucKyLuat;
	public Date thoiGianKyLuat;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	public Date thoiGianCapNhat;

	public String getMaThongTinKyLuat() {
		return maThongTinKyLuat;
	}

	public void setMaThongTinKyLuat(String maThongTinKyLuat) {
		this.maThongTinKyLuat = maThongTinKyLuat;
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	public String getNoiDungKyLuat() {
		return noiDungKyLuat;
	}

	public void setNoiDungKyLuat(String noiDungKyLuat) {
		this.noiDungKyLuat = noiDungKyLuat;
	}

	public HinhThucKyLuat getHinhThucKyLuat() {
		return hinhThucKyLuat;
	}

	public void setHinhThucKyLuat(HinhThucKyLuat hinhThucKyLuat) {
		this.hinhThucKyLuat = hinhThucKyLuat;
	}

	public Date getThoiGianKyLuat() {
		return thoiGianKyLuat;
	}

	public void setThoiGianKyLuat(Date thoiGianKyLuat) {
		this.thoiGianKyLuat = thoiGianKyLuat;
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
		result = prime * result + ((hinhThucKyLuat == null) ? 0 : hinhThucKyLuat.hashCode());
		result = prime * result + ((maThongTinKyLuat == null) ? 0 : maThongTinKyLuat.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((noiDungKyLuat == null) ? 0 : noiDungKyLuat.hashCode());
		result = prime * result + ((sinhVien == null) ? 0 : sinhVien.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + ((thoiGianKyLuat == null) ? 0 : thoiGianKyLuat.hashCode());
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
		ThongTinKyLuat other = (ThongTinKyLuat) obj;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (hinhThucKyLuat == null) {
			if (other.hinhThucKyLuat != null)
				return false;
		} else if (!hinhThucKyLuat.equals(other.hinhThucKyLuat))
			return false;
		if (maThongTinKyLuat == null) {
			if (other.maThongTinKyLuat != null)
				return false;
		} else if (!maThongTinKyLuat.equals(other.maThongTinKyLuat))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (noiDungKyLuat == null) {
			if (other.noiDungKyLuat != null)
				return false;
		} else if (!noiDungKyLuat.equals(other.noiDungKyLuat))
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
		if (thoiGianKyLuat == null) {
			if (other.thoiGianKyLuat != null)
				return false;
		} else if (!thoiGianKyLuat.equals(other.thoiGianKyLuat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThongTinKyLuat [maThongTinKyLuat=" + maThongTinKyLuat + ", sinhVien=" + sinhVien + ", noiDungKyLuat="
				+ noiDungKyLuat + ", hinhThucKyLuat=" + hinhThucKyLuat + ", thoiGianKyLuat=" + thoiGianKyLuat
				+ ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	public ThongTinKyLuat() {
		super();
	}

	public ThongTinKyLuat(String maThongTinKyLuat, SinhVien sinhVien, String noiDungKyLuat,
			HinhThucKyLuat hinhThucKyLuat, Date thoiGianKyLuat, String moTa, String ghiChu, Date thoiGianCapNhat) {
		super();
		this.maThongTinKyLuat = maThongTinKyLuat;
		this.sinhVien = sinhVien;
		this.noiDungKyLuat = noiDungKyLuat;
		this.hinhThucKyLuat = hinhThucKyLuat;
		this.thoiGianKyLuat = thoiGianKyLuat;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public int compareTo(ThongTinKyLuat o) {
		return this.maThongTinKyLuat.compareTo(o.maThongTinKyLuat);
	}

}

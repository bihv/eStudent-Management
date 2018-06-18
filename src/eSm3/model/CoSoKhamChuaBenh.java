package eSm3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class CoSoKhamChuaBenh implements Comparable<CoSoKhamChuaBenh> {
	@Id
	public String maCoSoKhamChuaBenh;
	public String tenCoSoKhamChuaBenh;
	public String diaChi;
	public String thongTinDangKyKhamChuaBenhBanDau;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	public Date thoiGianCapNhat;

	public String getMaCoSoKhamChuaBenh() {
		return maCoSoKhamChuaBenh;
	}

	public void setMaCoSoKhamChuaBenh(String maCoSoKhamChuaBenh) {
		this.maCoSoKhamChuaBenh = maCoSoKhamChuaBenh;
	}

	public String getTenCoSoKhamChuaBenh() {
		return tenCoSoKhamChuaBenh;
	}

	public void setTenCoSoKhamChuaBenh(String tenCoSoKhamChuaBenh) {
		this.tenCoSoKhamChuaBenh = tenCoSoKhamChuaBenh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getThongTinDangKyKhamChuaBenhBanDau() {
		return thongTinDangKyKhamChuaBenhBanDau;
	}

	public void setThongTinDangKyKhamChuaBenhBanDau(String thongTinDangKyKhamChuaBenhBanDau) {
		this.thongTinDangKyKhamChuaBenhBanDau = thongTinDangKyKhamChuaBenhBanDau;
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

	public CoSoKhamChuaBenh() {
	}

	public CoSoKhamChuaBenh(String maCoSoKhamChuaBenh, String tenCoSoKhamChuaBenh, String diaChi,
			String thongTinDangKyKhamChuaBenhBanDau, String moTa, String ghiChu, Date thoiGianCapNhat) {
		super();
		this.maCoSoKhamChuaBenh = maCoSoKhamChuaBenh;
		this.tenCoSoKhamChuaBenh = tenCoSoKhamChuaBenh;
		this.diaChi = diaChi;
		this.thongTinDangKyKhamChuaBenhBanDau = thongTinDangKyKhamChuaBenhBanDau;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((maCoSoKhamChuaBenh == null) ? 0 : maCoSoKhamChuaBenh.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((tenCoSoKhamChuaBenh == null) ? 0 : tenCoSoKhamChuaBenh.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result
				+ ((thongTinDangKyKhamChuaBenhBanDau == null) ? 0 : thongTinDangKyKhamChuaBenhBanDau.hashCode());
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
		CoSoKhamChuaBenh other = (CoSoKhamChuaBenh) obj;
		if (diaChi == null) {
			if (other.diaChi != null)
				return false;
		} else if (!diaChi.equals(other.diaChi))
			return false;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (maCoSoKhamChuaBenh == null) {
			if (other.maCoSoKhamChuaBenh != null)
				return false;
		} else if (!maCoSoKhamChuaBenh.equals(other.maCoSoKhamChuaBenh))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (tenCoSoKhamChuaBenh == null) {
			if (other.tenCoSoKhamChuaBenh != null)
				return false;
		} else if (!tenCoSoKhamChuaBenh.equals(other.tenCoSoKhamChuaBenh))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		if (thongTinDangKyKhamChuaBenhBanDau == null) {
			if (other.thongTinDangKyKhamChuaBenhBanDau != null)
				return false;
		} else if (!thongTinDangKyKhamChuaBenhBanDau.equals(other.thongTinDangKyKhamChuaBenhBanDau))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CoSoKhamChuaBenh [maCoSoKhamChuaBenh=" + maCoSoKhamChuaBenh + ", tenCoSoKhamChuaBenh="
				+ tenCoSoKhamChuaBenh + ", diaChi=" + diaChi + ", thongTinDangKyKhamChuaBenhBanDau="
				+ thongTinDangKyKhamChuaBenhBanDau + ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", thoiGianCapNhat="
				+ thoiGianCapNhat + "]";
	}

	@Override
	public int compareTo(CoSoKhamChuaBenh o) {
		return this.maCoSoKhamChuaBenh.compareTo(o.maCoSoKhamChuaBenh);
	}

}

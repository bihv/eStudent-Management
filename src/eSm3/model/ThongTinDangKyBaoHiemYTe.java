package eSm3.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import eCore.model.SinhVien;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ThongTinDangKyBaoHiemYTe implements Comparable<ThongTinDangKyBaoHiemYTe> {
	@Id
	public String maThongTinDangKyBaoHiemYTe;
	@ManyToOne
	public DotDangKyBaoHiem dotDangKyBaoHiem;
	public String maCoSoKhamChuaBenh;
	public String tenCoSoKhamChuaBenh;
	public String trangThai;
	public Date thoiGianDangKy;
	public String xa;
	public String huyen;
	public String tinh;
	public String diaChi;
	public String moTa;
	public String ghiChu;
	public Date thoiGianCapNhat;

	public ThongTinDangKyBaoHiemYTe() {
	}

	public ThongTinDangKyBaoHiemYTe(String maThongTinDangKyBaoHiemYTe, DotDangKyBaoHiem dotDangKyBaoHiem,
			String maCoSoKhamChuaBenh, String tenCoSoKhamChuaBenh, String trangThai, Date thoiGianDangKy, String xa,
			String huyen, String tinh, String diaChi, String moTa, String ghiChu, Date thoiGianCapNhat) {
		super();
		this.maThongTinDangKyBaoHiemYTe = maThongTinDangKyBaoHiemYTe;
		this.dotDangKyBaoHiem = dotDangKyBaoHiem;
		this.maCoSoKhamChuaBenh = maCoSoKhamChuaBenh;
		this.tenCoSoKhamChuaBenh = tenCoSoKhamChuaBenh;
		this.trangThai = trangThai;
		this.thoiGianDangKy = thoiGianDangKy;
		this.xa = xa;
		this.huyen = huyen;
		this.tinh = tinh;
		this.diaChi = diaChi;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	public String getMaThongTinDangKyBaoHiemYTe() {
		return maThongTinDangKyBaoHiemYTe;
	}

	public void setMaThongTinDangKyBaoHiemYTe(String maThongTinDangKyBaoHiemYTe) {
		this.maThongTinDangKyBaoHiemYTe = maThongTinDangKyBaoHiemYTe;
	}

	public DotDangKyBaoHiem getDotDangKyBaoHiem() {
		return dotDangKyBaoHiem;
	}

	public void setDotDangKyBaoHiem(DotDangKyBaoHiem dotDangKyBaoHiem) {
		this.dotDangKyBaoHiem = dotDangKyBaoHiem;
	}

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

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public Date getThoiGianDangKy() {
		return thoiGianDangKy;
	}

	public void setThoiGianDangKy(Date thoiGianDangKy) {
		this.thoiGianDangKy = thoiGianDangKy;
	}

	public String getXa() {
		return xa;
	}

	public void setXa(String xa) {
		this.xa = xa;
	}

	public String getHuyen() {
		return huyen;
	}

	public void setHuyen(String huyen) {
		this.huyen = huyen;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
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
	public String toString() {
		return "ThongTinDangKyBaoHiemYTe [maThongTinDangKyBaoHiemYTe=" + maThongTinDangKyBaoHiemYTe
				+ ", dotDangKyBaoHiem=" + dotDangKyBaoHiem + ", maCoSoKhamChuaBenh=" + maCoSoKhamChuaBenh
				+ ", tenCoSoKhamChuaBenh=" + tenCoSoKhamChuaBenh + ", trangThai=" + trangThai + ", thoiGianDangKy="
				+ thoiGianDangKy + ", xa=" + xa + ", huyen=" + huyen + ", tinh=" + tinh + ", diaChi=" + diaChi
				+ ", moTa=" + moTa + ", ghiChu=" + ghiChu + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
		result = prime * result + ((dotDangKyBaoHiem == null) ? 0 : dotDangKyBaoHiem.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((huyen == null) ? 0 : huyen.hashCode());
		result = prime * result + ((maCoSoKhamChuaBenh == null) ? 0 : maCoSoKhamChuaBenh.hashCode());
		result = prime * result + ((maThongTinDangKyBaoHiemYTe == null) ? 0 : maThongTinDangKyBaoHiemYTe.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((tenCoSoKhamChuaBenh == null) ? 0 : tenCoSoKhamChuaBenh.hashCode());
		result = prime * result + ((thoiGianCapNhat == null) ? 0 : thoiGianCapNhat.hashCode());
		result = prime * result + ((thoiGianDangKy == null) ? 0 : thoiGianDangKy.hashCode());
		result = prime * result + ((tinh == null) ? 0 : tinh.hashCode());
		result = prime * result + ((trangThai == null) ? 0 : trangThai.hashCode());
		result = prime * result + ((xa == null) ? 0 : xa.hashCode());
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
		ThongTinDangKyBaoHiemYTe other = (ThongTinDangKyBaoHiemYTe) obj;
		if (diaChi == null) {
			if (other.diaChi != null)
				return false;
		} else if (!diaChi.equals(other.diaChi))
			return false;
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
		if (huyen == null) {
			if (other.huyen != null)
				return false;
		} else if (!huyen.equals(other.huyen))
			return false;
		if (maCoSoKhamChuaBenh == null) {
			if (other.maCoSoKhamChuaBenh != null)
				return false;
		} else if (!maCoSoKhamChuaBenh.equals(other.maCoSoKhamChuaBenh))
			return false;
		if (maThongTinDangKyBaoHiemYTe == null) {
			if (other.maThongTinDangKyBaoHiemYTe != null)
				return false;
		} else if (!maThongTinDangKyBaoHiemYTe.equals(other.maThongTinDangKyBaoHiemYTe))
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
		if (thoiGianDangKy == null) {
			if (other.thoiGianDangKy != null)
				return false;
		} else if (!thoiGianDangKy.equals(other.thoiGianDangKy))
			return false;
		if (tinh == null) {
			if (other.tinh != null)
				return false;
		} else if (!tinh.equals(other.tinh))
			return false;
		if (trangThai == null) {
			if (other.trangThai != null)
				return false;
		} else if (!trangThai.equals(other.trangThai))
			return false;
		if (xa == null) {
			if (other.xa != null)
				return false;
		} else if (!xa.equals(other.xa))
			return false;
		return true;
	}

	@Override
	public int compareTo(ThongTinDangKyBaoHiemYTe o) {
		return this.maThongTinDangKyBaoHiemYTe.compareTo(o.maThongTinDangKyBaoHiemYTe);
	}

}

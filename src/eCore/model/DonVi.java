package eCore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

@Entity
public class DonVi implements Comparable<DonVi> {
	@Id
	public String maDonVi; // NOT Auto => System.getCrrent...
	public String tenDonVi;
	public String email;
	public String soDienThoai;
	public String diaChiLienHe;
	@Type(type = "text")
	public String moTa;
	@Type(type = "text")
	public String ghiChu;
	@ManyToOne(fetch = FetchType.EAGER)
	public DonVi donViCha;
	public Date thoiGianCapNhat;

	public DonVi() {
	}

	public DonVi(String maDonVi, String tenDonVi, String email, String soDienThoai, String diaChiLienHe, String moTa,
			String ghiChu, DonVi donViCha, Date thoiGianCapNhat) {
		super();
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChiLienHe = diaChiLienHe;
		this.moTa = moTa;
		this.ghiChu = ghiChu;
		this.donViCha = donViCha;
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public String toString() {
		return "DonVi [maDonVi=" + maDonVi + ", tenDonVi=" + tenDonVi + ", email=" + email + ", soDienThoai="
				+ soDienThoai + ", diaChiLienHe=" + diaChiLienHe + ", moTa=" + moTa + ", ghiChu=" + ghiChu
				+ ", donViCha=" + donViCha + ", thoiGianCapNhat=" + thoiGianCapNhat + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaChiLienHe == null) ? 0 : diaChiLienHe.hashCode());
		result = prime * result + ((donViCha == null) ? 0 : donViCha.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((ghiChu == null) ? 0 : ghiChu.hashCode());
		result = prime * result + ((maDonVi == null) ? 0 : maDonVi.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((soDienThoai == null) ? 0 : soDienThoai.hashCode());
		result = prime * result + ((tenDonVi == null) ? 0 : tenDonVi.hashCode());
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
		DonVi other = (DonVi) obj;
		if (diaChiLienHe == null) {
			if (other.diaChiLienHe != null)
				return false;
		} else if (!diaChiLienHe.equals(other.diaChiLienHe))
			return false;
		if (donViCha == null) {
			if (other.donViCha != null)
				return false;
		} else if (!donViCha.equals(other.donViCha))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (ghiChu == null) {
			if (other.ghiChu != null)
				return false;
		} else if (!ghiChu.equals(other.ghiChu))
			return false;
		if (maDonVi == null) {
			if (other.maDonVi != null)
				return false;
		} else if (!maDonVi.equals(other.maDonVi))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (soDienThoai == null) {
			if (other.soDienThoai != null)
				return false;
		} else if (!soDienThoai.equals(other.soDienThoai))
			return false;
		if (tenDonVi == null) {
			if (other.tenDonVi != null)
				return false;
		} else if (!tenDonVi.equals(other.tenDonVi))
			return false;
		if (thoiGianCapNhat == null) {
			if (other.thoiGianCapNhat != null)
				return false;
		} else if (!thoiGianCapNhat.equals(other.thoiGianCapNhat))
			return false;
		return true;
	}

	public String getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiLienHe() {
		return diaChiLienHe;
	}

	public void setDiaChiLienHe(String diaChiLienHe) {
		this.diaChiLienHe = diaChiLienHe;
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

	public DonVi getDonViCha() {
		return donViCha;
	}

	public void setDonViCha(DonVi donViCha) {
		this.donViCha = donViCha;
	}

	public Date getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}

	public void setThoiGianCapNhat(Date thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}

	@Override
	public int compareTo(DonVi arg0) {
		return this.maDonVi.compareTo(arg0.maDonVi);
	}

}

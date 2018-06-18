package eSm3.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import eCore.model.SinhVien;

@Entity
public class ThongTinDangKyBaoHiemYTeSinhVien extends ThongTinDangKyBaoHiemYTe {
	@ManyToOne
	public SinhVien sinhVien;

	public ThongTinDangKyBaoHiemYTeSinhVien(SinhVien sinhVien) {
		super();
		this.sinhVien = sinhVien;
	}

	public ThongTinDangKyBaoHiemYTeSinhVien() {
		super();
	}

	public SinhVien getSinhVien() {
		return sinhVien;
	}

	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((sinhVien == null) ? 0 : sinhVien.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThongTinDangKyBaoHiemYTeSinhVien other = (ThongTinDangKyBaoHiemYTeSinhVien) obj;
		if (sinhVien == null) {
			if (other.sinhVien != null)
				return false;
		} else if (!sinhVien.equals(other.sinhVien))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ThongTinDangKyBaoHiemYTeSinhVien [sinhVien=" + sinhVien + "]";
	}

}

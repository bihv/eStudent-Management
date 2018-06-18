package eSm3.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import eCore.model.NhanVien;

@Entity
public class ThongTinDangKyBaoHiemYTeNhanVien extends ThongTinDangKyBaoHiemYTe {
	@ManyToOne
	public NhanVien nhanVien;

	public ThongTinDangKyBaoHiemYTeNhanVien(NhanVien nhanVien) {
		super();
		this.nhanVien = nhanVien;
	}

	public ThongTinDangKyBaoHiemYTeNhanVien() {
		super();
	}

	@Override
	public String toString() {
		return "ThongTinDangKyBaoHiemYTeNhanVien [nhanVien=" + nhanVien + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nhanVien == null) ? 0 : nhanVien.hashCode());
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
		ThongTinDangKyBaoHiemYTeNhanVien other = (ThongTinDangKyBaoHiemYTeNhanVien) obj;
		if (nhanVien == null) {
			if (other.nhanVien != null)
				return false;
		} else if (!nhanVien.equals(other.nhanVien))
			return false;
		return true;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	

}

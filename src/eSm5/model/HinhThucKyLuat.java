package eSm5.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HinhThucKyLuat implements Comparable<HinhThucKyLuat> {
	@Id
	String maHinhThucKyLuat;
	String tenHinhThucKyLuat;

	public HinhThucKyLuat(String maHinhThucKyLuat, String tenHinhThucKyLuat) {
		super();
		this.maHinhThucKyLuat = maHinhThucKyLuat;
		this.tenHinhThucKyLuat = tenHinhThucKyLuat;
	}

	public HinhThucKyLuat() {
		super();
	}

	@Override
	public String toString() {
		return "HinhThucKyLuat [maHinhThucKyLuat=" + maHinhThucKyLuat + ", tenHinhThucKyLuat=" + tenHinhThucKyLuat
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maHinhThucKyLuat == null) ? 0 : maHinhThucKyLuat.hashCode());
		result = prime * result + ((tenHinhThucKyLuat == null) ? 0 : tenHinhThucKyLuat.hashCode());
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
		HinhThucKyLuat other = (HinhThucKyLuat) obj;
		if (maHinhThucKyLuat == null) {
			if (other.maHinhThucKyLuat != null)
				return false;
		} else if (!maHinhThucKyLuat.equals(other.maHinhThucKyLuat))
			return false;
		if (tenHinhThucKyLuat == null) {
			if (other.tenHinhThucKyLuat != null)
				return false;
		} else if (!tenHinhThucKyLuat.equals(other.tenHinhThucKyLuat))
			return false;
		return true;
	}

	public String getMaHinhThucKyLuat() {
		return maHinhThucKyLuat;
	}

	public void setMaHinhThucKyLuat(String maHinhThucKyLuat) {
		this.maHinhThucKyLuat = maHinhThucKyLuat;
	}

	public String getTenHinhThucKyLuat() {
		return tenHinhThucKyLuat;
	}

	public void setTenHinhThucKyLuat(String tenHinhThucKyLuat) {
		this.tenHinhThucKyLuat = tenHinhThucKyLuat;
	}

	@Override
	public int compareTo(HinhThucKyLuat o) {
		return this.maHinhThucKyLuat.compareTo(o.maHinhThucKyLuat);
	}

}

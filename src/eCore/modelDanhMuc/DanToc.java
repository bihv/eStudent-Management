package eCore.modelDanhMuc;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DanToc implements Comparable<DanToc>{
	@Id
	public String maDanToc;
	public String tenDanToc;
	
	



	public DanToc() {
	}



	public DanToc(String maDanToc, String tenDanToc) {
		this.maDanToc = maDanToc;
		this.tenDanToc = tenDanToc;
	}



	public String getMaDanToc() {
		return maDanToc;
	}



	public void setMaDanToc(String maDanToc) {
		this.maDanToc = maDanToc;
	}



	public String getTenDanToc() {
		return tenDanToc;
	}



	public void setTenDanToc(String tenDanToc) {
		this.tenDanToc = tenDanToc;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDanToc == null) ? 0 : maDanToc.hashCode());
		result = prime * result + ((tenDanToc == null) ? 0 : tenDanToc.hashCode());
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
		DanToc other = (DanToc) obj;
		if (maDanToc == null) {
			if (other.maDanToc != null)
				return false;
		} else if (!maDanToc.equals(other.maDanToc))
			return false;
		if (tenDanToc == null) {
			if (other.tenDanToc != null)
				return false;
		} else if (!tenDanToc.equals(other.tenDanToc))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "DanToc [maDanToc=" + maDanToc + ", tenDanToc=" + tenDanToc + "]";
	}



	@Override
	public int compareTo(DanToc o) {
		return this.maDanToc.compareTo(o.maDanToc);
	}
	
	
}

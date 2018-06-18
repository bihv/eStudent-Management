package eCore.modelDanhMuc;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TonGiao implements Comparable<TonGiao> {
	@Id
	public String maTonGiao;
	public String tenTonGiao;
	
	
	public TonGiao() {
	}


	public TonGiao(String maTonGiao, String tenTonGiao) {
		this.maTonGiao = maTonGiao;
		this.tenTonGiao = tenTonGiao;
	}


	public String getMaTonGiao() {
		return maTonGiao;
	}


	public void setMaTonGiao(String maTonGiao) {
		this.maTonGiao = maTonGiao;
	}


	public String getTenTonGiao() {
		return tenTonGiao;
	}


	public void setTenTonGiao(String tenTonGiao) {
		this.tenTonGiao = tenTonGiao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTonGiao == null) ? 0 : maTonGiao.hashCode());
		result = prime * result + ((tenTonGiao == null) ? 0 : tenTonGiao.hashCode());
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
		TonGiao other = (TonGiao) obj;
		if (maTonGiao == null) {
			if (other.maTonGiao != null)
				return false;
		} else if (!maTonGiao.equals(other.maTonGiao))
			return false;
		if (tenTonGiao == null) {
			if (other.tenTonGiao != null)
				return false;
		} else if (!tenTonGiao.equals(other.tenTonGiao))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "TonGiao [maTonGiao=" + maTonGiao + ", tenTonGiao=" + tenTonGiao + "]";
	}


	@Override
	public int compareTo(TonGiao o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

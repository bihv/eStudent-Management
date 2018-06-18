package eCore.modelDao;

import eCore.dao.ObjectDAO;
import eCore.model.SinhVien;

public class DAO_SinhVien extends ObjectDAO<SinhVien>{
	public DAO_SinhVien() {
		this.table = "SinhVien";
	}
}

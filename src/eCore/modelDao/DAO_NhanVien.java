package eCore.modelDao;

import eCore.dao.ObjectDAO;
import eCore.model.NhanVien;

public class DAO_NhanVien extends ObjectDAO<NhanVien> {
	public DAO_NhanVien() {
		this.table = "NhanVien";
	}
}

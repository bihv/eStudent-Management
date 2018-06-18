package eCore.modelDao;

import eCore.dao.ObjectDAO;
import eCore.model.TaiKhoanNhanVien;

public class DAO_TaiKhoanNhanVien extends ObjectDAO<TaiKhoanNhanVien> {
	public DAO_TaiKhoanNhanVien() {
		this.table = "TaiKhoanNhanVien";
	}
}

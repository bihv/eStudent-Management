package eCore.dao;

import java.util.ArrayList;
import java.util.Date;

import eCore.model.ChucNang;
import eCore.model.DonVi;
import eCore.model.HocKy;
import eCore.model.Lop;
import eCore.model.NamHoc;
import eCore.modelDao.DAO_ChucNang;
import eCore.modelDao.DAO_DonVi;
import eCore.modelDao.DAO_HocKy;
import eCore.modelDao.DAO_Lop;
import eCore.modelDao.DAO_NamHoc;

public class TestDao {
	public static void main(String[] args) {
		// ObjectDAO<NamHoc> dao_namHoc= new DAO_NamHoc();
		// for (int i = 2013; i < 2019; i++) {
		// NamHoc l = new NamHoc(i + "-" + (i + 1), i + "-" + (i + 1), new Date(i -
		// 1900, 9 - 1, 1),
		// new Date(i + 1 - 1900, 8 - 1, 30), "", "", new Date());
		// dao.saveOrUpdate(l);
		// }
		// ObjectDAO<HocKy> dao = new DAO_HocKy();
		// for (int i = 2013; i < 2019; i++) {
		// HocKy l = new HocKy("Học kỳ I năm "+i+"-"+(i+1), "Học kỳ I năm "+i +"-"+(i+1)
		// , new Date(i - 1900, 9 - 1, 1) , new Date(i - 1900, 8 - 1, 30), "", "",
		// dao_namHoc.listByColumns("maNamHoc", i + "-" + (i + 1)).get(0), new Date());
		// dao.saveOrUpdate(l);
		// HocKy l2 = new HocKy("Học kỳ II năm "+i+"-"+(i+1), "Học kỳ II năm "+i
		// +"-"+(i+1) , new Date(i - 1900, 9 - 1, 1) , new Date(i - 1900, 8 - 1, 30),
		// "", "", dao_namHoc.listByColumns("maNamHoc", i + "-" + (i + 1)).get(0), new
		// Date());
		// dao.saveOrUpdate(l2);
		// }

		// ObjectDAO<DonVi> dao = new DAO_DonVi();
		// dao.saveOrUpdate(new DonVi("Đơn vị 0", "Đơn vị 0", "donvi@utc2.edu.vn",
		// "0123456701", "450 Lê Văn Việt", "", "",
		// null, new Date()));
		// for (int i = 1; i < 10; i++) {
		// DonVi l = new DonVi("Đơn vị " + i, "Đơn vị " + i, "donvi" + i +
		// "@utc2.edu.vn", "01234567" + i + (i + 1),
		// "450 Lê Văn Việt", "", "", dao.listByColumns("maDonVi", "Đơn vị " +
		// (i-1)).get(0), new Date());
		// dao.saveOrUpdate(l);
		// }

		ObjectDAO<ChucNang> dao = new DAO_ChucNang();
		ArrayList<ChucNang> list_chucNang = dao.listAll();
		for (int i = 0; i < list_chucNang.size(); i++) {
			ChucNang chucNang = list_chucNang.get(i);
			System.out.println("ChucNang " + chucNang.getMaChucNang().replaceAll(" ", "_") + " = new ChucNang();");
			System.out.println(chucNang.getMaChucNang().replaceAll(" ", "_") + ".setMaChucNang(\""
					+ chucNang.getMaChucNang() + "\");");
			System.out.println(chucNang.getMaChucNang().replaceAll(" ", "_") + ".setDuongDan(\""
					+ chucNang.getDuongDan() + "\");");
			System.out.println(
					chucNang.getMaChucNang().replaceAll(" ", "_") + ".setHinhAnh(\"" + chucNang.getHinhAnh() + "\");");
			System.out.println(chucNang.getMaChucNang().replaceAll(" ", "_") + ".setTenHienThi(\""
					+ chucNang.getTenHienThi() + "\");");
			System.out.println(chucNang.getMaChucNang().replaceAll(" ", "_") + ".setChucNangCha();");
			System.out.println("daochucnang.saveOrUpdate(" + chucNang.getMaChucNang().replaceAll(" ", "_") + ");");
			System.out.println();
		}

	}
}

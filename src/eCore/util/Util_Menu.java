package eCore.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import eCore.model.ChucNang;
import eCore.model.NhomPhanQuyen;
import eCore.model.TaiKhoan;
import eCore.modelDao.DAO_TaiKhoan;

public class Util_Menu {
	public static String getMenu(String maDangNhap) {
		String result = "";
		try {
			TaiKhoan tk = (new DAO_TaiKhoan()).listByColumns("maDangNhap", maDangNhap).get(0);
			System.out.println(tk.getMaDangNhap());
			NhomPhanQuyen nhomPhanQuyen = ((TaiKhoan) tk).getNhomPhanQuyen();
			System.out.println(nhomPhanQuyen.getMaNhomPhanQuyen());

			HashMap<String, TreeSet<ChucNang>> hashMap = new HashMap<String, TreeSet<ChucNang>>();
			hashMap.put("-", new TreeSet<>());
			for (ChucNang chucNang : nhomPhanQuyen.getChucNangs()) {
				String key = chucNang.getChucNangCha() == null ? "-" : chucNang.getChucNangCha().getMaChucNang();
				TreeSet<ChucNang> cns = new TreeSet<>();
				if (hashMap.containsKey(key)) {
					cns = (TreeSet<ChucNang>) hashMap.get(key);
				}
				cns.add(chucNang);
				hashMap.put(key, cns);
			}

			TreeSet<ChucNang> treeSet = hashMap.get("-");
			for (ChucNang chucNang2 : treeSet) {
				result += "<li><a href=index.jsp?p=" + chucNang2.duongDan + "><i class=\"" + chucNang2.hinhAnh
						+ "\"></i> <span class=\"masked\"> " + chucNang2.tenHienThi
						+ " <span class=\"fa arrow\"></span> </span> </a>";
				if (hashMap.containsKey(chucNang2.getMaChucNang())) {
					TreeSet<ChucNang> treeSet2 = hashMap.get(chucNang2.getMaChucNang());
					result += "<ul class=\"nav nav-second-level collapse\" aria-expanded=\"true\"\r\n style=\"height: 0px;\">";
					for (ChucNang chucNang3 : treeSet2) {
						result += "<li><a  href=index.jsp?p=" + chucNang3.duongDan + "><i class=\""
								+ chucNang3.hinhAnh + "\"></i> <span class=\"masked\"> " + chucNang3.tenHienThi
								+ " </span> </a>";
					}
					result += "</ul>";
				}
				result += "</li>";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String getMenu2(String maDangNhap) {
		String result = "";
		try {
			TaiKhoan tk = (new DAO_TaiKhoan()).listByColumns("maDangNhap", maDangNhap).get(0);
			System.out.println(tk.getMaDangNhap());
			NhomPhanQuyen nhomPhanQuyen = ((TaiKhoan) tk).getNhomPhanQuyen();
			System.out.println(nhomPhanQuyen.getMaNhomPhanQuyen());

			HashMap<String, TreeSet<ChucNang>> hashMap = new HashMap<String, TreeSet<ChucNang>>();
			hashMap.put("-", new TreeSet<>());
			for (ChucNang chucNang : nhomPhanQuyen.getChucNangs()) {
				String key = chucNang.getChucNangCha() == null ? "-" : chucNang.getChucNangCha().getMaChucNang();
				TreeSet<ChucNang> cns = new TreeSet<>();
				if (hashMap.containsKey(key)) {
					cns = (TreeSet<ChucNang>) hashMap.get(key);
				}
				cns.add(chucNang);
				hashMap.put(key, cns);
			}

			TreeSet<ChucNang> treeSet = hashMap.get("-");
			for (ChucNang chucNang2 : treeSet) {
				result += "<li class=\"dropdown\"><a class=\"dropdown-toggle\" style=\"color: white;\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\" href=index.jsp?p=" + chucNang2.duongDan + "><i class=\"" + chucNang2.hinhAnh
						+ "\"></i> <span class=\"masked\"> " + chucNang2.tenHienThi
						+ "</a>";
				if (hashMap.containsKey(chucNang2.getMaChucNang())) {
					TreeSet<ChucNang> treeSet2 = hashMap.get(chucNang2.getMaChucNang());
					result += "<ul class=\"dropdown-menu\" >";
					for (ChucNang chucNang3 : treeSet2) {
						result += "<li><a  href=index.jsp?p=" + chucNang3.duongDan + "><i class=\""
								+ chucNang3.hinhAnh + "\"></i> &nbsp;&nbsp;" + chucNang3.tenHienThi
								+ " </a>";
					}
					result += "</ul>";
				}
				result += "</li>";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

<%@page import="eSm5.modelDao.DAO_ThongTinKyLuat"%>
<%@page import="eSm5.model.ThongTinKyLuat"%>
<%@page import="eSm4.model.ThongTinNgoaiTru"%>
<%@page import="eSm4.modelDao.DAO_ThongTinNgoaiTru"%>
<%@page import="eSm4.modelDao.DAO_DotKeKhaiThongTinNgoaiTru"%>
<%@page import="eSm4.model.DotKeKhaiThongTinNgoaiTru"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCore.modelDao.DAO_SinhVien"%>
<%@page import="eCore.model.SinhVien"%>
<%@page import="eCore.dao.ObjectDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ObjectDAO<SinhVien> dao_SinhVien = new DAO_SinhVien();
	ArrayList<SinhVien> list_SinhVien = dao_SinhVien.listAll();
	int soSinhVien = list_SinhVien.size();
%>

<%
	// lay ra nam da chon
	String namHoc = request.getParameter("namHoc"); // 2017-2018

	String[] arr = namHoc.split("-");
	int namBatDau = Integer.parseInt(arr[0]);
	int namKetThuc = Integer.parseInt(arr[1]);
	ObjectDAO<DotKeKhaiThongTinNgoaiTru> obj_DotKeKhaiThongTinNgoaiTru = new DAO_DotKeKhaiThongTinNgoaiTru();
	ArrayList<DotKeKhaiThongTinNgoaiTru> ls_DotKeKhaiThongTinNgoaiTru = obj_DotKeKhaiThongTinNgoaiTru.listAll();
	// lay ra dot dang ky co thoi gian bat dau tuong ung voi nam hoc da chon
	ls_DotKeKhaiThongTinNgoaiTru = obj_DotKeKhaiThongTinNgoaiTru
			.listByQuery("FROM DotKeKhaiThongTinNgoaiTru WHERE ngayBatDau > '" + namBatDau
					+ "-9-1' AND ngayBatDau < '" + namKetThuc + "-9-1'");
	System.out.println("ls_DotDangKyNgoaiTru = " + ls_DotKeKhaiThongTinNgoaiTru);
	String maDotKeKhaiThongTinNgoaiTru = "";

	ObjectDAO obj2 = new DAO_ThongTinNgoaiTru();
	ArrayList<ThongTinNgoaiTru> ls2 = new ArrayList<ThongTinNgoaiTru>();
	ArrayList<ThongTinNgoaiTru> ls_SinhVienNgoaiTru = new ArrayList<ThongTinNgoaiTru>();
	for (int i = 0; i < ls_DotKeKhaiThongTinNgoaiTru.size(); i++) {
		maDotKeKhaiThongTinNgoaiTru = ls_DotKeKhaiThongTinNgoaiTru.get(i).getMaDotKeKhaiThongTinNgoaiTru();
		// lay ra danh sach sinh vien ngoai tru theo nam hoc da chon o tren
		ls2 = obj2.listByColumns("dotKeKhaiThongTinNgoaiTru", maDotKeKhaiThongTinNgoaiTru);
		ls_SinhVienNgoaiTru.addAll(ls2);
	}

	int soSinhVienThueTro = 0;
	ArrayList<ThongTinKyLuat> list_ThongTinKyLuat = new ArrayList<ThongTinKyLuat>();
	ArrayList<ThongTinKyLuat> list_ThongTinKyLuat2 = new ArrayList<ThongTinKyLuat>();
	for (int i = 0; i < ls_SinhVienNgoaiTru.size(); i++) {
		if (ls_SinhVienNgoaiTru.get(i).isThueNhaTro())
			soSinhVienThueTro++;
		ObjectDAO<ThongTinKyLuat> dao_ThongTinKyLuat = new DAO_ThongTinKyLuat();
		list_ThongTinKyLuat = dao_ThongTinKyLuat.listByColumns("sinhVien",
				ls_SinhVienNgoaiTru.get(i).getSinhVien().getMaSinhVien());
		list_ThongTinKyLuat2.addAll(list_ThongTinKyLuat);
	}

	int khienTrach = 0;
	int canhCao = 0;
	int dinhChiHocTap1Nam = 0;
	int buocThoiHoc = 0;
	int hinhthucxulykhac = 0;
	for (int i = 0; i < list_ThongTinKyLuat2.size(); i++) {
		ThongTinKyLuat thongTinKyLuat = list_ThongTinKyLuat2.get(i);
		if (thongTinKyLuat.getHinhThucKyLuat().getMaHinhThucKyLuat().equals("buocthoihoc"))
			buocThoiHoc++;
		if (thongTinKyLuat.getHinhThucKyLuat().getMaHinhThucKyLuat().equals("canhcao"))
			canhCao++;
		if (thongTinKyLuat.getHinhThucKyLuat().getMaHinhThucKyLuat().equals("dinhchihoctap1namhoc"))
			dinhChiHocTap1Nam++;
		if (thongTinKyLuat.getHinhThucKyLuat().getMaHinhThucKyLuat().equals("hinhthucxulykhac"))
			hinhthucxulykhac++;
		if (thongTinKyLuat.getHinhThucKyLuat().getMaHinhThucKyLuat().equals("khientrach"))
			khienTrach++;
	}
%>

<table border=0 cellspacing=0 cellpadding=0 width="100%"
	style='width: 100.0%; border-collapse: collapse'>
	<!--VABWAFAATABfADIAMAAxADcAMAAyADIAMwA=-->
	<tr>
		<td width="37%" valign=top
			style='width: 37.8%; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'>
				<b>ĐƠN VỊ:</b> ………………………
			</p>
		</td>
		<td width="62%" valign=top
			style='width: 62.2%; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>
				<b><span lang=NL>CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM<br>
						Độc lập - Tự do - Hạnh phúc<br> -----------
				</span></b>
			</p>
		</td>
	</tr>
	<tr>
		<td width="37%" valign=top
			style='width: 37.8%; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>&nbsp;</p>
		</td>
		<td width="62%" valign=top
			style='width: 62.2%; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=right style='margin-bottom: 6.0pt; text-align: right'>
				<i>&nbsp;</i>
			</p>
		</td>
	</tr>
</table>

<p style='margin-bottom: 6.0pt'>
	<span style='font-size: 8.0pt'>&nbsp;</span>
</p>

<p align=center style='margin-bottom: 6.0pt; text-align: center'>Kính
	gửi: …………………………………………………………………………………..</p>

<p align=center style='margin-bottom: 6.0pt; text-align: center'>
	<b>BÁO CÁO CÔNG TÁC HỌC SINH, SINH VIÊN NGOẠI TRÚ NĂM HỌC <%=namHoc%></b>
</p>

<p align=center style='margin-bottom: 6.0pt; text-align: center'>
	<b>&nbsp;</b>
</p>

<table border=1 cellspacing=0 cellpadding=0 width="100%"
	style='width: 100.0%; border-collapse: collapse; border: none'>
	<tr>
		<td width="3%" rowspan=2
			style='width: 3.5%; border: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>
				<b>TT</b>
			</p>
		</td>
		<td width="19%" rowspan=2
			style='width: 19.1%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>
				<b>Trình độ đào tạo</b>
			</p>
		</td>
		<td width="6%" rowspan=2
			style='width: 6.76%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>
				<b>Tổng số HSSV toàn trường</b>
			</p>
		</td>
		<td width="15%" colspan=2
			style='width: 15.7%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>
				<b>HSSV ngoại trú</b>
			</p>
		</td>
		<td width="7%" rowspan=2
			style='width: 7.84%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>
				<b>Số lần nhà trường đi kiểm tra nơi ngoại trú của HSSV</b>
			</p>
		</td>
		<td width="7%" rowspan=2
			style='width: 7.84%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>
				<b>Số lần phối hợp với địa phương kiểm tra, giao ban</b>
			</p>
		</td>
		<td width="39%" colspan=5
			style='width: 39.24%; border: solid windowtext 1.0pt; border-left: none; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>
				<b>Số HSSV bị kỷ luật do vi phạm quy chế HSSV ngoại trú</b>
			</p>
		</td>
	</tr>
	<tr>
		<td width="7%"
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>Tổng
				số HSSV ngoại trú</p>
		</td>
		<td width="7%"
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>Số
				HSSV thuê nhà trọ</p>
		</td>
		<td width="7%"
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>Khiển
				trách</p>
		</td>
		<td width="7%"
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>Cảnh
				cáo</p>
		</td>
		<td width="7%"
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>Đình
				chỉ học tập 1 năm học</p>
		</td>
		<td width="7%"
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>Buộc
				thôi học</p>
		</td>
		<td width="7%"
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>Hình
				thức xử lý khác</p>
		</td>
	</tr>
	<tr>
		<td width="3%" valign=top
			style='width: 3.5%; border: solid windowtext 1.0pt; border-top: none; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p align=center style='margin-bottom: 6.0pt; text-align: center'>1</p>
		</td>
		<td width="19%" valign=top
			style='width: 19.1%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'>Đại học</p>
		</td>
		<td width="6%" valign=top
			style='width: 6.76%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'><%=soSinhVien%></p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'><%=ls_SinhVienNgoaiTru.size()%></p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'><%=soSinhVienThueTro%></p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'>&nbsp;</p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'>&nbsp;</p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'><%=khienTrach%></p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'><%=canhCao%></p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'><%=dinhChiHocTap1Nam%></p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'><%=buocThoiHoc%></p>
		</td>
		<td width="7%" valign=top
			style='width: 7.84%; border-top: none; border-left: none; border-bottom: solid windowtext 1.0pt; border-right: solid windowtext 1.0pt; padding: 0cm 5.4pt 0cm 5.4pt'>
			<p style='margin-bottom: 6.0pt'><%=hinhthucxulykhac%></p>
		</td>
	</tr>
</table>

<p style='margin-bottom: 6.0pt'>- Thành tích của trường trong công
	tác HSSV ngoại
	trú: .................................................................................................
</p>

<p style='margin-bottom: 6.0pt'>..........................................................................................................................................................................................
</p>

<p style='margin-bottom: 6.0pt'>- Đề xuất, kiến
	nghị:............................................................................................................................................................
</p>

<p style='margin-bottom: 6.0pt'>..........................................................................................................................................................................................
</p>


<%session.removeAttribute("msg"); %>
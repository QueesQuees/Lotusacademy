package com.example.LotusacademyBackend.controller;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LotusacademyBackend.model.DangKyHoc;
import com.example.LotusacademyBackend.model.KhoaHoc;
import com.example.LotusacademyBackend.model.TinhTrangHoc;
import com.example.LotusacademyBackend.service.DangKyHocService;
import com.example.LotusacademyBackend.service.KhoaHocService;
import com.example.LotusacademyBackend.service.TinhTrangHocService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value = "/dangkyhoc")
public class DangKyHocController {
	
	@Autowired
	DangKyHocService dangKyHocService;
	@Autowired
	TinhTrangHocService tinhTrangHocService;
	@Autowired
	KhoaHocService khoaHocService;
	
	//Danh sách đăng ký học
	@GetMapping(value = "/danhsach")
	public Page<DangKyHoc> danhSachDangKyHoc(@RequestParam String page, String size) {
		int page1 = Integer.parseInt(page);
		int size1 = Integer.parseInt(size);
		Pageable pageable = PageRequest.of(page1, size1);
		return dangKyHocService.getAll(pageable);
	}
	
	//Thêm đăng ký học
	@PostMapping(value = "/them")
	public String themDangKyHoc(@RequestBody String dangKyHoc) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		DangKyHoc dangKyHocNew = gson.fromJson(dangKyHoc, DangKyHoc.class);	
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		dangKyHocNew.setNgayDangKy(date);
		dangKyHocNew.setNgayKetThuc(null);
		dangKyHocNew.setNgayBatDau(null);
		dangKyHocNew.setTaiKhoan(null);
		TinhTrangHoc tinhTrangHoc = tinhTrangHocService.getOne(1);
		dangKyHocNew.setTinhTrangHoc(tinhTrangHoc);
		dangKyHocService.add(dangKyHocNew);
		return "Success";
	}
	
	//sửa đăng ký học
	@PutMapping(value = "/sua")
	public String suaDangKyHoc(@RequestBody String dangKyHoc) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		DangKyHoc dangKyHocNew = gson.fromJson(dangKyHoc, DangKyHoc.class);	
		
		//tính ngày bắt đầu
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		int idTinhTrangHoc = dangKyHocNew.getTinhTrangHoc().getTinhTrangHocID();
		DangKyHoc dangKyHocCu = dangKyHocService.getOne(dangKyHocNew.getDangKyHocID());
		dangKyHocNew.setNgayDangKy(dangKyHocCu.getNgayDangKy());
		if (dangKyHocCu.getTinhTrangHoc().getTinhTrangHocID() == 1) {
			if (idTinhTrangHoc == 2) {
				dangKyHocNew.setNgayBatDau(date);
			}
		}
		//Tính ngày kết thúc
		KhoaHoc khoaHoc = khoaHocService.getOne(dangKyHocNew.getKhoaHoc().getKhoaHocID());
		int thoiGianHoc = khoaHoc.getThoiGianHoc();
		Long time = (Long) (thoiGianHoc * 86400000L);
		long ngayBatDau = dangKyHocNew.getNgayBatDau().getTime();
		long ngayKetThuc = time + ngayBatDau;
		dangKyHocNew.setNgayKetThuc(new Date(ngayKetThuc));		
		dangKyHocService.update(dangKyHocNew);
		return "Success";
	}
	
	//xóa đăng ký học
	@DeleteMapping(value = "/xoa")
	public String xoaDangKyHoc(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		dangKyHocService.delete(id1);
		
		return "Delete success";
	}
}

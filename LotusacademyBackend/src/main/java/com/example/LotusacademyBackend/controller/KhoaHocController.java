package com.example.LotusacademyBackend.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.LotusacademyBackend.model.KhoaHoc;
import com.example.LotusacademyBackend.service.KhoaHocService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/khoahoc")
public class KhoaHocController {

	@Autowired
	KhoaHocService khoaHocService;
	
	//danh sách khóa học
	@GetMapping(value = "/danhsach")
	public Page<KhoaHoc> danhSachKhoaHoc(@RequestParam String page, String size) {
		int page1 = Integer.parseInt(page);
		int size1 = Integer.parseInt(size);
		Pageable pageable = PageRequest.of(page1, size1);	
		return khoaHocService.getAll(pageable);
	}
	
	@GetMapping(value = "/danhsachs")
	public List<KhoaHoc> danhSachKhoaHoc() {
		return khoaHocService.getAll();
	}
	
	//Thêm khóa học
	@PostMapping(value = "/them")
	public void themKhoaHoc(@RequestBody String khoaHoc) {
		Gson gson = new Gson();
		KhoaHoc khoaHocNew = gson.fromJson(khoaHoc, KhoaHoc.class);
		khoaHocService.add(khoaHocNew);
	}
	
	//Sửa khóa học
	@PutMapping(value = "/sua")
	public void suaKhoaHoc(@RequestBody String khoaHoc) {
		Gson gson = new Gson();
		KhoaHoc khoaHocNew = gson.fromJson(khoaHoc, KhoaHoc.class);
		khoaHocService.update(khoaHocNew);
	}
	
	//xóa khóa học
	@DeleteMapping(value = "/xoa")
	public void xoaKhoaHoc(@RequestParam String id) {
		int idKhoaHoc = Integer.parseInt(id);
		khoaHocService.delete(idKhoaHoc);
	}
	
	//Tìm kiếm khóa học theo tên
	@GetMapping(value = "/timkiem")
	public List<KhoaHoc> timKiemKhoaHoc (@RequestParam String tenKhoaHoc) {
		List<KhoaHoc> lstResult = new ArrayList<KhoaHoc>();
		
		List<KhoaHoc> lstKhoaHoc = khoaHocService.getAll();
				
		for (int i = 0; i < lstKhoaHoc.size(); i++) {
			if (lstKhoaHoc.get(i).getTenKhoaHoc().toLowerCase().contains(tenKhoaHoc.toLowerCase())) {
				lstResult.add(lstKhoaHoc.get(i));
			}
		}
			
		return lstResult;
	}
	
}

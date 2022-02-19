package com.example.LotusacademyBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LotusacademyBackend.model.LoaiKhoaHoc;
import com.example.LotusacademyBackend.service.LoaiKhoaHocService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/loaikhoahoc")
public class LoaiKhoaHocController {

	@Autowired
	LoaiKhoaHocService loaiKhoaHocService;
	
	//Danh sách loại khóa học
	@GetMapping(value = "/danhsach")
	public List<LoaiKhoaHoc> danhSachLoaiKhoaHoc() {
		return loaiKhoaHocService.getAll();
	}
	
	//Thêm loại khóa  học
	@PostMapping(value = "/them")
	public void themLoaiKhoaHoc(@RequestBody String loaiKhoaHoc) {
		Gson gson = new Gson();
		LoaiKhoaHoc loaiKhoaHocNew = gson.fromJson(loaiKhoaHoc, LoaiKhoaHoc.class);
		loaiKhoaHocService.add(loaiKhoaHocNew);
	}
	
	//Sửa loại khóa học
	@PutMapping(value = "/sua")
	public void suaLoaiKhoaHoc(@RequestBody String loaiKhoaHoc) {
		Gson gson = new Gson();
		LoaiKhoaHoc loaiKhoaHocNew = gson.fromJson(loaiKhoaHoc, LoaiKhoaHoc.class);
		loaiKhoaHocService.update(loaiKhoaHocNew);
	}
	
	//Xóa loại khóa học
	@DeleteMapping(value = "/xoa")
	public void xoaLoaiKhoaHoc(@RequestParam String id) {
		int idLoaiKhoaHoc = Integer.parseInt(id);
		loaiKhoaHocService.delete(idLoaiKhoaHoc);
	}

}

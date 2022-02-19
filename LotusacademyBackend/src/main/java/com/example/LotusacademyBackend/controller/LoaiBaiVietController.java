package com.example.LotusacademyBackend.controller;

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

import com.example.LotusacademyBackend.model.LoaiBaiViet;
import com.example.LotusacademyBackend.service.LoaiBaiVietService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/loaibaiviet")
public class LoaiBaiVietController {
	
	@Autowired
	LoaiBaiVietService loaiBaiVietService;
	
	//Danh sách loại bài viết
	@GetMapping(value = "/danhsach")
	public Page<LoaiBaiViet> danhSachLoaiBaiViet(@RequestParam String page, String size) {
		int page1 = Integer.parseInt(page);
		int size1 = Integer.parseInt(size);
		Pageable pageable = PageRequest.of(page1, size1);
		return loaiBaiVietService.getAll(pageable);
	}
	
	//Thêm loại bài viết
	@PostMapping(value = "/them")
	public String themLoaiBaiViet(@RequestBody String loaiBaiViet) {
		Gson gson = new Gson();
		LoaiBaiViet loaiBaiVietNew = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
		loaiBaiVietService.add(loaiBaiVietNew);
		return "Thêm loại bài viết mới thành công.";
	}
	
	//Sửa loại bài viết
	@PutMapping(value = "/sua")
	public String suaLoaiBaiViet(@RequestBody String loaiBaiViet) {
		Gson gson = new Gson();
		LoaiBaiViet loaiBaiVietNew = gson.fromJson(loaiBaiViet, LoaiBaiViet.class);
		loaiBaiVietService.add(loaiBaiVietNew);
		return "Sửa loại bài viết thành công.";
	}
	
	//xóa loại bài viết
	@DeleteMapping(value = "/xoa")
	public String xoaLoaiBaiViet(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		loaiBaiVietService.delete(id1);
		return "Xóa thành công";
	}
}

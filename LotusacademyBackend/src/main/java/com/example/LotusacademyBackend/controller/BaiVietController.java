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

import com.example.LotusacademyBackend.model.BaiViet;
import com.example.LotusacademyBackend.service.BaiVietService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value = "/baiviet")
public class BaiVietController {

	@Autowired
	BaiVietService baiVietService;

	// Lấy tất cả các bài viết
	@GetMapping(value = "/danhsach")
	public Page<BaiViet> danhSachBaiViet(@RequestParam String page, String size) {
		int page1 = Integer.parseInt(page);
		int size1 = Integer.parseInt(size);
		Pageable pageable = PageRequest.of(page1, size1);		
		return baiVietService.getAll(pageable);
	}

	// Thêm bài viết
	@PostMapping(value = "/them")
	public String themBaiViet(@RequestBody String baiViet) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		BaiViet baiVietMoi = gson.fromJson(baiViet, BaiViet.class);
		Date thoiGianTao = new Date(Calendar.getInstance().getTime().getTime());
		baiVietMoi.setThoiGianTao(thoiGianTao);		
		baiVietService.add(baiVietMoi);
		return "Thêm bài viết mới thành công";
	}
	
	// Sửa bài viết
	@PutMapping(value = "/sua")
	public String suaBaiViet(@RequestBody String baiViet) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		BaiViet baiVietMoi = gson.fromJson(baiViet, BaiViet.class);
		baiVietService.update(baiVietMoi);
		return "Sửa bài viết thành công.";
	}
	
	//Xóa bài viết
	@DeleteMapping(value = "/xoa")
	public String xoaBaiViet(@RequestParam String id) {
		int id1 = Integer.parseInt(id);	
		baiVietService.delete(id1);
		return "Xóa bài viết thành công.";
	}
}

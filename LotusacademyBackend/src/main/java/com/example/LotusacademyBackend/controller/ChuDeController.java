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

import com.example.LotusacademyBackend.model.ChuDe;
import com.example.LotusacademyBackend.service.ChuDeService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/chude")
public class ChuDeController {
	
	@Autowired
	ChuDeService chuDeService;
	
	//danh sách chủ đề
	@GetMapping(value = "/danhsach")
	public Page<ChuDe> danhSachChuDe(@RequestParam String page, String size) {
		int page1 = Integer.parseInt(page);
		int size1 = Integer.parseInt(size);
		Pageable pageable = PageRequest.of(page1, size1);
		return chuDeService.getAll(pageable);
	}
	
	//thêm chủ đề
	@PostMapping(value = "/them")
	public String themChuDe(@RequestBody String chuDe) {
		Gson gson = new Gson();
		ChuDe chuDeNew = gson.fromJson(chuDe, ChuDe.class);
		
		chuDeService.add(chuDeNew);
		
		return "Thêm chủ để mới thành công";
	}
	
	//sửa chủ đề
	@PutMapping(value = "/sua")
	public String suaChuDe (@RequestBody String chuDe) {
		Gson gson = new Gson();
		ChuDe chuDeNew = gson.fromJson(chuDe, ChuDe.class);
		
		chuDeService.add(chuDeNew);
		
		return "Sửa chủ để thành công";
	}
	
	//xóa chủ đề
	@DeleteMapping(value = "/xoa")
	public String xoaChuDe(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		chuDeService.delete(id1);
		return "Xóa chủ đề thành công";
	}
	
}

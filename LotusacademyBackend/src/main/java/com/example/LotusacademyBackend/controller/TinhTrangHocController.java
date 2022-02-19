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

import com.example.LotusacademyBackend.model.TinhTrangHoc;
import com.example.LotusacademyBackend.service.TinhTrangHocService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/tinhtranghoc")
public class TinhTrangHocController {

	@Autowired
	TinhTrangHocService tinhTrangHocService;
	
	//Danh sách tình trạng học
	@GetMapping(value = "/danhsach")
	public List<TinhTrangHoc> danhSachTinhTrangHoc() {
		return tinhTrangHocService.getAll();
	}
	
	//Thêm tình trạng học
	@PostMapping(value = "/them") 
	public String themTinhTrangHoc(@RequestBody String tinhTrangHoc) {
		Gson gson = new Gson();
		TinhTrangHoc tinhTrangHocNew = gson.fromJson(tinhTrangHoc, TinhTrangHoc.class);
		tinhTrangHocService.add(tinhTrangHocNew);	
		return "success";
	}
	
	//Sửa tình trạng học
	@PutMapping(value = "/sua") 
	public String suaTinhTrangHoc(@RequestBody String tinhTrangHoc) {
		Gson gson = new Gson();
		TinhTrangHoc tinhTrangHocNew = gson.fromJson(tinhTrangHoc, TinhTrangHoc.class);
		tinhTrangHocService.update(tinhTrangHocNew);	
		return "success";
	}
	
	//xóa tình trạng học
	@DeleteMapping(value = "/xoa")
	public String xoaTinhTrangHoc (@RequestParam String id) {	
		int id1 = Integer.parseInt(id);
		tinhTrangHocService.delete(id1);	
		return "success";
	}
	
	//Lấy một tình trạng học
	@GetMapping(value ="/laymot")
	public TinhTrangHoc layMot (@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		return tinhTrangHocService.getOne(id1);
	}
	
}

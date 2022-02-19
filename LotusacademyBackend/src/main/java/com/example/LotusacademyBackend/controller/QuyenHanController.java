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

import com.example.LotusacademyBackend.model.QuyenHan;
import com.example.LotusacademyBackend.service.QuyenHanService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/quyenhan")
public class QuyenHanController {
	
	@Autowired
	QuyenHanService quyenHanService;
	
	//Danh sách quyền hạn
	@GetMapping(value = "/danhsach")
	public Page<QuyenHan> danhSachQuyenHan(@RequestParam String page, String size) {
		int page1 = Integer.parseInt(page);
		int size1 = Integer.parseInt(size);
		Pageable pageable = PageRequest.of(page1, size1);
		return quyenHanService.getAll(pageable);
	}
	
	//Thêm Quyền hạn
	@PostMapping(value = "/them")
	public void themQuyenHan(@RequestBody String quyenHan) {
		Gson gson = new Gson();
		QuyenHan quyenHanMoi = gson.fromJson(quyenHan, QuyenHan.class);
		quyenHanService.add(quyenHanMoi);
	}
	
	//Sửa quyền hạn
	@PutMapping(value = "/sua")
	public void suaQuyenHan(@RequestBody String quyenHan) {
		Gson gson = new Gson();
		QuyenHan quyenHanMoi = gson.fromJson(quyenHan, QuyenHan.class);
		quyenHanService.update(quyenHanMoi);
	}
	
	//xóa quyền hạn
	@DeleteMapping(value = "/xoa")
	public void xoaQuyenHan(@RequestParam String id) {
		int idQuyenHan = Integer.parseInt(id);
		quyenHanService.delete(idQuyenHan);
	} 

}

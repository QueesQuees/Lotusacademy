package com.example.LotusacademyBackend.controller;

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

import com.example.LotusacademyBackend.model.HocVien;
import com.example.LotusacademyBackend.service.HocVienService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(value = "/hocvien")
public class HocVienController {
	
	@Autowired
	HocVienService hocVienService;
	
	//Danh sách học viên
	@GetMapping(value = "danhsach")
	public Page<HocVien> danhSachHocVien(@RequestParam String page, String size) {
		int page1 = Integer.parseInt(page);
		int size1 = Integer.parseInt(size);
		Pageable pageable = PageRequest.of(page1, size1);
		return hocVienService.getAll(pageable);
	}
	
	//Thêm học viên
	@PostMapping(value = "/them")
	public String themHocVien(@RequestBody String hocVien) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		HocVien hocVienNew = gson.fromJson(hocVien, HocVien.class);
		
		List<HocVien> hocViens = hocVienService.getAll();
		for (HocVien hocVienCu: hocViens) {
			if (hocVienCu.getEmail().equalsIgnoreCase(hocVienNew.getEmail())) {
				return "Email đã có";
			}
			
			if(hocVienCu.getSoDienThoai().equalsIgnoreCase(hocVienNew.getSoDienThoai())) {
				return "Số điện thoại đã tồn tại";
			}
		}
		
		String hoTen = hocVienNew.getHoTen();
	    hoTen =	hoTen.trim().toLowerCase();
		String[] temp = hoTen.split(" ");
	    hoTen = "";
	    
	    for(int i = 0; i < temp.length; i++) {
	    	hoTen += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
	    	if (i < temp.length -1) {
	    		hoTen += " ";
	    	}
	    }
	    hocVienNew.setHoTen(hoTen);
	    
	    hocVienService.add(hocVienNew);
		return "Thêm học viên thành công";
	}
	
	//sửa học viên
	@PutMapping(value = "/sua")
	public String suaHocVien(@RequestBody String hocVien) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		HocVien hocVienNew = gson.fromJson(hocVien, HocVien.class);
		
		List<HocVien> hocViens = hocVienService.getAll();
		for (HocVien hocVienCu: hocViens) {
			if (hocVienNew.getHocVienID() == hocVienCu.getHocVienID()) {
				continue;
			}
			if (hocVienCu.getEmail().equalsIgnoreCase(hocVienNew.getEmail())) {
				return "Email đã có";
			}
			
			if(hocVienCu.getSoDienThoai().equalsIgnoreCase(hocVienNew.getSoDienThoai())) {
				return "Số điện thoại đã tồn tại";
			}
		}
		
		String hoTen = hocVienNew.getHoTen();
	    hoTen =	hoTen.trim().toLowerCase();
		String[] temp = hoTen.split(" ");
	    hoTen = "";
	    
	    for(int i = 0; i < temp.length; i++) {
	    	hoTen += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
	    	if (i < temp.length -1) {
	    		hoTen += " ";
	    	}
	    }
	    hocVienNew.setHoTen(hoTen);
	    
	    hocVienService.update(hocVienNew);
		return "Sửa thông tin học viên thành công";
	}
	
	//xóa học viên
	@DeleteMapping(value = "/xoa")
	public String xoaHocVien(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		hocVienService.delete(id1);		
		return "Học viên đã bị xóa";
	}

}

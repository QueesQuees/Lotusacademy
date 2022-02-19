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

import com.example.LotusacademyBackend.model.TaiKhoan;
import com.example.LotusacademyBackend.service.TaiKhoanService;
import com.google.gson.Gson;

@RestController
@RequestMapping(value = "/taikhoan")
public class TaiKhoanController {
	
	@Autowired
	TaiKhoanService taiKhoanService;
	
	//Danh sách tài khoản
	@GetMapping(value = "/danhsach")
	public Page<TaiKhoan> danhSachTaiKhoan (@RequestParam String page, String size) {
		int page1 = Integer.parseInt(page);
		int size1 = Integer.parseInt(size);
		Pageable pageable = PageRequest.of(page1, size1);
		return taiKhoanService.getAll(pageable);
	}
	
	//Thêm tài khoản
	@PostMapping(value = "/them")
	public String themTaiKhoan(@RequestBody String taiKhoan) {
		Gson gson = new Gson();
		TaiKhoan taiKhoanNew = gson.fromJson(taiKhoan, TaiKhoan.class);
		
		//Kiểm tra tên đăng nhập là duy nhất
		List<TaiKhoan> lstTaiKhoan = taiKhoanService.getAll();
		for(TaiKhoan tk: lstTaiKhoan) {
			if(taiKhoanNew.getTenDangNhap().equalsIgnoreCase(tk.getTenDangNhap())) {
				return "Tên đăng nhập đã tồn tại";
			}
		}
		//kiểm tra mật khẩu
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20}$";		
		if (!taiKhoanNew.getMatKhau().matches(regex)) {
			return "Mật khẩu phải có ít nhất 6 ký tự. Một ký tự đặc biệt và một ký tự chữa hoa.";
		}
		taiKhoanService.add(taiKhoanNew);		
		return "Tạo tài khoản mới thành công";
	}
	
	//Sửa tài khoản
	@PutMapping(value = "/sua")
	public String suaTaiKhoan(@RequestBody String taiKhoan) {
		Gson gson = new Gson();
		TaiKhoan taiKhoanNew = gson.fromJson(taiKhoan, TaiKhoan.class);
		
		//Kiểm tra tên đăng nhập là duy nhất
		List<TaiKhoan> lstTaiKhoan = taiKhoanService.getAll();
		for(TaiKhoan tk: lstTaiKhoan) {
			if (tk.getTenDangNhap().equals(taiKhoanNew.getTenDangNhap())) {
				continue;
			}
			if(taiKhoanNew.getTenDangNhap().equalsIgnoreCase(tk.getTenDangNhap())) {
				return "Tên đăng nhập đã tồn tại";
			}
		}
		//kiểm tra mật khẩu
		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,20}$";		
		if (!taiKhoanNew.getMatKhau().matches(regex)) {
			return "Mật khẩu phải có ít nhất 6 ký tự. Một ký tự đặc biệt và một ký tự chữa hoa.";
		}
		taiKhoanService.update(taiKhoanNew);		
		return "Sửa tài khoản thành công";
	}
	
	//xóa tài khoản
	@DeleteMapping(value = "/xoa")
	public String xoaTaiKhoan(@RequestParam String id) {
		int id1 = Integer.parseInt(id);
		taiKhoanService.delete(id1);		
		return "Xóa tài  khoản thành công.";
	}

}

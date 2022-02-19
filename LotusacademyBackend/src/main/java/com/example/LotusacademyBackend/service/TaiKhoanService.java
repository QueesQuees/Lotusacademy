package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.LotusacademyBackend.model.TaiKhoan;

public interface TaiKhoanService {
	
	Page<TaiKhoan> getAll(Pageable pageable);
	List<TaiKhoan> getAll();
	void add(TaiKhoan taiKhoan);
	void update(TaiKhoan taiKhoan);
	void delete(int id);
	TaiKhoan getOne(int id);
}

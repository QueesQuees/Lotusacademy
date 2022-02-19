package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.LotusacademyBackend.model.DangKyHoc;

public interface DangKyHocService {

	Page<DangKyHoc> getAll(Pageable pageable);
	List<DangKyHoc> getAll();
	void add(DangKyHoc dangKyHoc);
	void update(DangKyHoc dangKyHoc);
	DangKyHoc getOne(int id);
	void delete(int id);
}

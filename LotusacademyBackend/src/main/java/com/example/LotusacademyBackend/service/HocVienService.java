package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.LotusacademyBackend.model.HocVien;

public interface HocVienService {

	Page<HocVien> getAll(Pageable pageable);
	List<HocVien> getAll();
	void add(HocVien hocVien);
	void update(HocVien hocVien);
	HocVien getOne(int id);
	void delete(int id);
}

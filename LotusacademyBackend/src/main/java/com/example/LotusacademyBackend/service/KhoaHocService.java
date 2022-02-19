package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.LotusacademyBackend.model.KhoaHoc;

public interface KhoaHocService {

	Page<KhoaHoc> getAll(Pageable pageable);
	List<KhoaHoc> getAll();
	void add(KhoaHoc khoaHoc);
	void update(KhoaHoc khoaHoc);
	KhoaHoc getOne(int id);
	void delete(int id);
}

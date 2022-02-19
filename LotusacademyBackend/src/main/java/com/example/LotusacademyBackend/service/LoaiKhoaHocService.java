package com.example.LotusacademyBackend.service;

import java.util.List;

import com.example.LotusacademyBackend.model.LoaiKhoaHoc;

public interface LoaiKhoaHocService {

	List<LoaiKhoaHoc> getAll();
	void add(LoaiKhoaHoc loaiKhoaHoc);
	void update(LoaiKhoaHoc loaiKhoaHoc);
	LoaiKhoaHoc getOne(int id);
	void delete(int id);
}

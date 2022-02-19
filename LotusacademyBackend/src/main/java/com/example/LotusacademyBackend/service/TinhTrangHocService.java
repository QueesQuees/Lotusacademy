package com.example.LotusacademyBackend.service;

import java.util.List;

import com.example.LotusacademyBackend.model.TinhTrangHoc;

public interface TinhTrangHocService {

	List<TinhTrangHoc> getAll();
	void add(TinhTrangHoc tinhTrangHoc);
	void update(TinhTrangHoc tinhTrangHoc);
	TinhTrangHoc getOne(int id);
	void delete(int id);
}

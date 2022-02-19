package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.LotusacademyBackend.model.BaiViet;

public interface BaiVietService {
	Page<BaiViet> getAll(Pageable pageable);
	List<BaiViet> getAll();
	void add(BaiViet baiViet);
	void update(BaiViet baiViet);
	BaiViet getOne(int id);
	void delete(int id);
}

package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.LotusacademyBackend.model.LoaiBaiViet;

public interface LoaiBaiVietService {

	Page<LoaiBaiViet> getAll(Pageable pageable);
	List<LoaiBaiViet> getAll();
	void delete(int id);
	void add(LoaiBaiViet loaiBaiViet);
	void update(LoaiBaiViet loaiBaiViet);
	LoaiBaiViet getOne(int id);
}

package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.LotusacademyBackend.model.ChuDe;

public interface ChuDeService {
	Page<ChuDe> getAll(Pageable pageable);
	List<ChuDe> getAll();
	void delete(int id);
	void add(ChuDe chuDe);
	void update(ChuDe chuDe);
	ChuDe getOne(int id);
	
}

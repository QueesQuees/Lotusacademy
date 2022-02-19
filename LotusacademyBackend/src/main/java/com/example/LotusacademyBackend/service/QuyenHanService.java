package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.LotusacademyBackend.model.QuyenHan;

public interface QuyenHanService {
	Page<QuyenHan> getAll(Pageable pageable);
	List<QuyenHan> getAll();
	void add(QuyenHan quyenHan);
	void update(QuyenHan quyenHan);
	QuyenHan getOne(int id);
	void delete(int id);
}

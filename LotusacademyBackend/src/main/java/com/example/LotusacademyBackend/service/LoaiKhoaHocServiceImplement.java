package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.LoaiKhoaHoc;
import com.example.LotusacademyBackend.reponsitory.LoaiKhoaHocRepository;

@Service
public class LoaiKhoaHocServiceImplement implements LoaiKhoaHocService {

	@Autowired
	LoaiKhoaHocRepository loaiKhoaHocRepository;
	
	@Override
	public List<LoaiKhoaHoc> getAll() {
		// TODO Auto-generated method stub
		return loaiKhoaHocRepository.findAll();
	}

	@Override
	public void add(LoaiKhoaHoc loaiKhoaHoc) {
		// TODO Auto-generated method stub
		loaiKhoaHocRepository.save(loaiKhoaHoc);
	}

	@Override
	public void update(LoaiKhoaHoc loaiKhoaHoc) {
		// TODO Auto-generated method stub
		LoaiKhoaHoc loaiKhoaHoc2 = loaiKhoaHocRepository.findById(loaiKhoaHoc.getLoaiKhoaHocID()).get();
		loaiKhoaHoc2.setTenLoai(loaiKhoaHoc.getTenLoai());
		loaiKhoaHoc2.setKhoaHocs(loaiKhoaHoc.getKhoaHocs());
		loaiKhoaHocRepository.save(loaiKhoaHoc2);
	}

	@Override
	public LoaiKhoaHoc getOne(int id) {
		// TODO Auto-generated method stub
		return loaiKhoaHocRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		loaiKhoaHocRepository.deleteById(id);
	}

}

package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.DangKyHoc;
import com.example.LotusacademyBackend.reponsitory.DangKyHocRepository;

@Service
public class DangKyHocServiceImplement implements DangKyHocService{

	@Autowired
	DangKyHocRepository dangKyHocRepository;
	
	@Override
	public List<DangKyHoc> getAll() {
		// TODO Auto-generated method stub
		return dangKyHocRepository.findAll();
	}

	@Override
	public void add(DangKyHoc dangKyHoc) {
		// TODO Auto-generated method stub
		dangKyHocRepository.save(dangKyHoc);
	}

	@Override
	public void update(DangKyHoc dangKyHoc) {
		// TODO Auto-generated method stub
		DangKyHoc dangKyHoc2 = dangKyHocRepository.findById(dangKyHoc.getDangKyHocID()).get();
		dangKyHoc2.setHocVien(dangKyHoc.getHocVien());
		dangKyHoc2.setKhoaHoc(dangKyHoc.getKhoaHoc());
		dangKyHoc2.setNgayBatDau(dangKyHoc.getNgayBatDau());
		dangKyHoc2.setNgayDangKy(dangKyHoc.getNgayDangKy());
		dangKyHoc2.setNgayKetThuc(dangKyHoc.getNgayKetThuc());
		dangKyHoc2.setTaiKhoan(dangKyHoc.getTaiKhoan());
		dangKyHoc2.setTinhTrangHoc(dangKyHoc.getTinhTrangHoc());
		dangKyHocRepository.save(dangKyHoc2);
	}

	@Override
	public DangKyHoc getOne(int id) {
		// TODO Auto-generated method stub
		return dangKyHocRepository.findById(id).get();
	}

	@Override
	public Page<DangKyHoc> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return dangKyHocRepository.findAll(pageable);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dangKyHocRepository.deleteById(id);
	}

}

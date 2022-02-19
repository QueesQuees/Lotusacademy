package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.KhoaHoc;
import com.example.LotusacademyBackend.reponsitory.KhoaHocRepository;

@Service
public class KhoaHocServiceImplement implements KhoaHocService{

	@Autowired
	KhoaHocRepository khoaHocRepository;
	
	@Override
	public Page<KhoaHoc> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return khoaHocRepository.findAll(pageable);
	}

	@Override
	public void add(KhoaHoc khoaHoc) {
		// TODO Auto-generated method stub
		khoaHocRepository.save(khoaHoc);
	}

	@Override
	public void update(KhoaHoc khoaHoc) {
		// TODO Auto-generated method stub
		KhoaHoc khoaHoc2 = khoaHocRepository.findById(khoaHoc.getKhoaHocID()).get();
		khoaHoc2.setDangKyHocs(khoaHoc.getDangKyHocs());
		khoaHoc2.setGioiThieu(khoaHoc.getGioiThieu());
		khoaHoc2.setHinhAnh(khoaHoc.getHinhAnh());
		khoaHoc2.setHocPhi(khoaHoc.getHocPhi());
		khoaHoc2.setLoaiKhoaHoc(khoaHoc.getLoaiKhoaHoc());
		khoaHoc2.setNoiDung(khoaHoc.getNoiDung());
		khoaHoc2.setSoHocVien(khoaHoc.getSoHocVien());
		khoaHoc2.setSoLuongMon(khoaHoc.getSoLuongMon());
		khoaHoc2.setTenKhoaHoc(khoaHoc.getTenKhoaHoc());
		khoaHoc2.setThoiGianHoc(khoaHoc.getThoiGianHoc());
		khoaHocRepository.save(khoaHoc2);
	}

	@Override
	public KhoaHoc getOne(int id) {
		// TODO Auto-generated method stub
		return khoaHocRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		khoaHocRepository.deleteById(id);
	}

	@Override
	public List<KhoaHoc> getAll() {
		// TODO Auto-generated method stub
		return khoaHocRepository.findAll();
	}

}

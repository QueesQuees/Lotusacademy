package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.TinhTrangHoc;
import com.example.LotusacademyBackend.reponsitory.TinhTrangHocRepository;

@Service
public class TinhTrangHocServiceImplement implements TinhTrangHocService{

	@Autowired
	TinhTrangHocRepository tinhTrangHocRepository;
	
	@Override
	public List<TinhTrangHoc> getAll() {
		// TODO Auto-generated method stub
		return tinhTrangHocRepository.findAll();
	}

	@Override
	public void add(TinhTrangHoc tinhTrangHoc) {
		// TODO Auto-generated method stub
		tinhTrangHocRepository.save(tinhTrangHoc);
	}

	@Override
	public void update(TinhTrangHoc tinhTrangHoc) {
		// TODO Auto-generated method stub
		TinhTrangHoc tinhTrangHoc2 = tinhTrangHocRepository.findById(tinhTrangHoc.getTinhTrangHocID()).get();
		tinhTrangHoc2.setTenTinhTrang(tinhTrangHoc.getTenTinhTrang());
		tinhTrangHoc2.setDangKyHocs(tinhTrangHoc.getDangKyHocs());
		tinhTrangHocRepository.save(tinhTrangHoc2);
	}

	@Override
	public TinhTrangHoc getOne(int id) {
		// TODO Auto-generated method stub
		return tinhTrangHocRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tinhTrangHocRepository.deleteById(id);
	}

}

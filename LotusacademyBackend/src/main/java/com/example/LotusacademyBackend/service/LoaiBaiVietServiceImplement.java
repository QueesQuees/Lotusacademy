package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.LoaiBaiViet;
import com.example.LotusacademyBackend.reponsitory.LoaiBaiVietRepository;

@Service
public class LoaiBaiVietServiceImplement implements LoaiBaiVietService {

	@Autowired
	LoaiBaiVietRepository loaiBaiVietRepository;
	
	@Override
	public List<LoaiBaiViet> getAll() {
		// TODO Auto-generated method stub
		return loaiBaiVietRepository.findAll();
	}

	@Override
	public void add(LoaiBaiViet loaiBaiViet) {
		// TODO Auto-generated method stub
		loaiBaiVietRepository.save(loaiBaiViet);
	}

	@Override
	public void update(LoaiBaiViet loaiBaiViet) {
		// TODO Auto-generated method stub
		LoaiBaiViet loaiBaiViet2 = loaiBaiVietRepository.findById(loaiBaiViet.getLoaiBaiVietID()).get();
		loaiBaiViet2.setChuDes(loaiBaiViet.getChuDes());
		loaiBaiViet2.setTenLoai(loaiBaiViet.getTenLoai());
		loaiBaiVietRepository.save(loaiBaiViet2);
	}

	@Override
	public LoaiBaiViet getOne(int id) {
		// TODO Auto-generated method stub
		return loaiBaiVietRepository.findById(id).get();
	}

	@Override
	public Page<LoaiBaiViet> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return loaiBaiVietRepository.findAll(pageable);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		loaiBaiVietRepository.deleteById(id);
	}

}

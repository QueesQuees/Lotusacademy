package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.ChuDe;
import com.example.LotusacademyBackend.reponsitory.ChuDeRepository;

@Service
public class ChuDeServiceImplement implements ChuDeService{

	@Autowired
	ChuDeRepository chuDeRepository;
	
	@Override
	public List<ChuDe> getAll() {
		// TODO Auto-generated method stub
		return chuDeRepository.findAll();
	}

	@Override
	public void add(ChuDe chuDe) {
		// TODO Auto-generated method stub
		chuDeRepository.save(chuDe);
	}

	@Override
	public void update(ChuDe chuDe) {
		// TODO Auto-generated method stub
		ChuDe chuDe2 = chuDeRepository.findById(chuDe.getChuDeID()).get();
		chuDe2.setBaiViets(chuDe.getBaiViets());
		chuDe2.setLoaiBaiViet(chuDe.getLoaiBaiViet());
		chuDe2.setTenChuDe(chuDe.getTenChuDe());
		chuDe2.setNoiDung(chuDe.getNoiDung());
		chuDeRepository.save(chuDe2);
	}

	@Override
	public ChuDe getOne(int id) {
		// TODO Auto-generated method stub
		return chuDeRepository.findById(id).get();
	}

	@Override
	public Page<ChuDe> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return chuDeRepository.findAll(pageable);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		chuDeRepository.deleteById(id);
	}

	
}

package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.BaiViet;
import com.example.LotusacademyBackend.reponsitory.BaiVietReponsitory;

@Service
public class BaiVietServiceImplement implements BaiVietService {
	
	@Autowired
	BaiVietReponsitory baiVietReponsitory;

	@Override
	public List<BaiViet> getAll() {
		// TODO Auto-generated method stub
		return baiVietReponsitory.findAll();
	}

	@Override
	public void add(BaiViet baiViet) {
		// TODO Auto-generated method stub
		baiVietReponsitory.save(baiViet);
	}

	@Override
	public void update(BaiViet baiViet) {
		// TODO Auto-generated method stub	
		BaiViet baiViet2 = baiVietReponsitory.findById(baiViet.getBaiVietID()).get();
		baiViet2.setTenBaiViet(baiViet.getTenBaiViet());
		baiViet2.setTenTacGia(baiViet.getTenTacGia());
		baiViet2.setNoiDung(baiViet.getNoiDung());
		baiViet2.setNoiDungNgan(baiViet.getNoiDungNgan());
		baiViet2.setHinhAnh(baiViet.getHinhAnh());
		baiViet2.setChuDe(baiViet.getChuDe());
		baiViet2.setTaiKhoan(baiViet.getTaiKhoan());
		baiViet2.setThoiGianTao(baiViet.getThoiGianTao());
		baiVietReponsitory.save(baiViet2);
	}

	@Override
	public BaiViet getOne(int id) {
		// TODO Auto-generated method stub
		return baiVietReponsitory.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		baiVietReponsitory.deleteById(id);
	}

	@Override
	public Page<BaiViet> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return baiVietReponsitory.findAll(pageable);
	}

}

package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.TaiKhoan;
import com.example.LotusacademyBackend.reponsitory.TaiKhoanRepository;

@Service
public class TaiKhoanServiceImplement implements TaiKhoanService {

	@Autowired
	TaiKhoanRepository taiKhoanRepository;
	
	@Override
	public List<TaiKhoan> getAll() {
		// TODO Auto-generated method stub
		return taiKhoanRepository.findAll();
	}

	@Override
	public void add(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		taiKhoanRepository.save(taiKhoan);
	}

	@Override
	public void update(TaiKhoan taiKhoan) {
		// TODO Auto-generated method stub
		TaiKhoan taiKhoan2 = taiKhoanRepository.findById(taiKhoan.getTaiKhoanID()).get();
		taiKhoan2.setBaiViets(taiKhoan.getBaiViets());
		taiKhoan2.setDangKyHocs(taiKhoan.getDangKyHocs());
		taiKhoan2.setMatKhau(taiKhoan.getMatKhau());
		taiKhoan2.setQuyenHan(taiKhoan.getQuyenHan());
		taiKhoan2.setTenDangNhap(taiKhoan.getTenDangNhap());
		taiKhoan2.setTenNguoiDung(taiKhoan.getTenNguoiDung());
		taiKhoanRepository.save(taiKhoan2);
	}

	@Override
	public TaiKhoan getOne(int id) {
		// TODO Auto-generated method stub
		return taiKhoanRepository.findById(id).get();
	}

	@Override
	public Page<TaiKhoan> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return taiKhoanRepository.findAll(pageable);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		taiKhoanRepository.deleteById(id);
	}

}

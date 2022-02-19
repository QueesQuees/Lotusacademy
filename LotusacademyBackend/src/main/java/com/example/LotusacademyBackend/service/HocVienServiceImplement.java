package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.HocVien;
import com.example.LotusacademyBackend.reponsitory.HocVienRepository;

@Service
public class HocVienServiceImplement implements HocVienService{

	@Autowired
	HocVienRepository hocVienRepository;
	
	@Override
	public List<HocVien> getAll() {
		// TODO Auto-generated method stub
		return hocVienRepository.findAll();
	}

	@Override
	public void add(HocVien hocVien) {
		// TODO Auto-generated method stub
		hocVienRepository.save(hocVien);
	}

	@Override
	public void update(HocVien hocVien) {
		// TODO Auto-generated method stub
		HocVien hocVien2 = hocVienRepository.findById(hocVien.getHocVienID()).get();
		hocVien2.setDangKyHocs(hocVien.getDangKyHocs());
		hocVien2.setEmail(hocVien.getEmail());
		hocVien2.setHinhAnh(hocVien.getHinhAnh());
		hocVien2.setHoTen(hocVien.getHoTen());
		hocVien2.setNgaySinh(hocVien.getNgaySinh());
		hocVien2.setSoDienThoai(hocVien.getSoDienThoai());
		hocVien2.setQuanHuyen(hocVien.getQuanHuyen());
		hocVien2.setTinhThanh(hocVien.getTinhThanh());
		hocVien2.setSoNha(hocVien.getSoNha());
		hocVien2.setPhuongXa(hocVien.getPhuongXa());
		hocVienRepository.save(hocVien2);
	}

	@Override
	public HocVien getOne(int id) {
		// TODO Auto-generated method stub
		return hocVienRepository.findById(id).get();
	}

	@Override
	public Page<HocVien> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return hocVienRepository.findAll(pageable);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		hocVienRepository.deleteById(id);
	}

}

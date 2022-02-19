package com.example.LotusacademyBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.LotusacademyBackend.model.QuyenHan;
import com.example.LotusacademyBackend.reponsitory.QuyenHanRepository;

@Service
public class QuyenHanServiceImplement implements QuyenHanService {

	@Autowired
	QuyenHanRepository quyenHanRepository;
	
	@Override
	public List<QuyenHan> getAll() {
		// TODO Auto-generated method stub
		return quyenHanRepository.findAll();
	}

	@Override
	public void add(QuyenHan quyenHan) {
		// TODO Auto-generated method stub
		quyenHanRepository.save(quyenHan);
	}

	@Override
	public void update(QuyenHan quyenHan) {
		// TODO Auto-generated method stub
		QuyenHan quyenHan2 = quyenHanRepository.findById(quyenHan.getQuyenHanID()).get();
		quyenHan2.setTaiKhoans(quyenHan.getTaiKhoans());
		quyenHan2.setTenQuyenHan(quyenHan.getTenQuyenHan());
		quyenHanRepository.save(quyenHan2);
	}

	@Override
	public QuyenHan getOne(int id) {
		// TODO Auto-generated method stub
		return quyenHanRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		quyenHanRepository.deleteById(id);
	}

	@Override
	public Page<QuyenHan> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return quyenHanRepository.findAll(pageable);
	}

}

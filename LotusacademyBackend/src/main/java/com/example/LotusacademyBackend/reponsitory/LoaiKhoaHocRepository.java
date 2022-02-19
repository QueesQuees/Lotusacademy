package com.example.LotusacademyBackend.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LotusacademyBackend.model.LoaiKhoaHoc;

@Repository
public interface LoaiKhoaHocRepository extends JpaRepository<LoaiKhoaHoc, Integer> {

}

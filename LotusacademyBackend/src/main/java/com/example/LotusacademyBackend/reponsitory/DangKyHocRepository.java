package com.example.LotusacademyBackend.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LotusacademyBackend.model.DangKyHoc;

@Repository
public interface DangKyHocRepository extends JpaRepository<DangKyHoc, Integer> {

}

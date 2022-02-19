package com.example.LotusacademyBackend.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LotusacademyBackend.model.QuyenHan;

@Repository
public interface QuyenHanRepository extends JpaRepository<QuyenHan, Integer>{

}

package com.example.LotusacademyBackend.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LotusacademyBackend.model.BaiViet;

@Repository
public interface BaiVietReponsitory extends JpaRepository<BaiViet, Integer> {

}

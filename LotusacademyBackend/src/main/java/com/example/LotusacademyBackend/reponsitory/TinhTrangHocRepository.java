package com.example.LotusacademyBackend.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LotusacademyBackend.model.TinhTrangHoc;

@Repository
public interface TinhTrangHocRepository extends JpaRepository<TinhTrangHoc, Integer>{

}

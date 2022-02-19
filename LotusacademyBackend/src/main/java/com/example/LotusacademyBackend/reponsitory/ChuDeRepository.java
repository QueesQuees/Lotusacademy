package com.example.LotusacademyBackend.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LotusacademyBackend.model.ChuDe;

@Repository
public interface ChuDeRepository extends JpaRepository<ChuDe, Integer> {

}

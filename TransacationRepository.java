package com.monocept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.entity.Transaction;
@Repository
public interface TransacationRepository extends JpaRepository<Transaction,Integer> {

}

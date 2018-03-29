package com.example.repository;

import com.example.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BankRepository extends JpaRepository<Bank, Long> {
}

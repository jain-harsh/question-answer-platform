package com.example.questionanswerproject.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionanswerproject.entities.Company;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long> {

}

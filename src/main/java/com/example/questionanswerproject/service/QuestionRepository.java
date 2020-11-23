package com.example.questionanswerproject.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionanswerproject.entities.questions;

@Repository
public interface QuestionRepository extends JpaRepository<questions,Long> {
	
	
	
}

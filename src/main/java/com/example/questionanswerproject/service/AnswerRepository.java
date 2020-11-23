package com.example.questionanswerproject.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.questionanswerproject.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}

package com.example.questionanswerproject.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.questionanswerproject.entities.Comments;

@Repository
public interface CommentsRepository  extends JpaRepository<Comments, Long> {

}

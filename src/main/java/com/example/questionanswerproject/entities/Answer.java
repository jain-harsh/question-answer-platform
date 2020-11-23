package com.example.questionanswerproject.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {
	
	@Id
//	@GeneratedValue
	private long Id;
	
	private String answer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private questions question;
	
	public Answer() {
		
	}

	public Answer(long id, String answer, questions question) {
		super();
		Id = id;
		this.answer = answer;
		this.question = question;
	}
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public questions getQuestion() {
		return question;
	}

	public void setQuestion(questions question) {
		this.question = question;
	}

	



}



package com.example.questionanswerproject.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comments {
	
	@Id
//	@GeneratedValue
	private long Id;
	
	private String comments;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private questions question;

	public Comments() {
		
	}
	
	public Comments(long id, String comments, questions question) {
		super();
		Id = id;
		this.comments = comments;
		this.question = question;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public questions getQuestion() {
		return question;
	}

	public void setQuestion(questions question) {
		this.question = question;
	}
	
	
	

}

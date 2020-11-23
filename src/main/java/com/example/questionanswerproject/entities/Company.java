package com.example.questionanswerproject.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {
	
	@Id
//	@GeneratedValue
	private long Id;
	
	private String company;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private questions question;

	public long getId() {
		return Id;
	}
	
	public Company() {
		
	}

	public Company(long id, String company, questions question) {
		super();
		Id = id;
		this.company = company;
		this.question = question;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public questions getQuestion() {
		return question;
	}

	public void setQuestion(questions question) {
		this.question = question;
	}
	
	
}

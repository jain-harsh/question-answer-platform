package com.example.questionanswerproject.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class questions {

	@Id
	@GeneratedValue
	private long Id;
	
	private String question;
	
	private int Likes;
	
	private String UserName;
	
	@OneToMany(mappedBy="question")
	private List<Company> company;
	
	@OneToMany(mappedBy="question")
	private List<Answer> answer;
	
	@OneToMany(mappedBy="question")
	private List<Comments> comments;
	
	protected questions() {
		
	}

	public questions(long id, String question, int likes, String userName, List<Company> company, List<Answer> answer,
			List<Comments> comments) {
		super();
		Id = id;
		this.question = question;
		Likes = likes;
		UserName = userName;
		this.company = company;
		this.answer = answer;
		this.comments = comments;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getLikes() {
		return Likes;
	}

	public void setLikes(int likes) {
		Likes = likes;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	@Override
	public String toString() {
		return "questions [Id=" + Id + ", question=" + question + ", Likes=" + Likes + ", UserName=" + UserName + "]";
	}
	
	
}

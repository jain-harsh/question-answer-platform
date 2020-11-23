package com.example.questionanswerproject.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.questionanswerproject.entities.Answer;
import com.example.questionanswerproject.entities.Comments;
import com.example.questionanswerproject.entities.Company;
import com.example.questionanswerproject.entities.questions;

@RestController
public class retreive_questions {

//	@Autowired
//	private questions question;

	@Autowired
	private QuestionRepository questionrepo;

	@Autowired
	private AnswerRepository answerrepo;

	@Autowired
	private CommentsRepository commentsrepo;

	@Autowired
	private CompanyRepository companyrepo;

	@GetMapping("/questions")
	public List<questions> retrive() {
		return questionrepo.findAll();
	}

	@GetMapping("/questions/{id}")
	public Optional<questions> retrieveone(@PathVariable long id) throws Exception {
		Optional<questions> ques = questionrepo.findById(id);
		if (!ques.isPresent())
			throw new Exception("id-" + id);

		return ques;
	}

	@DeleteMapping("/questions/{id}")
	public void deletequestion(@PathVariable long id) {
		questionrepo.deleteById(id);
	}

	@PostMapping("/questions")
	public ResponseEntity<questions> createquestion(@Valid @RequestBody questions question) {

		questions q = questionrepo.save(question);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(q.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@GetMapping("/questions/{id}/answer")
	public List<Answer> retrieveanswer(@PathVariable long id) throws Exception {
		Optional<questions> ques = questionrepo.findById(id);
		if (!ques.isPresent())
			throw new Exception("id-" + id);

		return ques.get().getAnswer();
	}

	@PostMapping("/questions/{id}/answer")
	public ResponseEntity<Object> createAnswer(@PathVariable long id, @RequestBody Answer ans) {

		Optional<questions> userOptional = questionrepo.findById(id);

//		if(!userOptional.isPresent()) {
//			throw new UserNotFoundException("id-" + id);
//		}

		questions q = userOptional.get();

		ans.setQuestion(q);

		answerrepo.save(ans);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ans.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping("/questions/{id}/comments")
	public List<Comments> retrievecomments(@PathVariable long id) throws Exception {
		Optional<questions> ques = questionrepo.findById(id);
		if (!ques.isPresent())
			throw new Exception("id-" + id);

		return ques.get().getComments();
	}

	@PostMapping("/questions/{id}/comments")
	public ResponseEntity<Object> createComments(@PathVariable long id, @RequestBody Comments comment) {

		Optional<questions> userOptional = questionrepo.findById(id);

//		if(!userOptional.isPresent()) {
//			throw new UserNotFoundException("id-" + id);
//		}

		questions q = userOptional.get();

		comment.setQuestion(q);

		commentsrepo.save(comment);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comment.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping("/questions/{id}/company")
	public List<Company> retrievecompany(@PathVariable long id) throws Exception {
		Optional<questions> ques = questionrepo.findById(id);
		if (!ques.isPresent())
			throw new Exception("id-" + id);

		return ques.get().getCompany();
	}

	@PostMapping("/questions/{id}/company")
	public ResponseEntity<Object> createCompany(@PathVariable long id, @RequestBody Company company) {

		Optional<questions> userOptional = questionrepo.findById(id);

//		if(!userOptional.isPresent()) {
//			throw new UserNotFoundException("id-" + id);
//		}

		questions q = userOptional.get();

		company.setQuestion(q);

		companyrepo.save(company);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(company.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}

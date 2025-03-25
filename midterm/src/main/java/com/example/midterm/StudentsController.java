package com.example.midterm;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
public class StudentsController {
	@Autowired
	StudentRepository repository;
	
	@GetMapping("/api/students/sample")
	void loadSampleStudents() {
		SampleStudents sampleStudents = new SampleStudents();
		repository.saveAll(sampleStudents.getStudents());
	}
	
	@GetMapping("/api/students")
	List<Student> getStudents() {
		return repository.findAll();
	}
	
	@GetMapping("/api/students/{id}")
	Student getStudent(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new Error("Error retrieving student with id " + id));
	}
	
	@PostMapping("/api/students")
	void newStudent(@RequestBody Student newStudent) {
		repository.save(newStudent);
	}
	
	@PutMapping("/api/students/{id}")
	void updateStudent(@RequestBody Student studentUpdate, @PathVariable Long id) {
		Student student = repository.findById(id).orElseThrow(() -> new Error("Error updating student with id" + id));
		student.updateStudent(studentUpdate);
		repository.save(student);
	}
	
	@DeleteMapping("/api/students/{id}")
	void deleteStudent(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
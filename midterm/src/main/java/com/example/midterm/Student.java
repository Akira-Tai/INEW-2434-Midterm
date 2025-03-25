package com.example.midterm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private boolean patternReady;
	private boolean definitionReady;
	private boolean studentReady;
	private boolean testPaid;
	
	public Student() {
		name = "name";
		patternReady = false;
		definitionReady = false;
		studentReady = false;
		testPaid = false;
	}
	
	public Student(String name, boolean patternReady, boolean definitionReady, boolean studentReady, boolean testPaid) {
		this.name = name;
		this.patternReady = patternReady;
		this.definitionReady = definitionReady;
		this.studentReady = studentReady;
		this.testPaid = testPaid;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean getPatternReady() {
		return patternReady;
	}
	public boolean getDefinitionReady() {
		return definitionReady;
	}
	public boolean getStudentReady() {
		return studentReady;
	}
	public boolean getTestPaid() {
		return testPaid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPatternReady(boolean ready) {
		patternReady = ready;
	}
	public void setDefinitionReady(boolean ready) {
		definitionReady = ready;
	}
	public void setStudentReady(boolean ready) {
		studentReady = ready;
	}
	public void setTestPaid(boolean paid) {
		testPaid = paid;
	}
	public void updateStudent(Student s) {
		name = s.getName();
		patternReady = s.getPatternReady();
		definitionReady = s.getDefinitionReady();
		studentReady = s.getStudentReady();
		testPaid = s.getTestPaid();
	}
	
	@Override
	public String toString() {
		return "Student{" + "id=" + this.id + ", name='" + this.name + 
				"', patternReady=" + this.patternReady + ", definitionReady=" + this.definitionReady + 
				", studentReady=" + this.studentReady + ", testPaid=" + this.testPaid + "}";
	}
	

}
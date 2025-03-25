package com.example.midterm;

import java.util.List;

public class SampleStudents {
	private List<Student> students;
	
	SampleStudents() {
	students = List.of(
			new Student("Alice", true, false, true, false),
			new Student("Bob", false, true, false, true),
		    new Student("Charlie", true, true, false, false),
		    new Student("Diana", false, false, true, true),
		    new Student("Ethan", true, false, false, true),
		    new Student("Fiona", false, true, true, false),
		    new Student("George", true, true, true, false),
		    new Student("Hannah", false, false, false, true),
		    new Student("Ian", true, false, true, true),
		    new Student("Julia", false, true, false, false)
			);
	}
	public List<Student> getStudents() {
		return students;
	}
}

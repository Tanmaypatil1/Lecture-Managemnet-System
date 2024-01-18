package com.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Lecture")
public class Lecture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="lecture")
	private List<Slide> slides = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			name = "lecture_teacher",
	        joinColumns = @JoinColumn(name = "lecture_id"),
	        inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	    private Set<Teacher> teachers = new HashSet<>();
	public Lecture() {
		super();
	}
	

	public Lecture(Long id, String title, List<Slide> slides, Set<Teacher> teachers) {
		super();
		this.id = id;
		this.title = title;
		this.slides = slides;
		this.teachers = teachers;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Slide> getSlides() {
		return slides;
	}

	public void setSlides(List<Slide> slides) {
		this.slides = slides;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}


	@Override
	public String toString() {
		return "Lecture [id=" + id + ", title=" + title + ", slides=" + slides + ", teachers=" + teachers + "]";
	}
}


package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Lecture;
import com.model.Teacher;
import com.repository.TeacherRepository;

@Service
public class TeacherService {
	@Autowired
	private TeacherRepository teacherRepository;

	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}

	public Teacher getTeacherById(Long id) {
		return teacherRepository.findById(id).orElse(null);
	}

	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	public void deleteTeacher(Long id) {
		teacherRepository.deleteById(id);
	}
}

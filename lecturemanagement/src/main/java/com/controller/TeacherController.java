package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Lecture;
import com.model.Teacher;
import com.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
    private TeacherService teacherService;
	 @GetMapping
	    public List<Teacher> getAllTeacher() {
	        return teacherService.getAllTeacher();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
	        Teacher teacher = teacherService.getTeacherById(id);
	        return ResponseEntity.ok(teacher);
	    }

	    @PostMapping
	    public ResponseEntity<Teacher> saveTeacher(@RequestBody @Validated Teacher teacher) {
	        Teacher savedTeacher = teacherService.saveTeacher(teacher);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeacher);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
	        teacherService.deleteTeacher(id);
	        return ResponseEntity.noContent().build();
	    }
}

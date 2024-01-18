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
import com.service.LectureService;

@RestController
@RequestMapping("/lectures")
public class LectureController {
	 @Autowired
	    private LectureService lectureService;

	    @GetMapping
	    public List<Lecture> getAllLectures() {
	        return lectureService.getAllLectures();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Lecture> getLectureById(@PathVariable Long id) {
	        Lecture lecture = lectureService.getLectureById(id);
	        return ResponseEntity.ok(lecture);
	    }

	    @PostMapping
	    public ResponseEntity<Lecture> saveLecture(@RequestBody @Validated Lecture lecture) {
	        Lecture savedLecture = lectureService.saveLecture(lecture);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedLecture);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteLecture(@PathVariable Long id) {
	        lectureService.deleteLecture(id);
	        return ResponseEntity.noContent().build();
	    }
	}


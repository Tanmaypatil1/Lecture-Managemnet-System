package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Lecture;
import com.repository.LectureRepository;

@Service
public class LectureService {
	 @Autowired
	    private LectureRepository lectureRepository;

	    public List<Lecture> getAllLectures() {
	        return lectureRepository.findAll();
	    }

	    public Lecture getLectureById(Long id) {
	        return lectureRepository.findById(id).orElse(null);
	    }

	    public Lecture saveLecture(Lecture lecture) {
	        return lectureRepository.save(lecture);
	    }

	    public void deleteLecture(Long id) {
	        lectureRepository.deleteById(id);
	    }
}

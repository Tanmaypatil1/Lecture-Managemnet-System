package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Lecture;
import com.model.Slide;
import com.repository.SlideRepository;

@Service
public class SlideService {
	@Autowired
	private SlideRepository slideRepository;

	public List<Slide> getAllSlide() {
		return slideRepository.findAll();
	}

	public Slide getSlideById(String id) {
		return slideRepository.findById(id).orElse(null);
	}

	public Slide saveSlide(Slide slide) {
		return slideRepository.save(slide);
	}

	public void deleteSlide(String id) {
		slideRepository.deleteById(id);
	}

}

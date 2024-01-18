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
import com.model.Slide;
import com.service.SlideService;

@RestController
@RequestMapping("/slides")
public class SlideController {
	 @Autowired
	    private SlideService slideService;
	 
	 @GetMapping
	    public List<Slide> getAllSlide() {
	        return slideService.getAllSlide();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Slide> getSlideById(@PathVariable String id) {
	        Slide slide = slideService.getSlideById(id);
	        return ResponseEntity.ok(slide);
	    }

	    @PostMapping
	    public ResponseEntity<Slide> saveLecture(@RequestBody @Validated Slide slide) {
	        Slide savedSlide = slideService.saveSlide(slide);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedSlide);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteSlide(@PathVariable String id) {
	        slideService.deleteSlide(id);
	        return ResponseEntity.noContent().build();
	    }
	 
	 
}

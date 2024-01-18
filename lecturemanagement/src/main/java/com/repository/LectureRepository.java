package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Lecture;

public interface LectureRepository extends JpaRepository<Lecture,Long> {

}

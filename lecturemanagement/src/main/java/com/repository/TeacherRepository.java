package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}

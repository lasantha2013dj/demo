package com.example.demo.dao;

import com.example.demo.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonDao extends JpaRepository<Lesson, Integer> {

    Lesson getLessonByLessonID(int lessonID);

}

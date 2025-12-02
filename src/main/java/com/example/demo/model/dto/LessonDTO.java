package com.example.demo.model.dto;

import com.example.demo.model.Lesson;

public class LessonDTO {

    private int lessonID;

    private String lessonName;

    private String lessonDescription;

    public LessonDTO(Lesson lesson) {
        this.lessonID = lesson.getLessonID();
        this.lessonName = lesson.getLessonName();
        this.lessonDescription = lesson.getLessonDescription();

    }

    public int getLessonID() {
        return lessonID;
    }

    public void setLessonID(int lessonID) {
        this.lessonID = lessonID;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }
}

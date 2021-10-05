package edu.wgu.shawnwigle_scheduler.database.course;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(tableName = "course_table")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseId;
    private String courseTitle;
    private LocalDateTime courseStart;
    private LocalDateTime courseEnd;
    private String courseStatus; // maybe make this a chooser with in-progress, completed, dropped, plan to take
    private String instructorName;
    private String instructorPhone;
    private String instructorEmail;
    private String noteTitle;
    private String noteContent;


    //TODO: Associate assessments with course. Probably as foreign key

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public LocalDateTime getCourseStart() {
        return courseStart;
    }

    public LocalDateTime getCourseEnd() {
        return courseEnd;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public String getInstructorPhone() {
        return instructorPhone;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    // Setters
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    // Constructor
    public Course(String courseTitle, LocalDateTime courseStart, LocalDateTime courseEnd, String courseStatus, String instructorName, String instructorPhone, String instructorEmail, String noteTitle, String noteContent) {
        this.courseTitle = courseTitle;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.courseStatus = courseStatus;
        this.instructorName = instructorName;
        this.instructorPhone = instructorPhone;
        this.instructorEmail = instructorEmail;
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    // toString

}

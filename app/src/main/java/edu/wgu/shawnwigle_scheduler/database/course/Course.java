package edu.wgu.shawnwigle_scheduler.database.course;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "course_table")
public class Course {
    @PrimaryKey(autoGenerate = true)
    private int courseId;
    private String courseTitle;
    private String courseStart;
    private String courseEnd;
    private String courseStatus; // maybe make this a chooser with in-progress, completed, dropped, plan to take

    //TODO: Associate assessments with course
    //TODO: Associate notes with course
    //TODO: Associate instructors with course? not sure if we want to add them on a separate screen
    //      or just allow them to be added on course screen and plopped into their own db table

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseStart() {
        return courseStart;
    }

    public String getCourseEnd() {
        return courseEnd;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    // Setters
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    // Constructor
    public Course(String courseTitle, String courseStart, String courseEnd, String courseStatus) {
        this.courseTitle = courseTitle;
        this.courseStart = courseStart;
        this.courseEnd = courseEnd;
        this.courseStatus = courseStatus;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseStart='" + courseStart + '\'' +
                ", courseEnd='" + courseEnd + '\'' +
                ", courseStatus='" + courseStatus + '\'' +
                '}';
    }
}

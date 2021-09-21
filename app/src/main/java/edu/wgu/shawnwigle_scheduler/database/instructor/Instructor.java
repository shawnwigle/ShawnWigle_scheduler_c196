package edu.wgu.shawnwigle_scheduler.database.instructor;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "instructor_table")
public class Instructor {
    @PrimaryKey(autoGenerate = true)
    private int instructorId;
    private String instructorName;
    private String instructorPhone;
    private String instructorEmail;

    // Getters

    public int getInstructorId() {
        return instructorId;
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

    // Setters

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    // Constructor

    public Instructor(String instructorName, String instructorPhone, String instructorEmail) {
        this.instructorName = instructorName;
        this.instructorPhone = instructorPhone;
        this.instructorEmail = instructorEmail;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", instructorName='" + instructorName + '\'' +
                ", instructorPhone='" + instructorPhone + '\'' +
                ", instructorEmail='" + instructorEmail + '\'' +
                '}';
    }
}

package edu.wgu.shawnwigle_scheduler.database.assessment;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "assessment_table")
public class Assessment {

    @PrimaryKey(autoGenerate = true)
    private int assessmentId;
    private String assessmentTitle;
    private String assessmentStart;
    private String assessmentEnd;
    private String assessmentType; // maybe make this a radio button? (Objective, Performance)

    // Getters
    public int getAssessmentId() {
        return assessmentId;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public String getAssessmentStart() {
        return assessmentStart;
    }

    public String getAssessmentEnd() {
        return assessmentEnd;
    }

    public String getAssessmentType() {
        return assessmentType;
    }

    // Setters
    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    // Constructors
    public Assessment(String assessmentTitle, String assessmentStart, String assessmentEnd, String assessmentType) {
        this.assessmentTitle = assessmentTitle;
        this.assessmentStart = assessmentStart;
        this.assessmentEnd = assessmentEnd;
        this.assessmentType = assessmentType;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "assessmentId=" + assessmentId +
                ", assessmentTitle='" + assessmentTitle + '\'' +
                ", assessmentStart='" + assessmentStart + '\'' +
                ", assessmentEnd='" + assessmentEnd + '\'' +
                ", assessmentType='" + assessmentType + '\'' +
                '}';
    }
}

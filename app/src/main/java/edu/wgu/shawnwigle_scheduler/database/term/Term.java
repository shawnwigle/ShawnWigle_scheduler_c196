package edu.wgu.shawnwigle_scheduler.database.term;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "term_table")
public class Term {
    @PrimaryKey(autoGenerate = true)
    private int termId;
    private String termTitle;
    private String startDate;
    private String endDate;

    //TODO: associate courses with term

    // Getters

    public int getTermId() {
        return termId;
    }

    public String getTermTitle() {
        return termTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    // Setter

    public void setTermId(int termId) {
        this.termId = termId;
    }

    // Constructor
    public Term(String termTitle, String startDate, String endDate) {
        this.termTitle = termTitle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Term{" +
                "termId=" + termId +
                ", termTitle='" + termTitle + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

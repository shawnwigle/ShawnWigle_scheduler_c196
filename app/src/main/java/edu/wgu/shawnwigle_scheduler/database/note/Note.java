package edu.wgu.shawnwigle_scheduler.database.note;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int noteId;
    private String noteTitle;
    private String noteContent;

    //TODO: Share notes via email or sms. AutoPopulate content of note into email or text.

    // Getters
    public int getNoteId() {
        return noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    // Setter
    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    // Constructor
    public Note(String noteTitle, String noteContent) {
        this.noteTitle = noteTitle;
        this.noteContent = noteContent;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteContent='" + noteContent + '\'' +
                '}';
    }
}

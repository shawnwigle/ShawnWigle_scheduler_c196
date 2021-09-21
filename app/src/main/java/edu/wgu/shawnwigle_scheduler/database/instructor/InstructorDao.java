package edu.wgu.shawnwigle_scheduler.database.instructor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface InstructorDao {

    @Insert
    void insert(Instructor instructor);

    @Update
    void update(Instructor instructor);

    @Delete
    void delete(Instructor instructor);

    @Query("DELETE FROM instructor_table")
    void deleteAllInstructors();

    @Query("SELECT * FROM instructor_table ORDER BY instructorId ASC")
    LiveData<List<Instructor>> getAllInstructors();
}

package edu.wgu.shawnwigle_scheduler.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.wgu.shawnwigle_scheduler.database.assessment.Assessment;
import edu.wgu.shawnwigle_scheduler.database.assessment.AssessmentDao;
import edu.wgu.shawnwigle_scheduler.database.course.Course;
import edu.wgu.shawnwigle_scheduler.database.course.CourseDao;
import edu.wgu.shawnwigle_scheduler.database.term.Term;
import edu.wgu.shawnwigle_scheduler.database.term.TermDao;

@Database(entities = {Assessment.class, Course.class, Term.class}, version = 1)
public abstract class SchedulerDatabase extends RoomDatabase {
    private static SchedulerDatabase instance;

    public abstract TermDao termDao();
    public abstract AssessmentDao assessmentDao();
    public abstract CourseDao courseDao();

    public static synchronized SchedulerDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    SchedulerDatabase.class, "school_scheduler_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

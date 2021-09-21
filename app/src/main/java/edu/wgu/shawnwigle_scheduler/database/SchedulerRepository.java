package edu.wgu.shawnwigle_scheduler.database;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import edu.wgu.shawnwigle_scheduler.database.assessment.Assessment;
import edu.wgu.shawnwigle_scheduler.database.assessment.AssessmentDao;
import edu.wgu.shawnwigle_scheduler.database.course.Course;
import edu.wgu.shawnwigle_scheduler.database.course.CourseDao;
import edu.wgu.shawnwigle_scheduler.database.instructor.Instructor;
import edu.wgu.shawnwigle_scheduler.database.instructor.InstructorDao;
import edu.wgu.shawnwigle_scheduler.database.note.Note;
import edu.wgu.shawnwigle_scheduler.database.note.NoteDao;
import edu.wgu.shawnwigle_scheduler.database.term.Term;
import edu.wgu.shawnwigle_scheduler.database.term.TermDao;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SchedulerRepository {
    // instantiate DAO objects
    private TermDao termDao;
    private AssessmentDao assessmentDao;
    private CourseDao courseDao;
    private InstructorDao instructorDao;
    private NoteDao noteDao;

    // Instantiate live data
    private LiveData<List<Term>> allTerms;
    private LiveData<List<Assessment>> allAssessments;
    private LiveData<List<Course>> allCourses;
    private LiveData<List<Instructor>> allInstructors;
    private LiveData<List<Note>> allNotes;

    public SchedulerRepository(Application application) {
        SchedulerDatabase database = SchedulerDatabase.getInstance(application);
        termDao = database.termDao();
        assessmentDao = database.assessmentDao();
        courseDao = database.courseDao();
        instructorDao = database.instructorDao();
        noteDao = database.noteDao();

        allTerms = termDao.getAllTerms();
        allAssessments = assessmentDao.getAllAssessments();
        allCourses = courseDao.getAllCourses();
        allInstructors = instructorDao.getAllInstructors();
        allNotes = noteDao.getAllNotes();
    }

    // Term functions
    public void insert(Term term){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(() -> {
            //Background work here
            termDao.insert(term);
            handler.post(() -> {
                //UI Thread work here
            });
        });
    }
    public void update(Term term){

    }
    public void delete(Term term){

    }
    public void deleteAllTerms(){

    }
    public LiveData<List<Term>> getAllTerms() {
        return allTerms;
    }

    // Assessment functions
    public void insert(Assessment assessment){

    }
    public void update(Assessment assessment){

    }
    public void delete(Assessment assessment){

    }
    public void deleteAllAssessments(){

    }
    public LiveData<List<Assessment>> getAllAssessments() {
        return allAssessments;
    }

    // Course functions
    public void insert(Course course){

    }
    public void update(Course course){

    }
    public void delete(Course course){

    }
    public void deleteAllCourses(){

    }
    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    // Instructor functions
    public void insert(Instructor instructor){

    }
    public void update(Instructor instructor){

    }
    public void delete(Instructor instructor){

    }
    public void deleteAllInstructors(){

    }
    public LiveData<List<Instructor>> getAllInstructors() {
        return allInstructors;
    }

    // Note functions
    public void insert(Note note){

    }
    public void update(Note note){

    }
    public void delete(Note note){

    }
    public void deleteAllNotes(){

    }
    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}

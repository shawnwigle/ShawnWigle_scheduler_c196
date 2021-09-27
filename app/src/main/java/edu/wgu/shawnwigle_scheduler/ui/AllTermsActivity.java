package edu.wgu.shawnwigle_scheduler.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import edu.wgu.shawnwigle_scheduler.R;
import edu.wgu.shawnwigle_scheduler.database.course.Course;
import edu.wgu.shawnwigle_scheduler.database.course.CourseRecViewAdapter;
import edu.wgu.shawnwigle_scheduler.database.term.Term;
import edu.wgu.shawnwigle_scheduler.database.term.TermRecViewAdapter;

public class AllTermsActivity extends AppCompatActivity {

    private RecyclerView termsRecView, coursesRecView;
    private TermRecViewAdapter termAdapter;
    private CourseRecViewAdapter courseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("All Terms");
        setContentView(R.layout.activity_all_terms);

        termAdapter = new TermRecViewAdapter(this);
        termsRecView = findViewById(R.id.termsRecView);
        courseAdapter = new CourseRecViewAdapter(this);
        coursesRecView = findViewById(R.id.coursesRecView);

        termsRecView.setAdapter(termAdapter);
        termsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        coursesRecView.setAdapter(courseAdapter);
        coursesRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Term("Term 1", "Start Date", "End Date"));
        terms.add(new Term("Term 2", "Start Date", "End Date"));
        terms.add(new Term("Term 3", "Start Date", "End Date"));
        terms.add(new Term("Term 4", "Start Date", "End Date"));
        terms.add(new Term("Term 5", "Start Date", "End Date"));
        terms.add(new Term("Term 6", "Start Date", "End Date"));
        terms.add(new Term("Term 7", "Start Date", "End Date"));
        terms.add(new Term("Term 8", "Start Date", "End Date"));

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Course 1", "Start Date", "End Date", "active"));
        courses.add(new Course("Course 2", "Start Date", "End Date", "active"));
        courses.add(new Course("Course 3", "Start Date", "End Date", "active"));
        courses.add(new Course("Course 4", "Start Date", "End Date", "active"));
        courses.add(new Course("Course 5", "Start Date", "End Date", "active"));
        courses.add(new Course("Course 6", "Start Date", "End Date", "active"));
        courses.add(new Course("Course 7", "Start Date", "End Date", "active"));
        courses.add(new Course("Course 8", "Start Date", "End Date", "active"));

        termAdapter.setTerms(terms);
        courseAdapter.setCourses(courses);
    }
}
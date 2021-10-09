package edu.wgu.shawnwigle_scheduler.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDateTime;
import java.util.ArrayList;

import edu.wgu.shawnwigle_scheduler.R;
import edu.wgu.shawnwigle_scheduler.database.course.Course;
import edu.wgu.shawnwigle_scheduler.database.course.CourseRecViewAdapter;

public class AllCoursesActivity extends AppCompatActivity {

    private RecyclerView coursesRecView;
    private CourseRecViewAdapter courseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("All Courses");
        setContentView(R.layout.activity_all_courses);

        // TODO: change to DAO actions
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Course 1",  "sdate", "edate", "started", "jb",
                "9384938484", "email@email.com","note","note desc"));

        courseAdapter = new CourseRecViewAdapter(this);
        courseAdapter.setCourses(courses);
        coursesRecView = findViewById(R.id.coursesRecView);
        coursesRecView.setAdapter(courseAdapter);
        coursesRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        FloatingActionButton btnAddTerm = findViewById(R.id.btnAddCourse);
        btnAddTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
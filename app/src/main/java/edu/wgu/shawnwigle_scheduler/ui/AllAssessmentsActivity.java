package edu.wgu.shawnwigle_scheduler.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import edu.wgu.shawnwigle_scheduler.R;
import edu.wgu.shawnwigle_scheduler.database.assessment.Assessment;
import edu.wgu.shawnwigle_scheduler.database.assessment.AssessmentRecViewAdapter;

public class AllAssessmentsActivity extends AppCompatActivity {

    private RecyclerView assessmentsRecView;
    private AssessmentRecViewAdapter assessmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("All Assessments");
        setContentView(R.layout.activity_all_assessments);

        // TODO: change to DAO actions
        ArrayList<Assessment> assessments = new ArrayList<>();
        assessments.add(new Assessment("Assessment 1", "Start Date", "End Date", "performance"));

        assessmentAdapter = new AssessmentRecViewAdapter(this);
        assessmentAdapter.setAssessments(assessments);
        assessmentsRecView = findViewById(R.id.assessmentsRecView);
        assessmentsRecView.setAdapter(assessmentAdapter);
        assessmentsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        FloatingActionButton btnAddTerm = findViewById(R.id.btnAddAssessement);
        btnAddTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
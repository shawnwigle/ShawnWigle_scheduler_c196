package edu.wgu.shawnwigle_scheduler.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.wgu.shawnwigle_scheduler.R;

public class HomeScreen extends AppCompatActivity {
    private Button btnTerms, btnCourses, btnAssessments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Main Activity");
        setContentView(R.layout.activity_main);
        btnTerms = findViewById(R.id.btnTerms);
        btnCourses = findViewById(R.id.btnCourses);
        btnAssessments = findViewById(R.id.btnAssessments);

        btnTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AllTermsActivity.class);
                view.getContext().startActivity(myIntent);
            }
        });
        btnCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AllCoursesActivity.class);
                view.getContext().startActivity(myIntent);
            }
        });
        btnAssessments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), AllAssessmentsActivity.class);
                view.getContext().startActivity(myIntent);
            }
        });
    }
}
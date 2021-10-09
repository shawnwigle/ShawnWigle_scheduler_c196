package edu.wgu.shawnwigle_scheduler.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import edu.wgu.shawnwigle_scheduler.R;
import edu.wgu.shawnwigle_scheduler.database.term.Term;
import edu.wgu.shawnwigle_scheduler.database.term.TermRecViewAdapter;

public class AllTermsActivity extends AppCompatActivity {

    private RecyclerView termsRecView;
    private TermRecViewAdapter termAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("All Terms");
        setContentView(R.layout.activity_all_terms);

        // TODO: change to DAO actions
        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Term("Term 1", "JAN 01 2021", "JAN 02 2021"));
        terms.add(new Term("Term 2", "JAN 01 2024", "JAN 02 2025"));

        termAdapter = new TermRecViewAdapter(this);
        termAdapter.setTerms(terms);
        termsRecView = findViewById(R.id.termsRecView);
        termsRecView.setAdapter(termAdapter);
        termsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        FloatingActionButton btnAddTerm = findViewById(R.id.btnAddTerm);
        btnAddTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TermDetailActivity.class);
                view.getContext().startActivity(myIntent);
            }
        });
    }
}
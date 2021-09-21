package edu.wgu.shawnwigle_scheduler.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import edu.wgu.shawnwigle_scheduler.R;
import edu.wgu.shawnwigle_scheduler.database.term.Term;
import edu.wgu.shawnwigle_scheduler.database.term.TermRecViewAdapter;

public class AllTermsActivity extends AppCompatActivity {

    private RecyclerView termsRecView;
    private TermRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("All Terms");
        setContentView(R.layout.activity_all_terms);

        adapter = new TermRecViewAdapter(this);
        termsRecView = findViewById(R.id.termsRecView);

        termsRecView.setAdapter(adapter);
        termsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        ArrayList<Term> terms = new ArrayList<>();
        terms.add(new Term("Term 1", "Start Date", "End Date"));
        terms.add(new Term("Term 2", "Start Date", "End Date"));
        terms.add(new Term("Term 3", "Start Date", "End Date"));
        terms.add(new Term("Term 4", "Start Date", "End Date"));
        terms.add(new Term("Term 5", "Start Date", "End Date"));
        terms.add(new Term("Term 6", "Start Date", "End Date"));
        terms.add(new Term("Term 7", "Start Date", "End Date"));
        terms.add(new Term("Term 8", "Start Date", "End Date"));

        adapter.setTerms(terms);
    }
}
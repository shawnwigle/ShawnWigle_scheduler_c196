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
        terms.add(new Term("Term 1", "Start Date", "End Date"));

        termAdapter = new TermRecViewAdapter(this);
        termAdapter.setTerms(terms);
        termsRecView = findViewById(R.id.termsRecView);
        termsRecView.setAdapter(termAdapter);
        termsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        FloatingActionButton btnAddTerm = findViewById(R.id.btnAddTerm);
        btnAddTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
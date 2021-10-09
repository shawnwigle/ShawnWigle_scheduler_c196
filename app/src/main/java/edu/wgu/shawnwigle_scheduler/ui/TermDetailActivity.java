package edu.wgu.shawnwigle_scheduler.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import edu.wgu.shawnwigle_scheduler.R;
import edu.wgu.shawnwigle_scheduler.database.term.TermRecViewAdapter;

public class TermDetailActivity extends AppCompatActivity {
    private DatePickerDialog startDatePickerDialog, endDatePickerDialog;
    private Button btnStartDatePicker, btnEndDatePicker;
    private EditText etTermTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_detail);
        this.setTitle("Term Detail");
        initStartDatePicker();
        initEndDatePicker();
        etTermTitle = findViewById(R.id.etTermTitle);
        btnStartDatePicker = findViewById(R.id.btnStartDatePicker);
        btnEndDatePicker = findViewById(R.id.btnEndDatePicker);

        Intent intent = getIntent();
        String termTitle = intent.getStringExtra("termTitle");
        String termStartDate = intent.getStringExtra("termStartDate");
        String termEndDate = intent.getStringExtra("termEndDate");

        if(termTitle != null){
            etTermTitle.setText(termTitle);
        } else{
            etTermTitle.setHint("Term Title");
            etTermTitle.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {
                    etTermTitle.setHint("");
                }
            });
        }

        if(termStartDate != null){
            btnStartDatePicker.setText(termStartDate);
        } else {
            btnStartDatePicker.setText(getTodaysDate());
        }

        if(termEndDate != null){
            btnEndDatePicker.setText(termEndDate);
        } else {
            btnEndDatePicker.setText(getTodaysDate());
        }

        btnStartDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStartDatePicker();
            }
        });

        btnEndDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEndDatePicker();
            }
        });
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return makeDateString(day, month, year);
    }

    private void openStartDatePicker() {
        startDatePickerDialog.show();
    }

    private void openEndDatePicker(){
        endDatePickerDialog.show();
    }

    private void initStartDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);

                btnStartDatePicker.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        startDatePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
    }

    private void initEndDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);

                btnEndDatePicker.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        endDatePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        switch(month){
            case 1:
                return "JAN";
            case 2:
                return "FEB";
            case 3:
                return "MAR";
            case 4:
                return "APR";
            case 5:
                return "MAY";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AUG";
            case 9:
                return "SEP";
            case 10:
                return "OCT";
            case 11:
                return "NOV";
            case 12:
                return "DEC";
            // should never call default
            default:
                return "default";
        }
    }
}
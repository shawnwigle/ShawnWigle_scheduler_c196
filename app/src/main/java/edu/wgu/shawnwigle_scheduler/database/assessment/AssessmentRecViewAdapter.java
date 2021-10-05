package edu.wgu.shawnwigle_scheduler.database.assessment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.wgu.shawnwigle_scheduler.R;
import edu.wgu.shawnwigle_scheduler.database.assessment.Assessment;

public class AssessmentRecViewAdapter extends RecyclerView.Adapter<AssessmentRecViewAdapter.ViewHolder> {
    private static final String TAG = "AssessmentRecViewAdapter";
    private ArrayList<Assessment> assessments = new ArrayList<>();
    private Context mContext;

    public AssessmentRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assessment_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder assessment: Called");
        holder.assessmentTitle.setText(assessments.get(holder.getAdapterPosition()).getAssessmentTitle());
        holder.assessmentStartDate.setText(assessments.get(holder.getAdapterPosition()).getAssessmentStart());
        holder.assessmentEndDate.setText(assessments.get(holder.getAdapterPosition()).getAssessmentEnd());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, assessments.get(holder.getAdapterPosition()).getAssessmentTitle() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return assessments.size();
    }

    public void setAssessments(ArrayList<Assessment> assessments) {
        this.assessments = assessments;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private TextView assessmentTitle, assessmentStartDate, assessmentEndDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.cvParent);
            assessmentTitle = itemView.findViewById(R.id.txtAssessmentTitle);
            assessmentStartDate = itemView.findViewById(R.id.txtAssessmentStartDate);
            assessmentEndDate = itemView.findViewById(R.id.txtAssessmentEndDate);
        }
    }
}


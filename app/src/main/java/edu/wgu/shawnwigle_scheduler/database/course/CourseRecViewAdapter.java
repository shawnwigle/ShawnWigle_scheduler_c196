package edu.wgu.shawnwigle_scheduler.database.course;

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

public class CourseRecViewAdapter extends RecyclerView.Adapter<CourseRecViewAdapter.ViewHolder> {
    private static final String TAG = "CourseRecViewAdapter";
    private ArrayList<Course> courses = new ArrayList<>();
    private Context mContext;

    public CourseRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder course: Called");
        holder.courseTitle.setText(courses.get(holder.getAdapterPosition()).getCourseTitle());
        holder.courseStartDate.setText(courses.get(holder.getAdapterPosition()).getCourseStart().toString());
        holder.courseEndDate.setText(courses.get(holder.getAdapterPosition()).getCourseEnd().toString());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, courses.get(holder.getAdapterPosition()).getCourseTitle() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private TextView courseTitle, courseStartDate, courseEndDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.cvParent);
            courseTitle = itemView.findViewById(R.id.txtCourseTitle);
            courseStartDate = itemView.findViewById(R.id.txtCourseStartDate);
            courseEndDate = itemView.findViewById(R.id.txtCourseEndDate);
        }
    }
}


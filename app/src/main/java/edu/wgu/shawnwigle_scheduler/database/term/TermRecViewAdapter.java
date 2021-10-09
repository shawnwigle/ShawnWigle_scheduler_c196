package edu.wgu.shawnwigle_scheduler.database.term;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import edu.wgu.shawnwigle_scheduler.R;
import edu.wgu.shawnwigle_scheduler.ui.TermDetailActivity;

public class TermRecViewAdapter extends RecyclerView.Adapter<TermRecViewAdapter.ViewHolder> {
    private static final String TAG = "TermRecViewAdapter";
    private ArrayList<Term> terms = new ArrayList<>();
    private Context mContext;

    public TermRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.term_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);

        Log.d(TAG, "onBindViewHolder term: Called");
        holder.termTitle.setText(terms.get(holder.getAdapterPosition()).getTermTitle());
        holder.termStartDate.setText(terms.get(holder.getAdapterPosition()).getStartDate());
        holder.termEndDate.setText(terms.get(holder.getAdapterPosition()).getEndDate());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String termTitle = holder.termTitle.getText().toString();
                String termStartDate = holder.termStartDate.getText().toString();
                String termEndDate = holder.termEndDate.getText().toString();

                Intent myIntent = new Intent(view.getContext(), TermDetailActivity.class);
                myIntent.putExtra("termTitle", termTitle);
                myIntent.putExtra("termStartDate", termStartDate);
                myIntent.putExtra("termEndDate", termEndDate);
                view.getContext().startActivity(myIntent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return terms.size();
    }

    public void setTerms(ArrayList<Term> terms) {
        this.terms = terms;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       private CardView parent;
       private TextView termTitle, termStartDate, termEndDate;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);
           parent = itemView.findViewById(R.id.cvParent);
           termTitle = itemView.findViewById(R.id.txtTermTitle);
           termStartDate = itemView.findViewById(R.id.txtTermStartDate);
           termEndDate = itemView.findViewById(R.id.txtTermEndDate);
       }
   }
}

package com.example.wonder_academy;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import  androidx.recyclerview.widget.LinearLayoutManager;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    Context context;
    List<Course> courseList;

    public CourseAdapter(Context context, List<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course c = courseList.get(position);
        holder.title.setText(c.title);
        holder.desc.setText(c.description);

        holder.btnApply.setOnClickListener(v -> {
            SharedPreferences prefs = context.getSharedPreferences("MyLearning", Context.MODE_PRIVATE);
            Set<String> savedCourses = prefs.getStringSet("courses", new HashSet<>());

            savedCourses.add(c.title);

            prefs.edit().putStringSet("courses", savedCourses).apply();

            holder.btnApply.setText("Applied ✔");
            holder.btnApply.setEnabled(false);
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        Button btnApply;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.courseTitle);
            desc = itemView.findViewById(R.id.courseDesc);
            btnApply = itemView.findViewById(R.id.btnApply);
        }
    }
}
